package com.tencent.hlyyb.downloader.h.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.g.a.e;
import com.tencent.hlyyb.downloader.g.a.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.sdk.QimeiSDK;
import dalvik.system.InMemoryDexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f114704a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19437);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(Context context) {
        String str = f114704a;
        if (str != null) {
            return str;
        }
        if (f(context)) {
            f114704a = b("0S200MNJT807V3GE");
        }
        if (!TextUtils.isEmpty(f114704a)) {
            return f114704a;
        }
        f114704a = "";
        return "";
    }

    public static String b(String str) {
        Object invoke;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Method declaredMethod = QimeiSDK.class.getDeclaredMethod("getInstance", String.class);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, str);
        } catch (Throwable unused) {
        }
        if (invoke == null) {
            return "";
        }
        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getQimei", new Class[0]);
        declaredMethod2.setAccessible(true);
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 == null) {
            return "";
        }
        Method declaredMethod3 = invoke2.getClass().getDeclaredMethod("getQimei36", new Class[0]);
        declaredMethod3.setAccessible(true);
        Object invoke3 = declaredMethod3.invoke(invoke2, new Object[0]);
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        Method declaredMethod4 = invoke2.getClass().getDeclaredMethod("getQimei16", new Class[0]);
        declaredMethod4.setAccessible(true);
        Object invoke4 = declaredMethod4.invoke(invoke2, new Object[0]);
        if (invoke4 instanceof String) {
            return (String) invoke4;
        }
        return "";
    }

    public static void c(Context context, JSONObject jSONObject, String str, String str2) {
        Class loadClass;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            String i3 = g.i(str);
            if (str2 != null && i3 != null) {
                if (!str2.equalsIgnoreCase(i3)) {
                    file.delete();
                    return;
                }
                if (e(jSONObject)) {
                    byte[] h16 = h(str);
                    if (h16 != null && h16.length != 0) {
                        ByteBuffer wrap = ByteBuffer.wrap(h16);
                        if (Build.VERSION.SDK_INT >= 26) {
                            loadClass = new InMemoryDexClassLoader(wrap, c.class.getClassLoader()).loadClass("com.tencent.yyb.qddownloader.A");
                            loadClass.getMethod("a", Context.class, JSONObject.class).invoke(loadClass.newInstance(), context, jSONObject);
                            return;
                        }
                        return;
                    }
                    return;
                }
                b.a(context, 1001);
                return;
            }
            file.delete();
        } catch (Throwable unused) {
        }
    }

    public static boolean d() {
        try {
            Class.forName("dalvik.system.InMemoryDexClassLoader");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(JSONObject jSONObject) {
        boolean z16;
        if (jSONObject != null && jSONObject.has("mbl")) {
            String optString = jSONObject.optString("mbl");
            if (!TextUtils.isEmpty(optString)) {
                z16 = optString.contains(e.b());
                if (Build.VERSION.SDK_INT >= 26 || !d() || z16) {
                    return false;
                }
                return true;
            }
        }
        z16 = false;
        return Build.VERSION.SDK_INT >= 26 ? false : false;
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        return "com.tencent.mobileqq".equals(context.getPackageName());
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static byte[] h(String str) {
        BufferedInputStream bufferedInputStream;
        if (!g(str)) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
            try {
                byte[] bArr = new byte[bufferedInputStream.available()];
                bufferedInputStream.read(bArr);
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
                return bArr;
            } catch (Throwable unused2) {
                if (bufferedInputStream == null) {
                    return null;
                }
                try {
                    bufferedInputStream.close();
                    return null;
                } catch (Throwable unused3) {
                    return null;
                }
            }
        } catch (Throwable unused4) {
            bufferedInputStream = null;
        }
    }
}
