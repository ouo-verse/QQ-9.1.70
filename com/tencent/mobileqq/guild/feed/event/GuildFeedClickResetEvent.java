package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedClickResetEvent extends SimpleBaseEvent {
    private String mTag;

    public GuildFeedClickResetEvent(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String toString() {
        return "GuildFeedClickResetEvent{mTag='" + this.mTag + "'} " + super.toString();
    }
}
