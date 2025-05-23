package com.qq.e.comm.plugin.tangramsplash.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.base.ad.model.t;
import com.qq.e.comm.plugin.k.ac;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.k;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.tencent.ams.music.widget.slidecalculate.a;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f39877a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile long f39878b;

    public static void a(String str) {
        synchronized (f39877a) {
            SharedPreferencedUtil.putInt("splashPlayround" + str, SharedPreferencedUtil.getInt("splashPlayround" + str, SharedPreferencedUtil.KEY_SPLASH_PLAYROUND_DEFAULT) + 1);
        }
    }

    public static void b(String str) {
        synchronized (f39877a) {
            SharedPreferencedUtil.putInt(SharedPreferencedUtil.KEY_SPLASH_HOT_START_PLAYROUND_PREFIX + str, SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_SPLASH_HOT_START_PLAYROUND_PREFIX + str, SharedPreferencedUtil.KEY_SPLASH_HOT_PLAYROUND_DEFAULT) + 1);
        }
    }

    public static int c(String str) {
        int i3;
        synchronized (f39877a) {
            i3 = SharedPreferencedUtil.getInt("splashPlayround" + str, SharedPreferencedUtil.KEY_SPLASH_PLAYROUND_DEFAULT);
        }
        return i3;
    }

    public static int d(String str) {
        int i3;
        synchronized (f39877a) {
            i3 = SharedPreferencedUtil.getInt(SharedPreferencedUtil.KEY_SPLASH_HOT_START_PLAYROUND_PREFIX + str, SharedPreferencedUtil.KEY_SPLASH_HOT_PLAYROUND_DEFAULT);
        }
        return i3;
    }

    public static boolean e(String str) {
        return "1".equals(SharedPreferencedUtil.getString(str + File.separator + SharedPreferencedUtil.KEY_CPM_PRIORITY_EXP, "0"));
    }

    public static int c() {
        return GDTADManager.getInstance().getSM().getInteger("splash_final_notice_time", 0);
    }

    public static boolean d() {
        try {
            String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date());
            String string = SharedPreferencedUtil.getString(SharedPreferencedUtil.KEY_SPLASH_MATERIAL_CHECK_ON_THE_DAY, "");
            if (!TextUtils.isEmpty(string) && string.trim().equals(format.trim())) {
                return true;
            }
            SharedPreferencedUtil.putString(SharedPreferencedUtil.KEY_SPLASH_MATERIAL_CHECK_ON_THE_DAY, format);
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean c(r rVar) {
        InteractiveInfo bJ;
        t F;
        if (rVar == null || (bJ = rVar.bJ()) == null || (F = bJ.F()) == null) {
            return false;
        }
        return F.a();
    }

    public static boolean a(Context context) {
        return GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue() > 0 && ac.a(context);
    }

    public static synchronized void b() {
        synchronized (f.class) {
            f39878b = 0L;
        }
    }

    public static boolean a(r rVar) {
        r bx4;
        return (rVar == null || (bx4 = rVar.bx()) == null || TextUtils.isEmpty(rVar.bv()) || TextUtils.isEmpty(rVar.bw()) || TextUtils.isEmpty(bx4.s()) || TextUtils.isEmpty(bx4.bn())) ? false : true;
    }

    public static r b(r rVar) {
        if (com.qq.e.comm.plugin.j.c.a("SplashAppendJoinAdVideoUrl", 1, 1) && !TextUtils.isEmpty(rVar.x())) {
            rVar.p(rVar.x() + "&posid=" + rVar.s());
        }
        return rVar;
    }

    public static boolean a(r rVar, boolean z16) {
        if (rVar == null || !rVar.bG()) {
            return false;
        }
        boolean exists = k.a(1, rVar.s(), rVar.i()).exists();
        if (!exists) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(14039, rVar, z16);
        }
        if (TextUtils.isEmpty(rVar.bE())) {
            return exists;
        }
        boolean exists2 = k.a(2, rVar.s(), rVar.bE()).exists();
        if (!exists2) {
            com.qq.e.comm.plugin.tangramsplash.report.c.a(14049, rVar, z16);
        }
        return exists && exists2;
    }

    private static boolean b(Point point, Point point2, r rVar, HashMap<String, Integer> hashMap) {
        if (point != null && point2 != null && rVar != null) {
            InteractiveInfo bJ = rVar.bJ();
            if (bJ == null) {
                GDTLogger.e("judgeSlideResultByNewRule interactiveInfo == null");
                return false;
            }
            t F = bJ.F();
            if (F == null) {
                GDTLogger.e("judgeSlideResultByNewRule slideAngleInfo == null");
                return false;
            }
            int b16 = F.b();
            int c16 = F.c();
            int d16 = F.d();
            int e16 = F.e();
            a(hashMap, b16, c16, d16, e16);
            boolean b17 = com.tencent.ams.music.widget.slidecalculate.b.b(point, point2, new a.b().h(b16).i(c16).j(Integer.valueOf(d16)).k(Integer.valueOf(e16)).l(F.f()).m(ak.a(GDTADManager.getInstance().getAppContext(), rVar.bU() / 2)).g());
            GDTLogger.i("SlideAdComponent checkSlideValid : " + b17);
            return b17;
        }
        GDTLogger.e("judgeSlideResultByNewRule startXY == null || endXY == null || splashAdInfo == null");
        return false;
    }

    public static boolean d(r rVar) {
        return rVar != null && "SlideCombinedInteractive".equals(rVar.bP()) && com.qq.e.comm.plugin.tangramsplash.interactive.a.a(rVar.bQ(), "ScrollInteractive");
    }

    public static boolean a() {
        if (!com.qq.e.comm.plugin.j.c.a("SplashAvoidMultiClick", 1, 1)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f39878b != 0 && currentTimeMillis - f39878b < 5000) {
            f39878b = currentTimeMillis;
            return true;
        }
        f39878b = currentTimeMillis;
        return false;
    }

    public static boolean a(View view, Activity activity) {
        return (view == null || activity == null || view.getContext() == null || !(view.getContext() instanceof Activity) || ((Activity) view.getContext()) != activity) ? false : true;
    }

    public static void a(com.qq.e.comm.plugin.base.ad.c cVar, int i3, int i16) {
        com.qq.e.comm.plugin.base.ad.model.c a16;
        if (cVar == null || (a16 = cVar.a()) == null) {
            return;
        }
        float f16 = i3;
        a16.a((a16.e() * 320.0f) / f16);
        float f17 = i16;
        a16.b((a16.f() * 480.0f) / f17);
        a16.c((a16.g() * 320.0f) / f16);
        a16.d((a16.h() * 480.0f) / f17);
    }

    public static boolean b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key is null or empty, return switch off");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", displayMode is null or empty, return switch off");
            return false;
        }
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, str2, str3);
        if (TextUtils.isEmpty(a16)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", enableInteractList is empty, return switch off");
            return false;
        }
        if ("AllInteractive".equals(a16)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", enable all interactive, return switch on");
            return true;
        }
        String[] split = a16.split(",");
        if (com.qq.e.comm.plugin.k.g.a(split)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", enableTypeList is empty, return switch off");
            return false;
        }
        for (String str4 : split) {
            if (!TextUtils.isEmpty(str4) && str.equals(str4)) {
                GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", " + str + " in enableTypeList, return switch on");
                return true;
            }
        }
        GDTLogger.i("isDisplayCodeSwitchOnWithEnableKey, key = " + str2 + ", " + str + " isn't in enableTypeList, return switch off");
        return false;
    }

    public static void a(long j3) {
        Vibrator vibrator;
        if (GDTADManager.getInstance().getAppContext().checkCallingOrSelfPermission("android.permission.VIBRATE") != 0 || (vibrator = (Vibrator) GDTADManager.getInstance().getAppContext().getSystemService("vibrator")) == null) {
            return;
        }
        vibrator.vibrate(j3);
    }

    public static boolean a(View view) {
        return view != null && view.getVisibility() == 0 && view.isShown() && view.getWindowVisibility() == 0;
    }

    public static boolean a(Point point, Point point2, r rVar, HashMap<String, Integer> hashMap) {
        if (c(rVar)) {
            GDTLogger.d("slide check hit new rule");
            return b(point, point2, rVar, hashMap);
        }
        return a(point, point2, rVar);
    }

    private static boolean a(Point point, Point point2, r rVar) {
        if (point == null || point2 == null || rVar == null) {
            return false;
        }
        int i3 = point2.y;
        int i16 = point.y;
        return i3 - i16 <= 0 && Math.abs(i3 - i16) >= ak.a(GDTADManager.getInstance().getAppContext(), rVar.bU() / 2);
    }

    private static void a(HashMap<String, Integer> hashMap, int i3, int i16, int i17, int i18) {
        if (hashMap == null) {
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            try {
                hashMap.put("degreeA", Integer.valueOf(i3));
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        if (i16 != Integer.MIN_VALUE) {
            hashMap.put("degreeB", Integer.valueOf(i16));
        }
        if (i17 != Integer.MIN_VALUE) {
            hashMap.put("degreeC", Integer.valueOf(i17));
        }
        if (i18 != Integer.MIN_VALUE) {
            hashMap.put("degreeD", Integer.valueOf(i18));
        }
    }

    public static boolean a(MotionEvent motionEvent, Rect rect) {
        return motionEvent == null || rect == null || motionEvent.getRawX() < ((float) rect.left) || motionEvent.getRawX() > ((float) rect.right) || motionEvent.getRawY() < ((float) rect.top) || motionEvent.getRawY() > ((float) rect.bottom);
    }

    public static boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key is null or empty, return switch on");
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", displayMode is null or empty, return switch on");
            return true;
        }
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, str2, str3);
        if (TextUtils.isEmpty(a16)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", disableInteractList is empty, return switch on");
            return true;
        }
        if ("AllInteractive".equals(a16)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", disable all interactive, return switch off");
            return false;
        }
        String[] split = a16.split(",");
        if (com.qq.e.comm.plugin.k.g.a(split)) {
            GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", disableTypeList is empty, return switch on");
            return true;
        }
        for (String str4 : split) {
            if (!TextUtils.isEmpty(str4) && str.equals(str4)) {
                GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", " + str + " in disableTypeList, return switch off");
                return false;
            }
        }
        GDTLogger.i("isDisplayCodeSwitchOnWithDisableKey, key = " + str2 + ", " + str + " isn't in disableTypeList, return switch on");
        return true;
    }
}
