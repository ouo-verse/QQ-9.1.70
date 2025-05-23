package com.tencent.mobileqq.qqlive.trtc.audio.audioeffect;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.trtc.utils.thread.RTCThreadAnnotations;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements InvocationHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f273235a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.trtc.utils.thread.b f273236b;

        a(c cVar, com.tencent.mobileqq.qqlive.trtc.utils.thread.b bVar) {
            this.f273235a = cVar;
            this.f273236b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) bVar);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
            }
            if (d.f(method, objArr)) {
                return d.d(this.f273236b, method, objArr);
            }
            return method.invoke(this.f273235a, objArr);
        }
    }

    public static com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a c(@NonNull com.tencent.mobileqq.qqlive.trtc.engine.c cVar) {
        c cVar2 = new c(cVar);
        return (com.tencent.mobileqq.qqlive.trtc.audio.audioeffect.a) Proxy.newProxyInstance(c.class.getClassLoader(), c.class.getInterfaces(), new a(cVar2, new com.tencent.mobileqq.qqlive.trtc.utils.thread.b(cVar2.i(), cVar2.g(), cVar2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object d(com.tencent.mobileqq.qqlive.trtc.utils.thread.b bVar, Method method, Object[] objArr) {
        String name = method.getName();
        if (method.getReturnType().getName().equals("void")) {
            bVar.e(method.getName(), objArr);
            return null;
        }
        Object f16 = bVar.f(method.getName(), objArr);
        QLog.i("RTCInnerMusicAccompanyProxyFactory", 1, "dealThreadSwitch: " + name + ", var count:" + e(objArr) + ", result:" + f16);
        return f16;
    }

    private static int e(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Method method, Object[] objArr) {
        if (RTCThreadAnnotations.b(c.class, method.getName(), objArr) == null) {
            return false;
        }
        return true;
    }
}
