package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLaunchFolderEvent extends SimpleBaseEvent {
    private final boolean mJumpTabPage;

    public QCircleLaunchFolderEvent(boolean z16) {
        this.mJumpTabPage = z16;
    }

    public boolean isJumpTabPage() {
        return this.mJumpTabPage;
    }
}
