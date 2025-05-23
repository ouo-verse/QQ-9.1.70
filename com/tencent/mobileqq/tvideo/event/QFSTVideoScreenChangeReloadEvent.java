package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QFSTVideoScreenChangeReloadEvent extends SimpleBaseEvent {
    private int orientation;

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i3) {
        this.orientation = i3;
    }
}
