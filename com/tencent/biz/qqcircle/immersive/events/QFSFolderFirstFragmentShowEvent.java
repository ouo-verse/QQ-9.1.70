package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFolderFirstFragmentShowEvent extends SimpleBaseEvent {
    private final int mActivityHashCode;

    public QFSFolderFirstFragmentShowEvent(int i3) {
        this.mActivityHashCode = i3;
    }

    public int getActivityHashCode() {
        return this.mActivityHashCode;
    }
}
