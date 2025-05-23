package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QCirclePushAnimationEvent extends SimpleBaseEvent {
    public static final int CLICK_TYPE_COMBO_CLICK = 2;
    public static final int CLICK_TYPE_LONG_PRESS = 3;
    public static final int CLICK_TYPE_OVER_PUSH_FIRST = 4;
    public static final int CLICK_TYPE_OVER_PUSH_SECOND = 5;
    public static final int CLICK_TYPE_SINGLE_CLICK = 1;
    public int mClickType;
    public int mPageType;
    public int mRecommendTimes;
    public String mTargetFeedId;

    public QCirclePushAnimationEvent(String str, int i3, int i16, int i17) {
        this.mTargetFeedId = str;
        this.mRecommendTimes = i3;
        this.mClickType = i16;
        this.mPageType = i17;
    }
}
