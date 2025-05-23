package com.tencent.gathererga.core.internal;

import android.content.Context;
import com.tencent.gathererga.core.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected volatile Context f108196a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile String f108197b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile ConcurrentHashMap<Integer, Boolean> f108198c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile ConcurrentHashMap<Integer, Boolean> f108199d;

    /* renamed from: e, reason: collision with root package name */
    protected volatile int f108200e;

    /* renamed from: f, reason: collision with root package name */
    protected volatile String f108201f;

    /* renamed from: g, reason: collision with root package name */
    protected volatile com.tencent.gathererga.core.internal.component.c f108202g;

    /* renamed from: h, reason: collision with root package name */
    protected volatile boolean f108203h;

    /* renamed from: i, reason: collision with root package name */
    protected volatile com.tencent.gathererga.core.c f108204i;

    /* renamed from: j, reason: collision with root package name */
    protected volatile com.tencent.gathererga.core.internal.component.cache.c f108205j;

    /* renamed from: k, reason: collision with root package name */
    protected volatile d f108206k;

    /* renamed from: l, reason: collision with root package name */
    protected volatile ConcurrentHashMap<Integer, Object> f108207l;

    /* renamed from: m, reason: collision with root package name */
    protected volatile String f108208m;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f108201f;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f108197b;
    }

    public Context c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f108196a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f108208m;
    }

    public com.tencent.gathererga.core.c e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.gathererga.core.c) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f108204i;
    }

    public com.tencent.gathererga.core.internal.component.c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.gathererga.core.internal.component.c) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (this.f108202g == null) {
            return new com.tencent.gathererga.core.internal.component.b();
        }
        return this.f108202g;
    }

    public Map<Integer, Boolean> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f108198c;
    }

    public ConcurrentHashMap<Integer, Boolean> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f108199d;
    }

    public d i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (d) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f108206k;
    }

    public com.tencent.gathererga.core.internal.component.cache.c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.gathererga.core.internal.component.cache.c) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.f108205j == null) {
            return new com.tencent.gathererga.core.internal.component.cache.d();
        }
        return this.f108205j;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f108200e;
    }

    public void l(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) concurrentHashMap);
        } else {
            this.f108198c = concurrentHashMap;
        }
    }

    public void m(ConcurrentHashMap<Integer, Boolean> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) concurrentHashMap);
        } else {
            this.f108199d = concurrentHashMap;
        }
    }
}
