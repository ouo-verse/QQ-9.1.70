package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedTroopLifeCycleEvent extends SimpleBaseEvent {
    private int mLifeCycleType;

    public GuildFeedTroopLifeCycleEvent(int i3) {
        this.mLifeCycleType = i3;
    }

    public int getTroopContainerLifeCycle() {
        return this.mLifeCycleType;
    }
}
