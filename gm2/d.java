package gm2;

import android.app.Activity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f402413a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f402414b;

    /* renamed from: c, reason: collision with root package name */
    public static int f402415c;

    /* renamed from: d, reason: collision with root package name */
    public static int f402416d;

    /* renamed from: e, reason: collision with root package name */
    public static long f402417e;

    private static String a() {
        if (f402416d == 1) {
            return "1";
        }
        return "0";
    }

    private static String b() {
        if (f402415c % 180 == 0) {
            return "0";
        }
        return "1";
    }

    public static void c(Activity activity, int i3, int i16) {
        if (i3 != 1012) {
            if (i3 == 10000 || i3 == 10007 || i3 == 10003 || i3 == 10004) {
                if (i16 == -1) {
                    if (!f402413a) {
                        com.tencent.mobileqq.activity.richmedia.d.d("", "0X8006A16", String.valueOf(f402417e), b(), a(), "");
                        return;
                    } else {
                        com.tencent.mobileqq.activity.richmedia.d.d("", "0X8006A19", String.valueOf(f402417e), b(), a(), f402414b);
                        return;
                    }
                }
                if (i16 == 0) {
                    if (f402413a) {
                        com.tencent.mobileqq.activity.richmedia.d.b("", "0X8006A1B");
                        return;
                    } else {
                        com.tencent.mobileqq.activity.richmedia.d.b("", "0X8006A17");
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i16 == -1) {
            if (f402413a) {
                com.tencent.mobileqq.activity.richmedia.d.d("", "0X80072C5", a(), f402414b, "", "");
                return;
            } else {
                com.tencent.mobileqq.activity.richmedia.d.c("", "0X80072C4", a());
                return;
            }
        }
        if (i16 == 0) {
            if (f402413a) {
                com.tencent.mobileqq.activity.richmedia.d.b("", "0X80072C6");
            } else {
                com.tencent.mobileqq.activity.richmedia.d.b("", "0X80072C7");
            }
        }
    }

    public static void d() {
        if (f402413a) {
            com.tencent.mobileqq.activity.richmedia.d.d("", "0X80072C3", a(), f402414b, "", "");
        } else {
            com.tencent.mobileqq.activity.richmedia.d.c("", "0X80072C2", a());
        }
    }

    public static void e() {
        if (f402413a) {
            com.tencent.mobileqq.activity.richmedia.d.d("", "0X8006A18", String.valueOf(f402417e), b(), a(), f402414b);
        } else {
            com.tencent.mobileqq.activity.richmedia.d.d("", "0X8006A13", String.valueOf(f402417e), b(), a(), "");
        }
    }

    public static void f(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.mobileqq.activity.richmedia.d.c("", "0X8007BB7", str);
    }

    public static void g(int i3, String str) {
        float f16;
        try {
            long c16 = im2.a.c(str);
            if (c16 == 0) {
                f16 = -1.0f;
            } else {
                f16 = (i3 * 1000.0f) / ((float) c16);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "capture_video_fps", false, f16, 0L, null, "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
