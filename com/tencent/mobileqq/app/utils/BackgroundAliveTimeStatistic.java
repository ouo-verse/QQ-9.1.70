package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BackgroundAliveTimeStatistic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f196570a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f196571b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f196572c;

    /* renamed from: d, reason: collision with root package name */
    private static int f196573d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f196574e;

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f196570a = 0L;
        boolean z17 = false;
        f196571b = false;
        if (MobileQQ.sProcessId == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        f196572c = z16;
        f196573d = 0;
        if (Math.random() < 9.999999747378752E-5d) {
            z17 = true;
        }
        f196574e = z17;
    }

    public static void a() {
        try {
            if (f196572c && f196574e && f196571b) {
                f196570a = 0L;
                f196573d = 0;
                SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("bg_alive_sp_file", 0).edit();
                edit.putLong("bg_time_sp_key", f196570a);
                edit.putInt("bg_mem_sp_key", 0);
                edit.apply();
            }
        } catch (Throwable th5) {
            QLog.e("BackgroundAliveTimeStatistic", 1, "clearBackgroundTickCount error", th5);
        }
    }

    public static void b() {
        try {
            if (f196572c && f196574e && f196571b) {
                long j3 = f196570a + 1;
                f196570a = j3;
                if (j3 == 1) {
                    f196573d = (int) SystemMethodProxy.getPss();
                }
                SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("bg_alive_sp_file", 0).edit();
                edit.putLong("bg_time_sp_key", f196570a);
                edit.putInt("bg_mem_sp_key", f196573d);
                edit.apply();
            }
        } catch (Throwable th5) {
            QLog.e("BackgroundAliveTimeStatistic", 1, "onBackgroundTick error", th5);
        }
    }

    public static void c() {
        try {
            if (!f196571b && f196572c) {
                f196571b = true;
                f196570a = 0L;
                f196573d = 0;
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("bg_alive_sp_file", 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                d(sharedPreferences.getLong("bg_time_sp_key", 0L), sharedPreferences.getInt("bg_mem_sp_key", 0));
                edit.putLong("bg_time_sp_key", 0L);
                edit.putInt("bg_mem_sp_key", 0);
                edit.apply();
            }
        } catch (Throwable th5) {
            QLog.e("BackgroundAliveTimeStatistic", 1, "reportBackgroundAliveTime error", th5);
        }
    }

    private static void d(long j3, int i3) {
        if (j3 > 0) {
            ThreadManager.getFileThreadHandler().postDelayed(new Runnable(j3, i3) { // from class: com.tencent.mobileqq.app.utils.BackgroundAliveTimeStatistic.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f196575d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f196576e;

                {
                    this.f196575d = j3;
                    this.f196576e = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("time", String.valueOf(this.f196575d));
                    hashMap.put("pss", String.valueOf(this.f196576e));
                    QLog.d("BackgroundAliveTimeStatistic", 1, "last time = " + this.f196575d + ",last pss = " + this.f196576e);
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String) null, "qq_bg_alive_time", true, this.f196575d, 1L, hashMap, "", false);
                }
            }, 1000L);
        }
    }
}
