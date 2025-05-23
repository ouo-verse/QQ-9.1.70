package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleShoppingLayerExitEvent extends SimpleBaseEvent {
    private int mPos;

    public QCircleShoppingLayerExitEvent(int i3) {
        this.mPos = i3;
    }

    public int getCurPosition() {
        return this.mPos;
    }
}
