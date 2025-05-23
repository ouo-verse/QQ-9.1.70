package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSShowPersonalPanelEvent extends SimpleBaseEvent {
    private final int mHashCode;
    private final boolean mIsShow;
    private boolean mNeedMaskView = false;
    private int mPanelModel;
    private FeedCloudMeta$StFeed mStFeed;

    public QFSShowPersonalPanelEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16, int i3) {
        this.mStFeed = feedCloudMeta$StFeed;
        this.mIsShow = z16;
        this.mHashCode = i3;
    }

    public String getFeedId() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mStFeed;
        if (feedCloudMeta$StFeed != null) {
            return feedCloudMeta$StFeed.f398449id.get();
        }
        return "";
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public int getPanelModel() {
        return this.mPanelModel;
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public boolean isNeedMaskView() {
        return this.mNeedMaskView;
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public void setNeedMaskView(boolean z16) {
        this.mNeedMaskView = z16;
    }

    public void setPanelModel(int i3) {
        this.mPanelModel = i3;
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mStFeed = feedCloudMeta$StFeed;
    }
}
