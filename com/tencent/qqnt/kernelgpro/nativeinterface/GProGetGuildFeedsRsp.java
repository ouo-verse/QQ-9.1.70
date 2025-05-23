package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetGuildFeedsRsp {
    public boolean hasFeed;
    public int isFinish;
    public int isFrontFinish;
    public int msgSumType;
    public ArrayList<GProStFeed> vecFeedList = new ArrayList<>();
    public String feedAttchInfo = "";
    public String traceId = "";
    public ArrayList<GProTopFeed> topFeeds = new ArrayList<>();
    public ArrayList<GProSimpleChannelInfo> channels = new ArrayList<>();
    public byte[] advInfo = new byte[0];
    public byte[] msgSum = new byte[0];
    public byte[] token = new byte[0];
    public byte[] frontFeedAttachInfo = new byte[0];

    public byte[] getAdvInfo() {
        return this.advInfo;
    }

    public ArrayList<GProSimpleChannelInfo> getChannels() {
        return this.channels;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public byte[] getFrontFeedAttachInfo() {
        return this.frontFeedAttachInfo;
    }

    public boolean getHasFeed() {
        return this.hasFeed;
    }

    public int getIsFinish() {
        return this.isFinish;
    }

    public int getIsFrontFinish() {
        return this.isFrontFinish;
    }

    public byte[] getMsgSum() {
        return this.msgSum;
    }

    public int getMsgSumType() {
        return this.msgSumType;
    }

    public byte[] getToken() {
        return this.token;
    }

    public ArrayList<GProTopFeed> getTopFeeds() {
        return this.topFeeds;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public ArrayList<GProStFeed> getVecFeedList() {
        return this.vecFeedList;
    }

    public String toString() {
        return "GProGetGuildFeedsRsp{vecFeedList=" + this.vecFeedList + ",isFinish=" + this.isFinish + ",feedAttchInfo=" + this.feedAttchInfo + ",traceId=" + this.traceId + ",topFeeds=" + this.topFeeds + ",channels=" + this.channels + ",advInfo=" + this.advInfo + ",msgSum=" + this.msgSum + ",token=" + this.token + ",hasFeed=" + this.hasFeed + ",msgSumType=" + this.msgSumType + ",isFrontFinish=" + this.isFrontFinish + ",frontFeedAttachInfo=" + this.frontFeedAttachInfo + ",}";
    }
}
