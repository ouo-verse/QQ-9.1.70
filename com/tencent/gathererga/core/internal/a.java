package com.tencent.gathererga.core.internal;

import com.tencent.gathererga.core.internal.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Object f108193a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, WeakReference<Object>> f108194b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Class<?>, Class<?>> f108195c;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f108193a = new Object();
        this.f108194b = new ConcurrentHashMap<>();
        this.f108195c = new ConcurrentHashMap<>();
    }

    public <T> T a(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        String name = cls.getName();
        WeakReference<Object> weakReference = this.f108194b.get(cls.getName());
        if (weakReference != null && weakReference.get() != null) {
            return (T) weakReference.get();
        }
        synchronized (this.f108193a) {
            WeakReference<Object> weakReference2 = this.f108194b.get(name);
            if (weakReference2 != null && weakReference2.get() != null) {
                return (T) weakReference2.get();
            }
            try {
                T t16 = (T) c(cls, this.f108195c.get(cls).getConstructor(new Class[0]).newInstance(new Object[0]));
                this.f108194b.put(name, new WeakReference<>(t16));
                return t16;
            } catch (Throwable th5) {
                d.b(th5.getMessage());
                return null;
            }
        }
    }

    public ConcurrentHashMap<Class<?>, Class<?>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f108195c;
    }

    protected abstract Object c(Class<?> cls, Object obj);

    public <T> void d(Class<T> cls, Class<?> cls2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls, (Object) cls2);
        } else if (this.f108195c.putIfAbsent(cls, cls2) != null) {
            d.f("BaseContext Overrides implementation: " + cls.getName());
        }
    }
}
