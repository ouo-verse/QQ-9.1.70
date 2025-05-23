package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetImmersiveFeedsRsp {
    public int isFinish;
    public int isRecommendFinish;
    public ArrayList<GProStFeed> feeds = new ArrayList<>();
    public byte[] attachInfo = new byte[0];
    public String traceId = "";
    public byte[] visitorMsg = new byte[0];
    public String sessionId = "";

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public ArrayList<GProStFeed> getFeeds() {
        return this.feeds;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public int getIsRecommendFinish() {
        return this.isRecommendFinish;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public byte[] getVisitorMsg() {
        return this.visitorMsg;
    }

    public String toString() {
        return "GProGetImmersiveFeedsRsp{feeds=" + this.feeds + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",isRecommendFinish=" + this.isRecommendFinish + ",traceId=" + this.traceId + ",visitorMsg=" + this.visitorMsg + ",sessionId=" + this.sessionId + ",}";
    }
}
