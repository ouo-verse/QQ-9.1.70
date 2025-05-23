package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class qbihQ extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382343a;

    /* renamed from: b, reason: collision with root package name */
    public int f382344b;

    /* renamed from: c, reason: collision with root package name */
    public String f382345c;

    /* renamed from: d, reason: collision with root package name */
    public String f382346d;

    /* renamed from: e, reason: collision with root package name */
    public String f382347e;

    /* renamed from: f, reason: collision with root package name */
    public int f382348f;

    /* renamed from: g, reason: collision with root package name */
    public int f382349g;

    /* renamed from: h, reason: collision with root package name */
    public long f382350h;

    /* renamed from: i, reason: collision with root package name */
    public int f382351i;

    /* renamed from: j, reason: collision with root package name */
    public String f382352j;

    public qbihQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382343a = 2;
        this.f382344b = 0;
        this.f382345c = "";
        this.f382346d = "";
        this.f382347e = "";
        this.f382348f = 0;
        this.f382349g = 0;
        this.f382350h = 0L;
        this.f382351i = 0;
        this.f382352j = "";
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new qbihQ() : (UMDtK) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382343a, 0);
        xjpd8.a(this.f382344b, 1);
        String str = this.f382345c;
        if (str != null) {
            xjpd8.a(str, 2);
        }
        String str2 = this.f382346d;
        if (str2 != null) {
            xjpd8.a(str2, 3);
        }
        String str3 = this.f382347e;
        if (str3 != null) {
            xjpd8.a(str3, 4);
        }
        int i3 = this.f382348f;
        if (i3 != 0) {
            xjpd8.a(i3, 5);
        }
        int i16 = this.f382349g;
        if (i16 != 0) {
            xjpd8.a(i16, 6);
        }
        long j3 = this.f382350h;
        if (j3 != 0) {
            xjpd8.a(j3, 7);
        }
        int i17 = this.f382351i;
        if (i17 != 0) {
            xjpd8.a(i17, 8);
        }
        String str4 = this.f382352j;
        if (str4 != null) {
            xjpd8.a(str4, 9);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382343a = yunKQ.a(this.f382343a, 0, true);
        this.f382344b = yunKQ.a(this.f382344b, 1, true);
        this.f382345c = yunKQ.b(2, false);
        this.f382346d = yunKQ.b(3, false);
        this.f382347e = yunKQ.b(4, false);
        this.f382348f = yunKQ.a(this.f382348f, 5, false);
        this.f382349g = yunKQ.a(this.f382349g, 6, false);
        this.f382350h = yunKQ.a(this.f382350h, 7, false);
        this.f382351i = yunKQ.a(this.f382351i, 8, false);
        this.f382352j = yunKQ.b(9, false);
    }
}
