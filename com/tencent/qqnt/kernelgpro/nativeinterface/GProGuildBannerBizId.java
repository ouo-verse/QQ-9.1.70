package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildBannerBizId {
    public int bannerType;
    public long channelId;
    public long feedCreateTime;
    public long feedCreateTinyId;
    public long msgSeq;
    public String feedId = "";
    public String thirdRecommendId = "";

    public int getBannerType() {
        return this.bannerType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getFeedCreateTime() {
        return this.feedCreateTime;
    }

    public long getFeedCreateTinyId() {
        return this.feedCreateTinyId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getThirdRecommendId() {
        return this.thirdRecommendId;
    }

    public String toString() {
        return "GProGuildBannerBizId{bannerType=" + this.bannerType + ",channelId=" + this.channelId + ",msgSeq=" + this.msgSeq + ",feedId=" + this.feedId + ",feedCreateTime=" + this.feedCreateTime + ",feedCreateTinyId=" + this.feedCreateTinyId + ",thirdRecommendId=" + this.thirdRecommendId + ",}";
    }
}
