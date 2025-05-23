package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTransActivityLifeEvent extends SimpleBaseEvent {
    public static final int EVENT_START = 0;
    public static final int EVENT_STOP = 1;
    private int mLifeEvent;

    public QCircleTransActivityLifeEvent(int i3) {
        this.mLifeEvent = i3;
    }

    public int getLifeEvent() {
        return this.mLifeEvent;
    }
}
