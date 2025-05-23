package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OSReadLikeListRsp {
    public int errCode;
    public String errMsg;

    public OSReadLikeListRsp() {
        this.errMsg = "";
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return "OSReadLikeListRsp{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",}";
    }

    public OSReadLikeListRsp(int i3, String str) {
        this.errCode = i3;
        this.errMsg = str;
    }
}
