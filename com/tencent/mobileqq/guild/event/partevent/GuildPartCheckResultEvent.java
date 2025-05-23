package com.tencent.mobileqq.guild.event.partevent;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildPartCheckResultEvent extends SimpleBaseEvent {
    public boolean hasComChannelCanSpeak;
    public boolean isEmpty;
    public boolean isOpenChannelSelected;

    public GuildPartCheckResultEvent() {
        this.isEmpty = true;
        this.hasComChannelCanSpeak = false;
        this.isOpenChannelSelected = false;
    }

    public GuildPartCheckResultEvent(boolean z16, boolean z17, boolean z18) {
        this.isEmpty = z16;
        this.hasComChannelCanSpeak = z17;
        this.isOpenChannelSelected = z18;
    }
}
