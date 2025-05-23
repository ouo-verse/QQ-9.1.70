package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckSmsReqBody {
    public AppInfo appInfo;
    public byte[] loginContext;
    public byte[] longCookie;
    public UserInfo userInfo = new UserInfo();
    public String smsCode = "";

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public byte[] getLoginContext() {
        return this.loginContext;
    }

    public byte[] getLongCookie() {
        return this.longCookie;
    }

    public String getSmsCode() {
        return this.smsCode;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "CheckSmsReqBody{userInfo=" + this.userInfo + ",loginContext=" + this.loginContext + ",longCookie=" + this.longCookie + ",smsCode=" + this.smsCode + ",appInfo=" + this.appInfo + ",}";
    }
}
