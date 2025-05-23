package com.tencent.bugly.battery.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class Utils {
    private static int kirin = 3;
    private static int oppo = 3;

    /* renamed from: samsung, reason: collision with root package name */
    private static int f97811samsung = 3;

    public static boolean isKirin() {
        int i3;
        int i16 = kirin;
        if (i16 != 3) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        String hardware = PrivacyInformation.getInstance().getHardware();
        if (!TextUtils.isEmpty(hardware) && (hardware.toLowerCase().contains("hi") || hardware.toLowerCase().contains("kirin"))) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        kirin = i3;
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean isOppo() {
        int i3;
        int i16 = oppo;
        if (i16 != 3) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo")) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        oppo = i3;
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean isSamsung() {
        int i3;
        int i16 = f97811samsung;
        if (i16 != 3) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        f97811samsung = i3;
        if (i3 != 1) {
            return false;
        }
        return true;
    }
}
