package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class flIYu extends UMDtK implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382248a;

    /* renamed from: b, reason: collision with root package name */
    public String f382249b;

    /* renamed from: c, reason: collision with root package name */
    public int f382250c;

    /* renamed from: d, reason: collision with root package name */
    public int f382251d;

    /* renamed from: e, reason: collision with root package name */
    public String f382252e;

    /* renamed from: f, reason: collision with root package name */
    public long f382253f;

    public flIYu() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382248a = 0;
        this.f382249b = "";
        this.f382250c = 0;
        this.f382251d = 0;
        this.f382252e = "";
        this.f382253f = 0L;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382248a, 0);
        xjpd8.a(this.f382249b, 1);
        int i3 = this.f382250c;
        if (i3 != 0) {
            xjpd8.a(i3, 3);
        }
        int i16 = this.f382251d;
        if (i16 != 0) {
            xjpd8.a(i16, 4);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382248a = yunKQ.a(this.f382248a, 0, true);
        this.f382249b = yunKQ.b(1, true);
        this.f382250c = yunKQ.a(this.f382250c, 3, false);
        this.f382251d = yunKQ.a(this.f382251d, 4, false);
        this.f382252e = yunKQ.b(5, false);
        this.f382253f = yunKQ.a(this.f382253f, 6, false);
    }
}
