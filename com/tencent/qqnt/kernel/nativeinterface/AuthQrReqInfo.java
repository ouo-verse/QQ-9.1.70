package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AuthQrReqInfo {
    public boolean needA1;
    public byte[] qrSig = new byte[0];
    public QrSwitchOperation opSwitch = QrSwitchOperation.values()[0];

    public boolean getNeedA1() {
        return this.needA1;
    }

    public QrSwitchOperation getOpSwitch() {
        return this.opSwitch;
    }

    public byte[] getQrSig() {
        return this.qrSig;
    }

    public String toString() {
        return "AuthQrReqInfo{needA1=" + this.needA1 + ",qrSig=" + this.qrSig + ",opSwitch=" + this.opSwitch + ",}";
    }
}
