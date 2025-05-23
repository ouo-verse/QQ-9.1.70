package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedVideoErrorEvent extends SimpleBaseEvent {
    private final s mErrorPresenterInfo;

    public QFSFeedVideoErrorEvent(s sVar) {
        this.mErrorPresenterInfo = sVar;
    }

    public s getErrorPresenterInfo() {
        return this.mErrorPresenterInfo;
    }
}
