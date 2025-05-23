package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSVideoLoopStartEvent extends SimpleBaseEvent {
    private final int mTabType;

    public QFSVideoLoopStartEvent(int i3) {
        this.mTabType = i3;
    }

    public int getTabType() {
        return this.mTabType;
    }
}
