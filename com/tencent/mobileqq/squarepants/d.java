package com.tencent.mobileqq.squarepants;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Object f289655a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f289656b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f289657c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f289658d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f289659e;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (f289659e) {
            return true;
        }
        f289659e = true;
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            Field declaredField = cls.getDeclaredField("sLock");
            declaredField.setAccessible(true);
            f289655a = declaredField.get(null);
            f289656b = cls.getDeclaredMethod("getHandler", new Class[0]);
            Field declaredField2 = cls.getDeclaredField("sFinishers");
            declaredField2.setAccessible(true);
            LinkedList linkedList = (LinkedList) declaredField2.get(null);
            synchronized (f289655a) {
                declaredField2.set(null, new FinishersProxy(linkedList));
            }
            Field declaredField3 = cls.getDeclaredField("sWork");
            f289658d = declaredField3;
            declaredField3.setAccessible(true);
            if (c() == null) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            c.c("SPSucks", th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler b() {
        try {
            synchronized (f289655a) {
                if (f289657c == null) {
                    f289656b.setAccessible(true);
                    f289657c = (Handler) f289656b.invoke(null, new Object[0]);
                }
            }
        } catch (Throwable th5) {
            c.c("SPSucks", th5);
        }
        return f289657c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WorkProxy c() {
        try {
            synchronized (f289655a) {
                LinkedList linkedList = (LinkedList) f289658d.get(null);
                if (linkedList instanceof WorkProxy) {
                    return (WorkProxy) linkedList;
                }
                WorkProxy workProxy = new WorkProxy(linkedList, f289655a);
                f289658d.set(null, workProxy);
                return workProxy;
            }
        } catch (Throwable th5) {
            c.c("SPSucks", th5);
            return null;
        }
    }
}
