package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgSubScribeEvent {
    SUBSCRIBE(1),
    UNSUBSCRIBE(2);

    private final int mValue;

    GmCgSubScribeEvent(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
