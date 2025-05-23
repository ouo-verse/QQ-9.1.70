package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpringUtil {
    public static double clamp(double d16, double d17, double d18) {
        return Math.min(Math.max(d16, d17), d18);
    }

    public static double mapValueFromRangeToRange(double d16, double d17, double d18, double d19, double d26) {
        return d19 + (((d16 - d17) / (d18 - d17)) * (d26 - d19));
    }
}
