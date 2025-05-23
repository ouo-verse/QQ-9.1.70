package com.tencent.luggage.wxa.tn;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.lang.reflect.Method;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static Context f141767a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f141768b = "package.unknown";

    /* renamed from: c, reason: collision with root package name */
    public static String f141769c = "";

    /* renamed from: d, reason: collision with root package name */
    public static volatile Resources f141770d;

    /* renamed from: e, reason: collision with root package name */
    public static ActivityManager f141771e;

    /* renamed from: f, reason: collision with root package name */
    public static a f141772f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        AssetManager a(AssetManager assetManager);
    }

    public static String a() {
        return f141768b;
    }

    public static void b(Context context) {
        f141767a = context;
        f141768b = context.getPackageName();
        w.a("MicroMsg.MMApplicationContext", "setup application context for package: " + f141768b);
        if (context instanceof Application) {
            com.tencent.luggage.wxa.tn.a.a((Application) context);
        }
        com.tencent.luggage.wxa.zp.g.a(context, new u0());
    }

    public static Context c() {
        return f141767a;
    }

    public static String d() {
        Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        if (invoke instanceof String) {
            return (String) invoke;
        }
        return null;
    }

    public static SharedPreferences e() {
        Context context = f141767a;
        if (context != null) {
            return context.getSharedPreferences(f(), 0);
        }
        return null;
    }

    public static String f() {
        return f141768b + "_preferences";
    }

    public static String g() {
        return f141768b;
    }

    public static String h() {
        return f141768b;
    }

    public static String i() {
        String str = f141769c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a16 = a(f141767a);
        f141769c = a16;
        return a16;
    }

    public static Resources j() {
        return f141770d;
    }

    public static boolean k() {
        return m();
    }

    public static boolean l() {
        return d(f141768b);
    }

    public static boolean m() {
        String i3 = i();
        if (i3 == null) {
            return true;
        }
        if (!i3.contains(":") && i3.startsWith(f141768b)) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        String i3 = i();
        w.d("MicroMsg.MMApplicationContext", "isToolsIsolatedProcess, processName:" + i3);
        if (i3 == null || i3.length() == 0) {
            i3 = f141768b;
        }
        if (!(f141768b + ":isolated_process0").equalsIgnoreCase(i3) && !b(i3) && !c(i3) && !a(i3)) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
            return processName;
        }
        try {
            return d();
        } catch (Exception unused) {
            return w0.b(context, Process.myPid());
        }
    }

    public static boolean c(String str) {
        return str.contains(f141768b + ":xweb_sandboxed_process_ex");
    }

    public static void a(Resources resources) {
        f141770d = resources;
    }

    public static void a(a aVar) {
        f141772f = aVar;
    }

    public static AssetManager b() {
        AssetManager assets = f141767a.getAssets();
        a aVar = f141772f;
        return aVar == null ? assets : aVar.a(assets);
    }

    public static boolean d(String str) {
        Context context = f141767a;
        if (context != null && f141768b != null) {
            if (f141771e == null) {
                f141771e = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            }
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses(f141771e).iterator();
                while (it.hasNext()) {
                    if (it.next().processName.equals(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Error e16) {
                w.b("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e16.toString());
                return false;
            } catch (Exception e17) {
                w.b("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e17.toString());
            }
        }
        return false;
    }

    public static String a(int i3, Object... objArr) {
        return j().getString(i3, objArr);
    }

    public static int a(int i3) {
        return ContextCompat.getColor(c(), i3);
    }

    public static boolean a(String str) {
        return str.contains(f141768b + ":xweb_privileged_process");
    }

    public static String b(int i3) {
        return j().getString(i3);
    }

    public static boolean b(String str) {
        return str.contains(f141768b + ":xweb_sandboxed_process");
    }
}
