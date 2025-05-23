package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSUpdateSuspendBoxCountEvent extends SimpleBaseEvent {
    private boolean mIsOpenAll;

    public QFSUpdateSuspendBoxCountEvent(boolean z16) {
        this.mIsOpenAll = z16;
    }

    public boolean getIsOpenAll() {
        return this.mIsOpenAll;
    }
}
