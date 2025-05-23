package com.tencent.mobileqq.videoplatform.util;

import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UIUtil {
    static IPatchRedirector $redirector_;

    public UIUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static String stringForTime(long j3) {
        int i3 = ((int) j3) / 1000;
        int i16 = i3 % 60;
        int i17 = (i3 / 60) % 60;
        int i18 = i3 / 3600;
        if (i18 > 0) {
            return String.format("%d:%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i17), Integer.valueOf(i16));
        }
        return String.format("%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i16));
    }
}
