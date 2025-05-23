package com.tencent.mobileqq.util;

import android.os.SystemProperties;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f306797a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f306798b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f306799c = "";

    /* renamed from: d, reason: collision with root package name */
    private static Object f306800d = new Object();

    private static void a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            f306798b = HardwareInfoProvider.HARMONY_OS.equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
            if (QLog.isColorLevel()) {
                QLog.i("DeviceUtils", 2, "Phone is HarmonyOS:" + f306798b);
            }
            f306799c = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "hw_sc.build.platform.version");
            if (QLog.isColorLevel()) {
                QLog.d("DeviceUtils", 2, "getHarmonyBuildOsVersion value: " + f306799c);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("DeviceUtils", 2, "check Harmony info failed!!!", th5);
            }
        }
    }

    public static String b() {
        String str;
        synchronized (f306800d) {
            if (!f306797a) {
                c();
            }
            str = f306799c;
        }
        return str;
    }

    private static void c() {
        a();
        f306797a = true;
    }

    public static boolean d() {
        boolean z16;
        synchronized (f306800d) {
            if (!f306797a) {
                c();
            }
            z16 = f306798b;
        }
        return z16;
    }
}
