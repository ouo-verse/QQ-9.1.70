package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckThirdCodeReq {
    public AppInfo appInfo;
    public byte[] loginContext;
    public VerifySuccessSign verifySign;
    public WechatReqBody wechatReqBody;

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public byte[] getLoginContext() {
        return this.loginContext;
    }

    public VerifySuccessSign getVerifySign() {
        return this.verifySign;
    }

    public WechatReqBody getWechatReqBody() {
        return this.wechatReqBody;
    }

    public String toString() {
        return "CheckThirdCodeReq{loginContext=" + this.loginContext + ",wechatReqBody=" + this.wechatReqBody + ",verifySign=" + this.verifySign + ",appInfo=" + this.appInfo + ",}";
    }
}
