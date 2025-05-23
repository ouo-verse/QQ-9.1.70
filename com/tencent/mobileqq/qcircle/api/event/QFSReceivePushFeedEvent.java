package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QFSReceivePushFeedEvent extends SimpleBaseEvent {
    public final boolean isTabPage;

    public QFSReceivePushFeedEvent(boolean z16) {
        this.isTabPage = z16;
    }
}
