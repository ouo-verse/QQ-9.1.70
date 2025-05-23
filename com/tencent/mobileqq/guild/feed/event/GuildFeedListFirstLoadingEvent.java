package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedListFirstLoadingEvent extends SimpleBaseEvent {
    private boolean mLoadingFinish;

    public GuildFeedListFirstLoadingEvent(boolean z16) {
        this.mLoadingFinish = z16;
    }

    public boolean isLoadingFinish() {
        return this.mLoadingFinish;
    }
}
