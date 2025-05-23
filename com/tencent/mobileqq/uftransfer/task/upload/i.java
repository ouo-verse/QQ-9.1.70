package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f305550m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f305551n;

    /* renamed from: o, reason: collision with root package name */
    protected ExcitingTransferUploadResultRp f305552o;

    public i(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, bVar, aVar, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, abstractC8873a);
            return;
        }
        this.f305550m = false;
        this.f305551n = false;
        this.f305552o = null;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.q, com.tencent.mobileqq.uftransfer.task.upload.a
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public void D(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar);
            return;
        }
        if (bVar.n() != null && (bVar.n() instanceof ExcitingTransferUploadResultRp)) {
            this.f305552o = (ExcitingTransferUploadResultRp) bVar.n();
        }
        super.D(bVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.q
    protected int E(com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) fVar)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, "TId[" + p() + "] start c2c extf upload. useIPv6:" + this.f305550m + " useMediaPlat:" + this.f305551n);
        com.tencent.mobileqq.uftransfer.common.transfer.d dVar = new com.tencent.mobileqq.uftransfer.common.transfer.d();
        dVar.u(bVar.i());
        dVar.s(bVar.p());
        dVar.t(Long.valueOf(bVar.q()).longValue());
        dVar.n(69);
        dVar.o(3);
        dVar.p(0);
        dVar.v(this.f305551n);
        dVar.q(bVar.b().a().a());
        dVar.f().l(bVar.d().a());
        dVar.f().m(bVar.d().b());
        dVar.f().n(bVar.d().c());
        dVar.f().o(bVar.d().d());
        if (this.f305551n) {
            dVar.f().p(fVar.r());
        } else {
            dVar.f().p(fVar.q());
        }
        dVar.f().q(fVar.o());
        dVar.f().r(bVar.e());
        dVar.f().s(bVar.o());
        dVar.f().t(bVar.f());
        dVar.l().m(false);
        dVar.l().j(fVar.m());
        ArrayList arrayList = new ArrayList();
        int f16 = com.tencent.mobileqq.uftransfer.depend.a.f(this.f305342a, this.f305550m, 1, arrayList);
        dVar.l().i(arrayList);
        if (f16 != 2 && f16 != 3) {
            fVar.l(false);
        } else {
            fVar.l(true);
            fVar.j(false);
            if (f16 == 3) {
                fVar.j(true);
            }
        }
        fVar.k(false);
        com.tencent.mobileqq.uftransfer.common.transfer.a a16 = com.tencent.mobileqq.uftransfer.common.transfer.c.a(this.f305342a, dVar);
        this.f305476j = a16;
        if (a16 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create extf uploader");
            t("file extf uploader can not create");
            return 9045;
        }
        a16.q(this);
        if (this.f305476j.g(0L)) {
            return 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfUploadFileOp", 1, "TId[" + p() + "] upload error. extf uploader start fail");
        t("run extf upload file fail");
        return AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.q, com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        this.f305552o = null;
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        this.f305550m = bVar.b().a().f();
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = bVar.r();
        if (r16 != null) {
            this.f305551n = r16.y();
        }
        return super.i();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305552o;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64HttpTime;
        }
        return super.w();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public long y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305552o;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64TransferSpeed;
        }
        return super.y();
    }
}
