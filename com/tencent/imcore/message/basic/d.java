package com.tencent.imcore.message.basic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d<K, T> implements c<K, T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<K, Class<? extends T>> f116580a;

    /* renamed from: b, reason: collision with root package name */
    private Map<K, T> f116581b;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116580a = new HashMap();
            this.f116581b = new HashMap();
        }
    }

    private T b(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            QLog.e("MapClassGeneratorImpl", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    public synchronized void a(K k3, Class<? extends T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) cls);
        } else {
            this.f116580a.put(k3, cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.c
    public synchronized T get(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        T t16 = this.f116581b.get(k3);
        if (t16 != null) {
            return t16;
        }
        Class<? extends T> cls = this.f116580a.get(k3);
        if (cls == null) {
            return null;
        }
        T b16 = b(cls);
        if (b16 != null) {
            this.f116581b.put(k3, b16);
        }
        return b16;
    }

    @Override // com.tencent.imcore.message.basic.c
    public synchronized List<Class<? extends T>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList(this.f116580a.values());
    }
}
