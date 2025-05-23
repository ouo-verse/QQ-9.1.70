package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.msf.core.net.s.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected g[] f249132a;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f249132a = new g[]{new h(com.tencent.mobileqq.msf.core.f0.c.d.a.f248086j, "MobileQQ1"), new h("http://sqimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2")};
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(g gVar, int i3, a.InterfaceC8088a interfaceC8088a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, this, gVar, Integer.valueOf(i3), interfaceC8088a);
        }
        if (gVar.f249100a != 2) {
            return null;
        }
        return new b(i3, ((h) gVar).f249102f, gVar.f249101b, 10000, interfaceC8088a);
    }

    public abstract void a();

    public abstract void a(String str);

    public abstract void a(String str, int i3);

    public abstract void b();

    public abstract void c();
}
