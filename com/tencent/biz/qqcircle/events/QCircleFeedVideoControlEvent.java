package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFeedVideoControlEvent extends SimpleBaseEvent {
    private int mHashCode;
    private boolean mIsPlay;

    public QCircleFeedVideoControlEvent(int i3, boolean z16) {
        this.mHashCode = i3;
        this.mIsPlay = z16;
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    public boolean isPlay() {
        return this.mIsPlay;
    }
}
