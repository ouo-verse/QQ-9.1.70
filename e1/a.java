package e1;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {
    public static float a(float f16, float f17, float f18, float f19) {
        return (float) Math.hypot(f18 - f16, f19 - f17);
    }

    public static float b(float f16, float f17, float f18, float f19, float f26, float f27) {
        return e(a(f16, f17, f18, f19), a(f16, f17, f26, f19), a(f16, f17, f26, f27), a(f16, f17, f18, f27));
    }

    public static boolean c(float f16, float f17, float f18) {
        if (f16 + f18 >= f17) {
            return true;
        }
        return false;
    }

    public static float d(float f16, float f17, float f18) {
        return ((1.0f - f18) * f16) + (f18 * f17);
    }

    private static float e(float f16, float f17, float f18, float f19) {
        if (f16 <= f17 || f16 <= f18 || f16 <= f19) {
            if (f17 > f18 && f17 > f19) {
                return f17;
            }
            if (f18 > f19) {
                return f18;
            }
            return f19;
        }
        return f16;
    }
}
