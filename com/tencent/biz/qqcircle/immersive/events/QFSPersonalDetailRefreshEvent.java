package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPersonalDetailRefreshEvent extends SimpleBaseEvent {
    private final String mUin;

    public QFSPersonalDetailRefreshEvent(String str) {
        this.mUin = str;
    }

    public String getUin() {
        return this.mUin;
    }
}
