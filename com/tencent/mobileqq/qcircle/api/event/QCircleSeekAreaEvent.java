package com.tencent.mobileqq.qcircle.api.event;

import android.view.MotionEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleSeekAreaEvent extends SimpleBaseEvent {
    private MotionEvent mEvent;

    public QCircleSeekAreaEvent(MotionEvent motionEvent) {
        this.mEvent = motionEvent;
    }

    public MotionEvent getEvent() {
        return this.mEvent;
    }
}
