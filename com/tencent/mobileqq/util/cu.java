package com.tencent.mobileqq.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cu {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f306742a;

    /* renamed from: b, reason: collision with root package name */
    static boolean f306743b;

    /* renamed from: c, reason: collision with root package name */
    static boolean f306744c;

    public static void a() {
        boolean z16 = true;
        f306743b = true;
        if (TextUtils.isEmpty(d("ro.miui.ui.version.code")) && TextUtils.isEmpty(d("ro.miui.ui.version.name")) && TextUtils.isEmpty(d("ro.miui.internal.storage"))) {
            z16 = false;
        }
        f306744c = z16;
    }

    public static long b() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long c() {
        try {
            StatFs statFs = new StatFs(IQzoneHardwareRestriction.APP_ROOT);
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String d(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, null);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean e() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean f() {
        boolean z16;
        Boolean bool = f306742a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            if (Build.class.getMethod("hasSmartBar", new Class[0]) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            f306742a = Boolean.valueOf(z16);
            return z16;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g() {
        if (f306743b) {
            return f306744c;
        }
        a();
        return f306744c;
    }

    public static boolean h() {
        if (TextUtils.isEmpty(d("ro.meizu.product.model"))) {
            String str = Build.BRAND;
            if (!"meizu".equalsIgnoreCase(str) && !"22c4185e".equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}
