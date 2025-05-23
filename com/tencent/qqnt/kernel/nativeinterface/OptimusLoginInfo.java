package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OptimusLoginInfo {
    public AppInfo appInfo;
    public byte[] loginContext;
    public byte[] longCookie;
    public UinInfo uinInfo;
    public VerifySuccessSign verifySign;
    public UserInfo userInfo = new UserInfo();
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
        return "OptimusLoginInfo{userInfo=" + this.userInfo + ",uinInfo=" + this.uinInfo + ",verifySign=" + this.verifySign + ",loginContext=" + this.loginContext + ",longCookie=" + this.longCookie + ",appInfo=" + this.appInfo + ",loginProcessReq=" + this.loginProcessReq + ",}";
    }
}
