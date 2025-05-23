package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleAddblackUpdateEvent extends SimpleBaseEvent {
    public int blackstate;
    public String mUserId;

    public QCircleAddblackUpdateEvent(int i3, String str) {
        this.blackstate = i3;
        this.mUserId = str;
    }
}
