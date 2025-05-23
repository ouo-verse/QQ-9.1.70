package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDraftH5AutoRestoreEvent extends SimpleBaseEvent {
    private String mFeedJson;

    public GuildDraftH5AutoRestoreEvent(String str) {
        this.mFeedJson = str;
    }

    public String getFeedJson() {
        return this.mFeedJson;
    }

    public void setFeedJson(String str) {
        this.mFeedJson = str;
    }

    public String toString() {
        return "GuildDraftH5AutoRestoreEvent{mFeedJson='" + this.mFeedJson + "'} " + super.toString();
    }
}
