package com.tencent.luggage.wxa.h1;

import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.ic.u;
import com.tencent.luggage.wxa.tn.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static LinkedHashMap f126831a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f126832b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return null;
        }
    }

    static {
        a(new com.tencent.luggage.wxa.h1.a());
        f126832b = new HashMap();
    }

    public static void a(c cVar) {
        if (cVar == null) {
            w.b("Luggage.Luggage", "install fail, plugin is null");
            return;
        }
        w.d("Luggage.Luggage", "plugin:[%s] installed", cVar.getName());
        f126831a.put(cVar.getName(), cVar);
        cVar.a();
    }

    public static d b(Class cls) {
        if (f126832b.get(cls) != null) {
            return (d) f126832b.get(cls);
        }
        d dVar = (d) Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{cls}, new a());
        f126832b.put(cls, dVar);
        return dVar;
    }

    public static d c(Class cls) {
        return a(cls, true);
    }

    public static b a(Class cls) {
        b bVar;
        if (cls == null) {
            return null;
        }
        ((u) g.a(u.class)).J();
        ListIterator listIterator = new ArrayList(f126831a.values()).listIterator(f126831a.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.b() != null && cVar.b().get(cls) != null) {
                return (b) cVar.b().get(cls);
            }
        }
        if (com.tencent.luggage.wxa.eo.c.class.isAssignableFrom(cls)) {
            try {
                bVar = (b) g.a(cls);
            } catch (Exception unused) {
                bVar = null;
            }
            if (bVar != null) {
                return bVar;
            }
        }
        w.h("Luggage.Luggage", "no customize found for [%s]", cls.getCanonicalName());
        return null;
    }

    public static void a(Class cls, b bVar) {
        if (cls == null || bVar == null) {
            return;
        }
        ((c) f126831a.get("luggage-core")).b().put(cls, bVar);
    }

    public static void a(Class cls, d dVar) {
        if (cls == null || dVar == null) {
            return;
        }
        ((c) f126831a.get("luggage-core")).c().put(cls, dVar);
    }

    public static d a(Class cls, boolean z16) {
        if (cls == null) {
            if (z16) {
                return b(cls);
            }
            return null;
        }
        ListIterator listIterator = new ArrayList(f126831a.values()).listIterator(f126831a.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.c() != null && cVar.c().get(cls) != null) {
                return (d) cVar.c().get(cls);
            }
        }
        w.h("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", cls.getCanonicalName(), Boolean.valueOf(z16));
        if (z16) {
            return b(cls);
        }
        return null;
    }
}
