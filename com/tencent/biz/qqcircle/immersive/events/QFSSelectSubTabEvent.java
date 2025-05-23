package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSelectSubTabEvent extends SimpleBaseEvent {
    public int mAnchor = 0;
    public int mSubTabType;

    public QFSSelectSubTabEvent(int i3) {
        this.mSubTabType = i3;
    }

    public int getAnchor() {
        return this.mAnchor;
    }

    public void setAnchor(int i3) {
        this.mAnchor = i3;
    }
}
