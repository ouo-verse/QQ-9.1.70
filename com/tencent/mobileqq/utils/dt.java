package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dt {
    public static SharedPreferences a(Context context, String str) {
        int i3;
        if (context != null && str != null && str.length() > 0) {
            try {
                Class<?> cls = Class.forName("android.content.Context");
                i3 = ((Integer) cls.getField("MODE_MULTI_PROCESS").get(cls)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | Exception unused) {
                i3 = -1;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            return context.getSharedPreferences(str, i3);
        }
        return null;
    }
}
