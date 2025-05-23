package com.tencent.imcore.message.report;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.perf.startup.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ds;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f116728a;

    /* renamed from: b, reason: collision with root package name */
    private long f116729b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f116730c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f116731d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final b f116732a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66442);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f116732a = new b();
            }
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116729b = -1L;
            this.f116731d = true;
        }
    }

    public static b a() {
        return a.f116732a;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.f116729b == -1) {
            this.f116729b = SystemClock.uptimeMillis();
        } else {
            this.f116729b = 0L;
        }
    }

    public void c(AppRuntime appRuntime, RecentBaseData recentBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime, (Object) recentBaseData);
            return;
        }
        if (!this.f116728a && this.f116730c && this.f116731d && recentBaseData.fromRegisterProxy && this.f116729b > 0 && appRuntime != null && f.f258038b > 0) {
            this.f116728a = true;
            if (ds.d(0, 1000) != 1) {
                return;
            }
            try {
                if (!((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("android_rp_show_report")) {
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                long j3 = uptimeMillis - this.f116729b;
                long j16 = uptimeMillis - f.f258038b;
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("duration", String.valueOf(j3));
                hashMap.put("launch2show", String.valueOf(j16));
                StatisticCollector.getInstance(appRuntime.getApplicationContext()).collectPerformance(appRuntime.getCurrentAccountUin(), "RPMsgFirstShow", true, j3, 0L, hashMap, null);
                QLog.d("RPReport", 1, "reportRPShow duration=" + j3 + " launch2Show=" + j16);
            } catch (Exception unused) {
                QLog.d("RPReport", 1, "reportRPShow Exception");
            }
        }
    }
}
