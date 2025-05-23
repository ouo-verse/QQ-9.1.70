package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSMusicCurrentProgressEvent extends SimpleBaseEvent {
    private int mCurrentProgress;
    private String mFeedId;

    public QFSMusicCurrentProgressEvent(String str, int i3) {
        this.mFeedId = str;
        this.mCurrentProgress = i3;
    }

    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }

    public String getFeedId() {
        return this.mFeedId;
    }
}
