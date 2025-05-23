package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedUpdateLikeEvent extends SimpleBaseEvent {
    private String feedId;
    private boolean isClicked;
    private int likeCount;

    public GuildFeedUpdateLikeEvent(String str, int i3, boolean z16) {
        this.likeCount = i3;
        this.feedId = str;
        this.isClicked = z16;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public int getLikeCount() {
        return this.likeCount;
    }
}
