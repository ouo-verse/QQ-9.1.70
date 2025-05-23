package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleVolumeMuteChangeEvent extends SimpleBaseEvent {
    private boolean mIsMute;

    public QCircleVolumeMuteChangeEvent(boolean z16) {
        this.mIsMute = z16;
    }

    public boolean isMute() {
        return this.mIsMute;
    }

    public void setMute(boolean z16) {
        this.mIsMute = z16;
    }

    public String toString() {
        return "QCircleVolumeMuteChangeEvent{mIsMute=" + this.mIsMute + "} " + super.toString();
    }
}
