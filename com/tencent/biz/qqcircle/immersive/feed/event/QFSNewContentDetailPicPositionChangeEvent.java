package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSNewContentDetailPicPositionChangeEvent extends SimpleBaseEvent {
    private String mFeedId;
    private int mPosition;

    public QFSNewContentDetailPicPositionChangeEvent(String str, int i3) {
        this.mFeedId = str;
        this.mPosition = i3;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getPosition() {
        return this.mPosition;
    }
}
