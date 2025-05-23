package androidx.core.math;

/* compiled from: P */
/* loaded from: classes.dex */
public class MathUtils {
    MathUtils() {
    }

    public static double clamp(double d16, double d17, double d18) {
        return d16 < d17 ? d17 : d16 > d18 ? d18 : d16;
    }

    public static float clamp(float f16, float f17, float f18) {
        return f16 < f17 ? f17 : f16 > f18 ? f18 : f16;
    }

    public static int clamp(int i3, int i16, int i17) {
        return i3 < i16 ? i16 : i3 > i17 ? i17 : i3;
    }

    public static long clamp(long j3, long j16, long j17) {
        return j3 < j16 ? j16 : j3 > j17 ? j17 : j3;
    }
}
