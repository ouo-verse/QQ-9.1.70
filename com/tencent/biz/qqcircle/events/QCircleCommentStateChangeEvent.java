package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleCommentStateChangeEvent extends SimpleBaseEvent {
    private boolean mIsDragging;

    public QCircleCommentStateChangeEvent(boolean z16) {
        this.mIsDragging = z16;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }
}
