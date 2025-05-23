package com.tencent.mobileqq.doc;

import android.content.Context;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(Context context, String str, int i3) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long b(Context context, String str, long j3) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void c(Context context, String str, boolean z16) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z16).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(Context context, String str, int i3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(str, i3).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e(Context context, String str, long j3) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, j3).commit();
    }
}
