package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l extends k {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements g.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.a
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), dVar);
            } else {
                if (((UFTBaseOp) l.this).f305346e) {
                    return;
                }
                l.this.z(z16, dVar);
            }
        }
    }

    public l(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar2) {
        super(appRuntime, bVar, aVar, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, bVar2);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected void B(com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, "TId[" + p() + "] request c2c upload url v2hit suc rsp:" + dVar.toString());
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(1);
        if (dVar.i() == 0 && dVar.o() != null && dVar.o().length > 0) {
            com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.f(dVar);
            fVar.z(true);
            D(fVar);
            aVar.f(0);
        }
        aVar.g(dVar.j());
        r(aVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected boolean C(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, "TId[" + p() + "] request c2c upload url v2hit.");
        return com.tencent.mobileqq.uftransfer.proto.g.b().e(this.f305342a, cVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    public int w(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar)).intValue();
        }
        int w3 = super.w(cVar);
        if (w3 != 0) {
            return w3;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        cVar.w(bVar.d().d());
        cVar.y(bVar.d().c());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    public void z(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), dVar);
            return;
        }
        if (!z16) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlV2HitOp", 1, "TId[" + p() + "] request c2c upload url v2hit fail. errCode:" + dVar.i());
            UFTBaseOp.a aVar = new UFTBaseOp.a();
            aVar.f(dVar.i());
            aVar.g(dVar.j());
            r(aVar);
            return;
        }
        B(dVar);
    }
}
