package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleActivityFocusChangeEvent extends SimpleBaseEvent {
    private final boolean mHasFocus;

    public QCircleActivityFocusChangeEvent(boolean z16) {
        this.mHasFocus = z16;
    }

    public boolean hasFocus() {
        return this.mHasFocus;
    }
}
