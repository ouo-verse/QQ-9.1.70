package com.tencent.qimei.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Context f342884a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(Context context) {
        String packageName;
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName)) {
                packageName = applicationInfo.packageName;
                return packageName;
            }
            packageName = a().getPackageName();
            return packageName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        String str2;
        try {
            str2 = (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static Context a() {
        Context context;
        synchronized (c.class) {
            if (f342884a == null) {
                Context context2 = null;
                try {
                    context2 = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                f342884a = context2;
            }
            context = f342884a;
        }
        return context;
    }
}
