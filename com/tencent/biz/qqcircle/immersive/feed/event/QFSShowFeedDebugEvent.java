package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSShowFeedDebugEvent extends SimpleBaseEvent {
    private final boolean mShowFeedInfo;

    public QFSShowFeedDebugEvent(boolean z16) {
        this.mShowFeedInfo = z16;
    }

    public boolean isShowFeedInfo() {
        return this.mShowFeedInfo;
    }
}
