package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSSelectTabEvent extends SimpleBaseEvent {
    private boolean mUseDarkTheme;

    public QFSSelectTabEvent(boolean z16) {
        this.mUseDarkTheme = z16;
    }

    public boolean useDarkTheme() {
        return this.mUseDarkTheme;
    }
}
