package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class q extends a {
    static IPatchRedirector $redirector_;

    public q(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, bVar, aVar, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, abstractC8873a);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    protected int E(com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar, (Object) fVar)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] start c2c ftn upload. ftn apiver:" + fVar.p());
        if (fVar.p() == 1) {
            com.tencent.mobileqq.uftransfer.common.transfer.i iVar = new com.tencent.mobileqq.uftransfer.common.transfer.i();
            iVar.h(bVar.i());
            iVar.g(bVar.p());
            iVar.i(bVar.o());
            List<String> a16 = fVar.a();
            iVar.p(fVar.e());
            iVar.q(fVar.b());
            if (a16 != null && a16.size() != 0) {
                iVar.o(a16);
                iVar.r(fVar.c());
                this.f305476j = com.tencent.mobileqq.uftransfer.common.transfer.c.c(this.f305342a, iVar);
            } else {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] upload error. no host");
                t("no host list");
                return 9048;
            }
        } else if (fVar.p() == 2) {
            com.tencent.mobileqq.uftransfer.common.transfer.h hVar = new com.tencent.mobileqq.uftransfer.common.transfer.h();
            hVar.h(bVar.i());
            hVar.g(bVar.p());
            hVar.i(bVar.o());
            hVar.p(fVar.e());
            hVar.q(fVar.b());
            hVar.v(fVar.s());
            hVar.w(fVar.u());
            List<String> a17 = fVar.a();
            if (a17 != null && a17.size() != 0) {
                hVar.o(a17);
                hVar.r(fVar.c());
                this.f305476j = com.tencent.mobileqq.uftransfer.common.transfer.c.b(this.f305342a, hVar);
            } else {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] upload error. no host");
                t("no host list");
                return 9048;
            }
        }
        com.tencent.mobileqq.uftransfer.common.transfer.a aVar = this.f305476j;
        if (aVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create ftn uploader");
            t("file uploader can not create");
            return 9045;
        }
        aVar.q(this);
        if (!this.f305476j.g(0L)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] upload error. ftn uploader start fail");
            t("run upload file fail");
            return AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] do start c2c upload op");
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = bVar.r();
        if (r16 == null) {
            t("upload file srv busi info is null");
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadFileOp", 1, "TId[" + p() + "] do start c2c upload fail. srv busi info is null");
            return 9005;
        }
        return E(bVar, r16);
    }
}
