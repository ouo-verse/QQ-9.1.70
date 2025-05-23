package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.a;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTDiscUploadTask extends com.tencent.mobileqq.uftransfer.task.upload.d {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.task.commonop.a f305431h;

    /* renamed from: i, reason: collision with root package name */
    protected r f305432i;

    /* renamed from: j, reason: collision with root package name */
    protected t f305433j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends UFTBaseOp.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTDiscUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                UFTDiscUploadTask.this.R(aVar.c());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTDiscUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                UFTDiscUploadTask.this.S(aVar.c(), aVar.d());
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTDiscUploadTask.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp.b
        public void b(UFTBaseOp.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            } else if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                a.b bVar = (a.b) aVar;
                UFTDiscUploadTask.this.U(bVar.c(), bVar.q(), bVar.d(), bVar.o());
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void d(long j3, long j16, long j17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            } else if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                UFTDiscUploadTask.this.f305508f.K(j3);
                UFTDiscUploadTask uFTDiscUploadTask = UFTDiscUploadTask.this;
                uFTDiscUploadTask.f305509g.h(((UFTBaseTask) uFTDiscUploadTask).f305358b, ((UFTBaseTask) UFTDiscUploadTask.this).f305359c.f(), j3, j17);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void e(int i3, String str, long j3, String str2, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Long.valueOf(j3), str2, obj);
            } else if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e && i3 != 0) {
                UFTDiscUploadTask.this.V(j3, i3, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.a.AbstractC8873a
        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                return;
            }
            UFTDiscUploadTask.this.f305508f.H(str);
            com.tencent.mobileqq.uftransfer.task.taskinfo.i iVar = UFTDiscUploadTask.this.f305508f;
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UFTDiscUploadTask.this);
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
            if (!((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                if (z16) {
                    if (j3 != 0) {
                        str = "send msg return error.retCode:" + j3;
                    } else {
                        str = "";
                        j3 = 0;
                    }
                } else {
                    str = "send msg return fail.retCode:" + j3;
                    j3 = 90460;
                }
                UFTDiscUploadTask.this.T((int) j3, str);
            }
        }
    }

    protected UFTDiscUploadTask(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        super(appRuntime, aVar, cVar, aVar2, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, cVar, aVar2, bVar);
        }
    }

    public static UFTDiscUploadTask Q(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar, com.tencent.mobileqq.uftransfer.task.a aVar2, com.tencent.mobileqq.uftransfer.api.b bVar) {
        if (UFTBaseTask.c(appRuntime, aVar, cVar, aVar2, "[UFTTransfer] UFTDiscUploadTask")) {
            return new UFTDiscUploadTask(appRuntime, aVar, cVar, aVar2, bVar);
        }
        return null;
    }

    protected void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] cancel all Op...");
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = this.f305431h;
        if (aVar != null) {
            aVar.v();
            this.f305431h = null;
        }
        r rVar = this.f305432i;
        if (rVar != null) {
            rVar.v();
            this.f305432i = null;
        }
        t tVar = this.f305433j;
        if (tVar != null) {
            tVar.v();
            this.f305433j = null;
        }
    }

    protected void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f305431h != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] calc hash op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] do calc hash op ...");
        this.f305509g.c(this.f305358b, 2, null);
        com.tencent.mobileqq.uftransfer.task.commonop.a aVar = new com.tencent.mobileqq.uftransfer.task.commonop.a(this.f305357a, this.f305359c, this.f305358b, r(), 25L, new a());
        this.f305431h = aVar;
        int u16 = aVar.u();
        if (u16 != 0) {
            R(u16);
        }
    }

    protected void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.f305432i != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] fetch url op had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] do fetch url op ...");
        this.f305509g.c(this.f305358b, 3, null);
        r rVar = new r(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c, this.f305358b, new b());
        this.f305432i = rVar;
        int u16 = rVar.u();
        if (u16 != 0) {
            S(u16, this.f305432i.o());
        }
    }

    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            H();
        }
    }

    protected void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] do send msg op ...");
        this.f305509g.c(this.f305358b, 6, null);
        if (this.f305509g.a(this.f305358b, null, new d()) != 0) {
            T(FileMsg.RESULT_CODE_0X211_CCMSG_ERROR, "send msg fail");
        }
    }

    protected void L(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.f305361e) {
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] do upload completed errCode:" + i3 + " errMsg:" + str);
        G();
        this.f305508f.y(System.currentTimeMillis());
        if (i3 != 0) {
            V(this.f305508f.q(), i3, str, str2);
            W(this.f305508f.q(), i3, str, str2);
        } else {
            X(str2);
        }
        this.f305509g.f(this.f305358b, i3, P(i3, str));
        g(i3);
    }

    protected void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.f305433j != null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] upload file had do");
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] do upload file op ...");
        this.f305508f.M(System.currentTimeMillis());
        this.f305509g.c(this.f305358b, 4, null);
        t tVar = new t(this.f305357a, (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c, this.f305358b, new c());
        this.f305433j = tVar;
        int u16 = tVar.u();
        if (u16 != 0) {
            U(u16, false, this.f305433j.o(), null);
        } else {
            this.f305508f.H(this.f305433j.B());
        }
    }

    protected void N(int i3, Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) bundle);
            return;
        }
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        G();
        super.k(bundle);
        if (z16) {
            ac P = P(9004, "net changed");
            P.g(i3);
            this.f305509g.f(this.f305358b, 9004, P);
            return;
        }
        this.f305509g.k(true);
    }

    protected s O() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (s) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c;
        AppRuntime appRuntime = this.f305357a;
        s sVar = new s(appRuntime, appRuntime.getCurrentUin());
        sVar.f305614m = this.f305508f.n();
        sVar.f305615n = cVar.q();
        sVar.f305616o = 3000;
        sVar.f305617p = cVar.c();
        sVar.f305620s = cVar.f();
        t tVar = this.f305433j;
        if (tVar != null) {
            i3 = tVar.x();
        } else {
            i3 = 0;
        }
        sVar.f305621t = i3;
        sVar.f305608g = this.f305358b.b();
        sVar.f305610i = this.f305508f.k();
        sVar.f305610i = this.f305508f.a();
        sVar.f305611j = this.f305508f.s();
        sVar.f305612k = this.f305508f.o();
        return sVar;
    }

    protected ac P(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ac) iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) str);
        }
        ac acVar = new ac();
        com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c;
        acVar.d(this.f305508f.u());
        acVar.c(cVar.c());
        acVar.h(this.f305508f.n());
        if (!TextUtils.isEmpty(cVar.s()) && !com.tencent.mobileqq.uftransfer.proto.g.c(i3)) {
            acVar.b(cVar.s());
        }
        return acVar;
    }

    protected void R(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] on calc hash op done retCode:" + i3);
        if (i3 != 0) {
            if (i3 == 1) {
                i16 = 9042;
            } else {
                i16 = 9041;
            }
            L(i16, "get md5 failed", null);
            return;
        }
        this.f305509g.b(this.f305358b, this.f305359c.d());
        I();
    }

    protected void S(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] on fetch url op done errCode:" + i3 + " errMsg:" + str);
        if (i3 != 0) {
            L(i3, str, null);
            return;
        }
        com.tencent.mobileqq.uftransfer.api.i iVar = new com.tencent.mobileqq.uftransfer.api.i();
        iVar.g(this.f305359c.c());
        this.f305509g.d(this.f305358b, iVar);
        M();
    }

    protected void T(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] on send msg op done errCode:" + i3 + " errMsg:" + str);
        L(i3, str, null);
    }

    protected void U(int i3, boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), str, str2);
            return;
        }
        this.f305508f.I(System.currentTimeMillis());
        this.f305508f.z(z16);
        this.f305508f.A(str2);
        t tVar = this.f305433j;
        if (tVar != null) {
            this.f305508f.H(tVar.B());
            this.f305508f.L(this.f305433j.z());
            this.f305508f.C(this.f305433j.x());
            this.f305508f.B(this.f305433j.w());
            this.f305508f.D(this.f305433j.y());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] on upload file op done. errCode:" + i3 + " flash:" + this.f305508f.u() + " speed:" + this.f305508f.j() + " httpTime:" + this.f305508f.f() + " url:" + this.f305508f.n() + " upStartSize:" + this.f305508f.r() + " upEndSize:" + this.f305508f.q());
        if (i3 != 0) {
            L(i3, str, str2);
            return;
        }
        this.f305508f.K(this.f305359c.f());
        if (((com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c).t()) {
            K();
        } else {
            L(0, "", null);
        }
    }

    protected void V(long j3, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2);
            return;
        }
        s O = O();
        O.f305606e = i3;
        O.f305607f = str;
        O.f305618q = j3;
        O.f305622u = str2;
        O.c();
    }

    protected void W(long j3, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Long.valueOf(j3), Integer.valueOf(i3), str, str2);
            return;
        }
        s O = O();
        O.f305606e = i3;
        O.f305607f = str;
        O.f305618q = j3;
        O.f305622u = str2;
        O.b();
    }

    protected void X(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        s O = O();
        O.f305606e = 0L;
        O.f305607f = "";
        O.f305618q = this.f305359c.f();
        O.f305622u = str;
        O.b();
    }

    protected void Y(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
            return;
        }
        this.f305509g.k(true);
        String str = "userCancel" + System.currentTimeMillis();
        long q16 = this.f305508f.q();
        t tVar = this.f305433j;
        if (tVar != null) {
            q16 = tVar.A();
        }
        long j3 = q16;
        V(j3, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL, str, null);
        W(j3, AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL, str, null);
        G();
        super.k(bundle);
    }

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
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTDiscUploadTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((UFTBaseTask) UFTDiscUploadTask.this).f305361e) {
                    return;
                }
                UFTDiscUploadTask uFTDiscUploadTask = UFTDiscUploadTask.this;
                uFTDiscUploadTask.f305509g.c(((UFTBaseTask) uFTDiscUploadTask).f305358b, 1, null);
                String r16 = UFTDiscUploadTask.this.r();
                if (!com.tencent.mobileqq.uftransfer.depend.a.A()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + UFTDiscUploadTask.this.d() + "] send local file[" + r16 + "] no network");
                    UFTDiscUploadTask.this.L(9004, "NoNetWork", null);
                    return;
                }
                if (TextUtils.isEmpty(r16)) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + UFTDiscUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is null");
                    UFTDiscUploadTask.this.L(9005, "strFilePath is null", null);
                    return;
                }
                if (!com.tencent.mobileqq.uftransfer.utility.a.a(r16)) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + UFTDiscUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is not exist");
                    UFTDiscUploadTask.this.L(9042, "fileNotExists", null);
                    return;
                }
                if (com.tencent.mobileqq.uftransfer.utility.a.b(r16) == 0) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + UFTDiscUploadTask.this.d() + "] send local file[" + r16 + "] strFilePath is empty file");
                    UFTDiscUploadTask.this.L(9071, "fileExistsEmpty", null);
                    return;
                }
                UFTDiscUploadTask.this.J();
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseTask
    public void k(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
            return;
        }
        if (this.f305508f.s() > 0) {
            this.f305508f.I(System.currentTimeMillis());
        }
        t tVar = this.f305433j;
        if (tVar != null) {
            this.f305508f.K(tVar.A());
            this.f305508f.B(this.f305433j.w());
            this.f305508f.D(this.f305433j.y());
        }
        if (bundle != null) {
            i3 = bundle.getInt("REASON");
        } else {
            i3 = 0;
        }
        com.tencent.mobileqq.uftransfer.depend.c.e("[UFTTransfer] UFTDiscUploadTask", 1, "TId[" + d() + "] stop ..." + i3);
        if (i3 == 0) {
            Y(bundle);
        } else {
            N(i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.upload.d
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return ((com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305359c).o();
    }
}
