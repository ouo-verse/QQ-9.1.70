package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSQzoneFirstVideoAutoSlideEvent extends SimpleBaseEvent {
    private String mFeedId;

    public QFSQzoneFirstVideoAutoSlideEvent(String str) {
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }
}
