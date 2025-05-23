package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetDetailRecommendFeedsRsp {
    public int isFinish;
    public ArrayList<GProStFeed> feeds = new ArrayList<>();
    public byte[] attachInfo = new byte[0];
    public String traceId = "";

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public ArrayList<GProStFeed> getFeeds() {
        return this.feeds;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetDetailRecommendFeedsRsp{feeds=" + this.feeds + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",traceId=" + this.traceId + ",}";
    }
}
