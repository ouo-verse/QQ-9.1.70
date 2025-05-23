package com.tencent.mobileqq.splashad;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.managers.AdDurationReportManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.w;
import cooperation.vip.tianshu.TianShuManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f288925a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f288926b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f288927c;

    /* renamed from: d, reason: collision with root package name */
    static QBaseActivity.a f288928d;

    /* renamed from: e, reason: collision with root package name */
    static BaseActivityLifecycleCallbacks f288929e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements QBaseActivity.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.QBaseActivity.a
        public void a(Activity activity, boolean z16) {
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, Boolean.valueOf(z16));
                return;
            }
            if (t.f288926b && !z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            t.f288927c = z17;
            QLog.d("VasSplashJumpManager", 1, "onTopResumedActivityChanged, isTopResumedActivity: " + z16 + ", splashAdBlocked: " + t.f288927c);
            t.f288926b = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends DefaultBaseActivityLifecycleCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
        public void doOnActivityStopped(Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
                return;
            }
            super.doOnActivityStopped(activity);
            QLog.d("VasSplashJumpManager", 1, "doOnActivityStopped, reset flags and listener");
            t.f288926b = false;
            t.f288927c = false;
            if (activity instanceof SplashActivity) {
                SplashActivity splashActivity = (SplashActivity) activity;
                splashActivity.setTopResumedActivityListener(null);
                splashActivity.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f288925a = false;
        f288926b = false;
        f288927c = false;
        f288928d = new a();
        f288929e = new b();
    }

    public t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean f(SplashActivity splashActivity, o43.a aVar) {
        if (TextUtils.isEmpty(aVar.f421941j)) {
            r(aVar, 141);
            return i(splashActivity, aVar);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(aVar.f421941j));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_splash_screen");
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            PackageManager packageManager = splashActivity.getPackageManager();
            if (packageManager != null && packageManager.resolveActivity(intent, 65536) != null) {
                splashActivity.startActivity(intent);
                t(aVar);
                r(aVar, 139);
                return false;
            }
        } catch (Exception e16) {
            QLog.e("VasSplashJumpManager", 1, "handleJumpAppSchema" + e16);
        }
        r(aVar, 141);
        return i(splashActivity, aVar);
    }

    private static boolean g(SplashActivity splashActivity, o43.a aVar, boolean z16) {
        if (TextUtils.isEmpty(aVar.f421941j)) {
            r(aVar, 141);
            return i(splashActivity, aVar);
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(aVar.f421941j));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_splash_screen");
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            PackageManager packageManager = splashActivity.getPackageManager();
            if (packageManager != null && packageManager.resolveActivity(intent, 65536) != null) {
                p(splashActivity, intent, aVar, z16);
                t(aVar);
                r(aVar, 139);
                return false;
            }
        } catch (Exception e16) {
            QLog.e("VasSplashJumpManager", 1, "handleJumpAppSchemaAndH5Delay" + e16);
        }
        r(aVar, 141);
        return i(splashActivity, aVar);
    }

    private static boolean h(SplashActivity splashActivity, o43.a aVar) {
        boolean z16;
        Intent intent;
        PackageManager packageManager;
        if (TextUtils.isEmpty(aVar.f421941j)) {
            r(aVar, 141);
            return i(splashActivity, aVar);
        }
        boolean j3 = j(splashActivity, aVar, Boolean.FALSE);
        try {
            intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(aVar.f421941j));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", "biz_src_jc_splash_screen");
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            packageManager = splashActivity.getPackageManager();
        } catch (Exception e16) {
            QLog.e("VasSplashJumpManager", 1, "handleJumpAppSchemaAndH5Sync" + e16);
            r(aVar, 141);
        }
        if (packageManager != null && packageManager.resolveActivity(intent, 65536) != null) {
            splashActivity.startActivity(intent);
            t(aVar);
            r(aVar, 139);
            z16 = false;
            if (!j3 && z16) {
                return true;
            }
        }
        z16 = true;
        return !j3 ? false : false;
    }

    private static boolean i(SplashActivity splashActivity, o43.a aVar) {
        return j(splashActivity, aVar, Boolean.TRUE);
    }

    private static boolean j(SplashActivity splashActivity, o43.a aVar, Boolean bool) {
        return m(splashActivity, aVar, bool, false);
    }

    private static boolean k(SplashActivity splashActivity, o43.a aVar, Boolean bool) {
        return m(splashActivity, aVar, bool, true);
    }

    private static boolean l(SplashActivity splashActivity, QQAppInterface qQAppInterface, o43.a aVar) {
        if (TextUtils.isEmpty(aVar.f421937h)) {
            QLog.i("QSplash@VasSplashUtil", 1, "scheme is null");
            return false;
        }
        try {
            bi.c(qQAppInterface, splashActivity, aVar.f421937h).b();
            t(aVar);
        } catch (Exception e16) {
            QLog.e("VasSplashJumpManager", 1, "handleJumpSchema" + e16);
        }
        return false;
    }

    private static boolean m(SplashActivity splashActivity, o43.a aVar, Boolean bool, boolean z16) {
        String str;
        if (z16) {
            str = aVar.f421939i;
        } else {
            str = aVar.f421937h;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("QSplash@VasSplashUtil", 1, "jumpH5Url is null");
            return false;
        }
        try {
            Intent intent = new Intent(splashActivity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("key_from_splash_ad", true);
            intent.putExtra("big_brother_source_key", "biz_src_jc_vip");
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            splashActivity.startActivity(intent);
            if (bool.booleanValue()) {
                t(aVar);
            }
            return true;
        } catch (Exception e16) {
            QLog.e("VasSplashJumpManager", 1, "handleJumpH5" + e16);
            return false;
        }
    }

    public static boolean n(SplashActivity splashActivity, QQAppInterface qQAppInterface) {
        o43.a aVar;
        if (!com.tencent.mobileqq.vassplash.common.c.f312375c || (aVar = com.tencent.mobileqq.vassplash.common.c.f312380h) == null) {
            return false;
        }
        int i3 = aVar.f421935g;
        com.tencent.mobileqq.vassplash.common.c.f312375c = false;
        if (i3 != 1) {
            switch (i3) {
                case 4:
                    return l(splashActivity, qQAppInterface, aVar);
                case 5:
                    return f(splashActivity, aVar);
                case 6:
                    return h(splashActivity, aVar);
                case 7:
                    return g(splashActivity, aVar, false);
                case 8:
                    return g(splashActivity, aVar, true);
                default:
                    return false;
            }
        }
        return i(splashActivity, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(long j3, long j16, boolean z16, SplashActivity splashActivity, o43.a aVar, int i3, int i16, Intent intent) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.d("VasSplashJumpManager", 1, "handleJumpAppSchemaAndH5Delay requestCode:", Integer.valueOf(i3), ",resultCode:", Integer.valueOf(i16), ",time:", Long.valueOf(currentTimeMillis));
        QLog.d("VasSplashJumpManager", 1, "result callback, setScheduleJumpSplashAd false");
        f288926b = false;
        if (i3 == 20240425 && f288927c && currentTimeMillis < j16) {
            QLog.d("VasSplashJumpManager", 1, "splash ad blocked, setSplashAdBlocked false, handleJumpAppSchemaAndH5Delay JumpH5");
            if (z16) {
                k(splashActivity, aVar, Boolean.FALSE);
            } else {
                j(splashActivity, aVar, Boolean.FALSE);
            }
        }
        f288927c = false;
        QLog.d("VasSplashJumpManager", 1, "jumpAppTimeMs duration:", Long.valueOf(currentTimeMillis));
        q(currentTimeMillis);
    }

    private static void p(final SplashActivity splashActivity, Intent intent, final o43.a aVar, final boolean z16) {
        final long currentTimeMillis = System.currentTimeMillis();
        final long splashAdCheckJumpAppDelayTimeMs = ((IGdtAPI) QRoute.api(IGdtAPI.class)).getSplashAdCheckJumpAppDelayTimeMs();
        QLog.d("VasSplashJumpManager", 1, "checkAppH5DelayDurationMs:", Long.valueOf(splashAdCheckJumpAppDelayTimeMs));
        QLog.d("VasSplashJumpManager", 1, "app exists setScheduleJumpSplashAd true");
        f288926b = true;
        splashActivity.setTopResumedActivityListener(f288928d);
        splashActivity.registerActivityLifecycleCallbacks(f288929e);
        splashActivity.startActivityForResult(intent, 20240425, new SplashActivity.e() { // from class: com.tencent.mobileqq.splashad.s
            @Override // com.tencent.mobileqq.activity.SplashActivity.e
            public final void a(int i3, int i16, Intent intent2) {
                t.o(currentTimeMillis, splashAdCheckJumpAppDelayTimeMs, z16, splashActivity, aVar, i3, i16, intent2);
            }
        });
    }

    private static void q(long j3) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("resultAfterJumpTime", String.valueOf(j3));
        if (f288925a) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("isApplicationBackground", str);
        QLog.d("VasSplashJumpManager", 1, "reportResultAfterClickTime:", Long.valueOf(j3), ",isApplicationBackground:", Boolean.valueOf(f288925a));
        ((IAdApi) QRoute.api(IAdApi.class)).report("splash_ad_jump", hashMap);
    }

    private static void r(o43.a aVar, int i3) {
        w.p(aVar.f421925b, i3, aVar.f421950o);
    }

    private static void s(o43.a aVar) {
        String str = aVar.f421923a + "_" + ((int) (System.currentTimeMillis() / 1000));
        AdDurationReportManager.c.a aVar2 = new AdDurationReportManager.c.a();
        aVar2.c("vab_qboss").d(aVar.f421925b).e(str).f(aVar.f421950o);
        AdDurationReportManager.d().g(aVar2.a());
    }

    private static void t(o43.a aVar) {
        TianShuManager.setLastClickAdTraceInfo(aVar.f421925b, aVar.f421950o);
        if (aVar.f()) {
            w.r(aVar.f421925b, com.tencent.mobileqq.vassplash.common.c.f312378f, aVar.f421950o);
        } else {
            w.o(aVar.f421925b, com.tencent.mobileqq.vassplash.common.c.f312378f, aVar.f421950o);
        }
        long i3 = SplashADUtil.i(BaseApplicationImpl.getApplication());
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("tianshu", "splash", "click", aVar.f421925b, i3 + "");
        s(aVar);
    }
}
