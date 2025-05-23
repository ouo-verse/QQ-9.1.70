package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRocketNumUpdateEvent extends SimpleBaseEvent {
    private final int mCount;

    public QFSRocketNumUpdateEvent(int i3) {
        this.mCount = i3;
    }

    public int getCount() {
        return this.mCount;
    }
}
