package com.tencent.mobileqq.qqlivehall.iv.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Method f274110a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f274111b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f274112c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            f274110a = Class.class.getDeclaredMethod("forName", String.class);
            f274111b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f274112c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable unused) {
            QLog.e(ReflectionUtil.TAG, 1, "init throw t");
        }
    }

    private static boolean a() {
        if (f274110a != null && f274111b != null && f274112c != null) {
            return true;
        }
        return false;
    }

    public static void b(@NonNull Object obj, @NonNull String str, @NonNull String str2, Object obj2) {
        if (a()) {
            try {
                Field field = (Field) f274112c.invoke((Class) f274110a.invoke(null, str), str2);
                field.setAccessible(true);
                field.set(obj, obj2);
            } catch (Throwable th5) {
                Log.e(ReflectionUtil.TAG, "setFiled throw t", th5);
            }
        }
    }
}
