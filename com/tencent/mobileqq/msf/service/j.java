package com.tencent.mobileqq.msf.service;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@TargetApi(9)
/* loaded from: classes15.dex */
public class j {
    static IPatchRedirector $redirector_ = null;
    private static final int A = 1;
    private static final int B = 2;
    private static final int C = 3;
    private static final int D = 4;
    public static final int E = 1;
    public static final int F = 2;
    private static int G = 0;
    private static int H = 0;
    private static String I = null;
    private static long J = 0;
    private static boolean K = false;
    private static long L = 0;
    private static int M = -1;
    private static boolean N = false;
    private static boolean O = false;
    public static boolean P = false;
    public static final String Q = "key_action_name";
    public static final String R = "key_from_job";

    /* renamed from: a, reason: collision with root package name */
    public static int f250926a = 8;

    /* renamed from: b, reason: collision with root package name */
    public static int f250927b = 22;

    /* renamed from: c, reason: collision with root package name */
    public static String f250928c = "MSFAliveManager";

    /* renamed from: d, reason: collision with root package name */
    public static boolean f250929d = false;

    /* renamed from: e, reason: collision with root package name */
    public static final int f250930e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final long f250931f = 900000;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f250932g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f250933h = false;

    /* renamed from: i, reason: collision with root package name */
    public static int f250934i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f250935j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f250936k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static int f250937l = 2;

    /* renamed from: m, reason: collision with root package name */
    public static int f250938m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static int f250939n = 1;

    /* renamed from: o, reason: collision with root package name */
    public static int f250940o = 2;

    /* renamed from: p, reason: collision with root package name */
    public static int f250941p = 3;

    /* renamed from: q, reason: collision with root package name */
    public static int f250942q = 4;

    /* renamed from: r, reason: collision with root package name */
    public static int f250943r = 5;

    /* renamed from: s, reason: collision with root package name */
    private static final String f250944s = "sp_job_ab";

    /* renamed from: t, reason: collision with root package name */
    private static final String f250945t = "sp_key_job_ab_enable";

    /* renamed from: u, reason: collision with root package name */
    public static final String f250946u = "sp_boot_msf";

    /* renamed from: v, reason: collision with root package name */
    private static final String f250947v = "sp_boot_time";

    /* renamed from: w, reason: collision with root package name */
    private static final String f250948w = "sp_last_su_time";

    /* renamed from: x, reason: collision with root package name */
    private static final String f250949x = "sp_day_id";

    /* renamed from: y, reason: collision with root package name */
    private static final String f250950y = "sp_s_times";

