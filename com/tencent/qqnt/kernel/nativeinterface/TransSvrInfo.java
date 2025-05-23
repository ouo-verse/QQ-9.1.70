package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TransSvrInfo {
    public String errMsg;
    public int retCode;
    public int subType;
    public byte[] transInfo;

    public TransSvrInfo() {
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public int getSubType() {
        return this.subType;
    }

    public byte[] getTransInfo() {
        return this.transInfo;
    }

    public String toString() {
        return "TransSvrInfo{subType=" + this.subType + ",retCode=" + this.retCode + ",errMsg=" + this.errMsg + ",transInfo=" + this.transInfo + ",}";
    }

    public TransSvrInfo(int i3, int i16, String str, byte[] bArr) {
        this.subType = i3;
        this.retCode = i16;
        this.errMsg = str;
        this.transInfo = bArr;
    }
}
