package com.tencent.biz.qqcircle.immersive.personal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPersonalGuildInfoEmptyEvent extends SimpleBaseEvent {
    public boolean isEmpty;

    public QFSPersonalGuildInfoEmptyEvent(boolean z16) {
        this.isEmpty = z16;
    }
}
