package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSResetPersonalInfoEvent extends SimpleBaseEvent {
    private final int mHashCode;

    public QFSResetPersonalInfoEvent(int i3) {
        this.mHashCode = i3;
    }

    public int getHashCode() {
        return this.mHashCode;
    }
}
