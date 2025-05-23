package com.tencent.mobileqq.guild.feed.launcher;

/* loaded from: classes13.dex */
public class GuildFeedPublishEditPostInitBean extends GuildFeedPublishInitBean {
    private long mCreateTime;
    private String mFeedId;
    private String mPosterTinyId;

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public String getPosterTinyId() {
        return this.mPosterTinyId;
    }

    public void setCreateTime(long j3) {
        this.mCreateTime = j3;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setPosterTinyId(String str) {
        this.mPosterTinyId = str;
    }

    @Override // com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean, com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean
    public String toString() {
        return "GuildFeedPublishEditPostInitBean{mFeedId='" + this.mFeedId + "', mCreateTime=" + this.mCreateTime + ", posterTinyId='" + this.mPosterTinyId + "'} " + super.toString();
    }
}
