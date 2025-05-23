package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchGuildFeed {
    public long channelId;
    public long commentCount;
    public long createTime;
    public long favorCount;
    public int feedType;
    public long guildId;
    public boolean needWebview;
    public long tinyId;
    public String feedId = "";
    public String nickName = "";
    public String title = "";
    public String content = "";
    public ArrayList<GProGuildSearchFeedImageEntity> images = new ArrayList<>();
    public ArrayList<GProGuildSearchFeedImageEntity> videos = new ArrayList<>();
    public byte[] oriContents = new byte[0];
    public ArrayList<Integer> functionList = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public long getCommentCount() {
        return this.commentCount;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getFavorCount() {
        return this.favorCount;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public ArrayList<Integer> getFunctionList() {
        return this.functionList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<GProGuildSearchFeedImageEntity> getImages() {
        return this.images;
    }

    public boolean getNeedWebview() {
        return this.needWebview;
    }

    public String getNickName() {
        return this.nickName;
    }

    public byte[] getOriContents() {
        return this.oriContents;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<GProGuildSearchFeedImageEntity> getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProGuildSearchGuildFeed{feedId=" + this.feedId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",createTime=" + this.createTime + ",nickName=" + this.nickName + ",title=" + this.title + ",content=" + this.content + ",images=" + this.images + ",videos=" + this.videos + ",favorCount=" + this.favorCount + ",commentCount=" + this.commentCount + ",oriContents=" + this.oriContents + ",needWebview=" + this.needWebview + ",feedType=" + this.feedType + ",functionList=" + this.functionList + ",}";
    }
}
