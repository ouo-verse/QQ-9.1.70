package com.tencent.mobileqq.guild.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedVideoCurrentTimeEvent extends SimpleBaseEvent {
    private long mCurrentTime;
    private String mFiledId;

    public GuildFeedVideoCurrentTimeEvent(long j3, String str) {
        this.mCurrentTime = j3;
        this.mFiledId = str;
    }

    public long getCurrentTime() {
        return this.mCurrentTime;
    }

    public String getFiledId() {
        return this.mFiledId;
    }

    public void setCurrentTime(long j3) {
        this.mCurrentTime = j3;
    }
}
