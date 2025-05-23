package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.utils.ea;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m {
    public static String a(Context context, String str) {
        return ea.U0(context).getString(str, "");
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = ea.U0(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void c(Context context, String str) {
        SharedPreferences.Editor edit = ea.U0(context).edit();
        edit.remove(str);
        edit.apply();
    }
}
