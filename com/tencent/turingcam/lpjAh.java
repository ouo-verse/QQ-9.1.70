package com.tencent.turingcam;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class lpjAh {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Object f382307a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f382308b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21184);
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
                f382308b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f382307a = method.invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }
}
