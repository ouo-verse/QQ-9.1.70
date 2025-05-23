package com.tencent.tgpa.vendorpd.b;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f376025a;

    public static Context a() {
        return f376025a;
    }

    public static void a(Context context) {
        String str;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                f376025a = applicationContext;
                return;
            }
            str = "get application context is null, ple check!";
        } else {
            str = "the init context is null, ple check!";
        }
        f.d(str);
    }
}
