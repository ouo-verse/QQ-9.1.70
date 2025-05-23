package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSLayerFeedPosSyncEvent extends SimpleBaseEvent {
    private String mCoverUrl;
    private final String mFeedId;
    private boolean mIsVerticalFeed;
    private final int mPageCode;
    private final int mPos;

    public QFSLayerFeedPosSyncEvent(int i3, int i16, String str) {
        this.mPageCode = i3;
        this.mPos = i16;
        this.mFeedId = str;
    }

    public String getCoverUrl() {
        return this.mCoverUrl;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getPageCode() {
        return this.mPageCode;
    }

    public int getPos() {
        return this.mPos;
    }

    public boolean isVerticalFeed() {
        return this.mIsVerticalFeed;
    }

    public QFSLayerFeedPosSyncEvent setCoverUrl(String str) {
        this.mCoverUrl = str;
        return this;
    }

    public QFSLayerFeedPosSyncEvent setIsVertical(boolean z16) {
        this.mIsVerticalFeed = z16;
        return this;
    }
}
