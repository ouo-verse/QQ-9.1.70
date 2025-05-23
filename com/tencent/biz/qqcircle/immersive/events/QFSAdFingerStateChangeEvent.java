package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAdFingerStateChangeEvent extends SimpleBaseEvent {
    private String mState;

    public QFSAdFingerStateChangeEvent(String str) {
        this.mState = str;
    }

    public String getState() {
        return this.mState;
    }
}
