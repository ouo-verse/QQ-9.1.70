package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, Throwable th5, int i3) {
        Intent intent = new Intent("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
        intent.putExtra("qshadow_plugin_id", str);
        intent.putExtra("qshadow_plugin_throwable", th5);
        intent.putExtra("qshadow_plugin_error_code", i3);
        context.sendBroadcast(intent);
    }
}
