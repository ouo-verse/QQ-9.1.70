package com.tencent.mobileqq.qqgamepub.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static long a(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_SharePreferenceUtils", 2, "getLong " + str);
        }
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences("qq_game_sharepreference", 4).getLong(str, 0L);
    }

    public static void b(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_SharePreferenceUtils", 2, "saveLong " + str + "_" + j3);
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("qq_game_sharepreference", 4).edit();
        edit.putLong(str, j3);
        edit.apply();
    }
}
