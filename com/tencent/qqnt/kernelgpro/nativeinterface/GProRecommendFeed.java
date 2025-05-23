package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendFeed implements Serializable {
    public long channelId;
    public long createTime;
    public long guildId;
    public long posterTinyId;
    long serialVersionUID = 1;
    public String feedId = "";
    public String feedTitle = "";
    public String feedCoverUrl = "";
    public String feedSubTitle = "";
    public String titleColor = "";
    public String cardBottomColor = "";
    public String channelInfoColor = "";
    public String feedVideoCoverUrl = "";

    public String getCardBottomColor() {
        return this.cardBottomColor;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelInfoColor() {
        return this.channelInfoColor;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedCoverUrl() {
        return this.feedCoverUrl;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFeedSubTitle() {
        return this.feedSubTitle;
    }

    public String getFeedTitle() {
        return this.feedTitle;
    }

    public String getFeedVideoCoverUrl() {
        return this.feedVideoCoverUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getPosterTinyId() {
        return this.posterTinyId;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String toString() {
        return "GProRecommendFeed{feedId=" + this.feedId + ",feedTitle=" + this.feedTitle + ",feedCoverUrl=" + this.feedCoverUrl + ",posterTinyId=" + this.posterTinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",createTime=" + this.createTime + ",feedSubTitle=" + this.feedSubTitle + ",titleColor=" + this.titleColor + ",cardBottomColor=" + this.cardBottomColor + ",channelInfoColor=" + this.channelInfoColor + ",feedVideoCoverUrl=" + this.feedVideoCoverUrl + ",}";
    }
}
