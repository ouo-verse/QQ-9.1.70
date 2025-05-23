package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAMoveBatchPhotoRsp {
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();

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

    public String getTraceId() {
        return this.traceId;
    }
}
