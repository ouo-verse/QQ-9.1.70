package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTriggerBottomRefreshEvent extends SimpleBaseEvent {
    private boolean mShouldCheckRefresh;

    public QCircleTriggerBottomRefreshEvent(boolean z16) {
        this.mShouldCheckRefresh = z16;
    }

    public boolean needCheckRefresh() {
        return this.mShouldCheckRefresh;
    }
}
