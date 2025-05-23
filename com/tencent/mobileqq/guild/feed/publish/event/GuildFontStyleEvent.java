package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import jn1.c;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFontStyleEvent extends SimpleBaseEvent {
    private c mGuildSetFontStyleInfo;

    public GuildFontStyleEvent(c cVar) {
        this.mGuildSetFontStyleInfo = cVar;
    }

    public c getGuildSetFontStyleInfo() {
        return this.mGuildSetFontStyleInfo;
    }

    public void setGuildSetFontStyleInfo(c cVar) {
        this.mGuildSetFontStyleInfo = cVar;
    }

    public String toString() {
        return "GuildFontStyleEvent{mGuildSetFontStyleInfo=" + this.mGuildSetFontStyleInfo + "} " + super.toString();
    }
}
