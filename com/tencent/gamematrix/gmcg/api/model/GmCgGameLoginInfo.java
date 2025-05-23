package com.tencent.gamematrix.gmcg.api.model;

import com.tencent.gamematrix.gmcg.api.GmCgAutoLoginIdType;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgGameLoginInfo {
    public int autoLoginChannelType;
    public String pAutoLoginChannelAppId;
    public String pGameDelegateCode;
    public String pGameOpenId;

    @GmCgAutoLoginIdType
    public int pIdType;
    public boolean pIsPlatAuth;
    public String pPayToken;
    public String pQQDelegateCode;
    public String pQQUserOpenId;
    public String pQQUserPayToken;
    public String pQQUserPf;
    public String pQQUserPfKey;
    public String pQQUserToken;
    public String pSrcAccessToken;
    public String pSrcOpenId;
    public String pUserGender;
    public String pUserHeadUrl;
    public String pUserNickName;
    public String pWeChatFinalCode;
    public String pWeChatOpenId;

    public String toString() {
        return "GmCgGameAutoLoginInfo{pIdType=" + this.pIdType + ", pIsPlatAuth=" + this.pIsPlatAuth + ", pUserNickName='" + this.pUserNickName + "', pUserHeadUrl='" + this.pUserHeadUrl + "', pUserGender='" + this.pUserGender + "', pQQUserOpenId='" + this.pQQUserOpenId + "', pQQUserToken='" + this.pQQUserToken + "', pQQUserPf='" + this.pQQUserPf + "', pQQUserPfKey='" + this.pQQUserPfKey + "', pQQUserPayToken='" + this.pQQUserPayToken + "', pQQDelegateCode='" + this.pQQDelegateCode + "', pWeChatOpenId='" + this.pWeChatOpenId + "', pWeChatFinalCode='" + this.pWeChatFinalCode + "', pGameDelegateCode='" + this.pGameDelegateCode + "'}";
    }
}
