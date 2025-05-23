package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTTroopUploadTask extends com.tencent.mobileqq.uftransfer.task.upload.d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f305438h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305439i;

    /* renamed from: j, reason: collision with root package name */
    protected z f305440j;

    /* renamed from: k, reason: collision with root package name */
    protected ab f305441k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTTroopUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void a(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                UFTTroopUploadTask uFTTroopUploadTask = UFTTroopUploadTask.this;
                uFTTroopUploadTask.f305509g.e(((UFTBaseTask) uFTTroopUploadTask).f305358b, j3, j16);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                UFTTroopUploadTask.this.X(aVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTTroopUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                UFTTroopUploadTask.this.q(aVar.c(), aVar.d(), aVar.e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends a.AbstractC8873a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTTroopUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                UFTTroopUploadTask.this.c0((a.b) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                    return;
                }
                a.b bVar = new a.b();
                bVar.f(-29120);
                bVar.g("upload out date");
                UFTTroopUploadTask.this.c0(bVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            } else if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                UFTTroopUploadTask.this.f305508f.K(j3);
                UFTTroopUploadTask uFTTroopUploadTask = UFTTroopUploadTask.this;
                uFTTroopUploadTask.f305509g.h(((UFTBaseTask) uFTTroopUploadTask).f305358b, ((UFTBaseTask) UFTTroopUploadTask.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 4;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, obj);
                return;
            }
            if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e && i3 != 0) {
                int d16 = com.tencent.mobileqq.uftransfer.utility.a.d(str);
                if (d16 == 0) {
                    d16 = com.tencent.mobileqq.uftransfer.utility.a.e(str2);
                }
                int c16 = com.tencent.mobileqq.uftransfer.utility.a.c(str);
                int b16 = aa.b(i3, c16);
                if (i3 != 9050) {
                    i16 = 3;
                }
                e eVar = new e(4, str, str2, false, obj);
                eVar.b(i16, b16, 3, i3);
                eVar.c(c16);
                eVar.d(d16);
                eVar.f305500f = UFTTroopUploadTask.this.f305441k.w();
                eVar.f305501g = UFTTroopUploadTask.this.f305441k.y();
                UFTTroopUploadTask.this.d0(j3, eVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            UFTTroopUploadTask.this.f305508f.H(str);
            com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = UFTTroopUploadTask.this.f305508f;
            iVar.N(iVar.t() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements com.tencent.mobileqq.uftransfer.api.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTTroopUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.api.d
        public void a(boolean z16, long j3, Bundle bundle) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), bundle);
                return;
            }
            if (!((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                if (z16) {
                    if (j3 != 0) {
                        str = "send msg return error:" + j3;
                    } else {
                        str = "";
                        j3 = 0;
                    }
                } else {
                    if (j3 == 0) {
                        j3 = -1;
                    }
                    str = "send msg return fail";
                }
                UFTTroopUploadTask.this.a0((int) j3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UFTTroopUploadTask(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        super(appRuntime, aVar, dVar, aVar2, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, dVar, aVar2, bVar);
        } else {
            this.f305438h = false;
        }
    }

    public static UFTTroopUploadTask U(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        if (UFTBaseTask.c(appRuntime, aVar, dVar, aVar2, "[UFTTransfer] UFTTroopUploadTask")) {
            return new UFTTroopUploadTask(appRuntime, aVar, dVar, aVar2, bVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305439i;
        if (aVar != null) {
            aVar.v();
            this.f305439i = null;
        }
        z zVar = this.f305440j;
        if (zVar != null) {
            zVar.v();
            this.f305440j = null;
        }
        ab abVar = this.f305441k;
        if (abVar != null) {
            abVar.v();
            this.f305441k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305439i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] CalcHashOp had do");
            return;
        }
        byte[] c16 = this.f305359c.d().c();
        byte[] b16 = this.f305359c.d().b();
        if (c16 != null && c16.length > 0 && b16 != null && b16.length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] file hash exist and calc hash done");
            X(0);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] doCalcHashOp...");
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 30L, new a());
        this.f305439i = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            X(u16);
        }
    }

    protected void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (this.f305440j != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] FetchUrlOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] doFetchUrlOp...");
        this.f305509g.c(this.f305358b, 3, null);
        z zVar = new z(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c, this.f305358b, z16, new b());
        this.f305440j = zVar;
        int u16 = zVar.u();
        if (u16 != 0) {
            v(u16, this.f305440j.o(), "");
        }
    }

    protected void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f305438h = false;
            J();
        }
    }

    protected void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.f305509g.c(this.f305358b, 6, null);
        int a16 = this.f305509g.a(this.f305358b, null, new d());
        if (a16 != 0) {
            a0(a16, "send msg fail");
        }
    }

    protected void N(int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) eVar);
            return;
        }
        if (this.f305361e) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] doUploadCompleted errCode:" + i3 + " errMsg:" + eVar.f305496b);
        I();
        this.f305508f.y(System.currentTimeMillis());
        if (i3 != 0) {
            d0(this.f305508f.q(), eVar);
            e0(eVar);
        } else {
            f0();
        }
        this.f305509g.f(this.f305358b, i3, R(eVar));
        p(i3);
        g(i3);
    }

    protected void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.f305441k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] UploadFileOp had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] doUploadFileOp...");
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        ab abVar = new ab(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c, this.f305358b, new c());
        this.f305441k = abVar;
        int u16 = abVar.u();
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
    public void P(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3, (Object) bundle);
            return;
        }
        e V = V(7, "exception broken" + System.currentTimeMillis());
        int i16 = 11;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 == 3) {
                i16 = 12;
            } else if (i3 != 2) {
                i16 = 8;
            }
        }
        V.b(i16, 0, 0, 0);
        d0(this.f305508f.q(), V);
        e0(V);
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        }
        I();
        super.k(bundle);
        if (z16) {
            ac R = R(V);
            R.g(i3);
            this.f305509g.f(this.f305358b, 1000, R);
        }
    }

    protected aa Q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (aa) iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        AppRuntime appRuntime = this.f305357a;
        aa aaVar = new aa(appRuntime, appRuntime.getCurrentAccountUin(), dVar.u());
        aaVar.A = dVar.e();
        aaVar.B = dVar.f();
        aaVar.D = dVar.c();
        aaVar.C = dVar.o();
        aaVar.f305678h = this.f305508f.m();
        aaVar.f305686p = this.f305508f.b() - this.f305508f.b();
        aaVar.f305681k = i3;
        aaVar.f305682l = i16;
        aaVar.f305671a = this.f305508f.n();
        aaVar.f305672b = this.f305508f.g();
        aaVar.f305673c = this.f305508f.h();
        aaVar.f305674d = this.f305508f.h();
        aaVar.f305694x = this.f305508f.i();
        aaVar.f305675e = this.f305508f.r();
        aaVar.f305680j = this.f305508f.u();
        aaVar.f305690t = S();
        aaVar.f305691u = T();
        aaVar.f305693w = W() ? 1 : 0;
        aaVar.f305692v = com.tencent.mobileqq.uftransfer.depend.a.q(this.f305508f.n());
        aaVar.f305676f = 1L;
        if (this.f305508f.q() > this.f305508f.r()) {
            aaVar.f305676f = this.f305508f.q() - this.f305508f.r();
        }
        return aaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac R(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ac) iPatchRedirector.redirect((short) 22, (Object) this, (Object) eVar);
        }
        ac acVar = new ac();
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        acVar.d(this.f305508f.u());
        acVar.c(dVar.c());
        acVar.h(this.f305508f.n());
        acVar.b(eVar.f305496b);
        acVar.f(eVar.f305495a);
        return acVar;
    }

    protected int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.h w3 = ((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c).w();
        if (w3 != null && w3.f()) {
            if (w3.d()) {
                return 3;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e V(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (e) iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) str);
        }
        e eVar = new e(i3, str);
        eVar.f305497c = this.f305508f.e();
        eVar.f305498d = this.f305508f.p();
        eVar.f305500f = this.f305508f.f();
        eVar.f305501g = this.f305508f.j();
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.h w3 = ((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c).w();
        if (w3 != null) {
            return w3.e();
        }
        return false;
    }

    protected void X(int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] onCalcHashOpDone errCode:" + i3);
        if (i3 != 0) {
            e V = V(2, "get md5 failed");
            if (i3 == 2) {
                i18 = 501;
                i17 = 102;
                i16 = 107;
            } else {
                i16 = 3;
                if (i3 == 1) {
                    i18 = 700;
                    i19 = 201;
                } else if (i3 == 4) {
                    i18 = 502;
                    i17 = 205;
                    i16 = 1;
                } else if (i3 == 3) {
                    i18 = 701;
                    i19 = 203;
                    i16 = 6;
                } else {
                    if (i3 == 7) {
                        i17 = 211;
                    } else {
                        i17 = 1;
                    }
                    i18 = 503;
                    i16 = 8;
                }
                i17 = i19;
                i26 = 7;
            }
            V.b(i26, i18, 1, i16);
            N(i17, V);
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        n(false);
    }

    protected void Y(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        int i16 = -136;
        if (i3 != -312 && i3 != -136) {
            if (i3 != -107) {
                i16 = -138;
                if (i3 != -139 && i3 != -138) {
                    if (i3 != -103) {
                        if (i3 != -102) {
                            if (i3 != -2) {
                                if (i3 != -1) {
                                    switch (i3) {
                                        case -303:
                                            break;
                                        case -302:
                                        case -301:
                                            break;
                                        default:
                                            i16 = 1;
                                            break;
                                    }
                                }
                            }
                            i16 = 102;
                        }
                    }
                    i16 = 206;
                }
            }
            i16 = 101;
        }
        e V = V(3, str);
        V.b(1, i3, 2, i3);
        N(i16, V);
    }

    protected void Z(int i3, String str, String str2) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (i3 != 1 && i3 != 2) {
            if (this.f305438h) {
                Y(i3, str, str2);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (i3 != -25126) {
                i16 = -136;
                if (i3 != -312 && i3 != -136) {
                    if (i3 != -134) {
                        if (i3 != -107 && i3 != -102) {
                            if (i3 != -36) {
                                if (i3 != -20001 && i3 != -20000 && i3 != -403) {
                                    if (i3 != -402) {
                                        i16 = -138;
                                        if (i3 != -139 && i3 != -138) {
                                            if (i3 != -2) {
                                                if (i3 != -1) {
                                                    str2 = str;
                                                    i16 = 1;
                                                }
                                            }
                                        }
                                    } else {
                                        i16 = 704;
                                    }
                                    e V = V(3, str2);
                                    V.b(1, i3, 2, i3);
                                    N(i16, V);
                                    return;
                                }
                                com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
                                if (dVar.o() != 104) {
                                    dVar.A(104);
                                    this.f305440j = null;
                                    n(false);
                                    return;
                                }
                                i16 = 204;
                            } else {
                                i16 = 210;
                            }
                        }
                        i16 = 208;
                    }
                    i16 = 202;
                }
            } else {
                i16 = 209;
            }
            str2 = str;
            e V2 = V(3, str2);
            V2.b(1, i3, 2, i3);
            N(i16, V2);
            return;
        }
        e V3 = V(3, str);
        V3.b(1, 103, 1, 101);
        N(207, V3);
    }

    protected void a0(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] onSendMsgDone errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            e eVar = new e(6, str, "", false, null);
            eVar.b(13, 1301, 3, i3);
            d0(this.f305508f.q(), eVar);
        }
        N(0, V(6, str));
    }

    protected void b0(a.b bVar) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
            return;
        }
        int c16 = bVar.c();
        int i17 = 4;
        e V = V(4, bVar.d());
        V.f305499e = bVar.p();
        int i18 = 1;
        if (c16 != 1 && c16 != 2 && c16 != 3 && c16 != 4) {
            int d16 = com.tencent.mobileqq.uftransfer.utility.a.d(bVar.d());
            if (d16 == 0) {
                d16 = com.tencent.mobileqq.uftransfer.utility.a.e(bVar.o());
            }
            int c17 = com.tencent.mobileqq.uftransfer.utility.a.c(bVar.d());
            int b16 = aa.b(c16, c17);
            if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
                b16 = 306;
                i16 = 106;
                i17 = 3;
                c16 = 7;
            } else {
                if (c16 == 9009) {
                    b16 = 312;
                    c16 = 111;
                } else if (c16 == 9001) {
                    b16 = 321;
                    c16 = 112;
                } else {
                    if (c16 == 9343) {
                        b16 = 313;
                        c16 = -97;
                        i3 = 1;
                    } else if (c16 == 9303) {
                        b16 = 707;
                        c16 = 6;
                        i16 = 203;
                        i17 = 7;
                    } else {
                        i3 = 206;
                        if (c16 == 9042) {
                            c16 = 3;
                            i17 = 3;
                            i18 = 3;
                        } else if (d16 != -38006 && d16 != -38007 && d16 != -38020) {
                            if (c16 == -29120) {
                                b16 = 302;
                                d16 = c16;
                            } else {
                                if (bVar.r()) {
                                    if (d16 != 0) {
                                        c16 = d16;
                                    }
                                    i3 = 105;
                                    i18 = 3;
                                } else {
                                    i3 = 1;
                                    i17 = 3;
                                    i18 = 3;
                                    if (d16 != 0) {
                                        c16 = d16;
                                    }
                                }
                                V.b(i17, b16, i18, c16);
                                V.c(c17);
                                V.d(d16);
                                N(i3, V);
                                return;
                            }
                        } else {
                            i17 = 3;
                            i18 = 3;
                            c16 = d16;
                        }
                        b16 = 311;
                        V.b(i17, b16, i18, c16);
                        V.c(c17);
                        V.d(d16);
                        N(i3, V);
                        return;
                    }
                    i17 = 3;
                    i18 = 3;
                    V.b(i17, b16, i18, c16);
                    V.c(c17);
                    V.d(d16);
                    N(i3, V);
                    return;
                }
                i17 = 3;
                i18 = 3;
                i3 = 102;
                V.b(i17, b16, i18, c16);
                V.c(c17);
                V.d(d16);
                N(i3, V);
                return;
            }
            i3 = i16;
            V.b(i17, b16, i18, c16);
            V.c(c17);
            V.d(d16);
            N(i3, V);
            return;
        }
        V.b(9, 904, 1, 112);
        N(1, V);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        this.f305508f.I(System.currentTimeMillis());
        this.f305508f.z(bVar.q());
        this.f305508f.A(bVar.o());
        this.f305508f.J(bVar.n());
        ab abVar = this.f305441k;
        if (abVar != null) {
            this.f305508f.H(abVar.B());
            this.f305508f.L(this.f305441k.z());
            this.f305508f.K(this.f305441k.A());
            this.f305508f.C(this.f305441k.x());
            this.f305508f.B(this.f305441k.w());
            this.f305508f.D(this.f305441k.y());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] on upload file op done. errCode:" + bVar.c() + " flash:" + this.f305508f.u() + " speed:" + this.f305508f.j() + " httpTime:" + this.f305508f.f() + " url:" + this.f305508f.n() + " upStartSize:" + this.f305508f.r() + " upEndSize:" + this.f305508f.q());
        if (bVar.c() != 0) {
            b0(bVar);
            return;
        }
        this.f305508f.K(this.f305359c.f());
        if (((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c).z()) {
            M();
            return;
        }
        e V = V(4, bVar.d());
        V.f305499e = bVar.p();
        N(0, V);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d0(long j3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), eVar);
            return;
        }
        aa Q = Q(eVar.f305446h, eVar.f305447i);
        if (j3 > this.f305508f.r()) {
            Q.f305676f = j3 - this.f305508f.r();
        }
        Q.f305683m = eVar.f305450l;
        Q.f305684n = eVar.f305451m;
        Q.f305688r = eVar.f305497c;
        Q.f305687q = eVar.f305496b;
        Q.f305677g = eVar.f305500f;
        Q.f305679i = eVar.f305501g;
        Q.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e0(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) eVar);
            return;
        }
        aa Q = Q(eVar.f305446h, eVar.f305447i);
        Q.f305683m = eVar.f305450l;
        Q.f305684n = eVar.f305451m;
        Q.f305688r = eVar.f305497c;
        Q.f305687q = eVar.f305496b;
        Q.f305677g = this.f305508f.f();
        Q.f305679i = this.f305508f.j();
        Q.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        aa Q = Q(0, 0);
        if (!this.f305508f.u() && this.f305359c.d().f() > this.f305508f.r()) {
            Q.f305676f = this.f305359c.d().f() - this.f305508f.r();
        }
        Q.f305683m = 0;
        Q.f305684n = 0;
        Q.f305680j = this.f305508f.u();
        Q.f305677g = this.f305508f.f();
        Q.f305679i = this.f305508f.j();
        Q.f();
        Q.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
            return;
        }
        this.f305509g.k(true);
        e V = V(7, "userCancel" + System.currentTimeMillis());
        V.b(8, 0, 0, 0);
        d0(this.f305508f.q(), V);
        e0(V);
        I();
        super.k(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f305508f.v();
        this.f305509g.k(false);
        this.f305508f.G(System.currentTimeMillis());
        this.f305509g.g(this.f305358b);
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTroopUploadTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((UFTBaseTask) UFTTroopUploadTask.this).f305361e) {
                    return;
                }
                UFTTroopUploadTask uFTTroopUploadTask = UFTTroopUploadTask.this;
                uFTTroopUploadTask.f305509g.c(((UFTBaseTask) uFTTroopUploadTask).f305358b, 1, null);
                if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + UFTTroopUploadTask.this.d() + "] send local file. no network");
                    e V = UFTTroopUploadTask.this.V(1, "NoNetWork");
                    V.b(9, 901, 1, 7);
                    UFTTroopUploadTask.this.N(106, V);
                    return;
                }
                if (TextUtils.isEmpty(UFTTroopUploadTask.this.r())) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + UFTTroopUploadTask.this.d() + "] send local file. file path is null");
                    UFTTroopUploadTask.this.V(1, "strFilePath is null").b(10, 1001, 1, 3);
                    UFTTroopUploadTask uFTTroopUploadTask2 = UFTTroopUploadTask.this;
                    uFTTroopUploadTask2.N(201, uFTTroopUploadTask2.V(1, "strFilePath is null"));
                    return;
                }
                File file = new File(UFTTroopUploadTask.this.r());
                if (file.exists() && file.length() > 4294967296L) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + UFTTroopUploadTask.this.d() + "] send local file. file size > 4G");
                    UFTTroopUploadTask.this.V(1, "file size > 4G").b(5, 502, 1, 1);
                    UFTTroopUploadTask uFTTroopUploadTask3 = UFTTroopUploadTask.this;
                    uFTTroopUploadTask3.N(205, uFTTroopUploadTask3.V(1, "file size > 4G"));
                    return;
                }
                UFTTroopUploadTask.this.L();
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bundle);
            return;
        }
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        ab abVar = this.f305441k;
        if (abVar != null) {
            this.f305508f.K(abVar.A());
            this.f305508f.B(this.f305441k.w());
            this.f305508f.D(this.f305441k.y());
        }
        if (bundle != null) {
            i3 = bundle.getInt("REASON");
        } else {
            i3 = 0;
        }
        this.f305508f.y(System.currentTimeMillis());
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] stop ..." + i3);
        if (i3 == 0) {
            g0(bundle);
        } else {
            P(i3, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    /* renamed from: o */
    public void s(UploadInfoEntity uploadInfoEntity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uploadInfoEntity, Boolean.valueOf(z16));
        } else if (uploadInfoEntity != null && uploadInfoEntity.isValidTroopCache()) {
            com.tencent.mobileqq.uftransfer.task.utils.a.b((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c, uploadInfoEntity);
            v(0, "", "");
        } else {
            K(z16);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return ((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c).s();
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    protected void v(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, str2);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTroopUploadTask", 1, "TId[" + d() + "] onFetchUrlOpDone errCode:" + i3 + " errMsg:" + str + " showWording:" + str2);
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305359c;
        if (i3 != 0) {
            Z(i3, str, str2);
            return;
        }
        com.tencent.mobileqq.uftransfer.api.l lVar = new com.tencent.mobileqq.uftransfer.api.l();
        lVar.g(this.f305359c.c());
        lVar.l(dVar.o());
        lVar.i(dVar.y());
        lVar.m(dVar.v());
        lVar.f(dVar.p());
        this.f305509g.d(this.f305358b, lVar);
        O();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends ad {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        public int f305446h;

        /* renamed from: i, reason: collision with root package name */
        public int f305447i;

        /* renamed from: j, reason: collision with root package name */
        public int f305448j;

        /* renamed from: k, reason: collision with root package name */
        public int f305449k;

        /* renamed from: l, reason: collision with root package name */
        public int f305450l;

        /* renamed from: m, reason: collision with root package name */
        public int f305451m;

        /* renamed from: n, reason: collision with root package name */
        public int f305452n;

        public e(int i3, String str) {
            super(i3, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f305452n = 0;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            }
        }

        public void b(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.f305446h = i3;
            this.f305447i = i16;
            this.f305448j = i17;
            this.f305449k = i18;
        }

        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.f305450l = i3;
            }
        }

        public void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.f305451m = i3;
            }
        }

        public e(int i3, String str, String str2, boolean z16, Object obj) {
            super(i3, str, str2, z16, obj);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f305452n = 0;
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), obj);
            }
        }
    }
}
