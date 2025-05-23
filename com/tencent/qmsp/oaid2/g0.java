package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g0 {
    public static final boolean a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e16) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e16.toString());
        }
        if (context == null) {
            return false;
        }
        return f0.a().a(context, false);
    }

    public static String b(Context context) {
        f0 a16 = f0.a();
        return a16.a(context.getApplicationContext(), a16.f344217b);
    }

    public static String a(Context context) {
        f0 a16 = f0.a();
        return a16.a(context.getApplicationContext(), a16.f344218c);
    }
}
