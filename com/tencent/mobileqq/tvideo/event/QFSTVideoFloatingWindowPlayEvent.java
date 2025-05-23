package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoFloatingWindowPlayEvent extends SimpleBaseEvent {
    private final boolean isPlaying;

    public QFSTVideoFloatingWindowPlayEvent(boolean z16) {
        this.isPlaying = z16;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