    /* renamed from: z, reason: collision with root package name */
    private static final int f250951z = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Intent intent, int i3) {
        if (J == 0) {
            G = i3;
            J = System.currentTimeMillis();
            if (intent == null) {
                H = 1;
            } else if (intent.getStringExtra(Q) != null) {
                H = 4;
                I = intent.getStringExtra(Q);
            } else if (intent.getBooleanExtra(R, false)) {
                H = 3;
            } else {
                H = 2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            L = currentTimeMillis - SystemClock.elapsedRealtime();
            SharedPreferences sharedPreferences = MsfService.getCore().getSharedPreferences(f250946u, 0);
            long j3 = sharedPreferences.getLong(f250947v, 0L);
            long j16 = sharedPreferences.getLong(f250948w, 0L);
            K = j3 != 0 && Math.abs(j3 - L) > 120000 && L > j16 && j16 > 0;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(f250947v, L).putLong(f250948w, currentTimeMillis);
            long j17 = sharedPreferences.getLong(f250949x, 0L);
            long currentTimeMillis2 = (System.currentTimeMillis() + MiniBoxNoticeInfo.HOUR_8) / 86400000;
            if (j17 == 0 || j17 > currentTimeMillis2) {
                edit.putLong(f250949x, currentTimeMillis2 + 1).putInt(f250950y, 0);
            } else if (j17 < currentTimeMillis2) {
                M = sharedPreferences.getInt(f250950y, 0);
                edit.putLong(f250949x, currentTimeMillis2).putInt(f250950y, 1);
            } else {
                edit.putInt(f250950y, sharedPreferences.getInt(f250950y, 0) + 1);
            }
            edit.apply();
            QLog.d(f250928c, 1, "startupType = ", Integer.valueOf(H), ", firstStartup = ", Boolean.valueOf(K), ", bootTime = ", Long.valueOf(L), ", lastStartupTime = ", Long.valueOf(j16), ", isOffline = ", Boolean.valueOf(MsfCore.sCore.isOffline()), ", recordDay = ", Long.valueOf(j17), ", currentDay = ", Long.valueOf(currentTimeMillis2), ", times=", M + ", sFromType = " + G, "sStartupBroadcast = " + I);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0061, code lost:
    
        if (java.lang.Math.random() < 0.10000000149011612d) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b() {
        boolean z16;
        Object obj;
        String str;
        Object obj2;
        int i3;
        if (N) {
            return;
        }
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore != null && msfCore.statReporter != null && !msfCore.isOffline() && H != 0) {
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
                boolean z17 = K;
                double random = Math.random();
                z16 = !z17 ? false : false;
            } else {
                if (!K) {
                }
                z16 = true;
            }
            long j3 = (J - L) / 1000;
            int autoStartMode = MsfSdkUtils.getAutoStartMode(BaseApplication.getContext());
            if (QLog.isColorLevel()) {
                QLog.d(f250928c, 2, "report service boot, isFirst = ", Boolean.valueOf(K), ", type = ", Integer.valueOf(H), ", bootDuration  = " + j3, "bdAction = " + I, ", report = ", Boolean.valueOf(z16), ", autoMode = " + autoStartMode);
            }
            if (z16) {
                HashMap hashMap = new HashMap(8);
                hashMap.put("osVersion", Build.VERSION.SDK_INT + "");
                hashMap.put("model", DeviceInfoMonitor.getModel());
                hashMap.put("manufacture", Build.MANUFACTURER);
                hashMap.put("startupType", String.valueOf(H));
                hashMap.put("startupAction", I);
                hashMap.put("bootDuration", String.valueOf(j3));
                hashMap.put("autoMode", String.valueOf(autoStartMode));
                com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
                obj = "osVersion";
                str = "";
                obj2 = "model";
                i3 = 8;
                MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.Q2, K, j3, 0L, (Map<String, String>) hashMap, false, false);
                if (MsfCore.sCore != null && K && MsfService.core.isConnected()) {
                    com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "self_start_rate", "", "", "", 1, "", String.valueOf(H), I, String.valueOf(j3), String.valueOf(autoStartMode), "", "", "");
                }
            } else {
                obj = "osVersion";
                str = "";
                obj2 = "model";
                i3 = 8;
            }
            if ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || Math.random() < 0.003000000026077032d) && M != -1) {
                HashMap hashMap2 = new HashMap(i3);
                hashMap2.put(obj, Build.VERSION.SDK_INT + str);
                hashMap2.put(obj2, DeviceInfoMonitor.getModel());
                hashMap2.put("manufacture", Build.MANUFACTURER);
                hashMap2.put("startTimes", String.valueOf(M));
                com.tencent.mobileqq.msf.core.e0.h.a(hashMap2);
                MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.R2, true, 0L, 0L, (Map<String, String>) hashMap2, false, false);
            }
            N = true;
            return;
        }
        QLog.e(f250928c, 1, "boot type uninit");
    }

    public static void c() {
        boolean z16;
        if (O) {
            return;
        }
        try {
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && Math.random() >= 0.009999999776482582d) {
                z16 = false;
                if (z16 && P && MsfCore.sCore != null && MsfService.core.isConnected()) {
                    long currentTimeMillis = System.currentTimeMillis() - InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 0).lastUpdateTime;
                    QLog.i(f250928c, 1, "intervalTime = " + currentTimeMillis + ",model = " + DeviceInfoMonitor.getModel() + ",manufacture = " + Build.MANUFACTURER + ",startupType = " + String.valueOf(H) + ",os = " + Build.VERSION.SDK_INT + ",sStartupBroadcast = " + I);
                    com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "update_start_rate", "", "", "", 1, "", String.valueOf(H), I, String.valueOf(currentTimeMillis), "", "", "", "");
                }
                O = true;
            }
            z16 = true;
            if (z16) {
                long currentTimeMillis2 = System.currentTimeMillis() - InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 0).lastUpdateTime;
                QLog.i(f250928c, 1, "intervalTime = " + currentTimeMillis2 + ",model = " + DeviceInfoMonitor.getModel() + ",manufacture = " + Build.MANUFACTURER + ",startupType = " + String.valueOf(H) + ",os = " + Build.VERSION.SDK_INT + ",sStartupBroadcast = " + I);
                com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "update_start_rate", "", "", "", 1, "", String.valueOf(H), I, String.valueOf(currentTimeMillis2), "", "", "", "");
            }
            O = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f250928c, 2, "checkReportUpdateBoot", e16);
            }
        }
    }

    public static boolean d() {
        int i3;
        int O2 = com.tencent.mobileqq.msf.core.x.b.O();
        if (O2 == f250937l) {
            f250934i = f250940o;
        } else if (O2 == f250935j) {
            f250934i = f250939n;
        } else if (O2 == f250936k) {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(f250944s, 0);
            int i16 = sharedPreferences.getInt(f250945t, f250938m);
            f250934i = i16;
            if (i16 == f250938m) {
                if (Math.random() <= 0.5d) {
                    i3 = f250941p;
                } else {
                    i3 = f250942q;
                }
                f250934i = i3;
                sharedPreferences.edit().putInt(f250945t, f250934i).commit();
                QLog.d(f250928c, 1, "MSF_Alive_Log sample job AB Test: ", Integer.valueOf(f250934i));
            }
        }
        QLog.d(f250928c, 1, "MSF_Alive_Log get job state = ", Integer.valueOf(f250934i));
        int i17 = f250934i;
        if (i17 != f250940o && i17 != f250941p) {
            return false;
        }
        return true;
    }

    public static void e() {
        if (QLog.isColorLevel()) {
            QLog.d(f250928c, 1, "onMSFServiceDestroy");
        }
        a.r();
    }

    public static void f() {
        f250929d = false;
    }

    public static void g() {
        ((JobScheduler) BaseApplication.getContext().getSystemService("jobscheduler")).cancel(1);
        QLog.d(f250928c, 1, "MSF_Alive_Log cancel JobScheduler!");
    }

    public static void a(com.tencent.mobileqq.msf.core.c0.j jVar, boolean z16) {
        f250929d = z16;
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        long currentTimeMillis2 = System.currentTimeMillis();
        long b16 = b(currentTimeMillis2);
        if (QLog.isColorLevel()) {
            QLog.d(f250928c, 1, "MSFAliveRecorder onMSFServiceBeginAsync " + currentTimeMillis2);
        }
        a.q();
        long j3 = a.f250775d;
        if (j3 > 0 && Math.abs(j3 - currentTimeMillis) <= 10000) {
            long a16 = a(a.f250774c);
            long a17 = a(currentTimeMillis2);
            if (a16 != a17) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250928c, 1, "not same day report " + a16 + " " + a17);
                }
                a.a(jVar);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(f250928c, 1, "fix data " + a.f250787p + " " + a.f250774c);
                }
                long j16 = a.f250774c;
                if (currentTimeMillis2 > j16 && currentTimeMillis2 - j16 <= a.J) {
                    if (!a.f250787p) {
                        a.f250786o += currentTimeMillis2 - a.f250774c;
                    }
                    a.f250774c = currentTimeMillis2;
                } else {
                    a.p();
                }
            }
            if (b16 > f250927b) {
                a.a(jVar);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f250928c, 1, "reboot or bad data " + a.f250775d);
            }
            a.p();
        }
        if (b16 < f250926a) {
            a.p();
        }
        if (b16 <= f250927b) {
            a.b(jVar);
        }
    }

    public static long b(long j3) {
        return TimeUnit.MILLISECONDS.toHours(j3 + TimeZone.getDefault().getRawOffset()) % 24;
    }

    public static long a(long j3) {
        return TimeUnit.MILLISECONDS.toDays(j3 + TimeZone.getDefault().getRawOffset());
    }

    public static void a() {
        int i3;
        if (!d()) {
            QLog.d(f250928c, 1, "MSF_Alive_Log add JobScheduler not enable");
            return;
        }
        QLog.d(f250928c, 1, "MSF_Alive_Log add JobScheduler begin");
        if (f250932g) {
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) BaseApplication.getContext().getSystemService("jobscheduler");
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(BaseApplication.getContext(), (Class<?>) MSFAliveJobService.class));
        builder.setPeriodic(900000L);
        builder.setPersisted(true);
        try {
            i3 = jobScheduler.schedule(builder.build());
        } catch (Throwable th5) {
            QLog.d(f250928c, 1, "MSF_Alive_Log add JobScheduler Throwable:", th5);
            i3 = 0;
        }
        if (i3 == 1) {
            QLog.d(f250928c, 1, "MSF_Alive_Log add JobScheduler success!");
            f250932g = true;
        } else if (i3 == 0) {
            QLog.d(f250928c, 1, "MSF_Alive_Log add JobScheduler fail!");
        }
    }

    public static void a(boolean z16) {
        b();
        if (!d()) {
            QLog.d(f250928c, 1, "MSF_Alive_Log reportJobAliveMsf not enable");
            return;
        }
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore != null && msfCore.statReporter != null) {
            HashMap hashMap = new HashMap(8);
            hashMap.put("osVersion", Build.VERSION.SDK_INT + "");
            hashMap.put("model", DeviceInfoMonitor.getModel());
            hashMap.put("manufacture", Build.MANUFACTURER);
            hashMap.put("rdminit", z16 ? "1" : "0");
            com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
            MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.P2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            f250933h = false;
            return;
        }
        f250933h = true;
    }
}
