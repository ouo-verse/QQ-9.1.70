package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes19.dex */
public class r extends UFTBaseOp {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected final boolean f305599j;

    /* renamed from: k, reason: collision with root package name */
    protected final boolean f305600k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements g.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) r.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.proto.g.c
        public void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), fVar);
            } else {
                if (((UFTBaseOp) r.this).f305346e) {
                    return;
                }
                r.this.y(z16, fVar);
            }
        }
    }

    public r(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar) {
        super(appRuntime, cVar, aVar, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, cVar, aVar, bVar);
        } else {
            this.f305599j = cVar.b().a().e();
            this.f305600k = cVar.b().a().f();
        }
    }

    protected void A(com.tencent.mobileqq.uftransfer.task.taskinfo.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gVar);
            return;
        }
        if (gVar == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305343b;
        if (!TextUtils.isEmpty(gVar.m())) {
            cVar.j(gVar.m());
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] updateUploadTaskInfo srvBusiProp:" + gVar.toString());
        cVar.u(gVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] do fetch disc upload url op." + x());
        com.tencent.mobileqq.uftransfer.task.taskinfo.c cVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305343b;
        com.tencent.mobileqq.uftransfer.proto.e eVar = new com.tencent.mobileqq.uftransfer.proto.e();
        eVar.g(cVar.q());
        eVar.h(cVar.e());
        eVar.i(cVar.f());
        eVar.j(this.f305342a.getCurrentUin());
        eVar.k(com.tencent.mobileqq.uftransfer.depend.a.z(cVar.d().a()));
        eVar.l(com.tencent.mobileqq.uftransfer.depend.a.z(cVar.d().c()));
        if (!z(eVar)) {
            t("request url fail");
            return 9001;
        }
        return 0;
    }

    protected String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return " cfg = useHttps:" + this.f305599j + " useIPv6:" + this.f305600k;
    }

    protected void y(boolean z16, com.tencent.mobileqq.uftransfer.proto.f fVar) {
        String str;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), fVar);
            return;
        }
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        if (!z16) {
            int d16 = fVar.d();
            if (d16 == 0) {
                d16 = 9001;
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] request disc upload url fail. errCode:" + d16);
            A(new com.tencent.mobileqq.uftransfer.task.taskinfo.g(fVar));
            aVar.f(d16);
            aVar.g(fVar.e());
            r(aVar);
            return;
        }
        if (fVar.d() != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] request disc upload url return error. errCode:" + fVar.d());
            A(new com.tencent.mobileqq.uftransfer.task.taskinfo.g(fVar));
            aVar.f(fVar.d());
            aVar.g(fVar.e());
            r(aVar);
            return;
        }
        boolean z26 = !TextUtils.isEmpty(fVar.g());
        boolean isEmpty = TextUtils.isEmpty(fVar.a());
        if (z26 && isEmpty) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] request disc upload url return empty uuid.");
            A(new com.tencent.mobileqq.uftransfer.task.taskinfo.g(fVar));
            aVar.f(9015);
            aVar.g("uuid_null[" + fVar.toString() + "]");
            r(aVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] request disc upload url suc rsp:" + fVar.toString());
        int c16 = fVar.c();
        if (this.f305599j && !TextUtils.isEmpty(fVar.h())) {
            String h16 = fVar.h();
            int b16 = fVar.b();
            if (b16 == 0) {
                b16 = WebSocketImpl.DEFAULT_WSS_PORT;
            }
            z17 = true;
            int i3 = b16;
            str = h16;
            c16 = i3;
        } else {
            str = null;
            if (c16 == 0) {
                c16 = 80;
            }
            z17 = false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, fVar.g() + ":" + c16);
        if (this.f305600k && !TextUtils.isEmpty(fVar.i())) {
            ArrayList arrayList2 = new ArrayList();
            int o16 = com.tencent.mobileqq.uftransfer.depend.a.o(this.f305342a, fVar.i(), c16, 5, arrayList2);
            if (arrayList2.size() > 0) {
                if (o16 == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                arrayList.addAll(0, arrayList2);
                z19 = true;
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] disc upload ftn host info is :UrlHostInfo{hostList=" + arrayList + ", useHttps=" + z17 + ", httpsDomain='" + str + "', useIpV6=" + z19 + ", useDnsIpV6=" + z18 + '}');
                com.tencent.mobileqq.uftransfer.task.taskinfo.g gVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.g(fVar);
                gVar.g(arrayList);
                gVar.i("/ftn_handler");
                gVar.k(z17);
                gVar.h(str);
                gVar.l(z19);
                gVar.j(z18);
                gVar.q(fVar.f());
                gVar.r(com.tencent.mobileqq.uftransfer.depend.a.z(((com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305343b).d().c()));
                A(gVar);
                aVar.f(0);
                r(aVar);
            }
        }
        z18 = false;
        z19 = false;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] disc upload ftn host info is :UrlHostInfo{hostList=" + arrayList + ", useHttps=" + z17 + ", httpsDomain='" + str + "', useIpV6=" + z19 + ", useDnsIpV6=" + z18 + '}');
        com.tencent.mobileqq.uftransfer.task.taskinfo.g gVar2 = new com.tencent.mobileqq.uftransfer.task.taskinfo.g(fVar);
        gVar2.g(arrayList);
        gVar2.i("/ftn_handler");
        gVar2.k(z17);
        gVar2.h(str);
        gVar2.l(z19);
        gVar2.j(z18);
        gVar2.q(fVar.f());
        gVar2.r(com.tencent.mobileqq.uftransfer.depend.a.z(((com.tencent.mobileqq.uftransfer.task.taskinfo.c) this.f305343b).d().c()));
        A(gVar2);
        aVar.f(0);
        r(aVar);
    }

    protected boolean z(com.tencent.mobileqq.uftransfer.proto.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar)).booleanValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchDiscUploadUrlOp", 1, "TId[" + p() + "] request disc upload url.");
        return com.tencent.mobileqq.uftransfer.proto.g.b().g(this.f305342a, eVar, new a());
    }
}
