package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSFeedFastPushRocketAnimEvent extends SimpleBaseEvent {
    private String mFeedId;
    private int mPushRocketCount;
    private int mPushType;

    public QFSFeedFastPushRocketAnimEvent(int i3, int i16, String str) {
        this.mPushType = i3;
        this.mPushRocketCount = i16;
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getPushRocketCount() {
        return this.mPushRocketCount;
    }

    public int getPushType() {
        return this.mPushType;
    }
}
