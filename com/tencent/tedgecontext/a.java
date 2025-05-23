package com.tencent.tedgecontext;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tedger.outapi.api.ITEdgeRSServer;
import com.tencent.tedger.outapi.delegate.ITEdgeRSSDKComponentDelegate;
import com.tencent.tedger.outapi.delegate.d;
import com.tencent.tedger.outapi.delegate.e;
import com.tencent.tedger.outapi.delegate.f;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.tedger.routecenter.a f375114a;

    /* renamed from: b, reason: collision with root package name */
    private String f375115b;

    /* renamed from: c, reason: collision with root package name */
    private String f375116c;

    /* renamed from: d, reason: collision with root package name */
    private String f375117d;

    /* renamed from: e, reason: collision with root package name */
    private String f375118e;

    /* renamed from: f, reason: collision with root package name */
    private f f375119f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<Application> f375120g;

    /* renamed from: h, reason: collision with root package name */
    private ITEdgeRSServer.TEdgeServerScene f375121h;

    /* renamed from: i, reason: collision with root package name */
    private String f375122i;

    /* renamed from: j, reason: collision with root package name */
    private String f375123j;

    /* renamed from: k, reason: collision with root package name */
    private String f375124k;

    /* renamed from: l, reason: collision with root package name */
    private String f375125l;

    /* renamed from: m, reason: collision with root package name */
    boolean f375126m;

    /* renamed from: n, reason: collision with root package name */
    boolean f375127n;

    public a(com.tencent.tedger.routecenter.a aVar, f fVar, ITEdgeRSServer.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, fVar, aVar2);
            return;
        }
        this.f375114a = aVar;
        this.f375115b = aVar2.f375265a;
        this.f375116c = aVar2.f375266b;
        this.f375117d = aVar2.f375267c;
        this.f375119f = fVar;
        this.f375118e = aVar2.f375268d;
        this.f375120g = new WeakReference<>(aVar2.f375270f);
        this.f375121h = aVar2.f375269e;
        this.f375122i = aVar2.f375271g;
        this.f375125l = aVar2.f375272h;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f375115b;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f375122i;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f375116c;
    }

    public ITEdgeRSSDKComponentDelegate d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ITEdgeRSSDKComponentDelegate) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f375119f.c();
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f375118e;
    }

    public Application f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Application) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f375120g.get();
    }

    public com.tencent.tedger.outapi.delegate.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.tedger.outapi.delegate.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f375119f.a();
    }

    public com.tencent.tedger.outapi.delegate.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.tedger.outapi.delegate.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f375119f.e();
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.f375125l;
    }

    public com.tencent.tedger.outapi.delegate.c j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.tedger.outapi.delegate.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f375119f.b();
    }

    public d k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f375119f.d();
    }

    public e l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f375119f.getLogDelegate();
    }

    public com.tencent.tedger.routecenter.a m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.tedger.routecenter.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f375114a;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        String str = this.f375124k;
        if (str == null) {
            return SemanticAttributes.HttpFlavorValues.HTTP_2_0;
        }
        return str;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        String str = this.f375123j;
        if (str == null) {
            return SemanticAttributes.HttpFlavorValues.HTTP_2_0;
        }
        return str;
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f375117d;
    }

    public ITEdgeRSServer.TEdgeServerScene q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ITEdgeRSServer.TEdgeServerScene) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.f375121h;
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f375126m;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.f375127n;
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.f375118e = str;
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.f375126m = z16;
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f375127n = z16;
        }
    }
}
