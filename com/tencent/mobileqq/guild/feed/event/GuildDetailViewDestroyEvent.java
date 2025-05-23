package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDetailViewDestroyEvent extends SimpleBaseEvent {
    private boolean clickedLike;
    private int commentCount;
    private String feedId;
    private int likeCount;
    private int preferCount;
    private int preferStatus;
    private int shareCount;

    public GuildDetailViewDestroyEvent(String str, int i3, int i16, boolean z16, int i17) {
        this.feedId = str;
        this.likeCount = i16;
        this.commentCount = i3;
        this.shareCount = i17;
        this.clickedLike = z16;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public int getPreferCount() {
        return this.preferCount;
    }

    public int getPreferStatus() {
        return this.preferStatus;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public boolean isClickedLike() {
        return this.clickedLike;
    }

    public void setClickedLike(boolean z16) {
        this.clickedLike = z16;
    }

    public void setCommentCount(int i3) {
        this.commentCount = i3;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setLikeCount(int i3) {
        this.likeCount = i3;
    }

    public void setPreferCount(int i3) {
        this.preferCount = i3;
    }

    public void setPreferStatus(int i3) {
        this.preferStatus = i3;
    }

    public void setShareCount(int i3) {
        this.shareCount = i3;
    }

    public GuildDetailViewDestroyEvent(String str, int i3, int i16, int i17, int i18) {
        this.feedId = str;
        this.preferCount = i16;
        this.commentCount = i3;
        this.shareCount = i18;
        this.preferStatus = i17;
    }
}
