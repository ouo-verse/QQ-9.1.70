package c.t.m.g;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class y3 {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f30121a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f30122b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f30123c;

    public y3(Class<?> cls, Method method, Object obj, boolean z16) {
        this.f30121a = cls;
        this.f30122b = method;
        this.f30123c = obj;
    }

    public boolean a(Object obj) {
        return obj.getClass().equals(this.f30121a);
    }

    public Object b() {
        return this.f30123c;
    }

    public Method a() {
        return this.f30122b;
    }
}
