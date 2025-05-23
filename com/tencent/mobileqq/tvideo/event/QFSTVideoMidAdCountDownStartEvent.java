package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoMidAdCountDownStartEvent extends SimpleBaseEvent {
    public int adType;

    public QFSTVideoMidAdCountDownStartEvent(int i3) {
        this.adType = i3;
    }
}
