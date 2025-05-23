package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAAddReplyRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String replyId = "";

    public String getErrMs() {
        return this.errMs;
    }

    public String getReplyId() {
        return this.replyId;
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

    public String getTraceId() {
        return this.traceId;
    }
}
