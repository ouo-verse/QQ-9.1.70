package com.tencent.gamematrix.gmcg.api;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgFramerateDef {
    FPS_30(30),
    FPS_15(15);

    private final int mValue;

    GmCgFramerateDef(int i3) {
        this.mValue = i3;
    }

    public String getString() {
        return String.valueOf(this.mValue);
    }

    public int getValue() {
        return this.mValue;
    }
}
