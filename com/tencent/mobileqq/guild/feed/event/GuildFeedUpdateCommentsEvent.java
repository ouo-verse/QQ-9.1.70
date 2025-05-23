package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedUpdateCommentsEvent extends SimpleBaseEvent {
    public int mCount;
    public String mFeedId;

    public GuildFeedUpdateCommentsEvent(String str, int i3) {
        this.mCount = i3;
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getList() {
        return this.mCount;
    }
}
