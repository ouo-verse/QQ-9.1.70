package com.tencent.library;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static float a(Context context, float f16, a aVar) {
        float c16;
        if (aVar == null) {
            c16 = context.getResources().getDisplayMetrics().density;
        } else {
            c16 = aVar.c(context);
        }
        return (f16 / c16) + 0.5f;
    }
}
