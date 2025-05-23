package com.tencent.mobileqq.colornote.swipe;

import android.app.Activity;
import android.app.ActivityOptions;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f201715a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f201716b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f201717c;

    /* renamed from: d, reason: collision with root package name */
    private static Class<?> f201718d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f201719e;

    public static void a(Activity activity, InvocationHandler invocationHandler) {
        b(activity, invocationHandler);
    }

    private static void b(Activity activity, InvocationHandler invocationHandler) {
        c();
        try {
            Object invoke = f201717c.invoke(activity, new Object[0]);
            Class<?> cls = f201718d;
            f201719e.invoke(activity, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler), invoke);
        } catch (Throwable unused) {
        }
    }

    private static void c() {
        if (f201715a) {
            return;
        }
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            f201717c = declaredMethod;
            declaredMethod.setAccessible(true);
            Class<?>[] declaredClasses = Activity.class.getDeclaredClasses();
            f201718d = null;
            for (Class<?> cls : declaredClasses) {
                if (cls.getSimpleName().contains("TranslucentConversionListener")) {
                    f201718d = cls;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", f201718d, ActivityOptions.class);
            f201719e = declaredMethod2;
            declaredMethod2.setAccessible(true);
            f201716b = true;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("SwipeLayoutUtils", 2, th5, new Object[0]);
            }
        }
        f201715a = true;
    }

    public static boolean d() {
        c();
        return f201716b;
    }
}
