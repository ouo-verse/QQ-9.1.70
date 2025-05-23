package com.tencent.liteav.base.util;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class g {
    public static float a(float f16, float f17) {
        if (f16 < f17) {
            return f17;
        }
        if (f16 > 1.0f) {
            return 1.0f;
        }
        return f16;
    }

    public static int a(int i3, int i16, int i17) {
        return i3 < i16 ? i16 : i3 > i17 ? i17 : i3;
    }
}
