package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedVideoCurrentTimeEvent extends SimpleBaseEvent {
    private long mCurrentTime;

    public QCircleFeedVideoCurrentTimeEvent(long j3) {
        this.mCurrentTime = j3;
    }

    public long getCurrentTime() {
        return this.mCurrentTime;
    }

    public void setCurrentTime(long j3) {
        this.mCurrentTime = j3;
    }
}
