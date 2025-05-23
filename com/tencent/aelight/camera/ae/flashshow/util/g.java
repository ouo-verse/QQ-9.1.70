package com.tencent.aelight.camera.ae.flashshow.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f65108a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f65109b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f65110c = false;

    public static int a(int i3) {
        int i16 = i3 % 16;
        return i16 != 0 ? i16 < 8 ? i3 - i16 : i3 + (16 - i16) : i3;
    }

    public static DisplayMetrics c(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean d() {
        return BaseApplication.getContext().getSharedPreferences("CaptureUtil", 4).getBoolean("capture_shared_gesture_recognize_result", false);
    }

    public static int f(int i3) {
        if (i3 == 0) {
            return 270;
        }
        if (i3 != 90) {
            if (i3 == 180) {
                return 90;
            }
            if (i3 == 270) {
                return 180;
            }
        }
        return 0;
    }

    public static synchronized boolean g() {
        boolean z16;
        boolean z17;
        boolean z18;
        synchronized (g.class) {
            if (!f65109b) {
                boolean z19 = true;
                boolean z26 = !((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist();
                ms.a.c("CaptureUtil", "PtvFilterSoLoad.getFilterSoState result = " + z26);
                ms.a.c("CaptureUtil", "[loadEffectSo] base so load start ");
                if (z26) {
                    z17 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadAEBaseSo();
                    z18 = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isFilterFaceSoVersionOK();
                    f65108a = (z17 && z18) ? 1 : 0;
                } else {
                    f65108a = 2;
                    z17 = false;
                    z18 = false;
                }
                if (!z17 || !z18) {
                    z19 = false;
                }
                f65109b = z19;
                ms.a.c("CaptureUtil", "[loadEffectSo] base so load end ");
                if (ms.a.g()) {
                    ms.a.a("CaptureUtil", "loadEffectSo, " + f65109b + "  ptuSo:" + z17 + "  ptuSoVersion:" + z18 + " result:" + z26 + "  PTV_FILTER_SO_LOADED:" + f65108a);
                }
            }
            z16 = f65109b;
        }
        return z16;
    }

    public static void i(boolean z16, boolean z17) {
        if (!z17 && f65110c == z16) {
            if (ms.a.g()) {
                ms.a.a("CaptureUtil", "no need to update ,update recognition result : " + z16 + " force : " + z17);
                return;
            }
            return;
        }
        f65110c = z16;
        BaseApplication.getContext().getSharedPreferences("CaptureUtil", 4).edit().putBoolean("capture_shared_gesture_recognize_result", z16).apply();
        if (ms.a.g()) {
            ms.a.a("CaptureUtil", "update sp ,update recognition result : " + z16 + " force : " + z17);
        }
    }

    public static boolean j() {
        int i3;
        boolean z16 = false;
        if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isSwitchOpen()) {
            z16 = true;
            i3 = 0;
        } else {
            i3 = 2;
        }
        DeviceInfoMonitor.getModel().equals("GT-I9500");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", Integer.toString(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actMediaCodecSupport", z16, 0L, 0L, hashMap, "");
        if (ms.a.g()) {
            ms.a.f("CaptureUtil", "mediacodec isMediaCodecSupport:" + z16 + ", code:" + i3);
        }
        return z16;
    }

    public static int e(int i3) {
        return ((i3 + 45) / 90) * 90;
    }

    public static int[] b(int i3, int i16, int i17, int i18, float f16) {
        float f17 = i3;
        int a16 = a((int) (f17 * f16));
        float f18 = i16;
        int a17 = a((int) (f18 * f16));
        float f19 = (f18 * 1.0f) / f17;
        float f26 = (i18 * 1.0f) / i17;
        if (f19 > f26) {
            a17 = a((int) (a16 * f26));
        } else {
            a16 = a((int) (a17 / f26));
        }
        if (ms.a.g()) {
            ms.a.a("CaptureUtil", "clipVideoSize(" + i3 + "," + i16 + "," + i17 + "," + i18 + "," + f16 + ") = (" + a16 + "," + a17 + ")");
        }
        return new int[]{a16, a17};
    }

    public static int[] h(int i3, int i16, int i17) {
        if (i17 > i3) {
            return new int[]{a((int) (i16 * ((i3 * 1.0f) / i17))), i3};
        }
        return new int[]{i16, i17};
    }
}
