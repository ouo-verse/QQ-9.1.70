package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Context f37981a;

    public static Context a() {
        return f37981a;
    }

    public static void a(Context context) {
        if (context == null || f37981a != null) {
            return;
        }
        f37981a = context.getApplicationContext();
    }
}
