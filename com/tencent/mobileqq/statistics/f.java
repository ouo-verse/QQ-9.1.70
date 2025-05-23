package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class f {
    static IPatchRedirector $redirector_;

    public static void a(Context context, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences("LIGHT_DPC_CFG", 4).edit();
        edit.putBoolean("SUPPORT_MTA", z16);
        edit.commit();
    }
}
