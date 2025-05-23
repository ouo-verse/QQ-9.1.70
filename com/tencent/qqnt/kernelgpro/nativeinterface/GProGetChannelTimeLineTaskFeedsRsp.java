package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetChannelTimeLineTaskFeedsRsp {
    public int isFinish;
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();
    public String attachInfo = "";
    public String traceId = "";

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProGetChannelTimeLineTaskFeedsRsp{vecFeedList=" + this.vecFeedList + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",traceId=" + this.traceId + ",}";
    }
}
