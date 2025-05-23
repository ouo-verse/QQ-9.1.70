package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSExitFoldCacheSaveEvent extends SimpleBaseEvent {
    private final int mContextHashCode;

    public QFSExitFoldCacheSaveEvent(int i3) {
        this.mContextHashCode = i3;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }
}
