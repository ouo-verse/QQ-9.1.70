package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes13.dex */
public class GuildFeedUpdatePreferEvent extends SimpleBaseEvent {
    private String feedId;
    private int preferCount;
    private int preferStatus;

    public GuildFeedUpdatePreferEvent(String str, int i3, int i16) {
        this.preferCount = i3;
        this.feedId = str;
        this.preferStatus = i16;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getPreferCount() {
        return this.preferCount;
    }

    public int getPreferStatus() {
        return this.preferStatus;
    }
}
