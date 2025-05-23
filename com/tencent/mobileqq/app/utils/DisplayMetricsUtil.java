package com.tencent.mobileqq.app.utils;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DisplayMetricsUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String CHECK_TOGGLE_NAME = "android_density_check";
    private static final String TAG = "DisplayMetricsUtil";

    public DisplayMetricsUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkAndCorrectDensity(DisplayMetrics displayMetrics) {
        DisplayMetrics displayMetrics2 = FontSettingManager.customMetrics;
        if (displayMetrics != null) {
            float f16 = displayMetrics2.density;
            if (f16 > 0.0f && displayMetrics.density != f16) {
                displayMetrics.density = f16;
                displayMetrics.densityDpi = displayMetrics2.densityDpi;
                displayMetrics.scaledDensity = displayMetrics2.scaledDensity;
            }
        }
    }
}
