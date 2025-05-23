package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendItem implements Serializable {
    public GProStickyFeedChannel activeFeedChannel;
    public GProStickyTextChannel activeTextChannel;
    public GProActiveUser activeUser;
    public byte[] adFeedModel;
    public GProAdInfo adInfo;
    public ArrayList<GProRecommendCategory> categories;
    public GProRecommendChannelInfo channelInfo;
    public GProRecommendExtra extra;
    public GProRecommendMyFeed feed;
    public GProRecommendItemForumChannel forumChannel;
    public GProRecommendH5GameChannel h5gameChannel;
    public GProItemHeadInfo itemHeadInfo;
    public String itemId;
    public long itemIdUint64;
    public int itemType;
    public GProPageHeadInfo pageHeadInfo;
    public GProQuickJoinBlock quickJoinBlock;
    public GProRecommendLiveChannel recommendLiveChannel;
    public ArrayList<String> recommendReasons;
    public GProRecommendRobotDrawCard robotDrawCard;
    public GProRecommendRobotGameCard robotGameCard;
    public GProSearchItem searchItem;
    long serialVersionUID;
    public int templateType;
    public GProRecommendTextChannel textChannel;
    public GProRecommendVoiceChannel voiceChannel;
    public GProVoiceTemplateChannel voiceTemplate;

    public GProRecommendItem() {
        this.serialVersionUID = 1L;
        this.itemId = "";
        this.channelInfo = new GProRecommendChannelInfo();
        this.recommendLiveChannel = new GProRecommendLiveChannel();
        this.voiceChannel = new GProRecommendVoiceChannel();
        this.feed = new GProRecommendMyFeed();
        this.categories = new ArrayList<>();
        this.h5gameChannel = new GProRecommendH5GameChannel();
        this.adInfo = new GProAdInfo();
        this.forumChannel = new GProRecommendItemForumChannel();
        this.extra = new GProRecommendExtra();
        this.voiceTemplate = new GProVoiceTemplateChannel();
        this.quickJoinBlock = new GProQuickJoinBlock();
        this.textChannel = new GProRecommendTextChannel();
        this.robotDrawCard = new GProRecommendRobotDrawCard();
        this.robotGameCard = new GProRecommendRobotGameCard();
        this.adFeedModel = new byte[0];
        this.activeTextChannel = new GProStickyTextChannel();
        this.activeFeedChannel = new GProStickyFeedChannel();
        this.activeUser = new GProActiveUser();
        this.pageHeadInfo = new GProPageHeadInfo();
        this.itemHeadInfo = new GProItemHeadInfo();
        this.searchItem = new GProSearchItem();
        this.recommendReasons = new ArrayList<>();
    }

    public GProStickyFeedChannel getActiveFeedChannel() {
        return this.activeFeedChannel;
    }

    public GProStickyTextChannel getActiveTextChannel() {
        return this.activeTextChannel;
    }

    public GProActiveUser getActiveUser() {
        return this.activeUser;
    }

    public byte[] getAdFeedModel() {
        return this.adFeedModel;
    }

    public GProAdInfo getAdInfo() {
        return this.adInfo;
    }

    public ArrayList<GProRecommendCategory> getCategories() {
        return this.categories;
    }

    public GProRecommendChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public GProRecommendExtra getExtra() {
        return this.extra;
    }

    public GProRecommendMyFeed getFeed() {
        return this.feed;
    }

    public GProRecommendItemForumChannel getForumChannel() {
        return this.forumChannel;
    }

    public GProRecommendH5GameChannel getH5gameChannel() {
        return this.h5gameChannel;
    }

    public GProItemHeadInfo getItemHeadInfo() {
        return this.itemHeadInfo;
    }

    public String getItemId() {
        return this.itemId;
    }

    public long getItemIdUint64() {
        return this.itemIdUint64;
    }

    public int getItemType() {
        return this.itemType;
    }

    public GProPageHeadInfo getPageHeadInfo() {
        return this.pageHeadInfo;
    }

    public GProQuickJoinBlock getQuickJoinBlock() {
        return this.quickJoinBlock;
    }

    public GProRecommendLiveChannel getRecommendLiveChannel() {
        return this.recommendLiveChannel;
    }

    public ArrayList<String> getRecommendReasons() {
        return this.recommendReasons;
    }

    public GProRecommendRobotDrawCard getRobotDrawCard() {
        return this.robotDrawCard;
    }

    public GProRecommendRobotGameCard getRobotGameCard() {
        return this.robotGameCard;
    }

    public GProSearchItem getSearchItem() {
        return this.searchItem;
    }

    public int getTemplateType() {
        return this.templateType;
    }

    public GProRecommendTextChannel getTextChannel() {
        return this.textChannel;
    }

    public GProRecommendVoiceChannel getVoiceChannel() {
        return this.voiceChannel;
    }

    public GProVoiceTemplateChannel getVoiceTemplate() {
        return this.voiceTemplate;
    }

    public String toString() {
        return "GProRecommendItem{itemId=" + this.itemId + ",itemType=" + this.itemType + ",channelInfo=" + this.channelInfo + ",recommendLiveChannel=" + this.recommendLiveChannel + ",voiceChannel=" + this.voiceChannel + ",feed=" + this.feed + ",itemIdUint64=" + this.itemIdUint64 + ",categories=" + this.categories + ",h5gameChannel=" + this.h5gameChannel + ",adInfo=" + this.adInfo + ",forumChannel=" + this.forumChannel + ",extra=" + this.extra + ",voiceTemplate=" + this.voiceTemplate + ",quickJoinBlock=" + this.quickJoinBlock + ",textChannel=" + this.textChannel + ",robotDrawCard=" + this.robotDrawCard + ",robotGameCard=" + this.robotGameCard + ",adFeedModel=" + this.adFeedModel + ",templateType=" + this.templateType + ",activeTextChannel=" + this.activeTextChannel + ",activeFeedChannel=" + this.activeFeedChannel + ",activeUser=" + this.activeUser + ",pageHeadInfo=" + this.pageHeadInfo + ",itemHeadInfo=" + this.itemHeadInfo + ",searchItem=" + this.searchItem + ",recommendReasons=" + this.recommendReasons + ",}";
    }

    public GProRecommendItem(String str, int i3, GProRecommendChannelInfo gProRecommendChannelInfo, GProRecommendLiveChannel gProRecommendLiveChannel, GProRecommendVoiceChannel gProRecommendVoiceChannel, GProRecommendMyFeed gProRecommendMyFeed, long j3, ArrayList<GProRecommendCategory> arrayList, GProRecommendH5GameChannel gProRecommendH5GameChannel, GProAdInfo gProAdInfo, GProRecommendItemForumChannel gProRecommendItemForumChannel, GProRecommendExtra gProRecommendExtra, GProVoiceTemplateChannel gProVoiceTemplateChannel, GProQuickJoinBlock gProQuickJoinBlock, GProRecommendTextChannel gProRecommendTextChannel, GProRecommendRobotDrawCard gProRecommendRobotDrawCard, GProRecommendRobotGameCard gProRecommendRobotGameCard, byte[] bArr, int i16, GProStickyTextChannel gProStickyTextChannel, GProStickyFeedChannel gProStickyFeedChannel, GProActiveUser gProActiveUser, GProPageHeadInfo gProPageHeadInfo, GProItemHeadInfo gProItemHeadInfo, GProSearchItem gProSearchItem, ArrayList<String> arrayList2) {
        this.serialVersionUID = 1L;
        this.itemId = "";
        this.channelInfo = new GProRecommendChannelInfo();
        this.recommendLiveChannel = new GProRecommendLiveChannel();
        this.voiceChannel = new GProRecommendVoiceChannel();
        this.feed = new GProRecommendMyFeed();
        this.categories = new ArrayList<>();
        this.h5gameChannel = new GProRecommendH5GameChannel();
        this.adInfo = new GProAdInfo();
        this.forumChannel = new GProRecommendItemForumChannel();
        this.extra = new GProRecommendExtra();
        this.voiceTemplate = new GProVoiceTemplateChannel();
        this.quickJoinBlock = new GProQuickJoinBlock();
        this.textChannel = new GProRecommendTextChannel();
        this.robotDrawCard = new GProRecommendRobotDrawCard();
        this.robotGameCard = new GProRecommendRobotGameCard();
        this.adFeedModel = new byte[0];
        this.activeTextChannel = new GProStickyTextChannel();
        this.activeFeedChannel = new GProStickyFeedChannel();
        this.activeUser = new GProActiveUser();
        this.pageHeadInfo = new GProPageHeadInfo();
        this.itemHeadInfo = new GProItemHeadInfo();
        this.searchItem = new GProSearchItem();
        new ArrayList();
        this.itemId = str;
        this.itemType = i3;
        this.channelInfo = gProRecommendChannelInfo;
        this.recommendLiveChannel = gProRecommendLiveChannel;
        this.voiceChannel = gProRecommendVoiceChannel;
        this.feed = gProRecommendMyFeed;
        this.itemIdUint64 = j3;
        this.categories = arrayList;
        this.h5gameChannel = gProRecommendH5GameChannel;
        this.adInfo = gProAdInfo;
        this.forumChannel = gProRecommendItemForumChannel;
        this.extra = gProRecommendExtra;
        this.voiceTemplate = gProVoiceTemplateChannel;
        this.quickJoinBlock = gProQuickJoinBlock;
        this.textChannel = gProRecommendTextChannel;
        this.robotDrawCard = gProRecommendRobotDrawCard;
        this.robotGameCard = gProRecommendRobotGameCard;
        this.adFeedModel = bArr;
        this.templateType = i16;
        this.activeTextChannel = gProStickyTextChannel;
        this.activeFeedChannel = gProStickyFeedChannel;
        this.activeUser = gProActiveUser;
        this.pageHeadInfo = gProPageHeadInfo;
        this.itemHeadInfo = gProItemHeadInfo;
        this.searchItem = gProSearchItem;
        this.recommendReasons = arrayList2;
    }
}
