package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedShowBubbleEvent extends SimpleBaseEvent {
    private final String mMsg;

    public GuildFeedShowBubbleEvent(String str) {
        this.mMsg = str;
    }

    public String getMsg() {
        return this.mMsg;
    }
}
