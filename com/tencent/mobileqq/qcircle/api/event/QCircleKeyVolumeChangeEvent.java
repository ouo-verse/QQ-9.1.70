package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleKeyVolumeChangeEvent extends SimpleBaseEvent {
    private int mCurVolume;
    private int mKeyCode;

    public QCircleKeyVolumeChangeEvent(int i3, int i16) {
        this.mKeyCode = i3;
        this.mCurVolume = i16;
    }

    public int getCurVolume() {
        return this.mCurVolume;
    }

    public int getKeyCode() {
        return this.mKeyCode;
    }

    public void setKeyCode(int i3) {
        this.mKeyCode = i3;
    }

    public String toString() {
        return "QCircleKeyVolumeChangeEvent{mKeyCode=" + this.mKeyCode + ", mCurVolume=" + this.mCurVolume + "} " + super.toString();
    }
}
