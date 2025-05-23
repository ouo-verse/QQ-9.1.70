package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenListScrollStateChangeEvent extends SimpleBaseEvent {
    private int mState;

    public QFSFullScreenListScrollStateChangeEvent(int i3) {
        this.mState = i3;
    }

    public int getState() {
        return this.mState;
    }
}
