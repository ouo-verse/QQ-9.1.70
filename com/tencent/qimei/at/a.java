package com.tencent.qimei.at;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.as.a;
import com.tencent.qimei.strategy.terminal.ITerminalStrategy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements ITerminalStrategy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f343129a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f343130b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f343131c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f343132d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f343133e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343134f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343135g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f343136h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f343137i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f343138j;

    /* renamed from: k, reason: collision with root package name */
    public String f343139k;

    /* renamed from: l, reason: collision with root package name */
    public String f343140l;

    /* renamed from: m, reason: collision with root package name */
    public String f343141m;

    /* renamed from: n, reason: collision with root package name */
    public String f343142n;

    /* renamed from: o, reason: collision with root package name */
    public String f343143o;

    /* renamed from: p, reason: collision with root package name */
    public String f343144p;

    /* renamed from: q, reason: collision with root package name */
    public String f343145q;

    /* renamed from: r, reason: collision with root package name */
    public final String f343146r;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343129a = true;
        this.f343130b = true;
        this.f343131c = true;
        this.f343132d = false;
        this.f343133e = true;
        this.f343134f = true;
        this.f343135g = true;
        this.f343136h = false;
        this.f343137i = true;
        this.f343138j = true;
        this.f343140l = "";
        this.f343141m = "";
        this.f343142n = "";
        this.f343143o = "";
        this.f343144p = "";
        this.f343145q = "";
        this.f343146r = str;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.f343129a && this.f343138j && com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343109g, this.f343146r).booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableAndroidId(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        this.f343132d = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableAudit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        this.f343136h = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableBuildModel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
        this.f343137i = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableCid(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        this.f343134f = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableIMEI(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        this.f343130b = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableIMSI(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        this.f343131c = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public boolean enableIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.f343138j;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableMAC(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.f343133e = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableOAID(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        this.f343129a = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy enableProcessInfo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        this.f343135g = z16;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setAndroidId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        }
        this.f343144p = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setAuditDomain(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setAuditErrUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setAuditSoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        com.tencent.qimei.u.a.c(str);
        this.f343142n = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setBuildModel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        this.f343145q = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setCid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setHidProcess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        }
        this.f343139k = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setIMEI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setIMSI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setMAC(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setOAID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        this.f343143o = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setQimeiSoPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        com.tencent.qimei.u.a.c(str);
        this.f343141m = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setReportDomain(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        this.f343140l = str;
        return this;
    }

    @Override // com.tencent.qimei.strategy.terminal.ITerminalStrategy
    public ITerminalStrategy setUserAgreePrivacy(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 24, (Object) this, z16);
        }
        this.f343138j = z16;
        return this;
    }
}
