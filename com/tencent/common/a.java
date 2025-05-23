package com.tencent.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, boolean z16) {
        return context.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("IS_USER_EXIT_RECEIVING_MSG", z16);
    }

    public static boolean b(Context context, boolean z16) {
        return context.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", z16);
    }

    public static void c(Context context, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
        edit.putBoolean("IS_USER_EXIT_RECEIVING_MSG", z16);
        edit.commit();
    }

    public static void d(Context context, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
        edit.putBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", z16);
        edit.commit();
    }
}
