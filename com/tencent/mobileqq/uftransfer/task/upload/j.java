package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j extends UFTC2CUploadTask {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f305553l;

    /* renamed from: m, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.api.b f305554m;

    /* renamed from: n, reason: collision with root package name */
    protected UFTC2CUploadTask f305555n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else {
                if (((UFTBaseTask) j.this).f305361e) {
                    return;
                }
                j.this.X(aVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends a.AbstractC8873a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) j.this).f305361e) {
                j.this.c0((a.b) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            } else if (!((UFTBaseTask) j.this).f305361e) {
                j.this.f305508f.K(j3);
                j jVar = j.this;
                jVar.f305509g.h(((UFTBaseTask) jVar).f305358b, ((UFTBaseTask) j.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, obj);
            } else if (!((UFTBaseTask) j.this).f305361e) {
                j.this.p0(j3, i3, new ad(4, str, str2, true, obj));
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            j.this.f305508f.H(str);
            com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = j.this.f305508f;
            iVar.N(iVar.t() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements com.tencent.mobileqq.uftransfer.task.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.a
        public void a(UFTBaseTask uFTBaseTask, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                j.this.g(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uFTBaseTask, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements com.tencent.mobileqq.uftransfer.api.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, this, aVar, bundle, dVar)).intValue();
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                return bVar.a(aVar, bundle, dVar);
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void b(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar, (Object) hVar);
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.b(aVar, hVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void c(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, aVar, Integer.valueOf(i3), bundle);
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.c(aVar, i3, bundle);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void d(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.i iVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) iVar);
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.d(aVar, iVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void e(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, aVar, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.e(aVar, j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, aVar, Integer.valueOf(i3), cVar);
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.f(aVar, i3, cVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, aVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                return;
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = j.this.f305554m;
            if (bVar != null) {
                bVar.h(aVar, j3, j16, j17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        super(appRuntime, aVar, bVar, aVar2, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, bVar, aVar2, bVar2);
            return;
        }
        this.f305555n = null;
        this.f305553l = bVar.b().a().g();
        this.f305554m = bVar2;
    }

    public static j s0(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        if (UFTBaseTask.c(appRuntime, aVar, bVar, aVar2, "[UFTTransfer] UFTC2CExtfUploadTask")) {
            return new j(appRuntime, aVar, bVar, aVar2, bVar2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.f305553l) {
            o0();
        } else {
            super.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void N(int i3, ad adVar) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) adVar);
            return;
        }
        if (this.f305361e) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] do upload completed errCode:" + i3 + " errMsg:" + adVar.f305496b);
        H();
        ExcitingTransferUploadResultRp d16 = this.f305508f.d();
        if (i3 != 0) {
            if (this.f305359c.b().a().b() && adVar.f305499e) {
                com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] ready to do safeGuard upload");
                q0(i3, adVar);
                return;
            }
            this.f305508f.y(System.currentTimeMillis());
            if (adVar.f305499e) {
                i16 = com.tencent.mobileqq.uftransfer.task.utils.b.b(i3);
            } else {
                d0(this.f305508f.q(), i3, adVar);
                i16 = i3;
            }
            e0(this.f305508f.q(), i16, adVar);
            u0(i3, d16);
        } else {
            this.f305508f.y(System.currentTimeMillis());
            f0();
            u0(0, d16);
        }
        this.f305509g.f(this.f305358b, i3, R(i3, adVar));
        p(i3);
        g(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f305424j != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] UploadFileOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] doUploadFileOp...");
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        i iVar = new i(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new b());
        this.f305424j = iVar;
        int u16 = iVar.u();
        if (u16 != 0) {
            a.b bVar = new a.b();
            bVar.f(u16);
            bVar.g(this.f305424j.o());
            c0(bVar);
            return;
        }
        this.f305508f.H(this.f305424j.B());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public ac R(int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ac) iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) adVar);
        }
        ac R = super.R(i3, adVar);
        R.i(true);
        return R;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    protected int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask
    public void g0(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else {
            t0();
            super.g0(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask, com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f305555n = null;
        return super.h();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask, com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        if (this.f305555n != null) {
            this.f305508f.y(System.currentTimeMillis());
            this.f305361e = true;
            i(3);
            this.f305555n.k(bundle);
            this.f305555n = null;
            return;
        }
        super.k(bundle);
    }

    protected void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f305422h != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] CalcHashOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] doCalcHashOp...");
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 31L, new a());
        this.f305422h = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            X(u16);
        }
    }

    protected void p0(long j3, int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3), adVar);
            return;
        }
        ExcitingTransferUploaderRp a16 = adVar.a();
        if (i3 != 0) {
            int b16 = com.tencent.mobileqq.uftransfer.task.utils.b.b(i3);
            if (a16 != null) {
                adVar.f305500f = a16.mu64HttpTime;
                adVar.f305501g = a16.mu64TransferSpeed;
            }
            d0(j3, b16, adVar);
        }
        if (a16 != null) {
            v0(i3, a16);
        }
    }

    protected void q0(int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) adVar);
            return;
        }
        u0(i3, this.f305508f.d());
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        String c16 = bVar.c();
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = bVar.r();
        boolean g16 = bVar.b().a().g();
        bVar.j("");
        bVar.b().a().k(false);
        bVar.b().a().i(false);
        bVar.b().a().n(false);
        bVar.A(null);
        UFTC2CUploadTask r06 = r0(new c(), new d());
        this.f305555n = r06;
        if (r06 == null || !r06.j()) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CExtfUploadTask", 1, "TId[" + d() + "] do safeGuard upload fail");
            this.f305508f.y(System.currentTimeMillis());
            bVar.j(c16);
            bVar.A(r16);
            bVar.b().a().n(g16);
            e0(this.f305508f.q(), com.tencent.mobileqq.uftransfer.task.utils.b.b(i3), adVar);
            this.f305509g.f(this.f305358b, i3, R(i3, adVar));
            g(i3);
        }
    }

    protected UFTC2CUploadTask r0(com.tencent.mobileqq.uftransfer.task.a aVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (UFTC2CUploadTask) iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar, (Object) bVar);
        }
        return UFTC2CUploadTask.U(this.f305357a, this.f305358b, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, aVar, bVar);
    }

    protected void t0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        g gVar = new g(this.f305357a);
        gVar.h(33);
        gVar.i(bVar.i());
        gVar.k(Long.valueOf(bVar.q()).longValue(), 0L, bVar.e(), com.tencent.mobileqq.uftransfer.depend.a.l(bVar.e()), bVar.f());
        gVar.f(this.f305508f.u());
        long c16 = this.f305508f.c() - this.f305508f.m();
        if (c16 > 0) {
            gVar.j(c16);
        } else {
            gVar.j(0L);
        }
        long b16 = this.f305508f.b() - this.f305508f.l();
        if (b16 > 0) {
            gVar.c(b16);
        } else {
            gVar.c(0L);
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
        excitingTransferUploadResultRp.mbIsXTFValid = true;
        excitingTransferUploadResultRp.mnResult = 33;
        gVar.d(excitingTransferUploadResultRp);
        gVar.l(T());
        gVar.g(false);
        gVar.b(false);
    }

    protected void u0(int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        boolean z16;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) excitingTransferUploadResultRp);
            return;
        }
        if (i3 == 9037) {
            t0();
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        g gVar = new g(this.f305357a);
        boolean z17 = true;
        if (excitingTransferUploadResultRp != null) {
            i16 = com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploadResultRp.mstrServerIp);
            if (excitingTransferUploadResultRp.mnResult != 0) {
                z17 = false;
            }
            gVar.d(excitingTransferUploadResultRp);
            z16 = z17;
        } else {
            if (i3 != 0) {
                z17 = false;
            }
            if (!z17) {
                if (this.f305508f.s() == 0) {
                    gVar.h(i3);
                } else {
                    gVar.h(17);
                }
            } else {
                gVar.h(0);
            }
            z16 = z17;
            i16 = 0;
        }
        gVar.i(bVar.i());
        boolean z18 = z16;
        gVar.k(Long.valueOf(bVar.q()).longValue(), 0L, bVar.e(), com.tencent.mobileqq.uftransfer.depend.a.l(bVar.e()), bVar.f());
        gVar.f(this.f305508f.u());
        long c16 = this.f305508f.c() - this.f305508f.m();
        if (c16 > 0) {
            gVar.j(c16);
        } else {
            gVar.j(0L);
        }
        long b16 = this.f305508f.b() - this.f305508f.l();
        if (b16 > 0) {
            gVar.c(b16);
        } else {
            gVar.c(0L);
        }
        gVar.l(T());
        gVar.e(i16);
        gVar.g(false);
        gVar.b(z18);
    }

    protected void v0(int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) excitingTransferUploaderRp);
            return;
        }
        if (excitingTransferUploaderRp == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = bVar.r();
        boolean z16 = true;
        if (r16 != null && r16.f()) {
            if (r16.d()) {
                i16 = 3;
            } else {
                i16 = 2;
            }
        } else {
            i16 = 1;
        }
        h hVar = new h(this.f305357a);
        hVar.g(d());
        String l3 = com.tencent.mobileqq.uftransfer.depend.a.l(this.f305359c.e());
        hVar.f(i3);
        hVar.h(Long.valueOf(bVar.q()).longValue(), 0L, bVar.e(), l3, bVar.f());
        hVar.c(excitingTransferUploaderRp);
        hVar.i(i16);
        hVar.d(com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploaderRp.mstrServerIp));
        hVar.e(false);
        if (i3 != 0) {
            z16 = false;
        }
        hVar.b(z16);
    }
}
