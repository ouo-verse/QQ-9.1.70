package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class z extends UFTBaseOp {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected final boolean f305651j;

    /* renamed from: k, reason: collision with root package name */
    protected final boolean f305652k;

    /* renamed from: l, reason: collision with root package name */
    protected final boolean f305653l;

    /* renamed from: m, reason: collision with root package name */
    protected Object f305654m;

    /* renamed from: n, reason: collision with root package name */
    protected final boolean f305655n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements g.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.d
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), jVar);
            } else {
                if (((UFTBaseOp) z.this).f305346e) {
                    return;
                }
                z.this.A(z16, jVar, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements g.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.d
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), jVar);
            } else {
                if (((UFTBaseOp) z.this).f305346e) {
                    return;
                }
                z.this.A(z16, jVar, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        List<String> f305658a;

        /* renamed from: b, reason: collision with root package name */
        boolean f305659b;

        /* renamed from: c, reason: collision with root package name */
        String f305660c;

        /* renamed from: d, reason: collision with root package name */
        boolean f305661d;

        /* renamed from: e, reason: collision with root package name */
        boolean f305662e;

        protected c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) z.this);
                return;
            }
            this.f305659b = false;
            this.f305661d = false;
            this.f305662e = false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UrlHostInfo{hostList=" + this.f305658a + ", useHttps=" + this.f305659b + ", httpsDomain='" + this.f305660c + "', useIpV6=" + this.f305661d + ", useDnsIpV6=" + this.f305662e + '}';
        }
    }

    public z(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, boolean z16, UFTBaseOp.b bVar) {
        super(appRuntime, dVar, aVar, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, dVar, aVar, Boolean.valueOf(z16), bVar);
            return;
        }
        this.f305654m = null;
        this.f305651j = dVar.b().a().e();
        this.f305652k = dVar.b().a().f();
        this.f305653l = dVar.b().a().d();
        this.f305655n = z16;
    }

    protected void A(boolean z16, com.tencent.mobileqq.uftransfer.proto.j jVar, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), jVar, Boolean.valueOf(z17));
            return;
        }
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        if (!z16) {
            int g16 = jVar.g();
            if (g16 != 0) {
                i3 = g16;
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] request troop upload url fail. errCode:" + i3);
            D(new com.tencent.mobileqq.uftransfer.task.taskinfo.h(jVar));
            aVar.f(i3);
            aVar.g(jVar.h());
            aVar.h(jVar.b());
            r(aVar);
            return;
        }
        if (jVar.g() != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] request troop upload url return error. errCode:" + jVar.g());
            aVar.f(jVar.g());
            aVar.g(jVar.h());
            aVar.h(jVar.b());
            D(new com.tencent.mobileqq.uftransfer.task.taskinfo.h(jVar));
            r(aVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] request troop upload url suc rsp:" + jVar.toString());
        com.tencent.mobileqq.uftransfer.task.taskinfo.h hVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.h(jVar);
        if (!this.f305653l) {
            c y16 = y(jVar, z17);
            hVar.k(y16.f305659b);
            hVar.h(y16.f305660c);
            hVar.g(y16.f305658a);
            hVar.i("/ftn_handler");
            hVar.l(y16.f305661d);
            hVar.y(com.tencent.mobileqq.uftransfer.depend.a.a(jVar.a()));
            hVar.z(com.tencent.mobileqq.uftransfer.depend.a.z(this.f305343b.d().c()));
        }
        D(hVar);
        aVar.f(0);
        aVar.g(jVar.h());
        aVar.h(jVar.b());
        r(aVar);
    }

    protected boolean B(com.tencent.mobileqq.uftransfer.proto.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] request troop re upload url.");
        Object h16 = com.tencent.mobileqq.uftransfer.proto.g.b().h(this.f305342a, hVar, new b());
        this.f305654m = h16;
        if (h16 != null) {
            return true;
        }
        return false;
    }

    protected boolean C(com.tencent.mobileqq.uftransfer.proto.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] request troop upload url.");
        Object i3 = com.tencent.mobileqq.uftransfer.proto.g.b().i(this.f305342a, iVar, new a());
        this.f305654m = i3;
        if (i3 != null) {
            return true;
        }
        return false;
    }

    protected void D(com.tencent.mobileqq.uftransfer.task.taskinfo.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) hVar);
            return;
        }
        if (hVar == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305343b;
        if (!TextUtils.isEmpty(hVar.p())) {
            dVar.j(hVar.p());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] updateUploadTaskInfo srvBusiProp:" + hVar.toString());
        dVar.B(hVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        boolean C;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] do fetch troop upload url op." + z());
        com.tencent.mobileqq.uftransfer.task.taskinfo.d dVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305343b;
        if (this.f305655n) {
            com.tencent.mobileqq.uftransfer.proto.h hVar = new com.tencent.mobileqq.uftransfer.proto.h();
            hVar.e(dVar.o());
            hVar.f(dVar.d().c());
            hVar.g(dVar.c());
            hVar.h(Long.valueOf(dVar.u()).longValue());
            C = B(hVar);
        } else {
            com.tencent.mobileqq.uftransfer.proto.i iVar = new com.tencent.mobileqq.uftransfer.proto.i();
            iVar.l(dVar.o());
            iVar.m(dVar.d().b());
            iVar.n(dVar.d().c());
            iVar.o(dVar.d().d());
            iVar.p(dVar.r());
            iVar.q(this.f305653l);
            iVar.r(dVar.f());
            iVar.s(dVar.e());
            iVar.t(dVar.s());
            iVar.u(dVar.x());
            iVar.v(Long.valueOf(dVar.u()).longValue());
            C = C(iVar);
        }
        if (!C) {
            t("request url fail");
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.v();
        if (this.f305654m != null) {
            com.tencent.mobileqq.uftransfer.proto.g.b().a(this.f305342a, this.f305654m);
            this.f305654m = null;
        }
    }

    protected c y(com.tencent.mobileqq.uftransfer.proto.j jVar, boolean z16) {
        String str;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, this, jVar, Boolean.valueOf(z16));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(jVar.j());
        if (!TextUtils.isEmpty(jVar.i())) {
            arrayList.add(jVar.i());
        }
        String i3 = jVar.i();
        if (z16) {
            i3 = ((com.tencent.mobileqq.uftransfer.task.taskinfo.d) this.f305343b).q();
        }
        if (this.f305651j && !TextUtils.isEmpty(i3)) {
            z17 = true;
            str = i3;
        } else {
            str = null;
            z17 = false;
        }
        if (this.f305652k && !TextUtils.isEmpty(i3)) {
            ArrayList arrayList2 = new ArrayList();
            int o16 = com.tencent.mobileqq.uftransfer.depend.a.o(this.f305342a, jVar.i(), 0, 3, arrayList2);
            if (arrayList2.size() > 0) {
                if (o16 == 1) {
                    arrayList.removeAll(arrayList2);
                    z18 = true;
                } else {
                    z18 = false;
                }
                arrayList.addAll(0, arrayList2);
                z19 = true;
                c cVar = new c();
                cVar.f305658a = arrayList;
                cVar.f305659b = z17;
                cVar.f305660c = str;
                cVar.f305661d = z19;
                cVar.f305662e = z18;
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] troop upload ftn host info is :" + cVar.toString());
                return cVar;
            }
        }
        z18 = false;
        c cVar2 = new c();
        cVar2.f305658a = arrayList;
        cVar2.f305659b = z17;
        cVar2.f305660c = str;
        cVar2.f305661d = z19;
        cVar2.f305662e = z18;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchTroopUploadUrlOp", 1, "TId[" + p() + "] troop upload ftn host info is :" + cVar2.toString());
        return cVar2;
    }

    protected String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return " cfg = useHttps:" + this.f305651j + " useIPv6:" + this.f305652k + " useExtf:" + this.f305653l + " reUpload:" + this.f305655n;
    }
}
