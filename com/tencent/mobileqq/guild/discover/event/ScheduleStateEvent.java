package com.tencent.mobileqq.guild.discover.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ScheduleStateEvent extends SimpleBaseEvent {
    private final long scheduleId;
    private final int scheduleState;

    public ScheduleStateEvent(long j3, int i3) {
        this.scheduleId = j3;
        this.scheduleState = i3;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public int getScheduleState() {
        return this.scheduleState;
    }
}
