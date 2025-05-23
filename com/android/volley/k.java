package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f31341a = "Volley";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f31342b = Log.isLoggable("Volley", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final String f31343c = k.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final boolean f31344c = k.f31342b;

        /* renamed from: a, reason: collision with root package name */
        private final List<C0211a> f31345a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private boolean f31346b = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.android.volley.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0211a {

            /* renamed from: a, reason: collision with root package name */
            public final String f31347a;

            /* renamed from: b, reason: collision with root package name */
            public final long f31348b;

            /* renamed from: c, reason: collision with root package name */
            public final long f31349c;

            public C0211a(String str, long j3, long j16) {
                this.f31347a = str;
                this.f31348b = j3;
                this.f31349c = j16;
            }
        }

        private long c() {
            if (this.f31345a.size() == 0) {
                return 0L;
            }
            return this.f31345a.get(r2.size() - 1).f31349c - this.f31345a.get(0).f31349c;
        }

        public synchronized void a(String str, long j3) {
            if (!this.f31346b) {
                this.f31345a.add(new C0211a(str, j3, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            this.f31346b = true;
            long c16 = c();
            if (c16 <= 0) {
                return;
            }
            long j3 = this.f31345a.get(0).f31349c;
            k.b("(%-4d ms) %s", Long.valueOf(c16), str);
            for (C0211a c0211a : this.f31345a) {
                long j16 = c0211a.f31349c;
                k.b("(+%-4d) [%2d] %s", Long.valueOf(j16 - j3), Long.valueOf(c0211a.f31348b), c0211a.f31347a);
                j3 = j16;
            }
        }

        protected void finalize() throws Throwable {
            if (!this.f31346b) {
                b("Request on the loose");
                k.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i3 = 2;
        while (true) {
            if (i3 < stackTrace.length) {
                if (!stackTrace[i3].getClassName().equals(f31343c)) {
                    String className = stackTrace[i3].getClassName();
                    String substring = className.substring(className.lastIndexOf(46) + 1);
                    str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i3].getMethodName();
                    break;
                }
                i3++;
            } else {
                str2 = "<unknown>";
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f31341a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f31341a, a(str, objArr));
    }

    public static void d(Throwable th5, String str, Object... objArr) {
        Log.e(f31341a, a(str, objArr), th5);
    }

    public static void e(String str, Object... objArr) {
        if (f31342b) {
            Log.v(f31341a, a(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f31341a, a(str, objArr));
    }
}
