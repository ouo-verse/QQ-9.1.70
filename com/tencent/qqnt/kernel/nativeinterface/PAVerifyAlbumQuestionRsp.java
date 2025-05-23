package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAVerifyAlbumQuestionRsp {
    public int result;
    public int seq;
    public int status;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String details = "";

    public String getDetails() {
        return this.details;
    }

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

    public int getStatus() {
        return this.status;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
