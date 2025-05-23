package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.upload.k;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m extends k {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements g.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.a
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), dVar);
            } else {
                if (((UFTBaseOp) m.this).f305346e) {
                    return;
                }
                m.this.z(z16, dVar);
            }
        }
    }

    public m(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar2) {
        super(appRuntime, bVar, aVar, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, bVar2);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected void B(com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV2Op", 1, "TId[" + p() + "] request c2c upload url v2 suc rsp:" + dVar.toString());
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(0);
        com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.f(dVar);
        if (!this.f305562l) {
            k.a x16 = x(dVar);
            String a16 = com.tencent.mobileqq.uftransfer.depend.a.a(dVar.e());
            if (dVar.d() == 1) {
                String str = "/?ver=2&ukey=" + a16 + "&filekey=" + this.f305564n + "&filesize=" + this.f305343b.f();
                fVar.k(x16.f305566b);
                fVar.h(x16.f305567c);
                fVar.g(x16.f305565a);
                fVar.i(str);
                fVar.l(x16.f305568d);
            } else if (dVar.d() == 2) {
                fVar.k(x16.f305566b);
                fVar.h(x16.f305567c);
                fVar.g(x16.f305565a);
                fVar.i("/ftn_handler");
                fVar.l(x16.f305568d);
                fVar.A(a16);
            } else {
                aVar.f(9045);
                aVar.g("upload param error");
            }
        }
        D(fVar);
        r(aVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected boolean C(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV2Op", 1, "TId[" + p() + "] request c2c upload url v2.");
        return com.tencent.mobileqq.uftransfer.proto.g.b().d(this.f305342a, cVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    public void D(com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fVar);
            return;
        }
        if (fVar != null && fVar.n() != null && fVar.n().length > 0) {
            this.f305343b.d().k(fVar.n());
        }
        super.D(fVar);
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
        cVar.w(this.f305343b.d().d());
        return 0;
    }
}
