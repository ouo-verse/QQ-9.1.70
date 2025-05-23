package hynb.j;

import hynb.j.d;
import hynb.p.g;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f406734a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final Short f406735b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final Long f406736c = 0L;

    /* renamed from: d, reason: collision with root package name */
    public static final Float f406737d = Float.valueOf(0.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final Double f406738e = Double.valueOf(0.0d);

    /* renamed from: f, reason: collision with root package name */
    public static final Boolean f406739f = Boolean.FALSE;

    /* renamed from: g, reason: collision with root package name */
    public static final Byte f406740g = (byte) 0;

    /* renamed from: h, reason: collision with root package name */
    public static final Character f406741h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Class<?>, Object> f406742i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public static final c f406743j = new c();

    public static synchronized <T> T a(Class<T> cls) {
        Object obj;
        synchronized (d.class) {
            Map<Class<?>, Object> map = f406742i;
            obj = map.get(cls);
            if (obj == null) {
                c cVar = f406743j;
                Object b16 = cVar.b(cls);
                obj = b16 == null ? (T) cVar.a(cls) : b16;
                map.put(cls, obj);
            }
            if (obj == null) {
                g.f406799a.b("HuyaServiceFetcher", "getService failed, service is null, serviceClass: %s", cls);
                obj = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: v15.a
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj2, Method method, Object[] objArr) {
                        return d.a(obj2, method, objArr);
                    }
                });
            }
        }
        return (T) obj;
    }

    public static /* synthetic */ Object a(Object obj, Method method, Object[] objArr) {
        Class<?> returnType = method.getReturnType();
        if (returnType != Integer.class && returnType != Integer.TYPE) {
            if (returnType != Short.class && returnType != Short.TYPE) {
                if (returnType != Long.class && returnType != Long.TYPE) {
                    if (returnType != Float.class && returnType != Float.TYPE) {
                        if (returnType != Double.class && returnType != Double.TYPE) {
                            if (returnType != Boolean.class && returnType != Boolean.TYPE) {
                                if (returnType != Byte.class && returnType != Byte.TYPE) {
                                    if (returnType == Character.class || returnType == Character.TYPE) {
                                        return f406741h;
                                    }
                                    return null;
                                }
                                return f406740g;
                            }
                            return f406739f;
                        }
                        return f406738e;
                    }
                    return f406737d;
                }
                return f406736c;
            }
            return f406735b;
        }
        return f406734a;
    }
}
