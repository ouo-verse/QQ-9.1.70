package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.uftransfer.data.UploadInfoEntity;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTC2CUploadTask extends com.tencent.mobileqq.uftransfer.task.upload.d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305422h;

    /* renamed from: i, reason: collision with root package name */
    protected k f305423i;

    /* renamed from: j, reason: collision with root package name */
    protected q f305424j;

    /* renamed from: k, reason: collision with root package name */
    protected p f305425k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                UFTC2CUploadTask.this.X(aVar.c());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                UFTC2CUploadTask.this.q(aVar.c(), aVar.d(), aVar.e());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                UFTC2CUploadTask.this.c0((a.b) aVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            } else if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                UFTC2CUploadTask.this.f305508f.K(j3);
                UFTC2CUploadTask uFTC2CUploadTask = UFTC2CUploadTask.this;
                uFTC2CUploadTask.f305509g.h(((UFTBaseTask) uFTC2CUploadTask).f305358b, ((UFTBaseTask) UFTC2CUploadTask.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, obj);
                return;
            }
            if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e && i3 != 0) {
                ad adVar = new ad(4, str, str2, false, obj);
                adVar.f305500f = UFTC2CUploadTask.this.f305424j.w();
                adVar.f305501g = UFTC2CUploadTask.this.f305424j.y();
                UFTC2CUploadTask.this.d0(j3, i3, adVar);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            UFTC2CUploadTask.this.f305508f.H(str);
            com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = UFTC2CUploadTask.this.f305508f;
            iVar.N(iVar.t() + 1);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                UFTC2CUploadTask.this.b0(aVar.c(), aVar.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements com.tencent.mobileqq.uftransfer.api.d {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
        @Override // com.tencent.mobileqq.uftransfer.api.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z16, long j3, Bundle bundle) {
            long j16;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), bundle);
                return;
            }
            if (!((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                long j17 = 0;
                if (z16) {
                    j16 = 58;
                    if (58 == j3) {
                        str = "ServerMasking";
                    } else {
                        str2 = "";
                        j16 = 0;
                        if (bundle != null) {
                            i3 = bundle.getInt("seq");
                            j17 = bundle.getLong("uniSeq");
                        }
                        UFTC2CUploadTask.this.a0((int) j16, str2, i3, j17);
                    }
                } else {
                    if (j3 == -100001) {
                        j16 = 9043;
                    } else {
                        j16 = 90460;
                    }
                    str = "send msg return fail.retCode:" + j3;
                }
                str2 = str;
                if (bundle != null) {
                }
                UFTC2CUploadTask.this.a0((int) j16, str2, i3, j17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UFTC2CUploadTask(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        super(appRuntime, aVar, bVar, aVar2, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, bVar, aVar2, bVar2);
        }
    }

    public static UFTC2CUploadTask U(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar2) {
        if (UFTBaseTask.c(appRuntime, aVar, bVar, aVar2, "[UFTTransfer] UFTC2CUploadTask")) {
            return new UFTC2CUploadTask(appRuntime, aVar, bVar, aVar2, bVar2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] cancel all Op...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305422h;
        if (aVar != null) {
            aVar.v();
            this.f305422h = null;
        }
        k kVar = this.f305423i;
        if (kVar != null) {
            kVar.v();
            this.f305423i = null;
        }
        q qVar = this.f305424j;
        if (qVar != null) {
            qVar.v();
            this.f305424j = null;
        }
        p pVar = this.f305425k;
        if (pVar != null) {
            pVar.v();
            this.f305425k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305422h != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] calc hash op had do");
            return;
        }
        byte[] c16 = this.f305359c.d().c();
        byte[] a16 = this.f305359c.d().a();
        if (c16 != null && c16.length > 0 && a16 != null && a16.length > 0) {
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] file hash exist and calc hash done");
            X(0);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do calc hash op ...");
        this.f305508f.F(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 25L, new a());
        this.f305422h = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            X(u16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f305423i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] fetch url op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do fetch url op ...");
        this.f305508f.E(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 3, null);
        n nVar = new n(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new b());
        this.f305423i = nVar;
        int u16 = nVar.u();
        if (u16 != 0) {
            v(u16, this.f305423i.o(), "");
        }
    }

    protected void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            I();
        }
    }

    protected void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do send msg op ...");
        this.f305509g.c(this.f305358b, 6, null);
        if (this.f305509g.a(this.f305358b, null, new e()) != 0) {
            a0(FileMsg.RESULT_CODE_0X211_CCMSG_ERROR, "send msg fail", 0, 0L);
        }
    }

    protected void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.f305425k != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] set upload suc op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do set upload suc op ...");
        this.f305509g.c(this.f305358b, 5, null);
        p pVar = new p(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new d());
        this.f305425k = pVar;
        int u16 = pVar.u();
        if (u16 != 0) {
            b0(u16, "set upload suc fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3, (Object) adVar);
            return;
        }
        if (this.f305361e) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do upload completed errCode:" + i3 + " errMsg:" + adVar.f305496b);
        H();
        this.f305508f.y(System.currentTimeMillis());
        if (i3 != 0) {
            d0(this.f305508f.q(), i3, adVar);
            e0(this.f305508f.q(), i3, adVar);
        } else {
            f0();
        }
        this.f305509g.f(this.f305358b, i3, R(i3, adVar));
        p(i3);
        g(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f305424j != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] upload file had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] do upload file op ...");
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        q qVar = new q(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, this.f305358b, new c());
        this.f305424j = qVar;
        int u16 = qVar.u();
        if (u16 != 0) {
            a.b bVar = new a.b();
            bVar.f(u16);
            bVar.g(this.f305424j.o());
            c0(bVar);
            return;
        }
        this.f305508f.H(this.f305424j.B());
    }

    protected void P(int i3, Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) bundle);
            return;
        }
        String str = "exception broken" + System.currentTimeMillis();
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        H();
        super.k(bundle);
        if (z16) {
            ac R = R(9004, V(7, str));
            R.g(i3);
            this.f305509g.f(this.f305358b, 9004, R);
            return;
        }
        this.f305509g.k(true);
    }

    protected o Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (o) iPatchRedirector.redirect((short) 28, (Object) this, z16);
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        o oVar = new o(this.f305357a, d(), bVar.q(), bVar.f(), S());
        oVar.f305581g = com.tencent.mobileqq.uftransfer.depend.a.z(this.f305359c.d().a());
        oVar.f305580f = bVar.c();
        oVar.f305585k = this.f305508f.i();
        oVar.f305587m = this.f305508f.m();
        oVar.f305591q = com.tencent.mobileqq.uftransfer.depend.a.q(this.f305508f.n());
        oVar.f305592r = W();
        oVar.f305590p = T();
        oVar.f305582h = this.f305508f.n();
        oVar.f305597w = this.f305508f.n();
        oVar.f305583i = 1L;
        if (this.f305508f.q() > this.f305508f.r()) {
            oVar.f305583i = this.f305508f.q() - this.f305508f.r();
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac R(int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ac) iPatchRedirector.redirect((short) 23, (Object) this, i3, (Object) adVar);
        }
        ac acVar = new ac();
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        acVar.d(this.f305508f.u());
        acVar.c(bVar.c());
        acVar.e(bVar.s());
        acVar.h(this.f305508f.n());
        if (!TextUtils.isEmpty(bVar.t()) && !com.tencent.mobileqq.uftransfer.proto.g.c(i3)) {
            acVar.b(bVar.t());
        }
        acVar.f(adVar.f305495a);
        return acVar;
    }

    protected int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = ((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c).r();
        if (r16 != null && r16.f()) {
            if (r16.d()) {
                return 3;
            }
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad V(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ad) iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) str);
        }
        ad adVar = new ad(i3, str);
        adVar.f305497c = this.f305508f.e();
        adVar.f305498d = this.f305508f.p();
        adVar.f305500f = this.f305508f.f();
        adVar.f305501g = this.f305508f.j();
        return adVar;
    }

    protected boolean W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.f r16 = ((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c).r();
        if (r16 != null) {
            return r16.e();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] on calc hash op done retCode:" + i3);
        this.f305508f.x(System.currentTimeMillis());
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 9042;
            } else {
                i16 = 9041;
            }
            N(i16, V(2, "get md5 failed"));
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        n(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c;
        com.tencent.mobileqq.uftransfer.api.i iVar = new com.tencent.mobileqq.uftransfer.api.i();
        iVar.g(bVar.c());
        iVar.j(bVar.z());
        iVar.h(bVar.s());
        this.f305509g.d(this.f305358b, iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] file is hit");
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        this.f305508f.z(true);
        this.f305508f.L(this.f305359c.f());
        this.f305508f.K(this.f305359c.f());
        M();
    }

    protected void a0(int i3, String str, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] on send msg op done. errCode:" + i3 + " errMsg:" + str + " seq:" + i16 + " uniSeq:" + j3);
        N(i3, V(6, str));
    }

    protected void b0(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] on set uploadsuc done errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            N(i3, V(5, str));
        } else if (((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c).y()) {
            L();
        } else {
            N(0, V(5, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(a.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
            return;
        }
        this.f305508f.I(System.currentTimeMillis());
        this.f305508f.z(bVar.q());
        this.f305508f.A(bVar.o());
        this.f305508f.J(bVar.n());
        q qVar = this.f305424j;
        if (qVar != null) {
            this.f305508f.H(qVar.B());
            this.f305508f.L(this.f305424j.z());
            this.f305508f.K(this.f305424j.A());
            this.f305508f.C(this.f305424j.x());
            this.f305508f.B(this.f305424j.w());
            this.f305508f.D(this.f305424j.y());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] on upload file op done. errCode:" + bVar.c() + " flash:" + this.f305508f.u() + " speed:" + this.f305508f.j() + " httpTime:" + this.f305508f.f() + " url:" + this.f305508f.n() + " upStartSize:" + this.f305508f.r() + " upEndSize:" + this.f305508f.q());
        if (bVar.c() != 0) {
            ad V = V(4, bVar.d());
            V.f305499e = bVar.p();
            N(bVar.c(), V);
        } else {
            this.f305508f.K(this.f305359c.f());
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d0(long j3, int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Integer.valueOf(i3), adVar);
            return;
        }
        o Q = Q(false);
        Q.f305593s = i3;
        String str = adVar.f305496b;
        Q.f305594t = str;
        Q.f305596v = adVar.f305497c;
        Q.f305595u = str;
        if (j3 > this.f305508f.r()) {
            Q.f305583i = j3 - this.f305508f.r();
        }
        Q.f305584j = j3;
        Q.f305588n = adVar.f305500f;
        Q.f305589o = adVar.f305501g;
        Q.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e0(long j3, int i3, ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Integer.valueOf(i3), adVar);
            return;
        }
        o Q = Q(false);
        Q.f305593s = i3;
        String str = adVar.f305496b;
        Q.f305594t = str;
        Q.f305596v = adVar.f305497c;
        Q.f305595u = str;
        if (j3 > this.f305508f.r()) {
            Q.f305583i = j3 - this.f305508f.r();
        }
        Q.f305584j = j3;
        Q.f305588n = this.f305508f.f();
        Q.f305589o = this.f305508f.j();
        Q.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        o Q = Q(true);
        Q.f305593s = 0L;
        if (!this.f305508f.u() && this.f305359c.d().f() > this.f305508f.r()) {
            Q.f305583i = this.f305359c.d().f() - this.f305508f.r();
        }
        Q.f305584j = this.f305359c.d().f();
        Q.f305588n = this.f305508f.f();
        Q.f305589o = this.f305508f.j();
        if (this.f305508f.t() > 0) {
            str = "ChangedUrlCount[" + this.f305508f.t() + "]";
        } else {
            str = null;
        }
        Q.f305586l = str;
        Q.d();
        Q.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bundle);
            return;
        }
        this.f305509g.k(true);
        String str = "userCancel" + System.currentTimeMillis();
        long q16 = this.f305508f.q();
        q qVar = this.f305424j;
        if (qVar != null) {
            q16 = qVar.A();
        }
        ad V = V(7, str);
        d0(q16, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL, V);
        e0(q16, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL, V);
        H();
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
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTC2CUploadTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((UFTBaseTask) UFTC2CUploadTask.this).f305361e) {
                    return;
                }
                UFTC2CUploadTask uFTC2CUploadTask = UFTC2CUploadTask.this;
                uFTC2CUploadTask.f305509g.c(((UFTBaseTask) uFTC2CUploadTask).f305358b, 1, null);
                String r16 = UFTC2CUploadTask.this.r();
                if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + UFTC2CUploadTask.this.d() + "] send local file[" + r16 + "] no network");
                    UFTC2CUploadTask uFTC2CUploadTask2 = UFTC2CUploadTask.this;
                    uFTC2CUploadTask2.N(9004, uFTC2CUploadTask2.V(1, "NoNetWork"));
                    return;
                }
                if (TextUtils.isEmpty(r16)) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + UFTC2CUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is null");
                    UFTC2CUploadTask uFTC2CUploadTask3 = UFTC2CUploadTask.this;
                    uFTC2CUploadTask3.N(9005, uFTC2CUploadTask3.V(1, "strFilePath is null"));
                    return;
                }
                if (!com.tencent.mobileqq.uftransfer.utility.a.a(r16)) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + UFTC2CUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is not exist");
                    UFTC2CUploadTask uFTC2CUploadTask4 = UFTC2CUploadTask.this;
                    uFTC2CUploadTask4.N(9042, uFTC2CUploadTask4.V(1, "fileNotExists"));
                    return;
                }
                if (com.tencent.mobileqq.uftransfer.utility.a.b(r16) == 0) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + UFTC2CUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is empty file");
                    UFTC2CUploadTask uFTC2CUploadTask5 = UFTC2CUploadTask.this;
                    uFTC2CUploadTask5.N(9071, uFTC2CUploadTask5.V(1, "fileExistsEmpty"));
                    return;
                }
                UFTC2CUploadTask.this.K();
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
            return;
        }
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        q qVar = this.f305424j;
        if (qVar != null) {
            this.f305508f.K(qVar.A());
            this.f305508f.B(this.f305424j.w());
            this.f305508f.D(this.f305424j.y());
        }
        if (bundle != null) {
            i3 = bundle.getInt("REASON");
        } else {
            i3 = 0;
        }
        this.f305508f.y(System.currentTimeMillis());
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] stop ..." + i3);
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
        } else if (uploadInfoEntity != null && uploadInfoEntity.isValidC2CCache()) {
            com.tencent.mobileqq.uftransfer.task.utils.a.a((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c, uploadInfoEntity);
            v(0, "", "");
        } else {
            J();
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return ((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c).o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    public void v(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, str2);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadTask", 1, "TId[" + d() + "] on fetch url op done errCode:" + i3 + " errMsg:" + str);
        this.f305508f.w(System.currentTimeMillis());
        if (i3 != 0) {
            N(i3, V(3, str));
            return;
        }
        Y();
        if (((com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305359c).x()) {
            Z();
        } else {
            O();
        }
    }
}
