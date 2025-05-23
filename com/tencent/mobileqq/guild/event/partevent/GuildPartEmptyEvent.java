package com.tencent.mobileqq.guild.event.partevent;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildPartEmptyEvent extends SimpleBaseEvent {
    public boolean isEmpty;

    public GuildPartEmptyEvent() {
        this.isEmpty = true;
    }

    public GuildPartEmptyEvent(boolean z16) {
        this.isEmpty = z16;
    }
}
