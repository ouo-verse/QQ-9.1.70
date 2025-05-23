package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSOpenSettingPermissionWindowEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed mFeed;
    private boolean mIsOpen;

    public QFSOpenSettingPermissionWindowEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mIsOpen = z16;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public boolean getIsOpen() {
        return this.mIsOpen;
    }
}
