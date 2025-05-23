package com.tencent.mobileqq.qqgamepub.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static final int a(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static final float b(int i3, Resources resources) {
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 / resources.getDisplayMetrics().density;
    }
}
