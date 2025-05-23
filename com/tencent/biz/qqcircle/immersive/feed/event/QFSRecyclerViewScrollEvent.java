package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRecyclerViewScrollEvent extends SimpleBaseEvent {
    public float mDistanceX;
    public float mDistanceY;

    public QFSRecyclerViewScrollEvent(float f16, float f17) {
        this.mDistanceY = f17;
        this.mDistanceX = f16;
    }
}
