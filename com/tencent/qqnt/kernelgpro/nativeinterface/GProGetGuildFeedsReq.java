package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProGetGuildFeedsReq {
    public int contentType;
    public int count;
    public int direction;
    public int from;
    public int getType;
    public long guildId;
    public long jumpFeedTime;
    public boolean needChannelList;
    public int needNewFeature;
    public boolean needRecommendCard;
    public boolean needTopInfo;
    public int sortOption;
    public long topChannelId;
    public int topType;
    public String feedAttchInfo = "";
    public String topFeedId = "";
    public String topBusinessId = "";
    public byte[] adReq = new byte[0];
    public byte[] token = new byte[0];
    public GProGuildFeedsFilter filter = new GProGuildFeedsFilter();
    public byte[] frontFeedAttachInfo = new byte[0];

    public byte[] getAdReq() {
        return this.adReq;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getCount() {
        return this.count;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getFeedAttchInfo() {
        return this.feedAttchInfo;
    }

    public GProGuildFeedsFilter getFilter() {
        return this.filter;
    }

    public int getFrom() {
        return this.from;
    }

    public byte[] getFrontFeedAttachInfo() {
        return this.frontFeedAttachInfo;
    }

    public int getGetType() {
        return this.getType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getJumpFeedTime() {
        return this.jumpFeedTime;
    }

    public boolean getNeedChannelList() {
        return this.needChannelList;
    }

    public int getNeedNewFeature() {
        return this.needNewFeature;
    }

    public boolean getNeedRecommendCard() {
        return this.needRecommendCard;
    }

    public boolean getNeedTopInfo() {
        return this.needTopInfo;
    }

    public int getSortOption() {
        return this.sortOption;
    }

    public byte[] getToken() {
        return this.token;
    }

    public String getTopBusinessId() {
        return this.topBusinessId;
    }

    public long getTopChannelId() {
        return this.topChannelId;
    }

    public String getTopFeedId() {
        return this.topFeedId;
    }

    public int getTopType() {
        return this.topType;
    }

    public String toString() {
        return "GProGetGuildFeedsReq{count=" + this.count + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",feedAttchInfo=" + this.feedAttchInfo + ",guildId=" + this.guildId + ",getType=" + this.getType + ",sortOption=" + this.sortOption + ",needChannelList=" + this.needChannelList + ",needTopInfo=" + this.needTopInfo + ",topFeedId=" + this.topFeedId + ",needRecommendCard=" + this.needRecommendCard + ",topChannelId=" + this.topChannelId + ",needNewFeature=" + this.needNewFeature + ",topType=" + this.topType + ",topBusinessId=" + this.topBusinessId + ",contentType=" + this.contentType + ",adReq=" + this.adReq + ",token=" + this.token + ",filter=" + this.filter + ",frontFeedAttachInfo=" + this.frontFeedAttachInfo + ",direction=" + this.direction + ",jumpFeedTime=" + this.jumpFeedTime + ",}";
    }
}
