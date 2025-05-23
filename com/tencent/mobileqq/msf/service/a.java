package com.tencent.mobileqq.msf.service;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;
    private static String A = "k_offline_time";
    private static String B = "k_offline_exist_time";
    private static String C = "k_alive_time_off";
    private static String D = "k_exist_time_off";
    private static final String E = "k_not_exit_time_off";
    public static String F = "msf_last_keep_alive_state";
    public static C8108a G = null;
    public static volatile boolean H = true;
    private static SharedPreferences I = null;
    public static final long J = 39600000;

    /* renamed from: a, reason: collision with root package name */
    public static final long f250772a = 5000;

    /* renamed from: b, reason: collision with root package name */
    public static long f250773b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static long f250774c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static long f250775d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static long f250776e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static long f250777f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static long f250778g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static long f250779h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static long f250780i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static long f250781j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static long f250782k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static long f250783l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static long f250784m = 0;

    /* renamed from: n, reason: collision with root package name */
    public static long f250785n = 0;

    /* renamed from: o, reason: collision with root package name */
    public static long f250786o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f250787p = false;

    /* renamed from: q, reason: collision with root package name */
    private static com.tencent.mobileqq.msf.core.c0.j f250788q = null;

    /* renamed from: r, reason: collision with root package name */
    private static String f250789r = "k_begin_time";

    /* renamed from: s, reason: collision with root package name */
    private static String f250790s = "k_end_time";

    /* renamed from: t, reason: collision with root package name */
    private static String f250791t = "k_boot_time";

    /* renamed from: u, reason: collision with root package name */
    private static String f250792u = "k_alive_time";

    /* renamed from: v, reason: collision with root package name */
    private static String f250793v = "k_exist_time";

    /* renamed from: w, reason: collision with root package name */
    private static String f250794w = "k_no_net_time";

    /* renamed from: x, reason: collision with root package name */
    private static String f250795x = "k_no_net_exist_time";

    /* renamed from: y, reason: collision with root package name */
    private static String f250796y = "k_not_connected_time";

    /* renamed from: z, reason: collision with root package name */
    private static String f250797z = "k_not_connected_exist_time";

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8108a extends BaseThread {
        static IPatchRedirector $redirector_;

        public C8108a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private void a(long j3, long j16) {
            long j17 = j3 - j16;
            if (j17 > 0 && j17 <= a.J) {
                try {
                    boolean isWifiOrMobileConn = NetConnInfoCenter.isWifiOrMobileConn();
                    boolean isOffline = MsfService.core.isOffline();
                    boolean isConnected = MsfService.core.isConnected();
                    if (!isWifiOrMobileConn) {
                        a.f250778g += 5000;
                        a.f250779h += j17;
                    }
                    if (!isConnected) {
                        a.f250780i += 5000;
                        a.f250781j += j17;
                    }
                    if (isOffline) {
                        a.f250782k += 5000;
                        a.f250783l += j17;
                    }
                    boolean z16 = j.f250929d;
                    a.f250787p = z16;
                    if (z16) {
                        a.f250776e += 5000;
                        a.f250777f += j17;
                    } else {
                        a.f250784m += 5000;
                        a.f250785n += j17;
                    }
                    a.f250774c = j3;
                    a.a("writeDownOneDayEndAndTotalTime");
                    SharedPreferences.Editor edit = a.I.edit();
                    edit.putLong(a.f250790s, a.f250774c);
                    edit.putLong(a.f250792u, a.f250776e);
                    edit.putLong(a.f250793v, a.f250777f);
                    edit.putLong(a.f250794w, a.f250778g);
                    edit.putLong(a.f250795x, a.f250779h);
                    edit.putLong(a.f250796y, a.f250780i);
                    edit.putLong(a.f250797z, a.f250781j);
                    edit.putLong(a.A, a.f250782k);
                    edit.putLong(a.B, a.f250783l);
                    edit.putLong(a.C, a.f250784m);
                    edit.putLong(a.D, a.f250785n);
                    edit.putLong(a.E, a.f250786o);
                    edit.putBoolean(a.F, a.f250787p);
                    edit.commit();
                    return;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return;
                }
            }
            a.p();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (a.H) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    LockMethodProxy.sleep(5000L);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long b16 = j.b(currentTimeMillis2);
                    if (a.f250775d == 0 && b16 >= j.f250926a) {
                        a.f250775d = System.currentTimeMillis() - SystemClock.elapsedRealtime();
                        a.f250773b = currentTimeMillis;
                        SharedPreferences.Editor edit = a.I.edit();
                        edit.putLong(a.f250789r, a.f250773b);
                        edit.putLong(a.f250791t, a.f250775d);
                        edit.commit();
                    }
                    if (a.f250775d <= 0) {
                        continue;
                    } else if (b16 <= j.f250927b) {
                        a(currentTimeMillis2, currentTimeMillis);
                    } else {
                        a.a(a.f250788q);
                        return;
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str) {
    }

    public static void p() {
        I.edit().clear();
        f250773b = 0L;
        f250774c = 0L;
        f250775d = 0L;
        f250776e = 0L;
        f250777f = 0L;
        f250778g = 0L;
        f250779h = 0L;
        f250780i = 0L;
        f250781j = 0L;
        f250782k = 0L;
        f250783l = 0L;
        f250784m = 0L;
        f250785n = 0L;
        f250786o = 0L;
        f250787p = false;
    }

    public static void q() {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(j.f250928c, 0);
        I = sharedPreferences;
        f250773b = sharedPreferences.getLong(f250789r, 0L);
        f250774c = I.getLong(f250790s, 0L);
        f250775d = I.getLong(f250791t, 0L);
        f250776e = I.getLong(f250792u, 0L);
        f250777f = I.getLong(f250793v, 0L);
        f250778g = I.getLong(f250794w, 0L);
        f250779h = I.getLong(f250795x, 0L);
        f250780i = I.getLong(f250796y, 0L);
        f250781j = I.getLong(f250797z, 0L);
        f250782k = I.getLong(A, 0L);
        f250783l = I.getLong(B, 0L);
        f250784m = I.getLong(C, 0L);
        f250785n = I.getLong(D, 0L);
        f250786o = I.getLong(E, 0L);
        f250787p = I.getBoolean(F, false);
        a("initSavedData");
    }

    public static void r() {
        H = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.tencent.mobileqq.msf.core.c0.j jVar) {
        if (G == null) {
            f250788q = jVar;
            C8108a c8108a = new C8108a();
            G = c8108a;
            c8108a.start();
        }
    }

    public static void a(com.tencent.mobileqq.msf.core.c0.j jVar) {
        a("reportAndClear");
        HashMap hashMap = new HashMap(32);
        hashMap.put("system_boot_time", "" + f250775d);
        hashMap.put("beginTime", "" + f250773b);
        hashMap.put("endTime", "" + f250774c);
        hashMap.put("noNetAlive", "" + f250778g);
        hashMap.put("noNetExist", "" + f250779h);
        hashMap.put("notConnectedAlive", "" + f250780i);
        hashMap.put("notConnectedExist", "" + f250781j);
        hashMap.put("offlineAlive", "" + f250782k);
        hashMap.put("offlineExist", "" + f250783l);
        hashMap.put("aliveTimeOff", "" + f250784m);
        hashMap.put("existTimeOff", "" + f250785n);
        hashMap.put("notExitTimeOff", "" + f250786o);
        hashMap.put("lastAliveOf", "" + f250787p);
        hashMap.put("jobschedulerAB", "" + j.f250934i);
        if (f250775d > 0) {
            long j3 = f250773b;
            if (j3 > 0) {
                long j16 = f250774c;
                if (j16 > 0) {
                    long j17 = f250776e;
                    if (j17 >= 0 && f250784m >= 0 && j16 > j3) {
                        if (jVar != null) {
                            jVar.a("msfAliveTime_new", j16 - j3 > 0, f250777f, j17, (Map<String, String>) hashMap, false, false);
                        }
                        try {
                            if (MsfCore.sCore != null && MsfService.core.isConnected()) {
                                com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "alive_rate", "", "", "", 1, "", String.valueOf(f250774c - f250773b), String.valueOf(f250785n), "", "", "", "", "");
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        p();
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(j.f250928c, 1, "report failed");
        }
        p();
    }
}
