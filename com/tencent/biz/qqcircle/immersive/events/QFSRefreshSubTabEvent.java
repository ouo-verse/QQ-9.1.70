package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRefreshSubTabEvent extends SimpleBaseEvent {
    private int mAnchor = 0;
    private int mCurrentPos;

    public QFSRefreshSubTabEvent(int i3) {
        this.mCurrentPos = i3;
    }

    public int getAnchor() {
        return this.mAnchor;
    }

    public int getCurrentPos() {
        return this.mCurrentPos;
    }

    public void setAnchor(int i3) {
        this.mAnchor = i3;
    }
}
