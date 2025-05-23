package com.tencent.mobileqq.uftransfer.task.commonop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.common.UFTHashCalculator;
import com.tencent.mobileqq.uftransfer.depend.c;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends UFTBaseOp implements UFTHashCalculator.b {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected final String f305363j;

    /* renamed from: k, reason: collision with root package name */
    protected final long f305364k;

    /* renamed from: l, reason: collision with root package name */
    protected long f305365l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f305366m;

    public a(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar2, String str, long j3, UFTBaseOp.b bVar) {
        super(appRuntime, aVar, aVar2, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, aVar2, str, Long.valueOf(j3), bVar);
            return;
        }
        this.f305365l = 0L;
        this.f305366m = false;
        this.f305363j = str;
        this.f305364k = j3;
    }

    private boolean w(long j3) {
        byte[] c16;
        byte[] d16;
        byte[] b16;
        byte[] a16;
        if ((1 & j3) != 0 && ((a16 = this.f305343b.d().a()) == null || a16.length == 0)) {
            c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] no 10m md5 calc result");
            return false;
        }
        if ((2 & j3) != 0 && ((b16 = this.f305343b.d().b()) == null || b16.length == 0)) {
            c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] no md5 calc result");
            return false;
        }
        if (this.f305366m && (4 & j3) != 0 && ((d16 = this.f305343b.d().d()) == null || d16.length == 0)) {
            c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] no sha3 calc result");
            return false;
        }
        if ((j3 & 8) == 0 || ((c16 = this.f305343b.d().c()) != null && c16.length != 0)) {
            return true;
        }
        c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] no sha calc result");
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.b
    public void a(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        } else {
            q(j17, j16);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.b
    public void b(long j3, int i3, UFTHashCalculator.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), cVar);
            return;
        }
        if (this.f305346e) {
            return;
        }
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        if (i3 != 0) {
            c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] on calc hash fail. errCode:" + i3);
            aVar.f(i3);
            r(aVar);
            return;
        }
        c.c("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] on calc hash suc:");
        if (cVar.getFileSize() > 0 && this.f305343b.d().f() == 0) {
            this.f305343b.d().n(cVar.getFileSize());
        }
        if (cVar.d() != null && cVar.d().length > 0) {
            this.f305343b.d().i(cVar.d());
        }
        if (cVar.a() != null && cVar.a().length > 0) {
            this.f305343b.d().j(cVar.a());
        }
        if (cVar.c() != null && cVar.c().length > 0) {
            this.f305343b.d().l(cVar.c());
        }
        if (cVar.b() != null && cVar.b().length > 0) {
            this.f305343b.d().k(cVar.b());
        }
        this.f305343b.d().p(cVar.f());
        this.f305343b.d().o(cVar.e());
        this.f305343b.d().m(cVar.getVideoDuration());
        if (w(this.f305364k)) {
            aVar.f(0);
        } else {
            aVar.f(7);
        }
        r(aVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.b
    public void e(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            q(j16, 0L);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f305366m) {
            j3 = 0;
        } else {
            j3 = 4;
        }
        long m3 = UFTHashCalculator.o().m(this.f305363j, this.f305364k, j3, this);
        this.f305365l = m3;
        if (m3 == 0) {
            c.b("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "run calc hash fail.");
            this.f305346e = false;
            return 6;
        }
        c.c("[UFTTransfer] UFTCalcHashOp", 1, "TId[" + p() + "] do calc hash op. calcId:" + this.f305365l + " calcWhat:" + this.f305364k + " ignoreWhat:" + j3);
        return 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            if (this.f305346e) {
                return;
            }
            super.v();
            UFTHashCalculator.o().n(this.f305365l);
            this.f305365l = 0L;
        }
    }

    public void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f305366m = z16;
        }
    }
}
