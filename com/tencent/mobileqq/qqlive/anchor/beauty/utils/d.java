package com.tencent.mobileqq.qqlive.anchor.beauty.utils;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static int a(Context context, float f16) {
        return (int) ((f16 * b(context)) + 0.5f);
    }

    public static float b(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }
}
