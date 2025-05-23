package com.tencent.qqnt.emotion.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, long j3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("sticker_remove_emoticon_package_time_" + str, j3);
        edit.apply();
    }
}
