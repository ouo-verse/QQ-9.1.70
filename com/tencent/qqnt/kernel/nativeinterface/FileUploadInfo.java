package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FileUploadInfo {
    public int errCode;
    public String errMsg = "";
    public boolean isNeedDelExif;
    public int svrErrCode;
    public long uploadedBytes;

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public boolean getIsNeedDelExif() {
        return this.isNeedDelExif;
    }

    public int getSvrErrCode() {
        return this.svrErrCode;
    }

    public long getUploadedBytes() {
        return this.uploadedBytes;
    }
}
