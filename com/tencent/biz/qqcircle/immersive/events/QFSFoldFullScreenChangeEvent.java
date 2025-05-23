package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFoldFullScreenChangeEvent extends SimpleBaseEvent {
    private final int mHashCode;
    private final boolean mIsEnter;

    public QFSFoldFullScreenChangeEvent(int i3, boolean z16) {
        this.mHashCode = i3;
        this.mIsEnter = z16;
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public boolean isEnter() {
        return this.mIsEnter;
    }
}
