package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckGatewayCodeReq {
    public AppInfo appInfo;
    public byte[] loginContext;
    public String phoneToken = "";
    public VerifySuccessSign verifySign;

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public byte[] getLoginContext() {
        return this.loginContext;
    }

    public String getPhoneToken() {
        return this.phoneToken;
    }

    public VerifySuccessSign getVerifySign() {
        return this.verifySign;
    }

    public String toString() {
        return "CheckGatewayCodeReq{loginContext=" + this.loginContext + ",phoneToken=" + this.phoneToken + ",verifySign=" + this.verifySign + ",appInfo=" + this.appInfo + ",}";
    }
}
