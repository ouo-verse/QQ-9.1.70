package com.tencent.biz.qqcircle.immersive.floatingwindow.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSFloatingPlayPauseEvent extends SimpleBaseEvent {
    public static final int FLOAT_PAUSE_STATE = 2;
    public static final int FLOAT_PLAY_STATE = 1;
    public final int mState;
    private final String mTargetFeed;

    public QFSFloatingPlayPauseEvent(String str, int i3) {
        this.mTargetFeed = str;
        this.mState = i3;
    }

    public String getTargetFeedId() {
        return this.mTargetFeed;
    }
}
