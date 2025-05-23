package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.pic.operator.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h<T extends a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Class<T> f258760a;

    /* renamed from: b, reason: collision with root package name */
    HashMap<Integer, Class<? extends T>> f258761b;

    public h(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
        } else {
            this.f258761b = new HashMap<>();
            this.f258760a = cls;
        }
    }

    public Class<? extends T> a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        Class<? extends T> cls = this.f258761b.get(Integer.valueOf(i3));
        if (cls == null) {
            return this.f258760a;
        }
        return cls;
    }

    public void b(int i3, Class<? extends T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) cls);
        } else {
            this.f258761b.put(Integer.valueOf(i3), cls);
        }
    }
}
