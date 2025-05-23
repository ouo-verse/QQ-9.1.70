package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.MotionEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class QFSAdSpaceDispatchTouchEvent extends SimpleBaseEvent {
    private GdtAd mAd;
    private MotionEvent mEvent;

    public QFSAdSpaceDispatchTouchEvent(GdtAd gdtAd, MotionEvent motionEvent) {
        this.mAd = gdtAd;
        this.mEvent = motionEvent;
    }

    public GdtAd getAd() {
        return this.mAd;
    }

    public MotionEvent getEvent() {
        return this.mEvent;
    }
}
