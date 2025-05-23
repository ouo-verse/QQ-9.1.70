package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.xiaomi.push.service.XMJobService;

/* compiled from: P */
/* renamed from: com.xiaomi.push.do, reason: invalid class name */
/* loaded from: classes28.dex */
public final class Cdo {

    /* renamed from: a, reason: collision with root package name */
    private static a f388617a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f388618b = XMJobService.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static int f388619c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.xiaomi.push.do$a */
    /* loaded from: classes28.dex */
    public interface a {
        void a();

        void a(boolean z16);

        /* renamed from: a, reason: collision with other method in class */
        boolean mo301a();
    }

    public static synchronized void a() {
        synchronized (Cdo.class) {
            if (f388617a == null) {
                return;
            }
            jz4.c.m("[Alarm] stop alarm.");
            f388617a.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (r6.equals(com.xiaomi.push.ii.c(r9, r5.name).getSuperclass().getCanonicalName()) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f388617a = new dq(applicationContext);
            return;
        }
        int i3 = 0;
        try {
            ServiceInfo[] serviceInfoArr = InstalledAppListMonitor.getPackageInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 4).services;
            if (serviceInfoArr != null) {
                int length = serviceInfoArr.length;
                int i16 = 0;
                while (i3 < length) {
                    try {
                        ServiceInfo serviceInfo = serviceInfoArr[i3];
                        if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            String str = f388618b;
                            if (!str.equals(serviceInfo.name)) {
                            }
                            i16 = 1;
                            if (i16 == 1) {
                                break;
                            }
                        }
                        if (f388618b.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            i3 = 1;
                            break;
                        }
                        i3++;
                    } catch (Exception e16) {
                        e = e16;
                        i3 = i16;
                        jz4.c.m("check service err : " + e.getMessage());
                        if (i3 != 0) {
                        }
                        f388617a = new dq(applicationContext);
                    }
                }
                i3 = i16;
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (i3 != 0 && ii.g(applicationContext)) {
            throw new RuntimeException("Should export service: " + f388618b + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
        }
        f388617a = new dq(applicationContext);
    }

    public static synchronized void c(Context context, int i3) {
        synchronized (Cdo.class) {
            int i16 = f388619c;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i3 == 2) {
                    f388619c = 2;
                } else {
                    f388619c = 0;
                }
            }
            int i17 = f388619c;
            if (i16 != i17 && i17 == 2) {
                a();
                f388617a = new dr(context);
            }
        }
    }

    public static synchronized void d(boolean z16) {
        synchronized (Cdo.class) {
            if (f388617a == null) {
                jz4.c.m("timer is not initialized");
                return;
            }
            jz4.c.m("[Alarm] register alarm. (" + z16 + ")");
            f388617a.a(z16);
        }
    }

    public static synchronized boolean e() {
        synchronized (Cdo.class) {
            a aVar = f388617a;
            if (aVar == null) {
                return false;
            }
            return aVar.mo301a();
        }
    }
}
