package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedSortModeChangeEvent extends SimpleBaseEvent {
    private final int mSortMode;

    public GuildFeedSortModeChangeEvent(int i3) {
        this.mSortMode = i3;
    }

    public int geSortMode() {
        return this.mSortMode;
    }
}
