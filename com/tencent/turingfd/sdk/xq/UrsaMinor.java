package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UrsaMinor<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f383175a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<E> f383176b;

    public UrsaMinor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f383176b = new LinkedList<>();
            this.f383175a = i3;
        }
    }

    public void a(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16);
            return;
        }
        if (this.f383176b.size() >= this.f383175a) {
            this.f383176b.poll();
        }
        this.f383176b.offer(e16);
    }
}
