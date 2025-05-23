package com.tencent.upgrade.report;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("ec75a987e1", "1.0");
        edit.commit();
    }
}
