package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildDraftNativeAutoRestoreEvent extends SimpleBaseEvent {
    private String mMainTaskId;

    public GuildDraftNativeAutoRestoreEvent(String str) {
        this.mMainTaskId = str;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public void setMainTaskId(String str) {
        this.mMainTaskId = str;
    }

    public String toString() {
        return "GuildDraftNativeAutoRestoreEvent{mFeedJson='" + this.mMainTaskId + "'} " + super.toString();
    }
}
