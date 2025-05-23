package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Context f380794a;

    public e() {
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
            } else {
                packageName = b().getPackageName();
            }
            return packageName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static Context b() {
        Context context;
        synchronized (e.class) {
            if (f380794a == null) {
                f380794a = c();
            }
            context = f380794a;
        }
        return context;
    }

    public static Context c() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static boolean a() {
        return (TextUtils.isEmpty(a("ro.build.version.emui")) && TextUtils.isEmpty(a("hw_sc.build.platform.version"))) ? false : true;
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
}
