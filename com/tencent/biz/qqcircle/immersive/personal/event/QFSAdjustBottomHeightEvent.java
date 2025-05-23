package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAdjustBottomHeightEvent extends SimpleBaseEvent {
    private int mHashCode;

    public QFSAdjustBottomHeightEvent(int i3) {
        this.mHashCode = i3;
    }

    public int getHashCode() {
        return this.mHashCode;
    }
}
