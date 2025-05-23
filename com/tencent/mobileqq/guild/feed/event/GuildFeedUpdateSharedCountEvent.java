package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedUpdateSharedCountEvent extends SimpleBaseEvent {
    private String feedId;
    private int sharedCount;

    public GuildFeedUpdateSharedCountEvent(String str, int i3) {
        this.sharedCount = i3;
        this.feedId = str;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getSharedCount() {
        return this.sharedCount;
    }
}
