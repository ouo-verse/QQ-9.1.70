package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSWeakNetworkChangeEvent extends SimpleBaseEvent {
    private boolean mIsWeakNetwork;
    private int mWeakType;

    public QFSWeakNetworkChangeEvent(boolean z16, int i3) {
        this.mIsWeakNetwork = z16;
        this.mWeakType = i3;
    }

    public int getWeakType() {
        return this.mWeakType;
    }

    public boolean isWeakNetwork() {
        return this.mIsWeakNetwork;
    }

    public void setWeakNetwork(boolean z16) {
        this.mIsWeakNetwork = z16;
    }

    public void setWeakType(int i3) {
        this.mWeakType = i3;
    }
}
