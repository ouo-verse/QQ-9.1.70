package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import qqcircle.QQCircleFeedBase$StUserPushBoxInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSuspendOpenBoxUpdateEvent extends SimpleBaseEvent {
    private QQCircleFeedBase$StUserPushBoxInfo mPushBoxInfo;

    public QFSSuspendOpenBoxUpdateEvent(QQCircleFeedBase$StUserPushBoxInfo qQCircleFeedBase$StUserPushBoxInfo) {
        this.mPushBoxInfo = qQCircleFeedBase$StUserPushBoxInfo;
    }

    public QQCircleFeedBase$StUserPushBoxInfo getPushBoxInfo() {
        return this.mPushBoxInfo;
    }
}
