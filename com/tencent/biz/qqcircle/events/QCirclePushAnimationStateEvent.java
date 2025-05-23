package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCirclePushAnimationStateEvent extends SimpleBaseEvent {
    public static final int ANIMATION_STATE_END = 2;
    public static final int ANIMATION_STATE_START = 1;
    public int mSceneType;
    public int mState;
    public String mTargetFeedId;

    public QCirclePushAnimationStateEvent(String str, int i3, int i16) {
        this.mTargetFeedId = str;
        this.mState = i3;
        this.mSceneType = i16;
    }
}
