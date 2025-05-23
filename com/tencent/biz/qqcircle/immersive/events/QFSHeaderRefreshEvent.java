package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSHeaderRefreshEvent extends SimpleBaseEvent {
    public boolean mIsCompleted;
    private int mTabType;

    public QFSHeaderRefreshEvent(boolean z16, int i3) {
        this.mIsCompleted = z16;
        this.mTabType = i3;
    }

    public int getTabType() {
        return this.mTabType;
    }

    public boolean isCompleted() {
        return this.mIsCompleted;
    }
}
