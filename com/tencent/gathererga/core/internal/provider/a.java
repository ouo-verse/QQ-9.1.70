package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.e;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.component.cloudconf.IDConfigManagerImpl;
import com.tencent.gathererga.core.internal.util.d;
import com.tencent.gathererga.core.internal.util.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements InvocationHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Object f108227a;

    public a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.f108227a = obj;
        }
    }

    private boolean a(Object obj) {
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return false;
    }

    private static e b(Object[] objArr) {
        Object obj;
        if (objArr == null || objArr.length < 1 || (obj = objArr[0]) == null || !(obj instanceof e)) {
            return null;
        }
        return (e) obj;
    }

    private static f c(Method method, Object[] objArr, InfoID infoID, int i3, Object obj) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return c.f(-1L);
                }
                com.tencent.gathererga.core.internal.component.cache.c g16 = com.tencent.gathererga.core.internal.component.a.f108209g.g();
                if (g16 == null) {
                    return c.f(-11L);
                }
                Object g17 = g16.g(infoID.id());
                if (g17 != null) {
                    return c.h(g17, 4);
                }
                return c.f(-11L);
            }
            if (!IDConfigManagerImpl.l().a(infoID.id())) {
                return c.f(-999L);
            }
            com.tencent.gathererga.core.internal.component.cache.c g18 = com.tencent.gathererga.core.internal.component.a.f108209g.g();
            if (g18 == null) {
                return c.f(-12L);
            }
            Object a16 = g18.a(infoID.id());
            if (a16 != null) {
                return c.h(a16, 2);
            }
            return c.f(-12L);
        }
        if (!IDConfigManagerImpl.l().e(infoID.id())) {
            return c.f(-999L);
        }
        String[] b16 = i.b(com.tencent.gathererga.core.b.e(), infoID.permissions());
        if (b16 != null && b16.length > 0) {
            d.a(method.getName() + " without permsssion : " + Arrays.asList(b16));
            return c.i(-888L, b16);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            f fVar = (f) method.invoke(obj, objArr);
            if (fVar != null) {
                fVar.d(System.currentTimeMillis() - currentTimeMillis);
            }
            return fVar;
        } catch (Throwable th5) {
            return c.g(-13L, th5);
        }
    }

    private static f d(Method method, Object[] objArr, InfoID infoID, e eVar, Object obj) {
        f c16 = c(method, objArr, infoID, eVar.c(), obj);
        if (c16.c()) {
            return c16;
        }
        if (eVar.a() == 0) {
            return c16;
        }
        f c17 = c(method, objArr, infoID, eVar.a(), obj);
        if (c17.c()) {
            return c17;
        }
        if (eVar.d() == 0) {
            return c17;
        }
        return c(method, objArr, infoID, eVar.d(), obj);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
        }
        Method method2 = this.f108227a.getClass().getMethod(method.getName(), method.getParameterTypes());
        Annotation annotation = method2.getAnnotation(InfoID.class);
        if (annotation == null) {
            try {
                return method2.invoke(this.f108227a, objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        if (!method.getReturnType().equals(f.class)) {
            try {
                return method2.invoke(this.f108227a, objArr);
            } catch (Throwable unused2) {
                return null;
            }
        }
        e b16 = b(objArr);
        if (b16 == null) {
            try {
                return method2.invoke(this.f108227a, objArr);
            } catch (Throwable unused3) {
                return null;
            }
        }
        InfoID infoID = (InfoID) annotation;
        f d16 = d(method, objArr, infoID, b16, this.f108227a);
        if (d16.c() && b16.b() && d16.a() != 2 && d16.a() != 4) {
            com.tencent.gathererga.core.internal.component.cache.c g16 = com.tencent.gathererga.core.internal.component.a.f108209g.g();
            if (g16 == null) {
                return d16;
            }
            int id5 = infoID.id();
            Object b17 = d16.b();
            if (b16.e() && a(d16.b())) {
                z16 = true;
            } else {
                z16 = false;
            }
            g16.d(id5, b17, z16);
        }
        return d16;
    }
}
