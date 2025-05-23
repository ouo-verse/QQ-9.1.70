package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.upload.k;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class n extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f305573o;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements g.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.a
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), dVar);
            } else {
                if (((UFTBaseOp) n.this).f305346e) {
                    return;
                }
                n.this.z(z16, dVar);
            }
        }
    }

    public n(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar2) {
        super(appRuntime, bVar, aVar, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, bVar2);
            return;
        }
        this.f305573o = false;
        if (this.f305562l) {
            this.f305573o = bVar.b().a().g();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected void B(com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV3Op", 1, "TId[" + p() + "] request c2c upload url v3 suc rsp:" + dVar.toString());
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        aVar.f(0);
        com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.f(dVar);
        if (dVar.p()) {
            fVar.z(true);
            D(fVar);
            aVar.f(dVar.i());
            aVar.g(dVar.j());
            r(aVar);
            return;
        }
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
                if (TextUtils.isEmpty(fVar.u())) {
                    fVar.B(com.tencent.mobileqq.uftransfer.depend.a.z(this.f305343b.d().c()));
                }
            } else {
                aVar.f(9045);
                aVar.g("upload rsp param error. svr api ver no support");
            }
        }
        D(fVar);
        r(aVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    protected boolean C(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlV3Op", 1, "TId[" + p() + "] request c2c upload url v3.");
        return com.tencent.mobileqq.uftransfer.proto.g.b().f(this.f305342a, cVar, new a());
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
        cVar.x(bVar.d().b());
        cVar.l(this.f305573o);
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.k
    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.y() + " useMediaPat:" + this.f305573o;
    }
}
