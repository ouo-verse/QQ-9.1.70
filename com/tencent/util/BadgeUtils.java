package com.tencent.util;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BadgeUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f383927a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f383928b;

    /* renamed from: c, reason: collision with root package name */
    public static int f383929c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f383930d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f383931e;

    /* renamed from: f, reason: collision with root package name */
    private static MMKVOptionEntityV2 f383932f;

    /* renamed from: g, reason: collision with root package name */
    private static ry2.a f383933g;

    /* renamed from: h, reason: collision with root package name */
    private static Runnable f383934h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32795);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383927a = new Handler(Looper.getMainLooper());
        f383928b = true;
        f383929c = -1;
        f383930d = false;
        f383931e = false;
        f383934h = new Runnable() { // from class: com.tencent.util.BadgeUtils.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
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
                    if (!BadgeUtilImpl.isEnabled(MobileQQ.sMobileQQ)) {
                        BadgeUtilImpl.disableBadge(MobileQQ.sMobileQQ);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BadgeUtils", 2, "disableBadge mobileqq", e16);
                    }
                }
            }
        };
    }

    static /* synthetic */ MMKVOptionEntityV2 c() {
        return g();
    }

    public static void d() {
        f383927a.removeCallbacksAndMessages(null);
    }

    public static ry2.a e() {
        if (f383933g == null) {
            String string = g().getString("last_badge_unread_composed", "", true);
            if (!TextUtils.isEmpty(string)) {
                try {
                    f383933g = (ry2.a) new Gson().fromJson(string, ry2.a.class);
                } catch (Exception e16) {
                    QLog.d("BadgeUtils", 1, "exception:" + e16);
                    f383933g = new ry2.a(0);
                }
            } else {
                f383933g = new ry2.a(0);
            }
        }
        return f383933g;
    }

    public static int f() {
        String str;
        if (b.a() && !l()) {
            return 99;
        }
        int i3 = f383929c;
        if (i3 == -1) {
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), IDPCApiConstant.AIO_MSG_LIMIT_COUNT);
                if (QLog.isColorLevel()) {
                    QLog.d("BadgeUtils", 2, "LimitConfig:" + featureValue);
                }
                String[] split = featureValue.split("\\|");
                if (split.length > 3) {
                    str = split[3];
                } else {
                    str = "";
                }
                i3 = Integer.valueOf(str).intValue();
                f383929c = i3;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("BadgeUtils", 2, "getLimitCount e:" + e16.toString());
                }
                i3 = 999;
                f383929c = 999;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("BadgeUtils", 2, "getLimitCount Limitcount" + i3);
        }
        return i3;
    }

    private static MMKVOptionEntityV2 g() {
        if (f383932f == null) {
            f383932f = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
        return f383932f;
    }

    public static boolean h(int i3, AppRuntime appRuntime) {
        boolean z16;
        if (i3 != 265 && (i3 < 512 || i3 > 522)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        if ((!i() && !k()) || !j(appRuntime.getApplicationContext())) {
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("miui_ignore_cancel_notification");
    }

    public static boolean i() {
        if (!f383931e && !f383930d) {
            f383931e = CommonBadgeUtilImpl.isMIUI6();
            f383930d = true;
        }
        return f383931e;
    }

    public static boolean j(Context context) {
        return BadgeUtilImpl.isSupportBadge(context);
    }

    public static boolean k() {
        return "VIVO".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean l() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static void m(Context context, int i3) {
        n(context, new ry2.a(i3));
    }

    public static void n(Context context, ry2.a aVar) {
        int totalCount;
        if (aVar == null) {
            totalCount = 0;
        } else {
            totalCount = aVar.getTotalCount();
        }
        if (!f383928b && totalCount > 0) {
            q(new ry2.a(0));
            return;
        }
        if (!j(context)) {
            q(new ry2.a(0));
            return;
        }
        int f16 = f();
        QLog.d("BadgeUtils_UnreadMonitor", 1, "setBadge limit: " + f16 + ", count: " + totalCount);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            BadgeUtilImpl.setLimitCount(f16);
            try {
                BadgeUtilImpl.setBadge(context, totalCount);
                q(aVar);
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(BadgeUtilImpl.TAG, 2, "badge not support");
                    return;
                }
                return;
            }
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(f16, context, totalCount, aVar) { // from class: com.tencent.util.BadgeUtils.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f383935d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f383936e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f383937f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ ry2.a f383938h;

            {
                this.f383935d = f16;
                this.f383936e = context;
                this.f383937f = totalCount;
                this.f383938h = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(f16), context, Integer.valueOf(totalCount), aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                BadgeUtilImpl.setLimitCount(this.f383935d);
                try {
                    BadgeUtilImpl.setBadge(this.f383936e, this.f383937f);
                    BadgeUtils.q(this.f383938h);
                } catch (Exception unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.e(BadgeUtilImpl.TAG, 2, "badge not support");
                    }
                }
            }
        });
    }

    public static void o(boolean z16) {
        CommonBadgeUtilImpl.setIsSupportMiui12(z16);
    }

    public static void p(Context context, int i3, Notification notification) {
        if (!f383931e) {
            if (!f383930d) {
                boolean isMIUI6 = CommonBadgeUtilImpl.isMIUI6();
                f383931e = isMIUI6;
                f383930d = true;
                if (!isMIUI6) {
                    return;
                }
            } else {
                return;
            }
        }
        QLog.d("BadgeUtils_UnreadMonitor", 1, "setMIUI6Badge count: " + i3);
        BadgeUtilImpl.setLimitCount(f());
        BadgeUtilImpl.setMIUI6Badge(context, i3, notification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(ry2.a aVar) {
        f383933g = aVar;
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.util.BadgeUtils.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String json;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MMKVOptionEntityV2 c16 = BadgeUtils.c();
                if (BadgeUtils.f383933g == null) {
                    json = "";
                } else {
                    json = new Gson().toJson(BadgeUtils.f383933g);
                }
                c16.putString("last_badge_unread_composed", json, true);
            }
        });
    }
}
