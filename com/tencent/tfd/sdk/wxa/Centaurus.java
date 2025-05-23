package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Centaurus<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f375525a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<E> f375526b;

    public Centaurus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f375526b = new LinkedList<>();
            this.f375525a = i3;
        }
    }

    public final void a(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16);
            return;
        }
        if (this.f375526b.size() >= this.f375525a) {
            this.f375526b.poll();
        }
        this.f375526b.offer(e16);
    }
}
