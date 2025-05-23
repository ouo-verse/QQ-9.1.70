package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMuteSwitchChangeEvent extends SimpleBaseEvent {
    private boolean mIsSwitchOpen;

    public QFSMuteSwitchChangeEvent(boolean z16) {
        this.mIsSwitchOpen = z16;
    }

    public boolean isSwitchOpen() {
        return this.mIsSwitchOpen;
    }

    public String toString() {
        return "QFSMuteSwitchChangeEvent{mIsSwitchOpen=" + this.mIsSwitchOpen + '}';
    }
}
