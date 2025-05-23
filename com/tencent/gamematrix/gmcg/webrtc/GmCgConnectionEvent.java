package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgConnectionEvent {
    CONNECTED(1),
    DISCONNECTED(2);

    private final int mValue;

    GmCgConnectionEvent(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
