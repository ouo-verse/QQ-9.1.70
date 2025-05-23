package com.tencent.mobileqq.qqlive.utils;

import android.content.Context;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q {
    static IPatchRedirector $redirector_;

    public static int a(Context context, float f16) {
        return (int) ((f16 * b(context)) + 0.5f);
    }

    private static float b(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int c(float f16) {
        if (GlobalDisplayMetricsManager.sOriginDisplayMetrics == null) {
            return a(BaseApplication.getContext(), f16);
        }
        float f17 = GlobalDisplayMetricsManager.sOriginDisplayMetrics.density;
        if (0.0f == f17) {
            return a(BaseApplication.getContext(), f16);
        }
        return (int) ((f16 * f17) + 0.5f);
    }
}
