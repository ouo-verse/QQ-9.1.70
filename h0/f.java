package h0;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final double f403954a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j3) {
        return (b() - j3) * f403954a;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
