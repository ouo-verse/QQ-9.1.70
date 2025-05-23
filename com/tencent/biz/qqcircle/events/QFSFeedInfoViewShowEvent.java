package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedInfoViewShowEvent extends SimpleBaseEvent {
    private String mFeedId;
    private boolean mIsShow;
    private boolean mNeedAnim;

    public QFSFeedInfoViewShowEvent(String str, boolean z16, boolean z17) {
        this.mFeedId = str;
        this.mIsShow = z16;
        this.mNeedAnim = z17;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isShow() {
        return this.mIsShow;
    }

    public boolean needAnim() {
        return this.mNeedAnim;
    }
}
