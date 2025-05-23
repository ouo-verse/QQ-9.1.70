package com.tencent.mobileqq;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes9.dex */
public class au implements InvocationHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f199821a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Object> f199822b;

    public au(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.f199822b = new WeakReference<>(obj);
            this.f199821a = obj.getClass().getSimpleName();
        }
    }

    @NonNull
    public static <T> T a(@NonNull T t16, @NonNull Class<T> cls) {
        return (T) Proxy.newProxyInstance(t16.getClass().getClassLoader(), new Class[]{cls}, new au(t16));
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
        }
        Object obj2 = this.f199822b.get();
        if (obj2 != null) {
            try {
                return method.invoke(obj2, objArr);
            } catch (Throwable th5) {
                if (!TextUtils.isEmpty(this.f199821a)) {
                    QLog.d("WeakReferenceListenerWrapper", 1, "[" + this.f199821a + "] invoke fail, e = ", th5);
                }
                return null;
            }
        }
        if (!TextUtils.isEmpty(this.f199821a)) {
            QLog.d("WeakReferenceListenerWrapper", 1, "[" + this.f199821a + "] invoke fail, recycled.");
        }
        return null;
    }
}
