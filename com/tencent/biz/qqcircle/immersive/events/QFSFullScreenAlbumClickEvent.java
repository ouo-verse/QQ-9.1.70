package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenAlbumClickEvent extends SimpleBaseEvent {
    private boolean mIsAlbumListEnd;
    private boolean mIsAutoNext;
    private FeedCloudMeta$StFeed mSelectedFeed;
    private FeedCloudMeta$StFeed mUnSelectedFeed;

    public QFSFullScreenAlbumClickEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2, boolean z16, boolean z17) {
        this.mUnSelectedFeed = feedCloudMeta$StFeed;
        this.mSelectedFeed = feedCloudMeta$StFeed2;
        this.mIsAlbumListEnd = z16;
    }

    public FeedCloudMeta$StFeed getSelectedFeed() {
        return this.mSelectedFeed;
    }

    public FeedCloudMeta$StFeed getUnSelectedFeed() {
        return this.mUnSelectedFeed;
    }

    public boolean isAlbumListEnd() {
        return this.mIsAlbumListEnd;
    }

    public boolean isAutoNext() {
        return this.mIsAutoNext;
    }
}
