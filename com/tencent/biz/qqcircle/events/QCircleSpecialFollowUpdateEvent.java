package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleSpecialFollowUpdateEvent extends SimpleBaseEvent {
    public final boolean isFollow;
    public final String uin;

    public QCircleSpecialFollowUpdateEvent(String str, boolean z16) {
        this.uin = str;
        this.isFollow = z16;
    }

    public String toString() {
        return "QCircleSpecialFollowUpdateEvent{uin='" + this.uin + "', isFollow=" + this.isFollow + '}';
    }
}
