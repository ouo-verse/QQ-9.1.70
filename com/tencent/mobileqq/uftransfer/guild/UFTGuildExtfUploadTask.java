package com.tencent.mobileqq.uftransfer.guild;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.uftransfer.api.i;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import com.tencent.mobileqq.uftransfer.task.upload.ac;
import com.tencent.mobileqq.uftransfer.task.upload.ad;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTGuildExtfUploadTask extends com.tencent.mobileqq.uftransfer.task.upload.d {

    /* renamed from: h, reason: collision with root package name */
    protected boolean f305172h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305173i;

    /* renamed from: j, reason: collision with root package name */
    protected UFTGuildFetchUploadUrlOp f305174j;

    /* renamed from: k, reason: collision with root package name */
    protected f f305175k;

    /* renamed from: l, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.guild.d f305176l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends UFTBaseOp.b {
        a() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            if (!((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                UFTGuildExtfUploadTask.this.c0(aVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends UFTBaseOp.b {
        b() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            if (!((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                UFTGuildExtfUploadTask.this.d0(aVar.c(), aVar.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends a.AbstractC8873a {
        c() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            if (!((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                UFTGuildExtfUploadTask.this.h0((a.b) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            if (!((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                ((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305508f.K(j3);
                ((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305509g.h(((UFTBaseTask) UFTGuildExtfUploadTask.this).f305358b, ((UFTBaseTask) UFTGuildExtfUploadTask.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            if (!((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                UFTGuildExtfUploadTask.this.R(j3, i3, new ad(4, str, str2, true, obj));
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            ((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305508f.H(str);
            ((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305508f.N(((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305508f.t() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends UFTBaseOp.b {
        d() {
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            UFTGuildExtfUploadTask.this.g0(aVar.c(), aVar.d());
        }
    }

    protected UFTGuildExtfUploadTask(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, g gVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        super(appRuntime, aVar, gVar, aVar2, bVar);
        this.f305172h = gVar.b().a().g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] send local file[" + str + "] strFilePath is null");
            V(9005, b0(1, "strFilePath is null"));
            return false;
        }
        if (!com.tencent.mobileqq.uftransfer.utility.a.a(str)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] send local file[" + str + "] strFilePath is not exist");
            V(9042, b0(1, "fileNotExists"));
            return false;
        }
        if (com.tencent.mobileqq.uftransfer.utility.a.b(str) != 0) {
            return true;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] send local file[" + str + "] strFilePath is empty file");
        V(9071, b0(1, "fileExistsEmpty"));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P(String str) {
        if (com.tencent.mobileqq.uftransfer.depend.a.A()) {
            return true;
        }
        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] send local file[" + str + "] no network");
        V(9004, b0(1, "NoNetWork"));
        return false;
    }

    public static UFTGuildExtfUploadTask a0(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, g gVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        if (UFTBaseTask.c(appRuntime, aVar, gVar, aVar2, "[UFTTransfer] UFTGuildExtfUploadTask")) {
            return new UFTGuildExtfUploadTask(appRuntime, aVar, gVar, aVar2, bVar);
        }
        return null;
    }

    protected void N() {
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] cancel all Op...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305173i;
        if (aVar != null) {
            aVar.v();
            this.f305173i = null;
        }
        UFTGuildFetchUploadUrlOp uFTGuildFetchUploadUrlOp = this.f305174j;
        if (uFTGuildFetchUploadUrlOp != null) {
            uFTGuildFetchUploadUrlOp.v();
            this.f305174j = null;
        }
        com.tencent.mobileqq.uftransfer.guild.d dVar = this.f305176l;
        if (dVar != null) {
            dVar.v();
            this.f305176l = null;
        }
        f fVar = this.f305175k;
        if (fVar != null) {
            fVar.v();
            this.f305175k = null;
        }
    }

    protected void Q() {
        if (!this.f305172h) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] calc hash mUseMediaPlatform == false");
            return;
        }
        if (this.f305173i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] calc hash op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] do calc hash op ...");
        this.f305508f.F(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 30L, new a());
        this.f305173i = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            c0(u16);
        }
    }

    protected void R(long j3, int i3, ad adVar) {
        ExcitingTransferUploaderRp a16 = adVar.a();
        if (a16 != null) {
            k0(i3, a16);
        }
    }

    protected void S() {
        if (this.f305174j != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] fetch url op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] do fetch url op fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        this.f305508f.E(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 3, null);
        UFTGuildFetchUploadUrlOp uFTGuildFetchUploadUrlOp = new UFTGuildFetchUploadUrlOp(this.f305357a, (g) this.f305359c, this.f305358b, new b());
        this.f305174j = uFTGuildFetchUploadUrlOp;
        int u16 = uFTGuildFetchUploadUrlOp.u();
        if (u16 != 0) {
            d0(u16, this.f305174j.o());
        }
    }

    protected void T() {
        Q();
    }

    protected void U() {
        if (this.f305175k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] set upload suc op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] do set upload suc op ...");
        this.f305509g.c(this.f305358b, 5, null);
        f fVar = new f(this.f305357a, (g) this.f305359c, this.f305358b, new d());
        this.f305175k = fVar;
        int u16 = fVar.u();
        if (u16 != 0) {
            g0(u16, "set upload suc fail");
        }
    }

    protected void V(int i3, ad adVar) {
        if (this.f305361e) {
            return;
        }
        ExcitingTransferUploadResultRp d16 = this.f305508f.d();
        if (i3 != 0) {
            this.f305508f.y(System.currentTimeMillis());
            j0(i3, d16);
        } else {
            this.f305508f.y(System.currentTimeMillis());
            j0(0, d16);
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] do upload completed errCode:" + i3 + " errMsg:" + adVar.f305496b + "fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        N();
        this.f305508f.y(System.currentTimeMillis());
        this.f305509g.f(this.f305358b, i3, Y(i3, adVar));
        g(i3);
    }

    protected void W() {
        if (this.f305176l != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] upload file had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] do upload file op fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        com.tencent.mobileqq.uftransfer.guild.d dVar = new com.tencent.mobileqq.uftransfer.guild.d(this.f305357a, (g) this.f305359c, this.f305358b, new c());
        this.f305176l = dVar;
        int u16 = dVar.u();
        if (u16 != 0) {
            a.b bVar = new a.b();
            bVar.f(u16);
            bVar.g(this.f305176l.o());
            h0(bVar);
            return;
        }
        this.f305508f.H(this.f305176l.B());
    }

    protected void X(int i3, Bundle bundle) {
        boolean z16;
        String str = "exception broken" + System.currentTimeMillis();
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        N();
        super.k(bundle);
        if (z16) {
            ac Y = Y(9004, b0(7, str));
            Y.g(i3);
            this.f305509g.f(this.f305358b, 9004, Y);
            return;
        }
        this.f305509g.k(true);
    }

    protected ac Y(int i3, ad adVar) {
        ac acVar = new ac();
        g gVar = (g) this.f305359c;
        acVar.d(this.f305508f.u());
        acVar.c(gVar.c());
        acVar.e("");
        acVar.h(this.f305508f.n());
        if (!TextUtils.isEmpty(gVar.y())) {
            acVar.b(gVar.y());
        }
        acVar.f(adVar.f305495a);
        return acVar;
    }

    protected int Z() {
        if (((g) this.f305359c).b().a().f()) {
            return 2;
        }
        return 1;
    }

    protected ad b0(int i3, String str) {
        ad adVar = new ad(i3, str);
        adVar.f305497c = this.f305508f.e();
        adVar.f305498d = this.f305508f.p();
        adVar.f305500f = this.f305508f.f();
        adVar.f305501g = this.f305508f.j();
        return adVar;
    }

    protected void c0(int i3) {
        int i16;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] on calc hash op done retCode:" + i3 + " fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        this.f305508f.x(System.currentTimeMillis());
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 9042;
            } else {
                i16 = 9041;
            }
            V(i16, b0(2, "get md5 failed"));
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        S();
    }

    protected void d0(int i3, String str) {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] on fetch url op done errCode:" + i3 + " errMsg:" + str + "fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        this.f305508f.w(System.currentTimeMillis());
        if (i3 != 0) {
            V(i3, b0(3, str));
            return;
        }
        e0();
        if (((g) this.f305359c).z()) {
            QLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, "isFlashFile! begin Report to Svr + fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
            f0();
            return;
        }
        W();
    }

    protected void e0() {
        g gVar = (g) this.f305359c;
        i iVar = new i();
        iVar.g(gVar.c());
        iVar.j(true);
        iVar.h("");
        this.f305509g.d(this.f305358b, iVar);
    }

    protected void f0() {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] file is hit");
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        this.f305508f.z(true);
        this.f305508f.L(this.f305359c.f());
        this.f305508f.K(this.f305359c.f());
        U();
    }

    protected void g0(int i3, String str) {
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] on set uploadsuc done errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            V(i3, b0(5, str));
        } else if (((g) this.f305359c).A()) {
            QLog.e("[UFTTransfer] UFTGuildExtfUploadTask", 1, "error! guild file not need send msg!!!");
        } else {
            V(0, b0(5, ""));
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    protected boolean h() {
        QLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 1, "uploadGuildFileTask begin run fileName = " + this.f305359c.e() + "fileSize = " + this.f305359c.f());
        this.f305508f.v();
        this.f305509g.k(false);
        this.f305508f.G(System.currentTimeMillis());
        this.f305509g.g(this.f305358b);
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.guild.UFTGuildExtfUploadTask.1
            @Override // java.lang.Runnable
            public void run() {
                if (((UFTBaseTask) UFTGuildExtfUploadTask.this).f305361e) {
                    return;
                }
                ((com.tencent.mobileqq.uftransfer.task.upload.d) UFTGuildExtfUploadTask.this).f305509g.c(((UFTBaseTask) UFTGuildExtfUploadTask.this).f305358b, 1, null);
                String r16 = UFTGuildExtfUploadTask.this.r();
                if (UFTGuildExtfUploadTask.this.P(r16) && UFTGuildExtfUploadTask.this.O(r16)) {
                    UFTGuildExtfUploadTask.this.T();
                }
            }
        });
        return true;
    }

    protected void h0(a.b bVar) {
        this.f305508f.I(System.currentTimeMillis());
        this.f305508f.z(bVar.q());
        this.f305508f.A(bVar.o());
        this.f305508f.J(bVar.n());
        com.tencent.mobileqq.uftransfer.guild.d dVar = this.f305176l;
        if (dVar != null) {
            this.f305508f.H(dVar.B());
            this.f305508f.L(this.f305176l.z());
            this.f305508f.K(this.f305176l.A());
            this.f305508f.C(this.f305176l.x());
            this.f305508f.B(this.f305176l.w());
            this.f305508f.D(this.f305176l.y());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] on upload file op done. errCode:" + bVar.c() + " flash:" + this.f305508f.u() + " speed:" + this.f305508f.j() + " httpTime:" + this.f305508f.f() + " url:" + this.f305508f.n() + " upStartSize:" + this.f305508f.r() + " upEndSize:" + this.f305508f.q());
        if (bVar.c() != 0) {
            ad b06 = b0(4, bVar.d());
            b06.f305499e = bVar.p();
            V(bVar.c(), b06);
        } else {
            this.f305508f.K(this.f305359c.f());
            U();
        }
    }

    protected void i0() {
        g gVar = (g) this.f305359c;
        com.tencent.mobileqq.uftransfer.guild.a aVar = new com.tencent.mobileqq.uftransfer.guild.a(this.f305357a);
        aVar.g(33);
        aVar.h(gVar.i());
        aVar.k(Long.valueOf(gVar.w()).longValue(), 0L, gVar.e(), com.tencent.mobileqq.uftransfer.depend.a.l(gVar.e()), gVar.f());
        aVar.e(this.f305508f.u());
        long c16 = this.f305508f.c() - this.f305508f.m();
        aVar.i(this.f305508f.m());
        if (c16 > 0) {
            aVar.j(c16);
        } else {
            aVar.j(0L);
        }
        long b16 = this.f305508f.b() - this.f305508f.l();
        if (b16 > 0) {
            aVar.b(b16);
        } else {
            aVar.b(0L);
        }
        ExcitingTransferUploadResultRp excitingTransferUploadResultRp = new ExcitingTransferUploadResultRp();
        excitingTransferUploadResultRp.mbIsXTFValid = true;
        excitingTransferUploadResultRp.mnResult = 33;
        aVar.c(excitingTransferUploadResultRp);
        aVar.l(Z());
        aVar.f(false);
        aVar.a(false);
    }

    protected void j0(int i3, ExcitingTransferUploadResultRp excitingTransferUploadResultRp) {
        boolean z16;
        int i16;
        if (i3 == 9037) {
            i0();
            return;
        }
        g gVar = (g) this.f305359c;
        com.tencent.mobileqq.uftransfer.guild.a aVar = new com.tencent.mobileqq.uftransfer.guild.a(this.f305357a);
        boolean z17 = true;
        if (excitingTransferUploadResultRp != null) {
            i16 = com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploadResultRp.mstrServerIp);
            if (excitingTransferUploadResultRp.mnResult != 0) {
                z17 = false;
            }
            aVar.c(excitingTransferUploadResultRp);
            z16 = z17;
        } else {
            if (i3 != 0) {
                z17 = false;
            }
            if (!z17) {
                if (this.f305508f.s() == 0) {
                    aVar.g(i3);
                } else {
                    aVar.g(17);
                }
            } else {
                aVar.g(0);
            }
            z16 = z17;
            i16 = 0;
        }
        aVar.h(gVar.i());
        boolean z18 = z16;
        aVar.k(Long.valueOf(gVar.w()).longValue(), 0L, gVar.e(), com.tencent.mobileqq.uftransfer.depend.a.l(gVar.e()), gVar.f());
        aVar.e(this.f305508f.u());
        long c16 = this.f305508f.c() - this.f305508f.m();
        aVar.i(this.f305508f.m());
        if (c16 > 0) {
            aVar.j(c16);
        } else {
            aVar.j(0L);
        }
        long b16 = this.f305508f.b() - this.f305508f.l();
        if (b16 > 0) {
            aVar.b(b16);
        } else {
            aVar.b(0L);
        }
        aVar.l(Z());
        aVar.d(i16);
        aVar.f(false);
        aVar.a(z18);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        int i3;
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        com.tencent.mobileqq.uftransfer.guild.d dVar = this.f305176l;
        if (dVar != null) {
            this.f305508f.K(dVar.A());
            this.f305508f.B(this.f305176l.w());
            this.f305508f.D(this.f305176l.y());
        }
        if (bundle != null) {
            i3 = bundle.getInt("REASON");
        } else {
            i3 = 0;
        }
        this.f305508f.y(System.currentTimeMillis());
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTGuildExtfUploadTask", 1, "TId[" + d() + "] stop ..." + i3 + "fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        if (i3 == 0) {
            l0(bundle);
        } else {
            X(i3, bundle);
        }
    }

    protected void k0(int i3, ExcitingTransferUploaderRp excitingTransferUploaderRp) {
        if (excitingTransferUploaderRp == null) {
            return;
        }
        g gVar = (g) this.f305359c;
        int Z = Z();
        com.tencent.mobileqq.uftransfer.guild.b bVar = new com.tencent.mobileqq.uftransfer.guild.b(this.f305357a);
        bVar.g(d());
        String l3 = com.tencent.mobileqq.uftransfer.depend.a.l(this.f305359c.e());
        bVar.f(i3);
        bVar.i(Long.valueOf(gVar.w()).longValue(), 0L, gVar.e(), l3, gVar.f());
        bVar.c(excitingTransferUploaderRp);
        bVar.j(Z);
        bVar.d(com.tencent.mobileqq.uftransfer.depend.a.p(excitingTransferUploaderRp.mstrServerIp));
        boolean z16 = false;
        bVar.e(false);
        com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = this.f305508f;
        if (iVar != null) {
            bVar.h(iVar.m());
            bVar.b(this.f305508f.c());
        }
        if (i3 == 0) {
            z16 = true;
        }
        bVar.a(z16);
    }

    protected void l0(Bundle bundle) {
        i0();
        this.f305509g.k(true);
        System.currentTimeMillis();
        QLog.d("[UFTTransfer] UFTGuildExtfUploadTask", 2, "userCancel fileName = " + this.f305359c.e() + " fileSize = " + this.f305359c.f());
        N();
        super.k(bundle);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    public String r() {
        return ((g) this.f305359c).q();
    }
}
