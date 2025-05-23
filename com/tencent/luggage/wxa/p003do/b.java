package com.tencent.luggage.wxa.p003do;

import android.content.Context;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.luggage.wxa.tn.a;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f124402a;

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            w.a("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.valueOf(booleanValue));
            return booleanValue;
        } catch (Throwable th5) {
            try {
                w.a("MicroMsg.Vendor.Huawei", th5, "hasCutOut call failed.", new Object[0]);
                w.a("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
                return false;
            } catch (Throwable th6) {
                w.a("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
                throw th6;
            }
        }
    }

    public static boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            if (!"tablet".equals(cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "ro.build.characteristics", ""))) {
                if (!a.a().getPackageManager().hasSystemFeature("com.huawei.software.features.pad")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        if (a() && !b()) {
            String str = Build.DEVICE;
            if (str.equals("HWTAH") || str.equals("HWTAH-C") || str.equals("unknownRLI") || str.equals("unknownTXL") || str.equals("unknownRHA") || str.equals("HWTET") || a.a().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean a() {
        if (f124402a == null) {
            String str = Build.BRAND;
            w.d("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", str);
            if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR.equalsIgnoreCase(str)) {
                f124402a = Boolean.TRUE;
            } else if ("HUAWEI".equalsIgnoreCase(str)) {
                f124402a = Boolean.TRUE;
            } else {
                f124402a = Boolean.FALSE;
            }
        }
        return f124402a.booleanValue();
    }
}
