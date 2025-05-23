package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes16.dex */
public class QFSPushRocketChargeTipsEvent extends SimpleBaseEvent {
    public String mToastText;

    public QFSPushRocketChargeTipsEvent(String str) {
        this.mToastText = str;
    }

    public String getToastText() {
        return this.mToastText;
    }
}
