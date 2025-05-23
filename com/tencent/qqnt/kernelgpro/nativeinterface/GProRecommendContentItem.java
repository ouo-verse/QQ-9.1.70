package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendContentItem implements Serializable {
    public byte[] adFeedModel;
    public GProContentFeedTopic contentFeedTopic;
    public GProContentRecommendGuild contentRecommendGuild;
    public GProContentRecommendHotLive contentRecommendHotLive;
    public GProContentRecommendLive contentRecommendLive;
    public GProContentRecommendSchema contentRecommendSchema;
    public GProContentRecommendSelectedGuild contentRecommendSelectedGuild;
    public GProContentRecommendVoice contentRecommendVoice;
    public GProExtra extra;
    public GProContentRecommendFeed feed;
    public GProContentRecommendFeedsGuild feedsGuild;
    public GProContentRecommendGroup group;
    public GProContentRecommendH5Kuikly h5kuikly;
    public int itemType;
    public GProContentRecommendOneToOne oneToOne;
    public GProContentRecommendRobot robot;
    long serialVersionUID;
    public byte[] tianShuAdItem;

    public GProRecommendContentItem() {
        this.serialVersionUID = 1L;
        this.feed = new GProContentRecommendFeed();
        this.robot = new GProContentRecommendRobot();
        this.group = new GProContentRecommendGroup();
        this.contentRecommendHotLive = new GProContentRecommendHotLive();
        this.contentRecommendSelectedGuild = new GProContentRecommendSelectedGuild();
        this.contentRecommendGuild = new GProContentRecommendGuild();
        this.contentRecommendLive = new GProContentRecommendLive();
        this.contentRecommendVoice = new GProContentRecommendVoice();
        this.contentRecommendSchema = new GProContentRecommendSchema();
        this.contentFeedTopic = new GProContentFeedTopic();
        this.feedsGuild = new GProContentRecommendFeedsGuild();
        this.h5kuikly = new GProContentRecommendH5Kuikly();
        this.oneToOne = new GProContentRecommendOneToOne();
        this.extra = new GProExtra();
        this.tianShuAdItem = new byte[0];
        this.adFeedModel = new byte[0];
    }

    public byte[] getAdFeedModel() {
        return this.adFeedModel;
    }

    public GProContentFeedTopic getContentFeedTopic() {
        return this.contentFeedTopic;
    }

    public GProContentRecommendGuild getContentRecommendGuild() {
        return this.contentRecommendGuild;
    }

    public GProContentRecommendHotLive getContentRecommendHotLive() {
        return this.contentRecommendHotLive;
    }

    public GProContentRecommendLive getContentRecommendLive() {
        return this.contentRecommendLive;
    }

    public GProContentRecommendSchema getContentRecommendSchema() {
        return this.contentRecommendSchema;
    }

    public GProContentRecommendSelectedGuild getContentRecommendSelectedGuild() {
        return this.contentRecommendSelectedGuild;
    }

    public GProContentRecommendVoice getContentRecommendVoice() {
        return this.contentRecommendVoice;
    }

    public GProExtra getExtra() {
        return this.extra;
    }

    public GProContentRecommendFeed getFeed() {
        return this.feed;
    }

    public GProContentRecommendFeedsGuild getFeedsGuild() {
        return this.feedsGuild;
    }

    public GProContentRecommendGroup getGroup() {
        return this.group;
    }

    public GProContentRecommendH5Kuikly getH5kuikly() {
        return this.h5kuikly;
    }

    public int getItemType() {
        return this.itemType;
    }

    public GProContentRecommendOneToOne getOneToOne() {
        return this.oneToOne;
    }

    public GProContentRecommendRobot getRobot() {
        return this.robot;
    }

    public byte[] getTianShuAdItem() {
        return this.tianShuAdItem;
    }

    public String toString() {
        return "GProRecommendContentItem{itemType=" + this.itemType + ",feed=" + this.feed + ",robot=" + this.robot + ",group=" + this.group + ",contentRecommendHotLive=" + this.contentRecommendHotLive + ",contentRecommendSelectedGuild=" + this.contentRecommendSelectedGuild + ",contentRecommendGuild=" + this.contentRecommendGuild + ",contentRecommendLive=" + this.contentRecommendLive + ",contentRecommendVoice=" + this.contentRecommendVoice + ",contentRecommendSchema=" + this.contentRecommendSchema + ",contentFeedTopic=" + this.contentFeedTopic + ",feedsGuild=" + this.feedsGuild + ",h5kuikly=" + this.h5kuikly + ",oneToOne=" + this.oneToOne + ",extra=" + this.extra + ",tianShuAdItem=" + this.tianShuAdItem + ",adFeedModel=" + this.adFeedModel + ",}";
    }

    public GProRecommendContentItem(int i3, GProContentRecommendFeed gProContentRecommendFeed, GProContentRecommendRobot gProContentRecommendRobot, GProContentRecommendGroup gProContentRecommendGroup, GProContentRecommendHotLive gProContentRecommendHotLive, GProContentRecommendSelectedGuild gProContentRecommendSelectedGuild, GProContentRecommendGuild gProContentRecommendGuild, GProContentRecommendLive gProContentRecommendLive, GProContentRecommendVoice gProContentRecommendVoice, GProContentRecommendSchema gProContentRecommendSchema, GProExtra gProExtra, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.feed = new GProContentRecommendFeed();
        this.robot = new GProContentRecommendRobot();
        this.group = new GProContentRecommendGroup();
        this.contentRecommendHotLive = new GProContentRecommendHotLive();
        this.contentRecommendSelectedGuild = new GProContentRecommendSelectedGuild();
        this.contentRecommendGuild = new GProContentRecommendGuild();
        this.contentRecommendLive = new GProContentRecommendLive();
        this.contentRecommendVoice = new GProContentRecommendVoice();
        this.contentRecommendSchema = new GProContentRecommendSchema();
        this.contentFeedTopic = new GProContentFeedTopic();
        this.feedsGuild = new GProContentRecommendFeedsGuild();
        this.h5kuikly = new GProContentRecommendH5Kuikly();
        this.oneToOne = new GProContentRecommendOneToOne();
        new GProExtra();
        this.adFeedModel = new byte[0];
        this.itemType = i3;
        this.feed = gProContentRecommendFeed;
        this.robot = gProContentRecommendRobot;
        this.group = gProContentRecommendGroup;
        this.contentRecommendHotLive = gProContentRecommendHotLive;
        this.contentRecommendSelectedGuild = gProContentRecommendSelectedGuild;
        this.contentRecommendGuild = gProContentRecommendGuild;
        this.contentRecommendLive = gProContentRecommendLive;
        this.contentRecommendVoice = gProContentRecommendVoice;
        this.contentRecommendSchema = gProContentRecommendSchema;
        this.extra = gProExtra;
        this.tianShuAdItem = bArr;
    }
}
