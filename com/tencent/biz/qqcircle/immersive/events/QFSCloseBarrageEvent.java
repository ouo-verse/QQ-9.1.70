package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCloseBarrageEvent extends SimpleBaseEvent {
    private String mFeedId;

    public static QFSCloseBarrageEvent build() {
        return new QFSCloseBarrageEvent();
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public QFSCloseBarrageEvent setFeedId(String str) {
        this.mFeedId = str;
        return this;
    }
}
