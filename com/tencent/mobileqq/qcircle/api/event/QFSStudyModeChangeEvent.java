package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSStudyModeChangeEvent extends SimpleBaseEvent {
    private final boolean mIsStudyMode;

    public QFSStudyModeChangeEvent(boolean z16) {
        this.mIsStudyMode = z16;
    }

    public boolean isStudyMode() {
        return this.mIsStudyMode;
    }
}
