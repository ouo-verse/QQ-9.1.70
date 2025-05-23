package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSendNoticeRsp {
    public int code;
    public String notAllowReason = "";

    public int getCode() {
        return this.code;
    }

    public String getNotAllowReason() {
        return this.notAllowReason;
    }

    public String toString() {
        return "GProSendNoticeRsp{code=" + this.code + ",notAllowReason=" + this.notAllowReason + ",}";
    }
}
