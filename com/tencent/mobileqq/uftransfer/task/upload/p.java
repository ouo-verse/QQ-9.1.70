package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import mqq.app.AppRuntime;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class p extends UFTBaseOp {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements g.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.b
        public void a(boolean z16, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                return;
            }
            if (((UFTBaseOp) p.this).f305346e) {
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CSetUploadSucOp", 1, "TId[" + p.this.p() + "] on set upload suc result. reqSuc:" + z16 + " errCode:" + i3 + " errmsg:" + str);
            UFTBaseOp.a aVar = new UFTBaseOp.a();
            aVar.f(i3);
            aVar.g(str);
            p.this.r(aVar);
        }
    }

    public p(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar2) {
        super(appRuntime, bVar, aVar, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, bVar2);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CSetUploadSucOp", 1, "TId[" + p() + "] do set upload suc op");
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        com.tencent.mobileqq.uftransfer.proto.a aVar = new com.tencent.mobileqq.uftransfer.proto.a();
        try {
            j3 = Long.parseLong(this.f305342a.getCurrentAccountUin());
        } catch (NumberFormatException unused) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CSetUploadSucOp", 1, "TId[" + p() + "] send uin err.");
            j3 = 0;
        }
        aVar.k(j3);
        aVar.j(Long.parseLong(bVar.q().replace(Marker.ANY_NON_NULL_MARKER, "")));
        aVar.g(bVar.u());
        aVar.h(bVar.v());
        aVar.i(bVar.w());
        if (bVar.c() == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CSetUploadSucOp", 1, "TId[" + p() + "] do set upload suc fail. file id is null");
            t("uuid is null");
            return 9005;
        }
        aVar.o(bVar.c().getBytes());
        aVar.p(bVar.s());
        if (!com.tencent.mobileqq.uftransfer.proto.g.b().j(this.f305342a, aVar, new a())) {
            t("request set upload suc fail");
            return 9001;
        }
        return 0;
    }
}
