package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NewDeviceVerifyRsp {
    public byte[] deviceCheckSucceedSig = new byte[0];
    public LoginRspInfo loginRspInfo = new LoginRspInfo();

    public byte[] getDeviceCheckSucceedSig() {
        return this.deviceCheckSucceedSig;
    }

    public LoginRspInfo getLoginRspInfo() {
        return this.loginRspInfo;
    }

    public String toString() {
        return "NewDeviceVerifyRsp{deviceCheckSucceedSig=" + this.deviceCheckSucceedSig + ",loginRspInfo=" + this.loginRspInfo + ",}";
    }
}
