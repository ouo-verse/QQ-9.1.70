package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cw {

    /* renamed from: a, reason: collision with root package name */
    private static int f388534a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f388535b = true;

    private static int a(Context context) {
        if (f388534a <= 0) {
            f388534a = hz.l(context);
        }
        return f388534a;
    }

    private static int b(boolean z16) {
        if (z16) {
            return 1;
        }
        return 0;
    }

    private static SharedPreferences c(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    private static ca d(Context context) {
        SharedPreferences c16 = c(context);
        ca caVar = new ca();
        caVar.c(c16.getInt("off_up_count", 0));
        caVar.g(c16.getInt("off_down_count", 0));
        caVar.k(c16.getInt("off_ping_count", 0));
        caVar.o(c16.getInt("off_pong_count", 0));
        caVar.d(c16.getLong("off_duration", 0L));
        caVar.r(c16.getInt("on_up_count", 0));
        caVar.t(c16.getInt("on_down_count", 0));
        caVar.v(c16.getInt("on_ping_count", 0));
        caVar.x(c16.getInt("on_pong_count", 0));
        caVar.h(c16.getLong("on_duration", 0L));
        caVar.l(c16.getLong("start_time", 0L));
        caVar.p(c16.getLong("end_time", 0L));
        caVar.z(c16.getInt("xmsf_vc", 0));
        caVar.B(c16.getInt("android_vc", 0));
        return caVar;
    }

    private static void e(Context context, long j3, int i3) {
        bz.c(JobDbManager.TBL_UPLOAD);
        new cb().a(context, d(context));
        j(context, j3, i3);
    }

    private static void f(Context context, long j3, long j16, int i3, int i16) {
        if (j3 > 0) {
            if (i(context) || i3 >= 1073741823 || j16 - j3 >= 86400000) {
                c(context).edit().putLong("end_time", j16).apply();
                e(context, j16, i16);
            }
        }
    }

    public static void g(final Context context, final long j3, final boolean z16) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.r(context, j3, z16);
                } catch (Exception e16) {
                    jz4.c.m("PowerStatsSP onSendMsg exception: " + e16.getMessage());
                }
            }
        });
    }

    private static void h(Context context, SharedPreferences sharedPreferences, long j3, int i3) {
        bz.c("recordInit");
        sharedPreferences.edit().putLong("start_time", j3).putInt("current_screen_state", i3).putLong("current_screen_state_start_time", j3).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static boolean i(Context context) {
        boolean z16 = false;
        if (f388535b) {
            f388535b = false;
            SharedPreferences c16 = c(context);
            int i3 = c16.getInt("xmsf_vc", 0);
            int i16 = c16.getInt("android_vc", 0);
            if (i3 != 0 && i16 != 0 && (i3 != a(context) || i16 != Build.VERSION.SDK_INT)) {
                z16 = true;
            }
        }
        bz.c("isVcChanged = " + z16);
        return z16;
    }

    private static void j(Context context, long j3, int i3) {
        bz.c("reset");
        c(context).edit().clear().putLong("start_time", j3).putInt("current_screen_state", i3).putLong("current_screen_state_start_time", j3).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    public static void k(final Context context, final long j3, final boolean z16) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.s(context, j3, z16);
                } catch (Exception e16) {
                    jz4.c.m("PowerStatsSP onReceiveMsg exception: " + e16.getMessage());
                }
            }
        });
    }

    public static void l(final Context context, final long j3, final boolean z16) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.t(context, j3, z16);
                } catch (Exception e16) {
                    jz4.c.m("PowerStatsSP onPing exception: " + e16.getMessage());
                }
            }
        });
    }

    public static void m(final Context context, final long j3, final boolean z16) {
        ae.b(context).g(new Runnable() { // from class: com.xiaomi.push.cw.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.u(context, j3, z16);
                } catch (Exception e16) {
                    jz4.c.m("PowerStatsSP onPong exception: " + e16.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void r(Context context, long j3, boolean z16) {
        int i3;
        synchronized (cw.class) {
            bz.c("recordSendMsg start");
            int b16 = b(z16);
            SharedPreferences c16 = c(context);
            long j16 = c16.getLong("start_time", 0L);
            if (j16 <= 0) {
                h(context, c16, j3, b16);
            }
            if (b16 == 1) {
                i3 = c16.getInt("on_up_count", 0) + 1;
                c16.edit().putInt("on_up_count", i3).apply();
            } else {
                i3 = c16.getInt("off_up_count", 0) + 1;
                c16.edit().putInt("off_up_count", i3).apply();
            }
            f(context, j16, j3, i3, b16);
            bz.c("recordSendMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void s(Context context, long j3, boolean z16) {
        int i3;
        synchronized (cw.class) {
            bz.c("recordReceiveMsg start");
            int b16 = b(z16);
            SharedPreferences c16 = c(context);
            long j16 = c16.getLong("start_time", 0L);
            if (j16 <= 0) {
                h(context, c16, j3, b16);
            }
            if (b16 == 1) {
                i3 = c16.getInt("on_down_count", 0) + 1;
                c16.edit().putInt("on_down_count", i3).apply();
            } else {
                i3 = c16.getInt("off_down_count", 0) + 1;
                c16.edit().putInt("off_down_count", i3).apply();
            }
            f(context, j16, j3, i3, b16);
            bz.c("recordReceiveMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void t(Context context, long j3, boolean z16) {
        int i3;
        synchronized (cw.class) {
            bz.c("recordPing start");
            int b16 = b(z16);
            SharedPreferences c16 = c(context);
            long j16 = c16.getLong("start_time", 0L);
            if (j16 <= 0) {
                h(context, c16, j3, b16);
            }
            if (b16 == 1) {
                i3 = c16.getInt("on_ping_count", 0) + 1;
                c16.edit().putInt("on_ping_count", i3).apply();
            } else {
                i3 = c16.getInt("off_ping_count", 0) + 1;
                c16.edit().putInt("off_ping_count", i3).apply();
            }
            f(context, j16, j3, i3, b16);
            bz.c("recordPing complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void u(Context context, long j3, boolean z16) {
        int i3;
        synchronized (cw.class) {
            bz.c("recordPong start");
            int b16 = b(z16);
            SharedPreferences c16 = c(context);
            long j16 = c16.getLong("start_time", 0L);
            if (j16 <= 0) {
                h(context, c16, j3, b16);
            }
            if (b16 == 1) {
                i3 = c16.getInt("on_pong_count", 0) + 1;
                c16.edit().putInt("on_pong_count", i3).apply();
            } else {
                i3 = c16.getInt("off_pong_count", 0) + 1;
                c16.edit().putInt("off_pong_count", i3).apply();
            }
            f(context, j16, j3, i3, b16);
            bz.c("recordPong complete");
        }
    }
}
