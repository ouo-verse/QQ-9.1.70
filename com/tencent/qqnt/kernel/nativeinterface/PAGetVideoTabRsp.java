package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetVideoTabRsp {
    public boolean hasMore;
    public boolean isFromCache;
    public int result;
    public int seq;
    public int videoNum;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<PhotoInfo> videos = new ArrayList<>();
    public String attachInfo = "";
    public StTimeLine timeLine = new StTimeLine();
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

    public boolean getHasMore() {
        return this.hasMore;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
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

    public StTimeLine getTimeLine() {
        return this.timeLine;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getVideoNum() {
        return this.videoNum;
    }

    public ArrayList<PhotoInfo> getVideos() {
        return this.videos;
    }
}
