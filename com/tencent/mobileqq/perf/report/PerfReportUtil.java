package com.tencent.mobileqq.perf.report;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PerfReportUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f258007a;

    /* renamed from: b, reason: collision with root package name */
    private static final ArrayList<String> f258008b;

    /* renamed from: com.tencent.mobileqq.perf.report.PerfReportUtil$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f258009d;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("PerfReportUtil", 2, "reportBeacon, eventName = " + this.f258009d);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.f258009d, true, 0L, 0L, null, "");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47517);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f258008b = arrayList;
        arrayList.add("QCircleLayerPage");
        arrayList.add("QCircleExplorePage");
        arrayList.add("QCircleFollowingPage");
    }

    public static void a(Map<String, String> map) {
        map.put("processName", MobileQQ.processName);
    }

    public static void b(String str, long j3) {
        if (f258007a == null) {
            f258007a = new ConcurrentHashMap<>(16);
        }
        f258007a.put(str, Long.valueOf(j3));
    }

    public static String c() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "-1";
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f258008b.contains(str);
    }

    public static void e(long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        g("actHotStart", hashMap, 0L);
    }

    public static void f() {
        HashMap<String, String> b16 = a.b();
        a(b16);
        g("actAppForeground", b16, 0L);
    }

    private static void g(@NonNull String str, @NonNull HashMap<String, String> hashMap, long j3) {
        ThreadManagerV2.executeDelay(new Runnable(hashMap, str) { // from class: com.tencent.mobileqq.perf.report.PerfReportUtil.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ HashMap f258010d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f258011e;

            {
                this.f258010d = hashMap;
                this.f258011e = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) hashMap, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    this.f258010d.put("realUin", PerfReportUtil.c());
                    if (QLog.isColorLevel()) {
                        QLog.d("PerfReportUtil", 2, "reportBeacon, eventName = " + this.f258011e + " \uff0cparams = " + this.f258010d.toString());
                    }
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", this.f258011e, true, 0L, 0L, this.f258010d, "");
                } catch (NoClassDefFoundError e16) {
                    QLog.e("PerfReportUtil", 1, e16, new Object[0]);
                }
            }
        }, 16, null, false, j3);
    }

    public static void h(@NonNull String str, @NonNull HashMap<String, String> hashMap) {
        hashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("realUin", c());
        a.a(hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("PerfReportUtil", 1, "reportBeaconWithMoreInfo, eventName = " + str + " , params = " + hashMap);
        }
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance("", str, true, 0L, 0L, hashMap, "");
    }

    public static void i() {
        HashMap<String, String> b16 = a.b();
        a(b16);
        g("actMainResume", b16, 0L);
    }

    public static void j(int i3, @NonNull String str) {
        g("actZPlanGameStart", a.b(), 0L);
    }

    public static void k() {
        g("actZPlanCrash", a.b(), 0L);
    }

    private static void l() {
        g("actZPlanEnd", a.b(), 0L);
    }

    public static void m() {
        g("actZPlanQuit", a.b(), 0L);
    }

    private static void n() {
        g("actZPlanStart", a.b(), 0L);
    }

    public static void o(boolean z16) {
        if (z16) {
            n();
        } else {
            l();
        }
    }
}
