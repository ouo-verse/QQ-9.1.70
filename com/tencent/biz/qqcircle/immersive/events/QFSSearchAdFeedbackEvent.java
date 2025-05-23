package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchAdFeedbackEvent extends SimpleBaseEvent {
    private int pos;

    public QFSSearchAdFeedbackEvent(int i3) {
        this.pos = i3;
    }

    public int getPos() {
        return this.pos;
    }
}
