package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static Object a(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
        } catch (Exception e16) {
            d.c("invokeStaticMethod got Exception:", e16);
        }
        return null;
    }
}
