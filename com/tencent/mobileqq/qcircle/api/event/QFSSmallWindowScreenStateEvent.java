package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSSmallWindowScreenStateEvent extends SimpleBaseEvent {
    private boolean mIsLockScreen;

    public QFSSmallWindowScreenStateEvent(boolean z16) {
        this.mIsLockScreen = z16;
    }

    public boolean isLockScreen() {
        return this.mIsLockScreen;
    }
}
