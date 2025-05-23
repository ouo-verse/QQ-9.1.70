package com.tencent.mobileqq.tvideo.pr;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class TVideoRightPrPositionEvent extends SimpleBaseEvent {
    private int yPosition;

    public int getYPosition() {
        return this.yPosition;
    }

    public void setYPosition(int i3) {
        this.yPosition = i3;
    }
}
