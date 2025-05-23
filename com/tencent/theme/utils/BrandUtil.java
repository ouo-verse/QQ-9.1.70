package com.tencent.theme.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class BrandUtil {
    static IPatchRedirector $redirector_;

    BrandUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isEmui() {
        if (TextUtils.isEmpty(PropertyUtils.getQuickly("ro.build.version.emui", null))) {
            String str = Build.BRAND;
            if (!str.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI) && !str.toLowerCase().contains("honor")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFlyme() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isGionee() {
        try {
            return Build.BRAND.toLowerCase().contains("gionee");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMiui() {
        String quickly = PropertyUtils.getQuickly("ro.miui.ui.version.name", null);
        if (!TextUtils.isEmpty(quickly) && quickly.contains("V")) {
            return true;
        }
        return false;
    }

    public static boolean isNubia() {
        try {
            return Build.BRAND.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_NUBIA);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isOppo() {
        try {
            return Build.BRAND.toLowerCase(Locale.US).contains("oppo");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isVivo() {
        try {
            return Build.BRAND.toLowerCase().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
        } catch (Exception unused) {
            return false;
        }
    }
}
