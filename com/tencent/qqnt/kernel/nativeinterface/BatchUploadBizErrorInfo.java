package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadBizErrorInfo {
    public long errCode;
    public String errMsg = "";
    public byte[] errTransInfo = new byte[0];

    public long getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public byte[] getErrTransInfo() {
        return this.errTransInfo;
    }

    public String toString() {
        return "BatchUploadBizErrorInfo{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",errTransInfo=" + this.errTransInfo + ",}";
    }
}
