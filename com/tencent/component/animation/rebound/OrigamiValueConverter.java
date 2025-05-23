package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class OrigamiValueConverter {
    public static double frictionFromOrigamiValue(double d16) {
        if (d16 == 0.0d) {
            return 0.0d;
        }
        return 25.0d + ((d16 - 8.0d) * 3.0d);
    }

    public static double origamiValueFromFriction(double d16) {
        if (d16 == 0.0d) {
            return 0.0d;
        }
        return 8.0d + ((d16 - 25.0d) / 3.0d);
    }

    public static double origamiValueFromTension(double d16) {
        if (d16 == 0.0d) {
            return 0.0d;
        }
        return 30.0d + ((d16 - 194.0d) / 3.62d);
    }

    public static double tensionFromOrigamiValue(double d16) {
        if (d16 == 0.0d) {
            return 0.0d;
        }
        return 194.0d + ((d16 - 30.0d) * 3.62d);
    }
}
