package com.qzone.reborn.qzmoment.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qzonemoment.QZMomentMeta$StFeed;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMNotifyDeleteFeedEvent extends SimpleBaseEvent {
    private QZMomentMeta$StFeed mFeed;

    public QZMNotifyDeleteFeedEvent(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        this.mFeed = qZMomentMeta$StFeed;
    }

    public QZMomentMeta$StFeed getFeed() {
        return this.mFeed;
    }
}
