package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenCloseEvent extends SimpleBaseEvent {
    private final String mFeedId;
    private final boolean mIsFinishActivity;

    public QFSFullScreenCloseEvent(String str) {
        this.mFeedId = str;
        this.mIsFinishActivity = false;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isFinishActivity() {
        return this.mIsFinishActivity;
    }

    public QFSFullScreenCloseEvent(String str, boolean z16) {
        this.mFeedId = str;
        this.mIsFinishActivity = z16;
    }
}
