package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PackRedBagRsp {
    public byte[] index;
    public int invalidTime;
    public byte[] qrCode;

    public PackRedBagRsp() {
        this.qrCode = new byte[0];
        this.index = new byte[0];
    }

    public byte[] getIndex() {
        return this.index;
    }

    public int getInvalidTime() {
        return this.invalidTime;
    }

    public byte[] getQrCode() {
        return this.qrCode;
    }

    public String toString() {
        return "PackRedBagRsp{qrCode=" + this.qrCode + ",invalidTime=" + this.invalidTime + ",index=" + this.index + ",}";
    }

    public PackRedBagRsp(byte[] bArr, int i3, byte[] bArr2) {
        this.qrCode = bArr;
        this.invalidTime = i3;
        this.index = bArr2;
    }
}
