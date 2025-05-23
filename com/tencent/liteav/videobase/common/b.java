package com.tencent.liteav.videobase.common;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum b {
    UNKNOWN(-1),
    HDR10(0),
    HLG(1),
    UNSUPPORTED(2);

    final int mValue;

    b(int i3) {
        this.mValue = i3;
    }

    public static b a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return UNKNOWN;
                }
                return UNSUPPORTED;
            }
            return HLG;
        }
        return HDR10;
    }
}
