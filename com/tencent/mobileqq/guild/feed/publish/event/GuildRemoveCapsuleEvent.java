package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRemoveCapsuleEvent extends SimpleBaseEvent {
    public String mGuildId;

    public GuildRemoveCapsuleEvent(String str) {
        this.mGuildId = str;
    }
}
