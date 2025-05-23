package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoFloatingWindowEvent extends SimpleBaseEvent {
    private final boolean enterFloatingWindow;
    private boolean isAuto;

    public QFSTVideoFloatingWindowEvent(boolean z16) {
        this.enterFloatingWindow = z16;
    }

    public boolean isAuto() {
        return this.isAuto;
    }

    public boolean isEnterFloatingWindow() {
        return this.enterFloatingWindow;
    }

    public void setAuto(boolean z16) {
        this.isAuto = z16;
    }
}
