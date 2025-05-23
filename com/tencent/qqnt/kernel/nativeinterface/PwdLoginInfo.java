package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PwdLoginInfo {
    public AppInfo appInfo;
    public byte[] loginContext;
    public byte[] longCookie;
    public UinInfo uinInfo;
    public VerifySuccessSign verifySign;
    public UserInfo userInfo = new UserInfo();
    public String passwordMd5 = "";
    public String registerSucceedSig = "";
    public LoginProcessReqBody loginProcessReq = new LoginProcessReqBody();

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public byte[] getLoginContext() {
        return this.loginContext;
    }

    public LoginProcessReqBody getLoginProcessReq() {
        return this.loginProcessReq;
    }

    public byte[] getLongCookie() {
        return this.longCookie;
    }

    public String getPasswordMd5() {
        return this.passwordMd5;
    }

    public String getRegisterSucceedSig() {
        return this.registerSucceedSig;
    }

    public UinInfo getUinInfo() {
        return this.uinInfo;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public VerifySuccessSign getVerifySign() {
        return this.verifySign;
    }

    public String toString() {
        return "PwdLoginInfo{userInfo=" + this.userInfo + ",uinInfo=" + this.uinInfo + ",passwordMd5=" + this.passwordMd5 + ",verifySign=" + this.verifySign + ",loginContext=" + this.loginContext + ",longCookie=" + this.longCookie + ",appInfo=" + this.appInfo + ",registerSucceedSig=" + this.registerSucceedSig + ",loginProcessReq=" + this.loginProcessReq + ",}";
    }
}
