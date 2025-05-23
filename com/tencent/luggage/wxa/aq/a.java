package com.tencent.luggage.wxa.aq;

import com.tencent.luggage.wxa.jq.h;
import com.tencent.luggage.wxa.kq.e;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static h a(Runnable runnable, long j3, long j16, boolean z16) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
        long convert = timeUnit.convert(j16, timeUnit2);
        long a16 = a(j3, timeUnit2);
        if (z16) {
            convert = -convert;
        }
        return new h(runnable, a16, convert, a(runnable));
    }

    public static h a(Runnable runnable, long j3, String str) {
        if (str != null && !str.isEmpty()) {
            return new e(runnable, a(j3, TimeUnit.MILLISECONDS), str, a(runnable));
        }
        return new h(runnable, a(j3, TimeUnit.MILLISECONDS), a(runnable));
    }

    public static h a(Callable callable, long j3, String str) {
        if (str != null && !str.isEmpty()) {
            return new e(callable, a(j3, TimeUnit.MILLISECONDS), str, a(callable));
        }
        return new h(callable, a(j3, TimeUnit.MILLISECONDS), a(callable));
    }

    public static long a(long j3, TimeUnit timeUnit) {
        if (timeUnit == null) {
            return System.nanoTime();
        }
        if (j3 < 0) {
            j3 = 0;
        }
        return a(timeUnit.toNanos(j3));
    }

    public static long a(long j3) {
        long nanoTime = System.nanoTime();
        if (j3 >= DurationKt.MAX_MILLIS) {
            j3 = 4611686018427387903L;
        }
        return nanoTime + j3;
    }

    public static boolean a(Object obj) {
        if (obj instanceof com.tencent.luggage.wxa.jq.e) {
            return ((com.tencent.luggage.wxa.jq.e) obj).a();
        }
        return true;
    }
}
