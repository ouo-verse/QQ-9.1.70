package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes28.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static int f388118a = -1;

    public static q a(Context context) {
        if (c(context)) {
            return q.HUAWEI;
        }
        if (e(context)) {
            return q.OPPO;
        }
        if (f(context)) {
            return q.VIVO;
        }
        return q.OTHER;
    }

    private static boolean b() {
        try {
            String str = (String) com.xiaomi.push.y.g(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME, "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
        return false;
    }

    public static boolean c(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (b()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean d(Context context) {
        boolean z16;
        int i3;
        Object e16 = com.xiaomi.push.y.e(com.xiaomi.push.y.g("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object f16 = com.xiaomi.push.y.f("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (f16 != null && (f16 instanceof Integer)) {
            int intValue = ((Integer) Integer.class.cast(f16)).intValue();
            if (e16 != null) {
                if (e16 instanceof Integer) {
                    if (((Integer) Integer.class.cast(e16)).intValue() == intValue) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    f388118a = i3;
                } else {
                    f388118a = 0;
                    jz4.c.z("google service is not avaliable");
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("is google service can be used");
            if (f388118a > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            jz4.c.z(sb5.toString());
            if (f388118a <= 0) {
                return false;
            }
            return true;
        }
        jz4.c.z("google service is not avaliable");
        f388118a = 0;
        return false;
    }

    public static boolean e(Context context) {
        boolean z16 = false;
        Object g16 = com.xiaomi.push.y.g("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (g16 != null && (g16 instanceof Boolean)) {
            z16 = ((Boolean) Boolean.class.cast(g16)).booleanValue();
        }
        jz4.c.z("color os push  is avaliable ? :" + z16);
        return z16;
    }

    public static boolean f(Context context) {
        boolean z16 = false;
        Object g16 = com.xiaomi.push.y.g("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (g16 != null && (g16 instanceof Boolean)) {
            z16 = ((Boolean) Boolean.class.cast(g16)).booleanValue();
        }
        jz4.c.z("fun touch os push  is avaliable ? :" + z16);
        return z16;
    }
}
