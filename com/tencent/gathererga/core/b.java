package com.tencent.gathererga.core;

import android.content.Context;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.impl.UserInfoImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends com.tencent.gathererga.core.internal.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final b f108187d;

    /* renamed from: e, reason: collision with root package name */
    private static WeakReference<Context> f108188e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<Integer, a> f108189f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Class<?> f108190a;

        /* renamed from: b, reason: collision with root package name */
        Method f108191b;

        /* renamed from: c, reason: collision with root package name */
        InfoID f108192c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f108187d = new b();
        f108189f = new ConcurrentHashMap();
        i(UserInfoProvider.class, UserInfoImpl.class);
        i(HardwareInfoProvider.class, com.tencent.gathererga.core.internal.provider.impl.d.class);
        i(AndroidInfoProvider.class, com.tencent.gathererga.core.internal.provider.impl.b.class);
        i(AppInfoProvider.class, com.tencent.gathererga.core.internal.provider.impl.c.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static Context e() {
        WeakReference<Context> weakReference = f108188e;
        if (weakReference != null && weakReference.get() != null) {
            return f108188e.get();
        }
        return null;
    }

    public static <T> T f(Class<T> cls) {
        return (T) f108187d.a(cls);
    }

    public static void g(com.tencent.gathererga.core.internal.b bVar) {
        f108188e = new WeakReference<>(bVar.c());
        com.tencent.gathererga.core.internal.util.e.b().c(bVar.e());
        com.tencent.gathererga.core.internal.component.a.f108209g.h(bVar);
        h();
    }

    @Deprecated
    private static void h() {
        InfoID infoID;
        f108189f.clear();
        for (Class<?> cls : f108187d.b().keySet()) {
            for (Method method : f108187d.b().get(cls).getMethods()) {
                try {
                    infoID = (InfoID) method.getAnnotation(InfoID.class);
                } catch (Throwable th5) {
                    com.tencent.gathererga.core.internal.util.d.b(th5.getMessage());
                    infoID = null;
                }
                if (infoID != null) {
                    Map<Integer, a> map = f108189f;
                    if (map.get(Integer.valueOf(infoID.id())) != null) {
                        map.get(Integer.valueOf(infoID.id()));
                        return;
                    }
                    a aVar = new a();
                    aVar.f108190a = cls;
                    aVar.f108191b = method;
                    aVar.f108192c = infoID;
                    map.put(Integer.valueOf(infoID.id()), aVar);
                }
            }
        }
    }

    public static <T> void i(Class<T> cls, Class<?> cls2) {
        f108187d.d(cls, cls2);
    }

    @Override // com.tencent.gathererga.core.internal.a
    protected Object c(Class<?> cls, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, obj);
        }
        WeakReference<Context> weakReference = f108188e;
        if (weakReference != null && weakReference.get() != null) {
            ((com.tencent.gathererga.core.internal.c) obj).onInit(f108188e.get());
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new com.tencent.gathererga.core.internal.provider.a(obj));
        }
        return null;
    }
}
