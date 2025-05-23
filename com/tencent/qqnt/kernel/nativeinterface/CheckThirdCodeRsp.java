package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckThirdCodeRsp {
    public LoginRspInfo loginRspInfo = new LoginRspInfo();
    public WechatRspBody wechatRspBody;

    public LoginRspInfo getLoginRspInfo() {
        return this.loginRspInfo;
    }

    public WechatRspBody getWechatRspBody() {
        return this.wechatRspBody;
    }

    public String toString() {
        return "CheckThirdCodeRsp{wechatRspBody=" + this.wechatRspBody + ",loginRspInfo=" + this.loginRspInfo + ",}";
    }
}
