package com.tencent.qqnt.indicators.magicindicator.buildins;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static int a(Context context, double d16) {
        return (int) ((d16 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }
}
