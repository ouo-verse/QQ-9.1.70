package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUserResetEvent extends SimpleBaseEvent {
    private final int mUnique;

    public QFSUserResetEvent(int i3) {
        this.mUnique = i3;
    }

    public int getUnique() {
        return this.mUnique;
    }
}
