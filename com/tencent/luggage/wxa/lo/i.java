package com.tencent.luggage.wxa.lo;

import android.app.UiModeManager;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.lo.i;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxa.t9.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static String f133722a = "";

    /* renamed from: b, reason: collision with root package name */
    public static final Method[] f133723b = {null, null};

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f133724c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f133725d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f133726e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f133727f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f133728g;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f133729h;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f133730i;

    /* renamed from: j, reason: collision with root package name */
    public static Boolean f133731j;

    /* renamed from: k, reason: collision with root package name */
    public static Boolean f133732k;

    /* renamed from: l, reason: collision with root package name */
    public static Boolean f133733l;

    public static final void a(String str) {
        f133722a = str;
    }

    public static int b() {
        int i3;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) z.c().getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        Display.Mode[] supportedModes = defaultDisplay.getSupportedModes();
        if (supportedModes != null && supportedModes.length > 0) {
            i3 = Math.min(supportedModes[0].getPhysicalWidth(), supportedModes[0].getPhysicalHeight());
            w.d("MicroMsg.UIUtils", "getDeviceWidthOne:%s", Integer.valueOf(i3));
            if (supportedModes.length > 1) {
                int min = Math.min(supportedModes[1].getPhysicalWidth(), supportedModes[1].getPhysicalHeight());
                if (min > 0 && i3 > 1440 && min < i3) {
                    i3 = min;
                }
                w.d("MicroMsg.UIUtils", "getDeviceWidthTwo:%s", Integer.valueOf(min));
            }
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            com.tencent.luggage.wxa.xm.b.INSTANCE.a(1055L, 2L, 1L, false);
        }
        w.d("MicroMsg.UIUtils", "getDeviceWidth:%s", Integer.valueOf(i3));
        return i3;
    }

    public static int c() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) z.c().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static DisplayMetrics d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) z.c().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!w0.c(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) || lowerCase.contains("honor")) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 == 26 || i3 == 27) {
                    w.d("MicroMsg.UIUtils", "dancy huaweiSpecial!!");
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean f() {
        return a(com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: g31.b
            @Override // com.tencent.luggage.wxa.so.c.a
            public final Object a() {
                Integer valueOf;
                valueOf = Integer.valueOf(i.a(i.a(), i.c(), i.b()));
                return valueOf;
            }
        }));
    }

    public static boolean g() {
        UiModeManager uiModeManager = (UiModeManager) ContextCompat.getSystemService(z.c(), UiModeManager.class);
        if (uiModeManager != null && uiModeManager.getNightMode() == 2) {
            return true;
        }
        Resources j3 = z.j();
        if (j3 != null && (j3.getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        if (!k() && !l() && !p() && !q() && !n() && !j() && !s() && !r()) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        if (f133733l == null) {
            try {
                Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
                boolean z16 = false;
                if ("tablet".equals(cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "ro.build.characteristics", "")) || z.c().getPackageManager().hasSystemFeature("com.huawei.software.features.pad")) {
                    z16 = true;
                }
                f133733l = Boolean.valueOf(z16);
            } catch (Exception unused) {
                f133733l = Boolean.FALSE;
            }
        }
        return f133733l.booleanValue();
    }

    public static boolean j() {
        if (f133726e == null) {
            if (com.tencent.luggage.wxa.p003do.a.f124400a.a()) {
                if ("HNMGI".equalsIgnoreCase(Build.DEVICE)) {
                    String model = DeviceInfoMonitor.getModel();
                    if ("DIA-AN00".equalsIgnoreCase(model) || "MGI-AN00".equalsIgnoreCase(model)) {
                        f133726e = Boolean.TRUE;
                    }
                }
                if (z.c().getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture")) {
                    f133726e = Boolean.TRUE;
                } else {
                    f133726e = Boolean.FALSE;
                }
            } else {
                f133726e = Boolean.FALSE;
            }
        }
        return f133726e.booleanValue();
    }

    public static boolean k() {
        if (f133725d == null) {
            if (com.tencent.luggage.wxa.p003do.b.a() && !i()) {
                String str = Build.DEVICE;
                if (!str.equals("HWBAL") && !str.equals("unknownQTZ") && !str.equals("HWBAL-QL")) {
                    if (!str.equals("HWTAH") && !str.equals("HWTAH-C") && !str.equals("unknownRLI") && !str.equals("unknownTXL") && !str.equals("unknownRHA") && !str.equals("HWTET")) {
                        if (z.c().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                            f133725d = Boolean.TRUE;
                        } else {
                            f133725d = Boolean.FALSE;
                        }
                    } else {
                        f133725d = Boolean.TRUE;
                    }
                } else {
                    f133725d = Boolean.FALSE;
                }
            } else {
                f133725d = Boolean.FALSE;
            }
        }
        return f133725d.booleanValue();
    }

    public static boolean l() {
        boolean z16;
        if (f133727f == null) {
            if (com.tencent.luggage.wxa.p003do.d.c()) {
                try {
                    if (y.a("persist.sys.muiltdisplay_type", 0) == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f133727f = Boolean.valueOf(z16);
                } catch (Exception e16) {
                    w.a("MicroMsg.UIUtils", e16, "get muiltdisplay_type failed", new Object[0]);
                    f133727f = Boolean.FALSE;
                }
            } else {
                f133727f = Boolean.FALSE;
            }
        }
        return f133727f.booleanValue();
    }

    public static boolean m() {
        if (com.tencent.luggage.wxa.p003do.d.c()) {
            String str = Build.DEVICE;
            if (str.equals("enuma") || str.equals("elish") || str.equals("nabu")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean n() {
        if (f133730i == null) {
            if (!com.tencent.luggage.wxa.aa.i.d() && !com.tencent.luggage.wxa.aa.i.c() && !com.tencent.luggage.wxa.aa.i.e()) {
                f133730i = Boolean.FALSE;
            } else {
                PackageManager packageManager = z.c().getPackageManager();
                if (!packageManager.hasSystemFeature("oplus.feature.largescreen.land") && !packageManager.hasSystemFeature("oplus.feature.largescreen.port")) {
                    f133730i = Boolean.FALSE;
                } else {
                    f133730i = Boolean.TRUE;
                }
            }
        }
        return f133730i.booleanValue();
    }

    public static boolean o() {
        return z.c().getPackageManager().hasSystemFeature("oplus.hardware.type.tablet");
    }

    public static boolean p() {
        if (f133728g == null) {
            String str = Build.BRAND;
            if (!w0.c(str) && str.toLowerCase().contains("royole")) {
                String str2 = f133722a;
                if (!w0.a(str2, "Royole FlexPai 2") && !w0.a(str2, "ROYOLE Flexi")) {
                    f133728g = Boolean.FALSE;
                } else {
                    w.d("MicroMsg.UIUtils", "isRoyoleFoldableDevice!!!");
                    f133728g = Boolean.TRUE;
                }
            } else {
                f133728g = Boolean.FALSE;
            }
        }
        return f133728g.booleanValue();
    }

    public static boolean q() {
        if (f133729h == null) {
            if (com.tencent.luggage.wxa.aa.i.f()) {
                String str = f133722a;
                if (!str.contains("SM-F9") && !str.contains("SM-W202") && !str.contains("SM-W90")) {
                    f133729h = Boolean.FALSE;
                } else {
                    w.d("MicroMsg.UIUtils", "isSamsungFoldableDevice!!!");
                    f133729h = Boolean.TRUE;
                }
            } else {
                f133729h = Boolean.FALSE;
            }
        }
        return f133729h.booleanValue();
    }

    public static boolean r() {
        if (f133732k == null) {
            if (com.tencent.luggage.wxa.aa.i.g()) {
                try {
                    if (y.a("ro.os_foldable_screen_support", 0) == 1) {
                        f133732k = new Boolean(true);
                    } else {
                        f133732k = new Boolean(false);
                    }
                } catch (Exception e16) {
                    w.a("MicroMsg.UIUtils", e16, "get displayMode failed", new Object[0]);
                    f133732k = new Boolean(false);
                }
            } else {
                f133732k = new Boolean(false);
            }
        }
        if (f133732k == null) {
            f133732k = new Boolean(false);
        }
        return f133732k.booleanValue();
    }

    public static boolean s() {
        if (f133731j == null) {
            if (com.tencent.luggage.wxa.aa.i.h()) {
                if (w0.a(y.a("ro.vivo.device.type"), "foldable")) {
                    f133731j = Boolean.TRUE;
                } else {
                    f133731j = Boolean.FALSE;
                }
            } else {
                f133731j = Boolean.FALSE;
            }
        }
        return f133731j.booleanValue();
    }

    public static boolean t() {
        if (w0.a(y.a("ro.vivo.device.type"), "tablet")) {
            return true;
        }
        return false;
    }

    public static int a() {
        try {
            Method[] methodArr = f133723b;
            Method method = methodArr[0];
            if (method == null) {
                synchronized (methodArr) {
                    method = methodArr[0];
                    if (method == null) {
                        method = Class.forName("android.view.WindowManagerGlobal").getDeclaredMethod("getWindowManagerService", new Class[0]);
                        method.setAccessible(true);
                        methodArr[0] = method;
                    }
                }
            }
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = methodArr[1];
            if (method2 == null) {
                synchronized (methodArr) {
                    method2 = methodArr[1];
                    if (method2 == null) {
                        method2 = invoke.getClass().getDeclaredMethod("getInitialDisplayDensity", Integer.TYPE);
                        method2.setAccessible(true);
                        methodArr[1] = method2;
                    }
                }
            }
            return w0.a((Integer) method2.invoke(invoke, 0), 0);
        } catch (Exception e16) {
            w.b("MicroMsg.UIUtils", "Exception:%s", e16);
            return 0;
        }
    }

    public static int a(int i3, int i16, int i17) {
        w.d("MicroMsg.UIUtils", "getWidthDp, getDeviceDpi:%d, getWindowDpi:%d, getDeviceWidth:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        if (i3 != 0) {
            if (h()) {
                DisplayMetrics d16 = d();
                if (d16 != null) {
                    return Math.round(Math.min(d16.heightPixels, d16.widthPixels) / d16.density);
                }
            } else {
                if (i3 != i16 && !e()) {
                    return Math.round(i17 / (i3 / 160.0f));
                }
                DisplayMetrics d17 = d();
                if (d17 != null) {
                    return Math.round(Math.min(d17.heightPixels, d17.widthPixels) / d17.density);
                }
            }
        }
        return 0;
    }

    public static boolean a(com.tencent.luggage.wxa.so.c cVar) {
        Boolean bool = f133724c;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (h()) {
            f133724c = Boolean.FALSE;
            return false;
        }
        if (com.tencent.luggage.wxa.p003do.b.a() && i()) {
            f133724c = Boolean.TRUE;
            return true;
        }
        if (com.tencent.luggage.wxa.p003do.d.c() && m()) {
            f133724c = Boolean.TRUE;
            return true;
        }
        if (com.tencent.luggage.wxa.aa.i.h() && t()) {
            f133724c = Boolean.TRUE;
            return true;
        }
        if ((com.tencent.luggage.wxa.aa.i.d() || com.tencent.luggage.wxa.aa.i.c()) && o()) {
            f133724c = Boolean.TRUE;
            return true;
        }
        if (e.a()) {
            f133724c = Boolean.TRUE;
            return true;
        }
        if (!c.b() && !c.a()) {
            if (((Integer) cVar.b()).intValue() >= 600) {
                f133724c = Boolean.TRUE;
                return true;
            }
            f133724c = Boolean.FALSE;
            return false;
        }
        f133724c = Boolean.TRUE;
        return true;
    }
}
