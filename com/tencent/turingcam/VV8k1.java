package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VV8k1<E> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f382069a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<E> f382070b;

    public VV8k1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f382070b = new LinkedList<>();
            this.f382069a = i3;
        }
    }

    public void a(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16);
            return;
        }
        if (this.f382070b.size() >= this.f382069a) {
            this.f382070b.poll();
        }
        this.f382070b.offer(e16);
    }
}
