package com.tencent.util;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class VersionUtils {
    static IPatchRedirector $redirector_;

    VersionUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isECLAIR_MR1() {
        return true;
    }

    public static boolean isGingerBread() {
        return true;
    }

    public static boolean isHoneycomb() {
        return true;
    }

    public static boolean isHoneycombMR2() {
        return true;
    }

    public static boolean isIceScreamSandwich() {
        return true;
    }

    public static boolean isJellyBean() {
        return true;
    }

    public static boolean isJellyBeanM1() {
        return true;
    }

    public static boolean isJellyBeanMA2() {
        return true;
    }

    public static boolean isKITKAT() {
        return true;
    }

    public static boolean isLOLLIPOP() {
        return true;
    }

    public static boolean isM() {
        return true;
    }

    public static boolean isNougat() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isOreo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean isrFroyo() {
        return true;
    }
}
