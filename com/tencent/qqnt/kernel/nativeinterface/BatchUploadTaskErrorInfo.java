package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatchUploadTaskErrorInfo {
    public long detailErrCode;
    public long srvErrCode;
    public int stepErr;
    public String errMsg = "";
    public BatchUploadBizErrorInfo bizErrorInfo = new BatchUploadBizErrorInfo();

    public BatchUploadBizErrorInfo getBizErrorInfo() {
        return this.bizErrorInfo;
    }

    public long getDetailErrCode() {
        return this.detailErrCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getSrvErrCode() {
        return this.srvErrCode;
    }

    public int getStepErr() {
        return this.stepErr;
    }

    public String toString() {
        return "BatchUploadTaskErrorInfo{stepErr=" + this.stepErr + ",detailErrCode=" + this.detailErrCode + ",srvErrCode=" + this.srvErrCode + ",errMsg=" + this.errMsg + ",bizErrorInfo=" + this.bizErrorInfo + ",}";
    }
}
