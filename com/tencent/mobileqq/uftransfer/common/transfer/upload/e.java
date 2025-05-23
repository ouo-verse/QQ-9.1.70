package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.depend.b;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends com.tencent.mobileqq.uftransfer.depend.b implements a {
    static IPatchRedirector $redirector_;
    private final int C;
    protected boolean D;
    protected String E;
    private b F;

    /* renamed from: m, reason: collision with root package name */
    private final int f305090m;

    e(AppRuntime appRuntime, long j3, int i3, int i16, boolean z16, String str) {
        super(appRuntime, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), str);
            return;
        }
        this.f305090m = i3;
        this.C = i16;
        this.D = z16;
        this.E = str;
    }

    public static e m(AppRuntime appRuntime, long j3, int i3, int i16, boolean z16, String str) {
        return new e(appRuntime, j3, i3, i16, z16, str);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public boolean a(String str, long j3, byte[] bArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), bArr)).booleanValue();
        }
        String str3 = str + "&bmd5=" + com.tencent.mobileqq.uftransfer.depend.a.C(bArr) + "&range=" + String.valueOf(j3);
        b.C8867b c8867b = new b.C8867b(str3, bArr, false);
        c8867b.v("POST");
        c8867b.w(5);
        c8867b.q(this.C);
        c8867b.p(this.f305090m);
        c8867b.t("bytes=" + j3 + "-");
        if (str3 != null) {
            str2 = str3.toLowerCase();
        } else {
            str2 = "";
        }
        if (this.D && str2.startsWith("https")) {
            c8867b.s(true);
            c8867b.r(com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.b.d(str3));
            c8867b.u(this.E);
        }
        return l(c8867b);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public void b(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.F = bVar;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.upload.a
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void i(b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnV1Uploader", 1, "id[" + this.f305127e + "] onError errCode:" + aVar.a() + " errMsg:" + aVar.b());
        this.F.t(aVar.a(), aVar.b(), aVar.c());
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.F.c(str);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.depend.b
    protected void k(b.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        if (cVar.c() < 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFtnV1Uploader", 1, "id[" + this.f305127e + "] onDataErr transferedSize:" + cVar.c());
            this.F.i(9001, "httpServer not has range");
            return;
        }
        this.F.o(cVar.c(), cVar.a());
    }
}
