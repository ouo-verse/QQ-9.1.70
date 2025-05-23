package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentTabSelectEvent extends SimpleBaseEvent {
    private final int mCurTabIndex;

    public QFSCommentTabSelectEvent(int i3) {
        this.mCurTabIndex = i3;
    }

    public int getCurTabIndex() {
        return this.mCurTabIndex;
    }
}
