package com.tencent.tgpa.lite.g;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f375965a;

    public static Context a() {
        if (f375965a == null) {
            try {
                f375965a = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e16) {
                e16.printStackTrace();
            }
        }
        if (f375965a == null) {
            Log.e("TGPALite", " App context get null! U should init sdk first.");
        }
        return f375965a;
    }

    public static String b() {
        File file;
        try {
            file = f375965a.getExternalFilesDir("");
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.e("TGPA", "getAppExFilesDir exception");
            file = null;
        }
        if (file == null) {
            return "";
        }
        return file.getPath();
    }

    public static String c() {
        Context context = f375965a;
        if (context != null) {
            return context.getPackageName();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() {
        String str;
        Context context = f375965a;
        if (context != null) {
            try {
                str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), f375965a.getPackageName(), 0).versionName;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (str != null) {
                return "0";
            }
            return str;
        }
        str = null;
        if (str != null) {
        }
    }

    public static void a(Context context) {
        f375965a = context.getApplicationContext();
    }
}
