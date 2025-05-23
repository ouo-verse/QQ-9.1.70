package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSDynamicUIBottomPanelVisibleEvent extends SimpleBaseEvent {
    private boolean mIsDynamicUIBottomPanelVisible;

    public QFSDynamicUIBottomPanelVisibleEvent(boolean z16) {
        this.mIsDynamicUIBottomPanelVisible = z16;
    }

    public boolean getIsDynamicUIBottomPanelVisible() {
        return this.mIsDynamicUIBottomPanelVisible;
    }
}
