package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PASendAlbumInvitationRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public Toast toast = new Toast();

    public String getErrMs() {
        return this.errMs;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public Toast getToast() {
        return this.toast;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
