package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305516o;

    /* renamed from: p, reason: collision with root package name */
    protected l f305517p;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) f.this).f305361e) {
                    return;
                }
                f.this.X(aVar.c());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) f.this).f305361e) {
                    return;
                }
                f.this.v(aVar.c(), aVar.d(), aVar.e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) f.this).f305361e) {
                    return;
                }
                f.this.D0(aVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (((UFTBaseTask) f.this).f305361e) {
                return;
            }
            f fVar = f.this;
            if (aVar.c() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            fVar.E0(z16);
        }
    }

    protected f(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        super(appRuntime, aVar, bVar, aVar2, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, bVar, aVar2, bVar2);
        }
    }

    public static f C0(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        if (UFTBaseTask.c(appRuntime, aVar, bVar, aVar2, "[UFTTransfer] UFTC2CBigFileUploadTask")) {
            return new f(appRuntime, aVar, bVar, aVar2, bVar2);
        }
        return null;
    }

    protected void A0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f305516o != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] CalcFullShaOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] doCalcFullShaOp...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 8L, new c());
        this.f305516o = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            D0(u16);
        }
    }

    protected void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f305517p != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] UploadHitOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] doUploadHitOp...");
        l lVar = new l(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new d());
        this.f305517p = lVar;
        lVar.u();
    }

    protected void D0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] onCalcFullShaOpDone errCode:" + i3);
        if (i3 != 0) {
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        B0();
        O();
    }

    protected void E0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] onUploadHitOpDone hit:" + z16);
        if (!z16) {
            return;
        }
        Y();
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305516o;
        if (aVar != null) {
            aVar.v();
            this.f305516o = null;
        }
        q qVar = this.f305424j;
        if (qVar != null) {
            qVar.v();
            this.f305424j = null;
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.H();
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305516o;
        if (aVar != null) {
            aVar.v();
            this.f305516o = null;
        }
        l lVar = this.f305517p;
        if (lVar != null) {
            lVar.v();
            this.f305517p = null;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.j, com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    protected void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f305553l) {
            super.I();
            return;
        }
        if (this.f305422h != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] CalcHashOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] doCalcHashOp...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 21L, new a());
        this.f305422h = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            X(u16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305553l) {
            super.J();
            return;
        }
        if (this.f305423i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] FetchUrlOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] doFetchUrlOp...");
        m mVar = new m(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new b());
        this.f305423i = mVar;
        int u16 = mVar.u();
        if (u16 != 0) {
            v(u16, this.f305423i.o(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void X(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        super.X(i3);
        if (!this.f305553l && i3 == 0) {
            A0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void c0(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if (!this.f305553l) {
            com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305516o;
            if (aVar != null) {
                aVar.v();
                this.f305516o = null;
            }
            l lVar = this.f305517p;
            if (lVar != null) {
                lVar.v();
                this.f305517p = null;
            }
        }
        super.c0(bVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.j
    protected UFTC2CUploadTask r0(com.tencent.mobileqq.uftransfer.task.a aVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (UFTC2CUploadTask) iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar, (Object) bVar);
        }
        byte[] c16 = this.f305359c.d().c();
        byte[] a16 = this.f305359c.d().a();
        if (c16 != null && c16.length > 0 && a16 != null && a16.length > 0) {
            return UFTC2CUploadTask.U(this.f305357a, this.f305358b, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, aVar, bVar);
        }
        return e.U(this.f305357a, this.f305358b, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask, com.tencent.mobileqq.uftransfer.task.upload.d
    public void v(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.f305553l) {
            super.v(i3, str, str2);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] onFetchUrlOpDone errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            N(i3, V(3, str));
            return;
        }
        Y();
        if (this.f305359c.d().c() != null && this.f305359c.d().c().length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] onFetchUrlOpDone getted sha and do hit");
            this.f305509g.b(this.f305358b, this.f305359c.d());
            com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305516o;
            if (aVar != null) {
                aVar.v();
                this.f305516o = null;
            }
            B0();
            O();
        }
    }
}
