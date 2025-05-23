package com.tencent.luggage.wxa.yq;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.tencent.luggage.wxa.ar.x0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static long f146079a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f146080b = false;

    /* renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f146081c;

    public static synchronized void a(boolean z16) {
        synchronized (i.class) {
            x0.d("XWebAutoUpdater", "enableAutoCheckUpdate, flag:" + z16);
            AtomicBoolean atomicBoolean = f146081c;
            if (atomicBoolean != null) {
                if (atomicBoolean.get() == z16) {
                    x0.d("XWebAutoUpdater", "enableAutoCheckUpdate, flag not changed");
                    return;
                }
                f146081c.set(z16);
            } else {
                f146081c = new AtomicBoolean(z16);
            }
            if (f146081c.get()) {
                d();
            } else {
                e();
            }
        }
    }

    public static boolean b() {
        AtomicBoolean atomicBoolean = f146081c;
        if (atomicBoolean != null && atomicBoolean.get()) {
            return true;
        }
        return false;
    }

    public static synchronized void c() {
        synchronized (i.class) {
            x0.d("XWebAutoUpdater", "resetAutoCheckUpdatePeriod, sEnableAutoCheckUpdate:" + f146081c + ", sAutoCheckUpdateWorkerStarted:" + f146080b);
            if (b() && f146080b) {
                d();
            }
        }
    }

    public static synchronized void d() {
        synchronized (i.class) {
            if (!XWalkEnvironment.hasInited()) {
                x0.f("XWebAutoUpdater", "startAutoCheckUpdate, xweb environment not inited");
                return;
            }
            if (!a()) {
                x0.f("XWebAutoUpdater", "startAutoCheckUpdate, work manager not init");
                return;
            }
            long c16 = u.c();
            if (f146079a == c16) {
                x0.d("XWebAutoUpdater", "startAutoCheckUpdate, timeThreshold not changed");
                return;
            }
            f146079a = c16;
            x0.d("XWebAutoUpdater", "startAutoCheckUpdate, timeThreshold:" + c16);
            long j3 = c16 + 600000;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            WorkManager.getInstance(XWalkEnvironment.getApplicationContext()).enqueueUniquePeriodicWork("auto_check_update", ExistingPeriodicWorkPolicy.REPLACE, new PeriodicWorkRequest.Builder(h.class, j3, timeUnit).setInitialDelay(j3, timeUnit).build());
            f146080b = true;
        }
    }

    public static synchronized void e() {
        synchronized (i.class) {
            if (!XWalkEnvironment.hasInited()) {
                x0.f("XWebAutoUpdater", "stopAutoCheckUpdate, xweb environment not inited");
            } else {
                if (!a()) {
                    x0.f("XWebAutoUpdater", "stopAutoCheckUpdate, work manager not init");
                    return;
                }
                x0.d("XWebAutoUpdater", "stopAutoCheckUpdate");
                WorkManager.getInstance(XWalkEnvironment.getApplicationContext()).cancelUniqueWork("auto_check_update");
                f146080b = false;
            }
        }
    }

    public static boolean a() {
        try {
            WorkManager.getInstance(XWalkEnvironment.getApplicationContext());
            return true;
        } catch (Exception e16) {
            x0.a("XWebAutoUpdater", "checkWorkManagerInit error", e16);
            return false;
        }
    }

    public static void a(Context context) {
        x0.d("XWebAutoUpdater", "initWorkManager");
        WorkManager.initialize(context, new Configuration.Builder().build());
    }
}
