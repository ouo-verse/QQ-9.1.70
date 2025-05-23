package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class x extends ab {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f305644m;

    /* renamed from: n, reason: collision with root package name */
    protected ExcitingTransferUploadResultRp f305645n;

    public x(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, a.AbstractC8873a abstractC8873a) {
        super(appRuntime, dVar, aVar, abstractC8873a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, dVar, aVar, abstractC8873a);
        } else {
            this.f305644m = false;
            this.f305645n = null;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.ab, com.tencent.mobileqq.uftransfer.task.upload.a
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
            this.f305645n = (ExcitingTransferUploadResultRp) bVar.n();
        }
        super.D(bVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.ab
    protected int E(com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.taskinfo.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar, (Object) hVar)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] start troop extf upload. useIPv6:" + this.f305644m);
        com.tencent.mobileqq.uftransfer.common.transfer.d dVar2 = new com.tencent.mobileqq.uftransfer.common.transfer.d();
        dVar2.u(dVar.i());
        dVar2.s(dVar.t());
        dVar2.t(Long.valueOf(dVar.u()).longValue());
        dVar2.n(71);
        dVar2.o(102);
        dVar2.p(1);
        dVar2.r(Long.valueOf(dVar.u()).longValue());
        dVar2.f().l(dVar.d().a());
        dVar2.f().m(dVar.d().b());
        dVar2.f().n(dVar.d().c());
        dVar2.f().o(dVar.d().d());
        dVar2.f().p(hVar.n());
        dVar2.f().q(hVar.o());
        dVar2.f().r(dVar.e());
        dVar2.f().s(dVar.s());
        dVar2.f().t(dVar.f());
        dVar2.l().m(false);
        ArrayList arrayList = new ArrayList();
        int f16 = com.tencent.mobileqq.uftransfer.depend.a.f(this.f305342a, this.f305644m, 3, arrayList);
        dVar2.l().i(arrayList);
        ArrayList arrayList2 = new ArrayList();
        List<String> q16 = hVar.q();
        int s16 = hVar.s();
        if (q16 != null && q16.size() > 0) {
            Iterator<String> it = q16.iterator();
            while (it.hasNext()) {
                arrayList2.add(new com.tencent.mobileqq.uftransfer.api.j(it.next(), s16));
            }
        }
        dVar2.l().k(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        List<String> r16 = hVar.r();
        if (r16 != null && r16.size() > 0) {
            Iterator<String> it5 = r16.iterator();
            while (it5.hasNext()) {
                arrayList3.add(new com.tencent.mobileqq.uftransfer.api.j(it5.next(), s16));
            }
        }
        dVar2.l().l(arrayList3);
        if (f16 != 2 && f16 != 3) {
            hVar.l(false);
        } else {
            hVar.l(true);
            hVar.j(false);
            if (f16 == 3) {
                hVar.j(true);
            }
        }
        hVar.k(false);
        com.tencent.mobileqq.uftransfer.common.transfer.a a16 = com.tencent.mobileqq.uftransfer.common.transfer.c.a(this.f305342a, dVar2);
        this.f305476j = a16;
        if (a16 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] upload error. cannot create extf uploader");
            t("file uploader cannt create");
            return 3;
        }
        a16.q(this);
        if (this.f305476j.g(0L)) {
            return 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadFileOp", 1, "TId[" + p() + "] upload error. extf uploader start fail");
        t("run upload file fail");
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.ab, com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        this.f305645n = null;
        this.f305644m = ((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305343b).b().a().f();
        return super.i();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.a
    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305645n;
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
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = this.f305645n;
        if (excitingTransferUploadResultRp != null) {
            return excitingTransferUploadResultRp.mu64TransferSpeed;
        }
        return super.y();
    }
}
