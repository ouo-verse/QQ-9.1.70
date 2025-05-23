package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class t extends a {
    static IPatchRedirector $redirector_;

    public t(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, cVar, aVar, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, cVar, aVar, abstractC8873a);
        }
    }

    private int E(com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar, com.tencent.mobileqq.uftransfer.task.taskinfo.g gVar) {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] start disc ftn upload.");
        com.tencent.mobileqq.uftransfer.common.transfer.h hVar = new com.tencent.mobileqq.uftransfer.common.transfer.h();
        hVar.h(cVar.i());
        hVar.g(cVar.p());
        hVar.i(cVar.o());
        hVar.p(gVar.e());
        hVar.q(gVar.b());
        hVar.v(gVar.n());
        hVar.w(gVar.o());
        List<String> a16 = gVar.a();
        if (a16 != null && a16.size() != 0) {
            hVar.o(a16);
            hVar.r(gVar.c());
            com.tencent.mobileqq.uftransfer.common.transfer.a b16 = com.tencent.mobileqq.uftransfer.common.transfer.c.b(this.f305342a, hVar);
            this.f305476j = b16;
            if (b16 == null) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create ftn uploader");
                t("file uploader can not create");
                return 9045;
            }
            b16.q(this);
            if (!this.f305476j.g(0L)) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] upload error. ftn uploader start fail");
                t("run upload file fail");
                return AppConstants.RichMediaErrorCode.ERROR_UNKOWN_EXCEPTION;
            }
            return 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] upload error. no host");
        t("no host list");
        return 9048;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] do start disc upload op");
        com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305343b;
        com.tencent.mobileqq.uftransfer.task.taskinfo.g r16 = cVar.r();
        if (r16 == null) {
            t("upload file srv busi info is null");
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadFileOp", 1, "TId[" + p() + "] do start disc upload fail. srv busi info is null");
            return 9005;
        }
        return E(cVar, r16);
    }
}
