package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class y extends UFTTroopUploadTask {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.api.b f305646l;

    /* renamed from: m, reason: collision with root package name */
    protected UFTTroopUploadTask f305647m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends a.AbstractC8873a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) y.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) y.this).f305361e) {
                y.this.c0((a.b) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            } else if (!((UFTBaseTask) y.this).f305361e) {
                y.this.f305508f.K(j3);
                y yVar = y.this;
                yVar.f305509g.h(((UFTBaseTask) yVar).f305358b, ((UFTBaseTask) y.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, obj);
                return;
            }
            if (!((UFTBaseTask) y.this).f305361e && i3 != 0) {
                UFTTroopUploadTask.e eVar = new UFTTroopUploadTask.e(4, str, str2, true, obj);
                if (i3 != 0) {
                    eVar.b(com.tencent.mobileqq.uftransfer.task.utils.b.c(i3), com.tencent.mobileqq.uftransfer.task.utils.b.e(i3), 3, com.tencent.mobileqq.uftransfer.task.utils.b.d(i3));
                } else {
                    eVar.b(0, 0, 0, 0);
                }
                eVar.f305452n = i3;
                y.this.n0(j3, eVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            y.this.f305508f.H(str);
            com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = y.this.f305508f;
            iVar.N(iVar.t() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements com.tencent.mobileqq.uftransfer.task.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) y.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.a
        public void a(UFTBaseTask uFTBaseTask, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                y.this.g(i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uFTBaseTask, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements com.tencent.mobileqq.uftransfer.api.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) y.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.b
        public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, this, aVar, bundle, dVar)).intValue();
            }
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
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
            com.tencent.mobileqq.uftransfer.api.b bVar = y.this.f305646l;
            if (bVar != null) {
                bVar.h(aVar, j3, j16, j17);
            }
        }
    }

    protected y(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        super(appRuntime, aVar, dVar, aVar2, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, dVar, aVar2, bVar);
        } else {
            this.f305647m = null;
            this.f305646l = bVar;
        }
    }

    public static y q0(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        if (UFTBaseTask.c(appRuntime, aVar, dVar, aVar2, "[UFTTransfer] UFTTroopExtfUploadTask")) {
            return new y(appRuntime, aVar, dVar, aVar2, bVar);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    protected void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f305438h = false;
            J();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    protected void N(int i3, UFTTroopUploadTask.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) eVar);
            return;
        }
        if (this.f305361e) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopExtfUploadTask", 1, "TId[" + d() + "] do upload completed errCode:" + i3 + " errMsg:" + eVar.f305496b);
        I();
        ExcitingTransferUploadResultRp d16 = this.f305508f.d();
        if (i3 != 0) {
            if (this.f305359c.b().a().b() && eVar.f305499e) {
                com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTTroopExtfUploadTask", 1, "TId[" + d() + "] ready to do safeGuard upload...");
                o0(i3, eVar);
                return;
            }
            this.f305508f.y(System.currentTimeMillis());
            if (!eVar.f305499e) {
                d0(this.f305508f.q(), eVar);
            }
            e0(eVar);
            int i16 = eVar.f305452n;
            if (!eVar.f305499e || i16 == 0) {
                i16 = com.tencent.mobileqq.uftransfer.task.utils.b.a(eVar.f305447i);
            }
            int i17 = eVar.f305446h;
            if (i17 != 8 && i17 != 11 && i17 != 12) {
                s0(i16, d16);
            } else {
                r0();
            }
        } else {
            this.f305508f.y(System.currentTimeMillis());
            f0();
            s0(0, d16);
        }
        this.f305509g.f(this.f305358b, i3, R(eVar));
        p(i3);
        g(i3);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    protected void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f305441k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, "TId[" + d() + "] UploadFileOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopExtfUploadTask", 1, "TId[" + d() + "] doUploadFileOp...");
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        x xVar = new x(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c, this.f305358b, new a());
        this.f305441k = xVar;
        int u16 = xVar.u();
        if (u16 != 0) {
            a.b bVar = new a.b();
            bVar.f(u16);
            bVar.g("start upload file op fail");
            c0(bVar);
            return;
        }
        this.f305508f.H(this.f305441k.B());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    public void P(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bundle);
        } else {
            r0();
            super.P(i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    protected int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    protected void b0(a.b bVar) {
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
            return;
        }
        int c16 = bVar.c();
        UFTTroopUploadTask.e V = V(4, bVar.d());
        V.f305499e = bVar.p();
        if (c16 != 3 && c16 != 4) {
            int c17 = com.tencent.mobileqq.uftransfer.task.utils.b.c(c16);
            int e16 = com.tencent.mobileqq.uftransfer.task.utils.b.e(c16);
            int f16 = com.tencent.mobileqq.uftransfer.task.utils.b.f(c16);
            V.b(c17, e16, 3, com.tencent.mobileqq.uftransfer.task.utils.b.d(c16));
            if (bVar.n() != null && (bVar.n() instanceof ExcitingTransferUploadResultRp)) {
                excitingTransferUploadResultRp = (ExcitingTransferUploadResultRp) bVar.n();
            } else {
                excitingTransferUploadResultRp = null;
            }
            if (excitingTransferUploadResultRp != null) {
                j3 = excitingTransferUploadResultRp.mnSrvReturCode;
            } else {
                j3 = 0;
            }
            V.d((int) j3);
            V.f305452n = c16;
            N(f16, V);
            return;
        }
        V.b(9, 904, 1, 112);
        V.f305452n = 7;
        N(1, V);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask
    public void g0(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        } else {
            r0();
            super.g0(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask, com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f305647m = null;
        return super.h();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask, com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (this.f305647m != null) {
            this.f305508f.y(System.currentTimeMillis());
            this.f305361e = true;
            i(3);
            this.f305647m.k(bundle);
            this.f305647m = null;
            return;
        }
        super.k(bundle);
    }

    protected void n0(long j3, UFTTroopUploadTask.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), eVar);
            return;
        }
        ExcitingTransferUploaderRp a16 = eVar.a();
        if (eVar.f305446h != 0) {
            if (a16 != null) {
                eVar.f305500f = a16.mu64HttpTime;
                eVar.f305501g = a16.mu64TransferSpeed;
            }
            super.d0(j3, eVar);
        }
        int i3 = eVar.f305452n;
        if (a16 != null) {
            t0(i3, a16);
        }
    }

    protected void o0(int i3, UFTTroopUploadTask.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) eVar);
            return;
        }
        s0(eVar.f305452n, this.f305508f.d());
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        String c16 = dVar.c();
        com.tencent.mobileqq.uftransfer.task.taskinfo.h w3 = dVar.w();
        dVar.j("");
        dVar.b().a().k(false);
        dVar.b().a().i(false);
        dVar.B(null);
        UFTTroopUploadTask U = UFTTroopUploadTask.U(this.f305357a, this.f305358b, dVar, new b(), new c());
        this.f305647m = U;
        if (U == null || !U.j()) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopExtfUploadTask", 1, "TId[" + d() + "] do safeGuard upload fail");
            this.f305508f.y(System.currentTimeMillis());
            dVar.j(c16);
            dVar.B(w3);
            e0(eVar);
            this.f305509g.f(this.f305358b, i3, R(eVar));
            g(i3);
        }
    }

    protected v p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (v) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        v vVar = new v(this.f305357a);
        vVar.e(this.f305359c.i());
        String l3 = com.tencent.mobileqq.uftransfer.depend.a.l(dVar.s());
        long longValue = Long.valueOf(dVar.u()).longValue();
        vVar.f(longValue, longValue, dVar.e(), l3, dVar.f());
        vVar.m(T());
        vVar.k(W());
        vVar.j(this.f305508f.u());
        long currentTimeMillis = System.currentTimeMillis() - this.f305508f.m();
        if (currentTimeMillis > 0) {
            vVar.l(currentTimeMillis);
        } else {
            vVar.l(0L);
        }
        long b16 = this.f305508f.b() - this.f305508f.l();
        if (b16 > 0) {
            vVar.g(b16);
        } else {
            vVar.g(0L);
        }
        return vVar;
    }

    protected void r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        v p06 = p0();
        p06.d(33);
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
        if (this.f305508f.s() > 0) {
            excitingTransferUploadResultRp.mu64HttpTime = System.currentTimeMillis() - this.f305508f.s();
        }
        if (this.f305508f.r() > 0) {
            excitingTransferUploadResultRp.mu64StartSize = this.f305508f.r();
        }
        if (this.f305508f.q() > 0) {
            excitingTransferUploadResultRp.mu64TransferSize = this.f305508f.q();
        }
        if (excitingTransferUploadResultRp.mu64HttpTime > 0) {
            if (excitingTransferUploadResultRp.mu64TransferSize > 0) {
                excitingTransferUploadResultRp.mu64TransferSpeed = ((float) r7) / (((float) r3) / 1000.0f);
                excitingTransferUploadResultRp.mbIsXTFValid = true;
                excitingTransferUploadResultRp.mnResult = 33;
                p06.h(excitingTransferUploadResultRp);
                p06.c(false);
            }
        }
        excitingTransferUploadResultRp.mu64TransferSpeed = 0L;
        excitingTransferUploadResultRp.mbIsXTFValid = true;
        excitingTransferUploadResultRp.mnResult = 33;
        p06.h(excitingTransferUploadResultRp);
        p06.c(false);
    }

    protected void s0(int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) excitingTransferUploadResultRp);
            return;
        }
        v p06 = p0();
        p06.d(i3);
        boolean z17 = true;
        int i16 = 0;
        if (excitingTransferUploadResultRp != null) {
            if (excitingTransferUploadResultRp.mnResult != 0) {
                z17 = false;
            }
            p06.h(excitingTransferUploadResultRp);
            i16 = com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploadResultRp.mstrServerIp);
        } else {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ExcitingTransferUploadResultRp excitingTransferUploadResultRp2 = new ExcitingTransferUploadResultRp();
            excitingTransferUploadResultRp2.mnResult = i3;
            if (this.f305508f.s() > 0) {
                excitingTransferUploadResultRp2.mu64HttpTime = System.currentTimeMillis() - this.f305508f.s();
            }
            if (this.f305508f.r() > 0) {
                excitingTransferUploadResultRp2.mu64StartSize = this.f305508f.r();
            }
            if (this.f305508f.q() > 0) {
                excitingTransferUploadResultRp2.mu64TransferSize = this.f305508f.q();
            }
            if (excitingTransferUploadResultRp2.mu64HttpTime > 0) {
                if (excitingTransferUploadResultRp2.mu64TransferSize > 0) {
                    excitingTransferUploadResultRp2.mu64TransferSpeed = ((float) r8) / (((float) r6) / 1000.0f);
                    excitingTransferUploadResultRp2.mbIsXTFValid = true;
                    p06.h(excitingTransferUploadResultRp2);
                    z17 = z16;
                }
            }
            excitingTransferUploadResultRp2.mu64TransferSpeed = 0L;
            excitingTransferUploadResultRp2.mbIsXTFValid = true;
            p06.h(excitingTransferUploadResultRp2);
            z17 = z16;
        }
        p06.i(i16);
        p06.c(z17);
    }

    protected void t0(int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) excitingTransferUploaderRp);
            return;
        }
        if (excitingTransferUploaderRp == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        w wVar = new w(this.f305357a);
        wVar.e(this.f305359c.i());
        String l3 = com.tencent.mobileqq.uftransfer.depend.a.l(dVar.s());
        wVar.d(i3);
        long longValue = Long.valueOf(dVar.u()).longValue();
        wVar.f(longValue, longValue, dVar.e(), l3, dVar.f());
        wVar.g(excitingTransferUploaderRp);
        wVar.j(T());
        wVar.h(com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploaderRp.mstrServerIp));
        wVar.i(W());
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        wVar.c(z16);
    }
}
