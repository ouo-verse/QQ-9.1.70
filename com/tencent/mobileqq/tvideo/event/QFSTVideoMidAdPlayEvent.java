package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes19.dex */
public class QFSTVideoMidAdPlayEvent extends SimpleBaseEvent {
    private boolean isComplete;
    private boolean isStart;

    public boolean isComplete() {
        return this.isComplete;
    }

    public boolean isStart() {
        return this.isStart;
    }

    public void setComplete(boolean z16) {
        this.isComplete = z16;
    }

    public void setStart(boolean z16) {
        this.isStart = z16;
    }
}
