package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTroopRefreshEvent extends SimpleBaseEvent {
    private boolean mForceRefresh;
    private boolean mForceSortByHot;

    public GuildFeedTroopRefreshEvent(boolean z16, boolean z17) {
        this.mForceRefresh = z16;
        this.mForceSortByHot = z17;
    }

    public boolean getForceRefresh() {
        return this.mForceRefresh;
    }

    public boolean getForceSortByHot() {
        return this.mForceSortByHot;
    }
}
