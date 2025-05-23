package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetLayerTailpageRecommendRsp {
    public boolean isFromCache;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<RecommendItem> recommendList = new ArrayList<>();
    public String title = "";

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public ArrayList<RecommendItem> getRecommendList() {
        return this.recommendList;
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

    public String getTitle() {
        return this.title;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
