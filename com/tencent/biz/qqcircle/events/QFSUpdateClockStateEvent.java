package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUpdateClockStateEvent extends SimpleBaseEvent {
    private int mDayCount;
    private boolean mIsAllComplete;

    public QFSUpdateClockStateEvent(int i3, boolean z16) {
        this.mDayCount = i3;
        this.mIsAllComplete = z16;
    }

    public int getDayCount() {
        return this.mDayCount;
    }

    public boolean isAllComplete() {
        return this.mIsAllComplete;
    }
}
