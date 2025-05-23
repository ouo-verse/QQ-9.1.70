package com.tencent.mobileqq.troop.adapter.base;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    SparseArrayCompat<a<T>> f293792a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293792a = new SparseArrayCompat<>();
        }
    }

    public b<T> a(a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        int size = this.f293792a.size();
        if (aVar != null) {
            this.f293792a.put(size, aVar);
        }
        return this;
    }

    public void b(c cVar, T t16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, cVar, t16, Integer.valueOf(i3));
            return;
        }
        int size = this.f293792a.size();
        for (int i16 = 0; i16 < size; i16++) {
            a<T> valueAt = this.f293792a.valueAt(i16);
            if (valueAt.a(t16, i3)) {
                valueAt.b(cVar, t16, i3);
                return;
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegateManager added that matches position=" + i3 + " in data source");
    }

    public a c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (a) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return this.f293792a.get(i3);
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f293792a.size();
    }

    public int e(T t16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) t16, i3)).intValue();
        }
        for (int size = this.f293792a.size() - 1; size >= 0; size--) {
            if (this.f293792a.valueAt(size).a(t16, i3)) {
                return this.f293792a.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + i3 + " in data source");
    }
}
