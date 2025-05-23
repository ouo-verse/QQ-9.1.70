package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildFeedDetailClickPreferEvent extends SimpleBaseEvent {
    private int mPreferActtion;

    public GuildFeedDetailClickPreferEvent(int i3) {
        this.mPreferActtion = i3;
    }

    public int getPreferAction() {
        return this.mPreferActtion;
    }
}
