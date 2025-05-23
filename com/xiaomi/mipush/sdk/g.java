package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.hz;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g {
    public static void a(Context context) {
        boolean z16 = false;
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        if (hz.l(context) >= 50002000) {
            z16 = true;
        }
        edit.putBoolean("is_xmsf_sup_decrypt", z16).apply();
    }
}
