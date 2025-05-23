package com.tencent.beacon.base.util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f77782a;

    public static String a() {
        String str = f77782a;
        if (str != null) {
            return str;
        }
        try {
            f77782a = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th5) {
            c.a(th5);
        }
        return f77782a;
    }
}
