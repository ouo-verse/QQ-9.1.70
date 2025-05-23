package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProFeedSearchInfo {
    public long channelId;
    public long commentCount;
    public long createTime;
    public long favorCount;
    public long guildId;
    public int showType;
    public int type;
    public String feedId = "";
    public String userId = "";
    public String title = "";
    public String content = "";
    public ArrayList<GProFeedImageEntity> images = new ArrayList<>();
    public String inviteCode = "";
    public GProSearchUser creator = new GProSearchUser();
    public String guildName = "";
    public String guildHeadUrl = "";
    public String joinGuildSig = "";
    public GProFeedImageEntity videoCoverUrl = new GProFeedImageEntity();
    public ArrayList<String> tags = new ArrayList<>();
    public GProRecallInfo recallInfo = new GProRecallInfo();
    public String contentId = "";
    public ArrayList<String> highlightWords = new ArrayList<>();
    public GProSuggestedSearch suggestedSearchInfo = new GProSuggestedSearch();
    public byte[] stFeed = new byte[0];

    public long getChannelId() {
        return this.channelId;
    }

    public long getCommentCount() {
        return this.commentCount;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentId() {
        return this.contentId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProSearchUser getCreator() {
        return this.creator;
    }

    public long getFavorCount() {
        return this.favorCount;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getGuildHeadUrl() {
        return this.guildHeadUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public ArrayList<GProFeedImageEntity> getImages() {
        return this.images;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public int getShowType() {
        return this.showType;
    }

    public byte[] getStFeed() {
        return this.stFeed;
    }

    public GProSuggestedSearch getSuggestedSearchInfo() {
        return this.suggestedSearchInfo;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUserId() {
        return this.userId;
    }

    public GProFeedImageEntity getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public String toString() {
        return "GProFeedSearchInfo{feedId=" + this.feedId + ",userId=" + this.userId + ",createTime=" + this.createTime + ",title=" + this.title + ",content=" + this.content + ",images=" + this.images + ",inviteCode=" + this.inviteCode + ",creator=" + this.creator + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildHeadUrl=" + this.guildHeadUrl + ",channelId=" + this.channelId + ",joinGuildSig=" + this.joinGuildSig + ",type=" + this.type + ",videoCoverUrl=" + this.videoCoverUrl + ",tags=" + this.tags + ",recallInfo=" + this.recallInfo + ",favorCount=" + this.favorCount + ",commentCount=" + this.commentCount + ",contentId=" + this.contentId + ",highlightWords=" + this.highlightWords + ",suggestedSearchInfo=" + this.suggestedSearchInfo + ",stFeed=" + this.stFeed + ",showType=" + this.showType + ",}";
    }
}
