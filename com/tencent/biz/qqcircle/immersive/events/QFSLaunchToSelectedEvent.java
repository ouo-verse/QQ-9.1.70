package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLaunchToSelectedEvent extends SimpleBaseEvent {
    public int mLaunchTo;

    public QFSLaunchToSelectedEvent(int i3) {
        this.mLaunchTo = i3;
    }
}
