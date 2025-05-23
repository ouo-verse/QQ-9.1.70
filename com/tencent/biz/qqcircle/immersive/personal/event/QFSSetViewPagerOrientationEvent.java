package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSSetViewPagerOrientationEvent extends SimpleBaseEvent {
    private int mHashCode;
    private int mOrientation;

    public QFSSetViewPagerOrientationEvent(int i3, int i16) {
        this.mOrientation = i3;
        this.mHashCode = i16;
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public int getOrientation() {
        return this.mOrientation;
    }
}
