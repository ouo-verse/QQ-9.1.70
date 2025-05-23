package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAdBannerChangeEvent extends SimpleBaseEvent {
    public boolean mShow;
    private String mState;

    public QFSAdBannerChangeEvent(String str) {
        this.mState = str;
    }

    public String getState() {
        return this.mState;
    }
}
