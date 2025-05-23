package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailClickLikeEvent extends SimpleBaseEvent {
    private boolean isLikeFeed;

    public GuildFeedDetailClickLikeEvent(boolean z16) {
        this.isLikeFeed = z16;
    }

    public boolean isLike() {
        return this.isLikeFeed;
    }
}
