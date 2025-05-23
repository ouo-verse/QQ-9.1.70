package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class uAnWx extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382396a;

    /* renamed from: b, reason: collision with root package name */
    public int f382397b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f382398c;

    /* renamed from: d, reason: collision with root package name */
    public int f382399d;

    /* renamed from: e, reason: collision with root package name */
    public int f382400e;

    public uAnWx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382396a = "";
        this.f382397b = 0;
        this.f382398c = null;
        this.f382399d = 0;
        this.f382400e = 0;
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a(this.f382396a, 0);
        qjsR0.a(this.f382397b, 1);
        qjsR0.a(this.f382398c, 2);
        qjsR0.a(this.f382399d, 3);
        qjsR0.a(this.f382400e, 4);
        qjsR0.a(0, 5);
        qjsR0.a("", 6);
    }
}
