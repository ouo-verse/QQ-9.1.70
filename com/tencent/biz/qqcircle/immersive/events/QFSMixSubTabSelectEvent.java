package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixSubTabSelectEvent extends SimpleBaseEvent {
    private final int mActivityHashCode;
    private final int mSelectPos;

    public QFSMixSubTabSelectEvent(int i3, int i16) {
        this.mSelectPos = i3;
        this.mActivityHashCode = i16;
    }

    public int getActivityHashCode() {
        return this.mActivityHashCode;
    }

    public int getSelectPos() {
        return this.mSelectPos;
    }
}
