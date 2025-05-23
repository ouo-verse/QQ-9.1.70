package com.tencent.tfd.sdk.wxa;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.class, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cclass {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Object f375746a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f375747b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                f375747b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f375746a = method.invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a() {
        Method method;
        String[] strArr = {"L"};
        Object obj = f375746a;
        if (obj == null || (method = f375747b) == null) {
            return false;
        }
        try {
            method.invoke(obj, strArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
