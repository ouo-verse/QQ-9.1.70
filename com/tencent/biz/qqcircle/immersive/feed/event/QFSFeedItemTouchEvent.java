package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.MotionEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedItemTouchEvent extends SimpleBaseEvent {
    private final MotionEvent mEvent;

    public QFSFeedItemTouchEvent(MotionEvent motionEvent) {
        this.mEvent = motionEvent;
    }

    public MotionEvent getEvent() {
        return this.mEvent;
    }
}
