package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoScrollToNextEvent extends SimpleBaseEvent {
    private int nextPos;

    public int getNextPos() {
        return this.nextPos;
    }

    public void setNextPos(int i3) {
        this.nextPos = i3;
    }
}
