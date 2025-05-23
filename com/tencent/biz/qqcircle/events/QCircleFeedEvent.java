package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedEvent extends SimpleBaseEvent {
    public static final int STATE_COMPLETE = 2;
    public static final int STATE_DELETE = 3;
    public static final int STATE_DELETE_AD_FEEDS = 8;
    public static final int STATE_DELETE_FEEDS_BY_UID = 6;
    public static final int STATE_UNDO_PUSH = 7;
    public static final int TARGET_ALL_PAGE = -1;
    public int mState;
    public String mTargetId;
    public int mTargetPage = -1;

    public QCircleFeedEvent(String str, int i3) {
        this.mState = i3;
        if (str != null) {
            this.mTargetId = str;
        }
    }

    public void setTargetPage(int i3) {
        this.mTargetPage = i3;
    }

    public QCircleFeedEvent(int i3) {
        this.mState = i3;
    }
}
