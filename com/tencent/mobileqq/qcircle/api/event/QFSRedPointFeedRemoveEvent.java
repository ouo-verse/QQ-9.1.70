package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QFSRedPointFeedRemoveEvent extends SimpleBaseEvent {
    private final int mSource;

    public QFSRedPointFeedRemoveEvent(int i3) {
        this.mSource = i3;
    }

    public int getSource() {
        return this.mSource;
    }
}
