package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedOrientationChangeEvent extends SimpleBaseEvent {
    private boolean mIsSwitchFeedOrientation;

    public QFSFeedOrientationChangeEvent(boolean z16) {
        this.mIsSwitchFeedOrientation = z16;
    }

    public boolean isSwitchFeedOrientation() {
        return this.mIsSwitchFeedOrientation;
    }
}
