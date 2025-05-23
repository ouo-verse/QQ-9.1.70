package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class sUvea extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382361a;

    /* renamed from: b, reason: collision with root package name */
    public String f382362b;

    /* renamed from: c, reason: collision with root package name */
    public String f382363c;

    /* renamed from: d, reason: collision with root package name */
    public String f382364d;

    /* renamed from: e, reason: collision with root package name */
    public String f382365e;

    /* renamed from: f, reason: collision with root package name */
    public String f382366f;

    /* renamed from: g, reason: collision with root package name */
    public String f382367g;

    /* renamed from: h, reason: collision with root package name */
    public String f382368h;

    /* renamed from: i, reason: collision with root package name */
    public String f382369i;

    public sUvea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382361a = 0;
        this.f382362b = "";
        this.f382363c = "";
        this.f382364d = "";
        this.f382365e = "";
        this.f382366f = "";
        this.f382367g = "";
        this.f382368h = "";
        this.f382369i = "";
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a(this.f382361a, 0);
        qjsR0.a(this.f382362b, 1);
        qjsR0.a(this.f382363c, 2);
        qjsR0.a(this.f382364d, 3);
        qjsR0.a(this.f382365e, 4);
        qjsR0.a(this.f382366f, 5);
        qjsR0.a(this.f382367g, 6);
        qjsR0.a(this.f382368h, 7);
        String str = this.f382369i;
        if (str != null) {
            qjsR0.a(str, 8);
        }
    }
}
