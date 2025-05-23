package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends UFTC2CUploadTask {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305510l;

    /* renamed from: m, reason: collision with root package name */
    protected l f305511m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) e.this).f305361e) {
                    return;
                }
                e.this.X(aVar.c());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) e.this).f305361e) {
                    return;
                }
                e.this.v(aVar.c(), aVar.d(), aVar.e());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) e.this).f305361e) {
                    return;
                }
                e.this.n0(aVar.c());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
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
            if (((UFTBaseTask) e.this).f305361e) {
                return;
            }
            e eVar = e.this;
            if (aVar.c() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            eVar.o0(z16);
        }
    }

    protected e(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        super(appRuntime, aVar, bVar, aVar2, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, bVar, aVar2, bVar2);
        }
    }

    public static UFTC2CUploadTask U(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        if (UFTBaseTask.c(appRuntime, aVar, bVar, aVar2, "[UFTTransfer] UFTC2CBigFileUploadTask")) {
            return new e(appRuntime, aVar, bVar, aVar2, bVar2);
        }
        return null;
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
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305510l;
        if (aVar != null) {
            aVar.v();
            this.f305510l = null;
        }
        l lVar = this.f305511m;
        if (lVar != null) {
            lVar.v();
            this.f305511m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f305422h != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] calc hash op had do");
            return;
        }
        byte[] d16 = this.f305359c.d().d();
        byte[] a16 = this.f305359c.d().a();
        if (d16 != null && d16.length > 0 && a16 != null && a16.length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] file hash exist and calc hash done");
            X(0);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] calc hash op ...");
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 21L, new a());
        this.f305422h = aVar;
        aVar.x(true);
        int u16 = this.f305422h.u();
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
        if (this.f305423i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] fetch url op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] fetch url op ...");
        this.f305509g.c(this.f305358b, 3, null);
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
        if (i3 == 0) {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void c0(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305510l;
        if (aVar != null) {
            aVar.v();
            this.f305510l = null;
        }
        l lVar = this.f305511m;
        if (lVar != null) {
            lVar.v();
            this.f305511m = null;
        }
        super.c0(bVar);
    }

    protected void l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f305510l != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] calc full sha op had do");
            return;
        }
        byte[] c16 = this.f305359c.d().c();
        if (c16 != null && c16.length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] file hash exist and calc full sha done");
            n0(0);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] calc full sha op...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 8L, new c());
        this.f305510l = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            n0(u16);
        }
    }

    protected void m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f305511m != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] upload hit op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] upload hit op ...");
        l lVar = new l(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new d());
        this.f305511m = lVar;
        lVar.u();
    }

    protected void n0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] on calc full sha done. errCode:" + i3);
        if (i3 != 0) {
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        m0();
    }

    protected void o0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] on upload hit done. hit:" + z16);
        if (!z16) {
            return;
        }
        Y();
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305510l;
        if (aVar != null) {
            aVar.v();
            this.f305510l = null;
        }
        q qVar = this.f305424j;
        if (qVar != null) {
            qVar.v();
            this.f305424j = null;
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask, com.tencent.mobileqq.uftransfer.task.upload.d
    public void v(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, str2);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] on fetch url op done errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            N(i3, V(3, str));
            return;
        }
        Y();
        if (this.f305359c.d().c() != null && this.f305359c.d().c().length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CBigFileUploadTask", 1, "TId[" + d() + "] on fetch url op done. getted sha and do hit");
            this.f305509g.b(this.f305358b, this.f305359c.d());
            com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305510l;
            if (aVar != null) {
                aVar.v();
                this.f305510l = null;
            }
            m0();
        }
        O();
    }
}
