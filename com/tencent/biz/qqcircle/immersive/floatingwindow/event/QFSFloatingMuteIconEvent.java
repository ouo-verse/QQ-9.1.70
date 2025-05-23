package com.tencent.biz.qqcircle.immersive.floatingwindow.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFloatingMuteIconEvent extends SimpleBaseEvent {
    private final boolean mIsMute;
    private final String mTargetFeed;

    public QFSFloatingMuteIconEvent(String str, boolean z16) {
        this.mTargetFeed = str;
        this.mIsMute = z16;
    }

    public String getTargetFeedId() {
        return this.mTargetFeed;
    }

    public boolean isMute() {
        return this.mIsMute;
    }
}
