package com.blah.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blah.vo.MemberVo;


@Repository
public class AccountDaoImpl implements AccountDao {
	@Override
	public String checkId(String memberId) throws Exception{
		
		return sqlSession.selectOne("member2.idchk", memberId);
	}
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE+"login",vo);
		}catch (Exception e) {
			System.out.println("[error] : LOGIN");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int signup(MemberVo vo) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"sign",vo);
		}catch (Exception e) {
			System.out.println("[error] : sign");
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public Map<String, String> selectSearchId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE2+"findId",map);
		}


	@Override
	public MemberVo checkApiId(String memberId) {
		MemberVo res = null;
		try {
			res = sqlSession.selectOne(NAMESPACE+"checkApiId",memberId);
		}catch (Exception e) {
			System.out.println("[error] : checkApiId");
			e.printStackTrace();
		}
		
		return res;	
	}

	@Override
	public int insertApiMember(MemberVo vo) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insertApiMember",vo);
		}catch (Exception e) {
			System.out.println("[error] : insertApiMember");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Map<String, String> selectEmail(MemberVo vo) {
		Map<String, String> res = null;
		try {
			res = sqlSession.selectOne(NAMESPACE+"selectEmail",vo);
		}catch (Exception e) {
			System.out.println("[error] : selectEmail");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updatePwd(MemberVo vo) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatePwd",vo);
		}catch (Exception e) {
			System.out.println("[error] : updatePwd");
			e.printStackTrace();
		}
		return res;
	}

}











