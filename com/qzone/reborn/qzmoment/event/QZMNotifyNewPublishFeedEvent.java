package com.qzone.reborn.qzmoment.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qzonemoment.QZMomentMeta$StFeed;

/* loaded from: classes37.dex */
public class QZMNotifyNewPublishFeedEvent extends SimpleBaseEvent {
    public QZMomentMeta$StFeed mNewFeed;

    public QZMNotifyNewPublishFeedEvent(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        this.mNewFeed = qZMomentMeta$StFeed;
    }
}
