package com.tencent.biz.qqcircle.debug;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSShowNotificationEvent extends SimpleBaseEvent {
    public String jumpUrl;

    public QFSShowNotificationEvent(String str) {
        this.jumpUrl = str;
    }
}
