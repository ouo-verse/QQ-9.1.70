package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFloatVolumeSwitchEvent extends SimpleBaseEvent {
    private final String mFeedId;
    private final boolean mIsMute;

    public QFSFloatVolumeSwitchEvent(String str, boolean z16) {
        this.mFeedId = str;
        this.mIsMute = z16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean isMute() {
        return this.mIsMute;
    }
}
