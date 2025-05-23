package hynb.o;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import hynb.p.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static b f406786e;

    /* renamed from: f, reason: collision with root package name */
    public static String f406787f;

    /* renamed from: g, reason: collision with root package name */
    public static String f406788g;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f406789a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f406790b;

    /* renamed from: c, reason: collision with root package name */
    public String f406791c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f406792d = "";

    public static String a(Context context) {
        String str;
        try {
            str = f406787f;
        } catch (Exception e16) {
            g.f406799a.b("HuyaHySignalFieldsCache", "getAndroidId err: %s, return", e16.getMessage());
        }
        if (str != null) {
            return str;
        }
        f406787f = hynb.m.a.a(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        return f406787f;
    }

    public static String c(Context context) {
        return a(context, true);
    }

    public static b e() {
        if (f406786e == null) {
            f406786e = new b();
        }
        return f406786e;
    }

    public final String b(Context context) {
        String c16 = context != null ? c(context) : null;
        g.f406799a.a("HuyaHySignalFieldsCache", "getGUIDSpName:HySignalGUIDCache, processName:" + c16);
        return "HySignalGUIDCache";
    }

    public synchronized void d(Context context) {
        if (this.f406790b) {
            g.f406799a.error("HuyaHySignalFieldsCache", "has inited, return");
            return;
        }
        if (context == null) {
            g.f406799a.error("HuyaHySignalFieldsCache", "init context is null");
            return;
        }
        this.f406789a = context.getSharedPreferences(b(context), 0);
        g();
        this.f406790b = true;
        try {
            this.f406792d = a(context);
        } catch (Exception e16) {
            g.f406799a.error("HuyaHySignalFieldsCache", "get mid failed:" + e16.getMessage());
        }
    }

    public String f() {
        return this.f406792d;
    }

    public final void g() {
        String string = this.f406789a.getString("GUID", "");
        if (a(string)) {
            this.f406791c = string;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r2 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c() {
        BufferedReader bufferedReader;
        String str = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            try {
                str = bufferedReader.readLine().trim();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused3) {
            return str;
        }
    }

    public synchronized void b(String str) {
        if (!this.f406790b) {
            g.f406799a.error("HuyaHySignalFieldsCache", "save GUID need init, return");
            return;
        }
        if (!a(str)) {
            g.f406799a.c("HuyaHySignalFieldsCache", "save GUID is err: %s, return", str);
            return;
        }
        String d16 = d();
        if (str.equals(d16)) {
            g.f406799a.c("HuyaHySignalFieldsCache", "set same GUID:%s, return", d16);
            return;
        }
        try {
            SharedPreferences.Editor edit = this.f406789a.edit();
            edit.putString("GUID", str);
            edit.apply();
        } catch (Exception e16) {
            g.f406799a.b("HuyaHySignalFieldsCache", "save guid occur exception: %s", e16.getMessage());
        }
        this.f406791c = str;
        g.f406799a.c("HuyaHySignalFieldsCache", "save GUID success, old:%s, new:%s", d16, str);
    }

    public boolean a(String str) {
        return (str == null || str.isEmpty() || str.trim().length() != 32) ? false : true;
    }

    public static String a(Context context, boolean z16) {
        String str = f406788g;
        if (str != null && str.length() > 0) {
            return f406788g;
        }
        String b16 = b();
        f406788g = b16;
        if (b16 != null && b16.length() > 0) {
            return f406788g;
        }
        String a16 = a();
        f406788g = a16;
        if (a16 != null && a16.length() > 0) {
            return f406788g;
        }
        String c16 = c();
        f406788g = c16;
        return (c16 == null || c16.length() <= 0) ? "" : f406788g;
    }

    public String d() {
        return this.f406791c;
    }

    public static String b() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return (String) Class.forName("android.app.Application").getDeclaredMethod("getProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static String a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
