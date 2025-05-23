package com.tencent.luggage.wxa.z9;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    public static void a(boolean z16) {
        SharedPreferences e16 = z.e();
        boolean z17 = e16.getBoolean("settings_support_swipe", true);
        if (z17 != z16) {
            e16.edit().putBoolean("settings_support_swipe", z16).commit();
        }
        w.d("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(z17), Boolean.valueOf(z16));
    }
}
