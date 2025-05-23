package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetTopicFeedsRsp {
    public int isFinish;
    public ArrayList<GProStFeed> feeds = new ArrayList<>();
    public byte[] attachInfo = new byte[0];
    public String pageView = "";
    public String totalFeedNum = "";
    public String topicName = "";
    public String traceId = "";
    public GProStChannelSign channelSign = new GProStChannelSign();

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public ArrayList<GProStFeed> getFeeds() {
        return this.feeds;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public String getPageView() {
        return this.pageView;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public String getTotalFeedNum() {
        return this.totalFeedNum;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProGetTopicFeedsRsp{feeds=" + this.feeds + ",isFinish=" + this.isFinish + ",attachInfo=" + this.attachInfo + ",pageView=" + this.pageView + ",totalFeedNum=" + this.totalFeedNum + ",topicName=" + this.topicName + ",traceId=" + this.traceId + ",channelSign=" + this.channelSign + ",}";
    }
}
