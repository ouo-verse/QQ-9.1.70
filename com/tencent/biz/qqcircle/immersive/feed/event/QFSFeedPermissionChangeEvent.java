package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSFeedPermissionChangeEvent extends SimpleBaseEvent {
    private String feedId;
    private int mRightFlag;

    public QFSFeedPermissionChangeEvent(int i3, String str) {
        this.mRightFlag = i3;
        this.feedId = str;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getRightFlag() {
        return this.mRightFlag;
    }
}
