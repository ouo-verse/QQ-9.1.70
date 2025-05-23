package com.tencent.biz.qqcircle.immersive.feed.event;

import android.view.View;
import com.tencent.biz.qqcircle.immersive.feed.av;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedItemScaleGestureEvent extends SimpleBaseEvent {
    public static final int BIND_INSTANCE = 0;
    public static final int MOVE_EXIT = 3;
    public static final int SCALE_BEGIN = 1;
    public static final int SCALE_END = 2;
    private View mDetectorView;
    private FeedCloudMeta$StFeed mFeed;
    private av.b mPlayStatusProvider;
    private final float mScale;
    private final int mType;

    public QFSFeedItemScaleGestureEvent(float f16, int i3) {
        this.mScale = f16;
        this.mType = i3;
    }

    public View getDetectorView() {
        return this.mDetectorView;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public av.b getPlayStatusProvider() {
        return this.mPlayStatusProvider;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isPic() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    public QFSFeedItemScaleGestureEvent setDetectorView(View view) {
        this.mDetectorView = view;
        return this;
    }

    public QFSFeedItemScaleGestureEvent setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
        return this;
    }

    public QFSFeedItemScaleGestureEvent setPlayStatusProvider(av.b bVar) {
        this.mPlayStatusProvider = bVar;
        return this;
    }
}
