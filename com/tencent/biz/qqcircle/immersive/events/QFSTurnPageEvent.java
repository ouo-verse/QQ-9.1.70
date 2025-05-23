package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSTurnPageEvent extends SimpleBaseEvent {
    private int mOffsetIndex;

    public QFSTurnPageEvent(int i3) {
        this.mOffsetIndex = i3;
    }

    public int getTurnOffsetIndex() {
        return this.mOffsetIndex;
    }
}
