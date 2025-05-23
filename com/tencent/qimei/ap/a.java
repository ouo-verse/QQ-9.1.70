package com.tencent.qimei.ap;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ao.a;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f343088a;

    /* renamed from: b, reason: collision with root package name */
    public b f343089b;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f343088a = str;
        }
    }

    @Override // com.tencent.qimei.ap.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (c() == null) {
            return "";
        }
        return c().a();
    }

    @Override // com.tencent.qimei.ap.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (c() == null) {
            return "";
        }
        return c().b();
    }

    @Nullable
    public final b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        b bVar = this.f343089b;
        if (bVar != null) {
            return bVar;
        }
        ConcurrentHashMap<String, com.tencent.qimei.aq.a> concurrentHashMap = com.tencent.qimei.ao.a.f343086a;
        com.tencent.qimei.ao.a aVar = a.C9309a.f343087a;
        String str = "BizInfo" + this.f343088a;
        aVar.getClass();
        com.tencent.qimei.aq.a aVar2 = com.tencent.qimei.ao.a.f343086a.get(str);
        if (aVar2 instanceof b) {
            b bVar2 = (b) aVar2;
            this.f343089b = bVar2;
            return bVar2;
        }
        return null;
    }

    @Override // com.tencent.qimei.ap.b
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (c() == null) {
            return "";
        }
        return c().f();
    }

    @Override // com.tencent.qimei.ap.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (c() == null) {
                return;
            }
            c().g();
        }
    }

    @Override // com.tencent.qimei.ap.b
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (c() == null) {
            return "";
        }
        return c().h();
    }

    @Override // com.tencent.qimei.ap.b
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (c() == null) {
            return "";
        }
        return c().i();
    }
}
