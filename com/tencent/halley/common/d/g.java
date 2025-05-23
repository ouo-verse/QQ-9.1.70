package com.tencent.halley.common.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g implements c, d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile g f113521a;

    /* renamed from: b, reason: collision with root package name */
    private d f113522b;

    /* renamed from: c, reason: collision with root package name */
    private c f113523c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f113524d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f113521a = null;
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113524d = false;
        }
    }

    public static g e() {
        if (f113521a == null) {
            synchronized (g.class) {
                if (f113521a == null) {
                    f113521a = new g();
                }
            }
        }
        return f113521a;
    }

    @Override // com.tencent.halley.common.d.a
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f113522b.a();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.a
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f113522b.b();
        }
    }

    @Override // com.tencent.halley.common.d.c
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f113523c.c();
        }
    }

    @Override // com.tencent.halley.common.d.d
    public final synchronized void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f113524d) {
            return;
        }
        com.tencent.halley.common.d.b.b.c c16 = com.tencent.halley.common.d.b.b.c.c();
        this.f113522b = c16;
        if (c16 != null) {
            c16.a(this);
            this.f113522b.d();
        }
        this.f113524d = true;
    }

    @Override // com.tencent.halley.common.d.a
    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f113522b.a(i3);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    @Override // com.tencent.halley.common.d.d
    public final void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f113523c = cVar;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
        }
    }

    @Override // com.tencent.halley.common.d.b
    public final void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            this.f113523c.a(str, str2);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.halley.common.d.b
    public final void a(String str, byte[] bArr, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f113523c.a(str, bArr, str2);
        } else {
            iPatchRedirector.redirect((short) 8, this, str, bArr, str2);
        }
    }
}
