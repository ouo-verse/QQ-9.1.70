package com.tencent.mobileqq.bgprobe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopapps.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class BackgroundProbeManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final long f200343c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f200344d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f200345e;

    /* renamed from: a, reason: collision with root package name */
    private long f200346a;

    /* renamed from: b, reason: collision with root package name */
    private Context f200347b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final BackgroundProbeManager f200350a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70975);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f200350a = new BackgroundProbeManager();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f200343c = TimeUnit.DAYS.toMillis(1L);
            f200345e = false;
        }
    }

    BackgroundProbeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        BaseApplication baseApplication = BaseApplication.context;
        this.f200347b = baseApplication;
        this.f200346a = PreferenceManager.getDefaultSharedPreferences(baseApplication).getLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", 0L);
        f200345e = new Random(System.currentTimeMillis()).nextInt(100000) == 0;
    }

    private static boolean c() {
        boolean z16;
        boolean z17;
        if (i() >= 26) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            return true;
        }
        return false;
    }

    public static BackgroundProbeManager d() {
        return a.f200350a;
    }

    public static void e() {
        BackgroundProbeManager d16 = d();
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.bgprobe.BackgroundProbeManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BackgroundProbeManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    BackgroundProbeManager.this.g();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.tencent.mobileqq.bgprobe.BackgroundProbeManager.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BackgroundProbeManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    BackgroundProbeManager.this.h();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        };
        boolean f16 = d16.f();
        if (QLog.isColorLevel()) {
            QLog.i("BackgroundProbeManager", 2, "onRunningBackground: invoked.  probeEnabled: " + f16);
        }
        if (f16) {
            g.g(runnable, 180000L);
        }
        g.g(runnable2, 181000L);
    }

    private boolean f() {
        boolean z16;
        if (System.currentTimeMillis() - this.f200346a > f200343c) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c() && z16) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (!f200344d) {
                this.f200347b.startService(new Intent(this.f200347b, (Class<?>) BackgroundService.class));
                this.f200346a = System.currentTimeMillis();
                f200344d = true;
                PreferenceManager.getDefaultSharedPreferences(this.f200347b).edit().putLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", this.f200346a).apply();
            }
        } catch (Throwable unused) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(new BackgroundException("startProbeService failed"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            if (f200344d) {
                this.f200347b.stopService(new Intent(this.f200347b, (Class<?>) BackgroundService.class));
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("BackgroundProbeManager", 2, "stopProbeService: failed. ", th5);
            }
        }
    }

    private static int i() {
        try {
            ApplicationInfo applicationInfo = BaseApplicationImpl.getApplication().getPackageManager().getApplicationInfo("com.tencent.mobileqq", 128);
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
