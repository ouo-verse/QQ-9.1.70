package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleShowSettingEvent extends SimpleBaseEvent {
    public int mCode;
    public boolean mShow;

    public QCircleShowSettingEvent(int i3, boolean z16) {
        this.mCode = i3;
        this.mShow = z16;
    }
}
