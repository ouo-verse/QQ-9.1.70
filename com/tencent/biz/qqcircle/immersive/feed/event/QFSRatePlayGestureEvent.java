package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSRatePlayGestureEvent extends SimpleBaseEvent {
    public static final int TYPE_ON_LONG_PRESS_SCROLL_DOWN = 4;
    public static final int TYPE_ON_LONG_PRESS_SCROLL_UP = 3;
    public static final int TYPE_ON_LONG_PRESS_START = 0;
    public static final int TYPE_ON_LONG_PRESS_UP = 1;
    private int mContextHashCode;
    private final int mEventType;
    private FeedCloudMeta$StFeed mFeed;
    private boolean mIsHitLockRate = false;
    private final float mPlayRate;

    public QFSRatePlayGestureEvent(int i3, float f16) {
        this.mEventType = i3;
        this.mPlayRate = f16;
    }

    public int getCurrentContextHashCode() {
        return this.mContextHashCode;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public boolean getIsHitLockRate() {
        return this.mIsHitLockRate;
    }

    public float getPlayRate() {
        return this.mPlayRate;
    }

    public QFSRatePlayGestureEvent setCurrentContextHaseCode(int i3) {
        this.mContextHashCode = i3;
        return this;
    }

    public QFSRatePlayGestureEvent setCurrentFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
        return this;
    }

    public void setIsHitLockRate(boolean z16) {
        this.mIsHitLockRate = z16;
    }
}
