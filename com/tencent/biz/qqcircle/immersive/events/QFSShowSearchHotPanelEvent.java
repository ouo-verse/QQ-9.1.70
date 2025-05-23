package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSShowSearchHotPanelEvent extends SimpleBaseEvent {
    private final boolean mIsShow;

    public QFSShowSearchHotPanelEvent(boolean z16) {
        this.mIsShow = z16;
    }

    public boolean isShow() {
        return this.mIsShow;
    }
}
