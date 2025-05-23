package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ab extends a {
    static IPatchRedirector $redirector_;

    public ab(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, dVar, aVar, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, dVar, aVar, abstractC8873a);
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

    protected int E(com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.taskinfo.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar, (Object) hVar)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] start troop ftn upload.");
        com.tencent.mobileqq.uftransfer.common.transfer.h hVar2 = new com.tencent.mobileqq.uftransfer.common.transfer.h();
        hVar2.h(dVar.i());
        hVar2.g(dVar.t());
        hVar2.i(dVar.s());
        hVar2.p(hVar.e());
        hVar2.q(hVar.b());
        hVar2.v(hVar.u());
        hVar2.w(hVar.v());
        hVar2.x("TroopFile");
        hVar2.j(true);
        List<String> a16 = hVar.a();
        if (a16 != null && a16.size() != 0) {
            hVar2.o(a16);
            hVar2.r(hVar.c());
            com.tencent.mobileqq.uftransfer.common.transfer.a b16 = com.tencent.mobileqq.uftransfer.common.transfer.c.b(this.f305342a, hVar2);
            this.f305476j = b16;
            if (b16 == null) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create ftn uploader");
                t("ftn fileUploader cannot create");
                return 3;
            }
            b16.q(this);
            if (!this.f305476j.g(0L)) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] upload error. ftn uploader start fail");
                t("run upload file fail");
                return 4;
            }
            return 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] upload error. no host");
        t("no host list");
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] do start troop upload op");
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305343b;
        com.tencent.mobileqq.uftransfer.task.taskinfo.h w3 = dVar.w();
        if (w3 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadFileOp", 1, "TId[" + p() + "] do start troop upload fail. srv busi info is null");
            t("upload file srv busi info is null");
            return 1;
        }
        return E(dVar, w3);
    }
}
