package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildCreateTextLinkEvent extends SimpleBaseEvent {
    public String desc;
    public String url;

    public GuildCreateTextLinkEvent(String str, String str2) {
        this.url = str;
        this.desc = str2;
    }

    public String toString() {
        return "GuildCreateTextLinkEvent{url='" + this.url + "', desc='" + this.desc + "'}";
    }
}
