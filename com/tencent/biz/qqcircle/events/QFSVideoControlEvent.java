package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSVideoControlEvent extends SimpleBaseEvent {
    private String mFeedId;
    private boolean mIsPlay;
    private int mMediaFocusType;

    public QFSVideoControlEvent(String str, boolean z16) {
        this.mFeedId = str;
        this.mIsPlay = z16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getMediaFocusType() {
        return this.mMediaFocusType;
    }

    public boolean isPlay() {
        return this.mIsPlay;
    }

    public void setMediaFocusType(int i3) {
        this.mMediaFocusType = i3;
    }
}
