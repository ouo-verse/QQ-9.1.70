package com.tencent.gathererga.core.internal.component;

import android.content.Context;
import com.tencent.gathererga.core.internal.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends com.tencent.gathererga.core.internal.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static final a f108209g;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f108210d;

    /* renamed from: e, reason: collision with root package name */
    private String f108211e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.gathererga.core.internal.component.cache.c f108212f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f108209g = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T> T e(Class<T> cls) {
        return (T) f108209g.a(cls);
    }

    public static <T> void i(Class<T> cls, Class<?> cls2) {
        f108209g.d(cls, cls2);
    }

    @Override // com.tencent.gathererga.core.internal.a
    protected Object c(Class<?> cls, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls, obj);
        }
        WeakReference<Context> weakReference = this.f108210d;
        if (weakReference != null && weakReference.get() != null) {
            ((com.tencent.gathererga.core.internal.c) obj).onInit(this.f108210d.get());
            return obj;
        }
        return null;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f108211e;
    }

    public com.tencent.gathererga.core.internal.component.cache.c g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.gathererga.core.internal.component.cache.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f108212f;
    }

    public void h(com.tencent.gathererga.core.internal.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        this.f108210d = new WeakReference<>(bVar.c());
        this.f108211e = bVar.d();
        d.e(bVar.i());
        com.tencent.gathererga.core.internal.component.cache.c j3 = bVar.j();
        this.f108212f = j3;
        j3.onInit(bVar.c());
        i(com.tencent.gathererga.core.internal.component.cache.a.class, com.tencent.gathererga.core.internal.component.cache.b.class);
    }
}
