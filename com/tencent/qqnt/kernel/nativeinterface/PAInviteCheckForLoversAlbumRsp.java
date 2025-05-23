package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAInviteCheckForLoversAlbumRsp {
    public boolean haveLover;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser lover = new StUser();

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getHaveLover() {
        return this.haveLover;
    }

    public StUser getLover() {
        return this.lover;
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
