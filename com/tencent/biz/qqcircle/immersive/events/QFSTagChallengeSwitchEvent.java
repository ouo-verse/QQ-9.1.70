package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTagChallengeSwitchEvent extends SimpleBaseEvent {
    private int mSwitchDirection;

    public QFSTagChallengeSwitchEvent() {
        this.mSwitchDirection = 0;
    }

    public int getSwitchDirection() {
        return this.mSwitchDirection;
    }

    public QFSTagChallengeSwitchEvent(int i3) {
        this.mSwitchDirection = i3;
    }
}
