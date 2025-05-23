package com.tencent.smtt.utils;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    public static boolean a(Context context) {
        if (context != null && ("com.tencent.wemeet.app".equalsIgnoreCase(context.getPackageName()) || "com.tencent.wemeet.dev".equalsIgnoreCase(context.getPackageName()))) {
            return true;
        }
        return false;
    }
}
