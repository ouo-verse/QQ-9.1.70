package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendsV2Feed implements Serializable {
    public long cardId;
    public long cardTank;
    public long channelId;
    public long createTime;
    public int favorCnt;
    public int feedCardType;
    public long guildId;
    public int imageRatioType;
    public int isMore;
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
    public String cardUrl = "";
    public String inviteCode = "";
    public String contentId = "";
    public String bannerUrl = "";
    public ArrayList<String> attributeTags = new ArrayList<>();
    public String buttonDesc = "";
    public String buttonColor = "";
    public String buttonDescColor = "";

    public ArrayList<String> getAttributeTags() {
        return this.attributeTags;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    public String getButtonDesc() {
        return this.buttonDesc;
    }

    public String getButtonDescColor() {
        return this.buttonDescColor;
    }

    public String getCardBottomColor() {
        return this.cardBottomColor;
    }

    public long getCardId() {
        return this.cardId;
    }

    public long getCardTank() {
        return this.cardTank;
    }

    public String getCardUrl() {
        return this.cardUrl;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelInfoColor() {
        return this.channelInfoColor;
    }

    public String getContentId() {
        return this.contentId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getFavorCnt() {
        return this.favorCnt;
    }

    public int getFeedCardType() {
        return this.feedCardType;
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

    public int getImageRatioType() {
        return this.imageRatioType;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getIsMore() {
        return this.isMore;
    }

    public long getPosterTinyId() {
        return this.posterTinyId;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String toString() {
        return "GProRecommendsV2Feed{feedId=" + this.feedId + ",feedTitle=" + this.feedTitle + ",feedCoverUrl=" + this.feedCoverUrl + ",posterTinyId=" + this.posterTinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",createTime=" + this.createTime + ",feedSubTitle=" + this.feedSubTitle + ",titleColor=" + this.titleColor + ",cardBottomColor=" + this.cardBottomColor + ",channelInfoColor=" + this.channelInfoColor + ",feedVideoCoverUrl=" + this.feedVideoCoverUrl + ",imageRatioType=" + this.imageRatioType + ",favorCnt=" + this.favorCnt + ",feedCardType=" + this.feedCardType + ",cardUrl=" + this.cardUrl + ",inviteCode=" + this.inviteCode + ",contentId=" + this.contentId + ",bannerUrl=" + this.bannerUrl + ",cardId=" + this.cardId + ",isMore=" + this.isMore + ",attributeTags=" + this.attributeTags + ",cardTank=" + this.cardTank + ",buttonDesc=" + this.buttonDesc + ",buttonColor=" + this.buttonColor + ",buttonDescColor=" + this.buttonDescColor + ",}";
    }
}
