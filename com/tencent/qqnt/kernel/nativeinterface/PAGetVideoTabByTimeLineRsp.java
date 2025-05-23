package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetVideoTabByTimeLineRsp {
    public boolean isFromCache;
    public boolean nextHasMore;
    public boolean preHasMore;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<PhotoInfo> videos = new ArrayList<>();
    public String attachInfo = "";
    public PageEndMsg endMsg = new PageEndMsg();

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public PageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public boolean getNextHasMore() {
        return this.nextHasMore;
    }

    public boolean getPreHasMore() {
        return this.preHasMore;
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

    public ArrayList<PhotoInfo> getVideos() {
        return this.videos;
    }
}
