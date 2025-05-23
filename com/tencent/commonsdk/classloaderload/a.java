package com.tencent.commonsdk.classloaderload;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Method f99890a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f99891b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f99892c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        try {
            f99890a = Class.class.getDeclaredMethod("forName", String.class);
            f99891b = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            f99892c = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable unused) {
            QLog.e(ReflectionUtil.TAG, 1, "init throw t");
        }
    }

    private static boolean a() {
        if (f99890a != null && f99891b != null && f99892c != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(Object obj, String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        obj.getClass().getDeclaredMethod(str, new Class[0]).invoke(obj, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public static Object c(@NonNull Object obj, @NonNull String str, @NonNull String str2, @NonNull Object obj2) {
        if (a()) {
            try {
                Field field = (Field) f99892c.invoke((Class) f99890a.invoke(null, str), str2);
                field.setAccessible(true);
                return field.get(obj);
            } catch (Throwable th5) {
                QLog.e(ReflectionUtil.TAG, 1, "getFiled throw t", th5);
                return obj2;
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object d(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}
