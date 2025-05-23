package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBeKickedEvent extends SimpleBaseEvent {
    private final int mBlackType;
    private final String mGuildId;

    public GuildBeKickedEvent(String str, int i3) {
        this.mGuildId = str;
        this.mBlackType = i3;
    }

    public int getBlackType() {
        return this.mBlackType;
    }

    public String getGuildId() {
        return this.mGuildId;
    }
}
