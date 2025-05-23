package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoAuthPayReloadEvent extends SimpleBaseEvent {
    private boolean ignorePos;
    private int pos;

    public int getPos() {
        return this.pos;
    }

    public boolean isIgnorePos() {
        return this.ignorePos;
    }

    public void setIgnorePos(boolean z16) {
        this.ignorePos = z16;
    }

    public void setPos(int i3) {
        this.pos = i3;
    }
}
