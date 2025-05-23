package com.tencent.mobileqq.guild.media.widget.zoom;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    public static float a(float f16, float f17, float f18) {
        return Math.max(f16, Math.min(f17, f18));
    }

    public static boolean b(float f16, float f17) {
        return c(f16, f17, 0.001f);
    }

    public static boolean c(float f16, float f17, float f18) {
        if (Float.compare(f16, f17) != 0 && Math.abs(f16 - f17) > f18) {
            return false;
        }
        return true;
    }
}
