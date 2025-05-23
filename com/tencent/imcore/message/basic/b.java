package com.tencent.imcore.message.basic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b<T> implements a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<Class<? extends T>> f116578a;

    /* renamed from: b, reason: collision with root package name */
    private List<T> f116579b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116578a = new ArrayList();
            this.f116579b = new ArrayList();
        }
    }

    private T a(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e16) {
            QLog.e("ClassGeneratorImpl", 1, e16, new Object[0]);
            return null;
        }
    }

    private T b(Class<? extends T> cls) {
        for (T t16 : this.f116579b) {
            if (t16.getClass().equals(cls)) {
                return t16;
            }
        }
        return null;
    }

    private void c(Class<? extends T> cls) {
        for (int size = this.f116579b.size() - 1; size >= 0; size--) {
            if (this.f116579b.get(size).getClass().equals(cls)) {
                this.f116579b.remove(size);
            }
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public synchronized List<T> getInstances() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? extends T> cls : this.f116578a) {
            T b16 = b(cls);
            if (b16 != null) {
                arrayList.add(b16);
            } else {
                T a16 = a(cls);
                if (a16 != null) {
                    this.f116579b.add(a16);
                    arrayList.add(a16);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.basic.a
    public synchronized void register(Class<? extends T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
            return;
        }
        if (cls != null && !this.f116578a.contains(cls)) {
            this.f116578a.add(cls);
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public synchronized void unregister(Class<? extends T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        } else {
            if (this.f116578a.remove(cls)) {
                c(cls);
            }
        }
    }

    @Override // com.tencent.imcore.message.basic.a
    public synchronized List<Class<? extends T>> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new ArrayList(this.f116578a);
    }
}
