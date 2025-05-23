package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoFloatingWindowStatusEvent extends SimpleBaseEvent {
    private final int status;

    public QFSTVideoFloatingWindowStatusEvent(int i3) {
        this.status = i3;
    }

    public int getStatus() {
        return this.status;
    }
}
