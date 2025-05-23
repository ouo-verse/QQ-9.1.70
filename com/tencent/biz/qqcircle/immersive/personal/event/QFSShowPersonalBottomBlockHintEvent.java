package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSShowPersonalBottomBlockHintEvent extends SimpleBaseEvent {
    public boolean isShowBlockHint;

    public QFSShowPersonalBottomBlockHintEvent(boolean z16) {
        this.isShowBlockHint = z16;
    }
}
