package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final q f34707a = q.b();

    /* renamed from: b, reason: collision with root package name */
    private boolean f34708b;

    /* renamed from: c, reason: collision with root package name */
    private long f34709c;

    /* renamed from: d, reason: collision with root package name */
    private long f34710d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34711a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f34711a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34711a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34711a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34711a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34711a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34711a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34711a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    m() {
    }

    private static String a(TimeUnit timeUnit) {
        switch (a.f34711a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "\u03bcs";
            case 3:
                return "ms";
            case 4:
                return ReportConstant.COSTREPORT_PREFIX;
            case 5:
                return Element.ELEMENT_NAME_MIN;
            case 6:
                return tl.h.F;
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j3) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j3, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j3, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j3, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j3, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j3, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        if (timeUnit7.convert(j3, timeUnit2) > 0) {
            return timeUnit7;
        }
        return timeUnit2;
    }

    public static m c() {
        return new m().g();
    }

    public static m d() {
        return new m();
    }

    private long f() {
        if (this.f34708b) {
            return (this.f34707a.a() - this.f34710d) + this.f34709c;
        }
        return this.f34709c;
    }

    public long e(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.NANOSECONDS);
    }

    @CanIgnoreReturnValue
    public m g() {
        j.t(!this.f34708b, "This stopwatch is already running.");
        this.f34708b = true;
        this.f34710d = this.f34707a.a();
        return this;
    }

    @CanIgnoreReturnValue
    public m h() {
        long a16 = this.f34707a.a();
        j.t(this.f34708b, "This stopwatch is already stopped.");
        this.f34708b = false;
        this.f34709c += a16 - this.f34710d;
        return this;
    }

    public String toString() {
        long f16 = f();
        TimeUnit b16 = b(f16);
        return i.a(f16 / TimeUnit.NANOSECONDS.convert(1L, b16)) + " " + a(b16);
    }
}
