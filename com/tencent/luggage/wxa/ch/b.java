package com.tencent.luggage.wxa.ch;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static int a(int i3, float f16) {
        if (i3 > 180) {
            if (i3 <= 600) {
                i3 = 180;
            } else {
                i3 = i3 <= 1800 ? 300 : 600;
            }
        }
        return (int) (i3 * f16);
    }

    public static int a(float f16, float f17, int i3, int i16) {
        int a16 = i3 + a(i16, f16 / f17);
        if (a16 < 0) {
            return 0;
        }
        return a16 > i16 ? i16 : a16;
    }
}
