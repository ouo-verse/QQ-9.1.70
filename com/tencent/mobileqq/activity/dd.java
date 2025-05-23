package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class dd implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static boolean D;
    private final com.tencent.mobileqq.splash.a C;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<SplashActivity> f181858d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f181859e;

    /* renamed from: f, reason: collision with root package name */
    private long f181860f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f181861h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f181862i;

    /* renamed from: m, reason: collision with root package name */
    private long f181863m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements com.tencent.mobileqq.splash.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dd.this);
            }
        }

        @Override // com.tencent.mobileqq.splash.a
        public void a(boolean z16) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QLog.e("HotSplash", 1, "onShow " + z16 + " timeout " + dd.this.f181862i);
            if (!dd.this.f181862i) {
                dd.this.f181861h = true;
                if (System.currentTimeMillis() - dd.this.f181863m > ((IGdtAPI) QRoute.api(IGdtAPI.class)).getWarmDecodeTimeout() && dd.this.f181863m != -1) {
                    dd.this.h();
                    return;
                }
                dd ddVar = dd.this;
                if (z16) {
                    i3 = 1004;
                } else {
                    i3 = 1005;
                }
                ddVar.k(i3, 0L);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67152);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            D = false;
        }
    }

    public dd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f181859e = new Handler(Looper.getMainLooper(), this);
        this.f181863m = -1L;
        this.C = new a();
    }

    private void g(long j3, long j16, boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleWeakNetReporter.KEY_COST, String.valueOf(j3));
        hashMap.put("splash_duration", String.valueOf(j16));
        String str2 = "0";
        if (!z16) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("is_ad_splash", str);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        }
        QQBeaconReport.report(str2, "startup_warm_splash", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f181862i = true;
        QLog.e("HotSplash", 1, "onShow timeout");
        com.tencent.mobileqq.splashad.l.f288780d.m();
        j(false, ((IGdtAPI) QRoute.api(IGdtAPI.class)).getWarmDecodeTimeout());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i3) {
        j(true, i3);
    }

    private void j(boolean z16, int i3) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f181860f;
        D = false;
        WeakReference<SplashActivity> weakReference = this.f181858d;
        if (weakReference != null && weakReference.get() != null) {
            this.f181858d.get().realOnCreate();
        } else {
            QLog.e("HotSplash", 1, "splashActivity should not be null!");
        }
        g(uptimeMillis, i3, z16);
        QLog.d("HotSplash", 1, "HotSplash completed and realCreate. Is bizSplash:" + z16 + ", duration:" + i3 + ", cost:" + uptimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i3, long j3) {
        this.f181859e.removeMessages(i3);
        this.f181859e.sendEmptyMessageDelayed(i3, j3);
    }

    public static void l(boolean z16) {
        D = z16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1003:
                if (!this.f181861h) {
                    h();
                    break;
                }
                break;
            case 1004:
                QLog.d("HotSplash", 1, "HotSplash show splash delay" + (System.currentTimeMillis() - this.f181860f));
                com.tencent.mobileqq.splashad.l.f288780d.s(new com.tencent.mobileqq.splash.b() { // from class: com.tencent.mobileqq.activity.dc
                    @Override // com.tencent.mobileqq.splash.b
                    public final void onCompleted(int i3) {
                        dd.this.i(i3);
                    }
                });
                break;
            case 1005:
                j(false, 0);
                break;
        }
        return true;
    }

    public boolean m(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!D) {
            return false;
        }
        if (!com.tencent.mobileqq.splashad.q.f288880a.e(true)) {
            QLog.d("HotSplash", 1, "return for checker failed");
            return false;
        }
        if (!(obj instanceof SplashActivity)) {
            return false;
        }
        this.f181860f = SystemClock.uptimeMillis();
        SplashActivity splashActivity = (SplashActivity) obj;
        if (!SplashADUtil.v(splashActivity)) {
            QLog.d("HotSplash", 1, "return for not start form launcher");
            return false;
        }
        if (QBaseActivity.sTopActivity != null) {
            QLog.d("HotSplash", 1, "return for topActivity not null " + QBaseActivity.sTopActivity);
            return false;
        }
        this.f181861h = false;
        this.f181862i = false;
        this.f181858d = new WeakReference<>(splashActivity);
        this.f181863m = -1L;
        boolean r16 = com.tencent.mobileqq.splashad.l.f288780d.r(splashActivity, false, this.C);
        QLog.d("HotSplash", 1, "has bizSplash " + r16);
        if (!r16) {
            return false;
        }
        this.f181863m = System.currentTimeMillis();
        k(1003, ((IGdtAPI) QRoute.api(IGdtAPI.class)).getWarmDecodeTimeout());
        splashActivity.getWindow().addFlags(1024);
        return true;
    }
}
