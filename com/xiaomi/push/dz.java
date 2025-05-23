package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.dw;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dz {

    /* renamed from: a, reason: collision with root package name */
    private static final int f388643a = ei.PING_RTT.a();

    /* renamed from: b, reason: collision with root package name */
    private static long f388644b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static Hashtable<Integer, Long> f388645a = new Hashtable<>();
    }

    public static void a() {
        if (f388644b == 0 || SystemClock.elapsedRealtime() - f388644b > 7200000) {
            f388644b = SystemClock.elapsedRealtime();
            c(0, f388643a);
        }
    }

    public static void b(int i3) {
        ej a16 = dy.f().a();
        a16.a(ei.CHANNEL_STATS_COUNTER.a());
        a16.c(i3);
        dy.f().i(a16);
    }

    public static synchronized void c(int i3, int i16) {
        synchronized (dz.class) {
            if (i16 < 16777215) {
                a.f388645a.put(Integer.valueOf((i3 << 24) | i16), Long.valueOf(System.currentTimeMillis()));
            } else {
                jz4.c.B("stats key should less than 16777215");
            }
        }
    }

    public static void d(int i3, int i16, int i17, String str, int i18) {
        ej a16 = dy.f().a();
        a16.a((byte) i3);
        a16.a(i16);
        a16.b(i17);
        a16.b(str);
        a16.c(i18);
        dy.f().i(a16);
    }

    public static synchronized void e(int i3, int i16, String str, int i17) {
        synchronized (dz.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i18 = (i3 << 24) | i16;
            if (a.f388645a.containsKey(Integer.valueOf(i18))) {
                ej a16 = dy.f().a();
                a16.a(i16);
                a16.b((int) (currentTimeMillis - a.f388645a.get(Integer.valueOf(i18)).longValue()));
                a16.b(str);
                if (i17 > -1) {
                    a16.c(i17);
                }
                dy.f().i(a16);
                a.f388645a.remove(Integer.valueOf(i16));
            } else {
                jz4.c.B("stats key not found");
            }
        }
    }

    public static void f(XMPushService xMPushService, am.b bVar) {
        new el(xMPushService, bVar).b();
    }

    public static void g(String str, int i3, Exception exc) {
        ej a16 = dy.f().a();
        if (dy.e() != null && dy.e().f388629d != null) {
            a16.c(au.v(dy.e().f388629d) ? 1 : 0);
        }
        if (i3 > 0) {
            a16.a(ei.GSLB_REQUEST_SUCCESS.a());
            a16.b(str);
            a16.b(i3);
            dy.f().i(a16);
            return;
        }
        try {
            dw.a a17 = dw.a(exc);
            a16.a(a17.f388627a.a());
            a16.c(a17.f388628b);
            a16.b(str);
            dy.f().i(a16);
        } catch (NullPointerException unused) {
        }
    }

    public static void h(String str, Exception exc) {
        int i3;
        try {
            dw.a c16 = dw.c(exc);
            ej a16 = dy.f().a();
            a16.a(c16.f388627a.a());
            a16.c(c16.f388628b);
            a16.b(str);
            if (dy.e() != null && dy.e().f388629d != null) {
                if (au.v(dy.e().f388629d)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                a16.c(i3);
            }
            dy.f().i(a16);
        } catch (NullPointerException unused) {
        }
    }

    public static byte[] i() {
        ek c16 = dy.f().c();
        if (c16 != null) {
            return fv.e(c16);
        }
        return null;
    }

    public static void j() {
        e(0, f388643a, null, -1);
    }

    public static void k(String str, Exception exc) {
        int i3;
        try {
            dw.a e16 = dw.e(exc);
            ej a16 = dy.f().a();
            a16.a(e16.f388627a.a());
            a16.c(e16.f388628b);
            a16.b(str);
            if (dy.e() != null && dy.e().f388629d != null) {
                if (au.v(dy.e().f388629d)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                a16.c(i3);
            }
            dy.f().i(a16);
        } catch (NullPointerException unused) {
        }
    }
}
