package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QCirclePushEffectUpdateEvent extends SimpleBaseEvent {
    private final long mEndTime;
    private final long mStartTime;

    public QCirclePushEffectUpdateEvent(long j3, long j16) {
        this.mStartTime = j3;
        this.mEndTime = j16;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public long getStartTime() {
        return this.mStartTime;
    }
}
