package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VerifySuccessSign {
    public byte[] deviceCheckSucceedSig;
    public Iframe iframe;
    public VerifyType verifyType = VerifyType.values()[0];

    public byte[] getDeviceCheckSucceedSig() {
        return this.deviceCheckSucceedSig;
    }

    public Iframe getIframe() {
        return this.iframe;
    }

    public VerifyType getVerifyType() {
        return this.verifyType;
    }

    public String toString() {
        return "VerifySuccessSign{verifyType=" + this.verifyType + ",iframe=" + this.iframe + ",deviceCheckSucceedSig=" + this.deviceCheckSucceedSig + ",}";
    }
}
