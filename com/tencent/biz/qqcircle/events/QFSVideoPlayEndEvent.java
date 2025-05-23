package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSVideoPlayEndEvent extends SimpleBaseEvent {
    public final String mFeedId;
    public final int mPos;

    public QFSVideoPlayEndEvent(String str, int i3) {
        this.mFeedId = str;
        this.mPos = i3;
    }
}
