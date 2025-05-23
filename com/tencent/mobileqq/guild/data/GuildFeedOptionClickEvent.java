package com.tencent.mobileqq.guild.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedOptionClickEvent extends SimpleBaseEvent {
    private final String feedId;

    public GuildFeedOptionClickEvent(String str) {
        this.feedId = str;
    }

    public String getFeedId() {
        return this.feedId;
    }
}
