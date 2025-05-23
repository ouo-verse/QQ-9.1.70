package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoAuthPayPanelEvent extends SimpleBaseEvent {
    private boolean isShow;

    public boolean isShow() {
        return this.isShow;
    }

    public void setShow(boolean z16) {
        this.isShow = z16;
    }
}
