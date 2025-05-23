package com.tencent.mobileqq.ark;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aio.data.AIOContact;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.api.IArkAppConfig;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f199481a = BaseChatItemLayout.M;

    /* renamed from: b, reason: collision with root package name */
    public static int f199482b = BaseChatItemLayout.N;

    /* renamed from: c, reason: collision with root package name */
    public static int f199483c;

    /* renamed from: d, reason: collision with root package name */
    public static int f199484d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f199485e;

    /* renamed from: f, reason: collision with root package name */
    public static int f199486f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f199487g;

    /* renamed from: h, reason: collision with root package name */
    private static int f199488h;

    /* renamed from: i, reason: collision with root package name */
    public static DisplayMetrics f199489i;

    static {
        int i3 = BaseChatItemLayout.L;
        f199483c = i3;
        f199484d = i3;
        f199485e = false;
        f199486f = 840;
        f199487g = false;
        f199488h = 0;
        f199489i = null;
        a(1);
    }

    private static void a(int i3) {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        f199484d = min;
        if (f199489i == null) {
            f199489i = displayMetrics;
        }
        QLog.e("ArkApp.ArkAppCenterUtil", 1, "ArkFold.checkArkSize model=", DeviceInfoMonitor.getModel(), ",screenWidth=", Integer.valueOf(min), ",sDisplayWith=", Integer.valueOf(f199483c), ",scene=", Integer.valueOf(i3));
        if (min >= 1536 && f199483c != d()) {
            f199485e = true;
            int d16 = d();
            f199483c = d16;
            int c16 = (int) (d16 - (c() * 108.0f));
            f199481a = c16;
            f199482b = (c16 - BaseChatItemLayout.d()) - BaseChatItemLayout.c();
            QLog.e("ArkApp.ArkAppCenterUtil", 1, "ArkFold.checkArkSize handle fold screen sChatBubbleMaxWidth=", Integer.valueOf(f199481a), ",sDisplayWith=", Integer.valueOf(f199483c), ",sChatTextViewMaxWidth=", Integer.valueOf(f199482b));
        }
    }

    public static String b() {
        return ((IArkAppConfig) QRoute.api(IArkAppConfig.class)).getCurrentAppConfig();
    }

    public static float c() {
        return BaseChatItemLayout.f178053k0;
    }

    private static int d() {
        boolean z16;
        if (f199487g) {
            return f199486f;
        }
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) && upperCase.contains("PAL-AL00")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f199486f = 1176;
        } else {
            f199486f = 840;
        }
        f199487g = true;
        return f199486f;
    }

    public static boolean e() {
        AIOContact a16;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(baseActivity)) != null && a16.e() == 103) {
            return true;
        }
        return false;
    }

    public static void f() {
        ((IArkHelper) QRoute.api(IArkHelper.class)).onThemeChange();
    }

    public static void g(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "ArkApp.ArkAppCenterUtil";
        }
        try {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            StringBuilder sb5 = new StringBuilder("print density info:");
            sb5.append("\n model=");
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append(", ver=");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append(",SDK=");
            sb5.append(Build.VERSION.SDK_INT);
            sb5.append("\n BaseChatItemLayout.density=");
            sb5.append(BaseChatItemLayout.f178053k0);
            sb5.append("\n application density=");
            sb5.append(displayMetrics.density);
            sb5.append("-");
            sb5.append(displayMetrics.scaledDensity);
            if (context != null) {
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                sb5.append("\n activity density=");
                sb5.append(displayMetrics2.density);
                sb5.append("-");
                sb5.append(displayMetrics2.scaledDensity);
            }
            if (QLog.isColorLevel()) {
                QLog.i(str, 2, sb5.toString());
            }
        } catch (Exception e16) {
            QLog.e("ArkApp.ArkAppCenterUtil", 1, "printScaleInfo Exception:", e16);
        }
    }
}
