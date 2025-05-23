package com.tencent.mobileqq.auto.engine.loader;

import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.selector.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f199859a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f199860b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f199861c;

    /* renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<g<ASPluginBean>> f199862d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f199863e;

    /* renamed from: f, reason: collision with root package name */
    private a f199864f;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f199865g;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        boolean a(ASEnterBean aSEnterBean);
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f199859a;
    }

    public List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f199865g;
    }

    public CopyOnWriteArrayList<g<ASPluginBean>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f199862d;
    }

    public b d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.f199859a = str;
        return this;
    }

    public b e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        this.f199860b = z16;
        return this;
    }

    public b f(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (b) iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        }
        this.f199865g = list;
        return this;
    }

    public b g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (b) iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
        this.f199863e = z16;
        return this;
    }

    public b h(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (b) iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        }
        this.f199864f = aVar;
        return this;
    }

    public b i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        this.f199861c = z16;
        return this;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f199863e;
    }

    public boolean k(ASEnterBean aSEnterBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) aSEnterBean)).booleanValue();
        }
        a aVar = this.f199864f;
        if (aVar != null) {
            return aVar.a(aSEnterBean);
        }
        return false;
    }
}
