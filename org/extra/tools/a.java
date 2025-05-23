package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f423594a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static Context f423595b;

    public static Context a() {
        return f423595b;
    }

    public static void b(String str) {
        try {
            f423595b = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        } catch (Exception unused) {
        }
        b(f423595b, str);
    }

    private static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                org.extra.relinker.c.a(context, str);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th5) {
            Log.i(f423594a, "loadLibrary " + str + " fail! Error: " + th5.getMessage());
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + RFixConstants.SO_PATH + str + ".so");
            return true;
        } catch (Throwable th5) {
            Log.i(f423594a, "load  fail! Error: " + th5.getMessage());
            return false;
        }
    }

    private static void b(Context context, String str) {
        if (a(str) || a(context, str)) {
            return;
        }
        c(context, str);
    }
}
