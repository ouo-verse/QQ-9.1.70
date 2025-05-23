package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSlideRightActionEvent extends SimpleBaseEvent {
    private int clientFromType;
    private int hashCode;

    public QFSSlideRightActionEvent(int i3, int i16) {
        this.hashCode = i3;
    }

    public int getClientFromType() {
        return this.clientFromType;
    }

    public int getHashCode() {
        return this.hashCode;
    }
}
