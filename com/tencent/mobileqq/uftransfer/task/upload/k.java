package com.tencent.mobileqq.uftransfer.task.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.java_websocket.WebSocketImpl;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class k extends UFTBaseOp {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    protected final boolean f305560j;

    /* renamed from: k, reason: collision with root package name */
    protected final boolean f305561k;

    /* renamed from: l, reason: collision with root package name */
    protected final boolean f305562l;

    /* renamed from: m, reason: collision with root package name */
    protected final boolean f305563m;

    /* renamed from: n, reason: collision with root package name */
    protected String f305564n;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    protected class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        List<String> f305565a;

        /* renamed from: b, reason: collision with root package name */
        boolean f305566b;

        /* renamed from: c, reason: collision with root package name */
        String f305567c;

        /* renamed from: d, reason: collision with root package name */
        boolean f305568d;

        /* renamed from: e, reason: collision with root package name */
        boolean f305569e;

        protected a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
                return;
            }
            this.f305566b = false;
            this.f305568d = false;
            this.f305569e = false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UrlHostInfo{hostList=" + this.f305565a + ", useHttps=" + this.f305566b + ", httpsDomain='" + this.f305567c + "', useIpV6=" + this.f305568d + ", useDnsIpV6=" + this.f305569e + '}';
        }
    }

    public k(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar, UFTBaseOp.b bVar2) {
        super(appRuntime, bVar, aVar, bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, bVar, aVar, bVar2);
            return;
        }
        this.f305560j = bVar.b().a().e();
        this.f305561k = bVar.b().a().f();
        this.f305562l = bVar.b().a().d();
        this.f305563m = bVar.b().a().c();
        A();
    }

    private void A() {
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        byte[] a16 = bVar.d().a();
        byte[] bArr = new byte[a16.length + 4];
        com.tencent.mobileqq.uftransfer.depend.a.c(bArr, 0, a16, a16.length);
        com.tencent.mobileqq.uftransfer.depend.a.d(bArr, a16.length, bVar.f());
        this.f305564n = com.tencent.mobileqq.uftransfer.depend.a.a(bArr).toLowerCase(Locale.US);
    }

    protected abstract void B(com.tencent.mobileqq.uftransfer.proto.d dVar);

    protected abstract boolean C(com.tencent.mobileqq.uftransfer.proto.c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
            return;
        }
        if (fVar == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        if (fVar.o() != null && fVar.o().length > 0) {
            bVar.j(new String(fVar.o()));
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] updateUploadTaskInfo srvBusiProp:" + fVar.toString());
        bVar.A(fVar);
    }

    @Override // com.tencent.mobileqq.uftransfer.task.UFTBaseOp
    protected int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] do fetch c2c upload url op." + y());
        com.tencent.mobileqq.uftransfer.proto.c cVar = new com.tencent.mobileqq.uftransfer.proto.c();
        int w3 = w(cVar);
        if (w3 != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] fetch c2c upload url fail. build upload req fail. retCode:" + w3);
            return w3;
        }
        if (!C(cVar)) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] request c2c upload url fail");
            t("request url fail");
            return 9001;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(com.tencent.mobileqq.uftransfer.proto.c cVar) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar)).intValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.b bVar = (com.tencent.mobileqq.uftransfer.task.taskinfo.b) this.f305343b;
        try {
            byte[] bytes = bVar.e().getBytes("utf-8");
            byte[] bytes2 = bVar.o().getBytes("utf-8");
            try {
                j3 = Long.parseLong(this.f305342a.getCurrentAccountUin());
            } catch (NumberFormatException unused) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] send uin err.");
                j3 = 0;
            }
            cVar.k(j3);
            cVar.j(Long.parseLong(bVar.q().replace(Marker.ANY_NON_NULL_MARKER, "")));
            cVar.g(bVar.u());
            cVar.h(bVar.v());
            cVar.i(bVar.w());
            cVar.B(bVar.f());
            cVar.z(new String(bytes));
            cVar.A(new String(bytes2));
            cVar.v(bVar.d().a());
            return 0;
        } catch (Exception unused2) {
            t("strFilePath to bytes fail");
            return 9005;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a x(com.tencent.mobileqq.uftransfer.proto.d dVar) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar);
        }
        List<String> f16 = dVar.f();
        int h16 = dVar.h();
        if (this.f305560j && !TextUtils.isEmpty(dVar.m())) {
            String m3 = dVar.m();
            int c16 = dVar.c();
            if (c16 == 0) {
                c16 = WebSocketImpl.DEFAULT_WSS_PORT;
            }
            z16 = true;
            int i3 = c16;
            str = m3;
            h16 = i3;
        } else {
            str = null;
            if (h16 == 0) {
                h16 = 80;
            }
            z16 = false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.n() + ":" + h16);
        if (f16 != null) {
            for (String str2 : f16) {
                if (!arrayList.contains(str2 + ":" + h16)) {
                    arrayList.add(str2 + ":" + h16);
                }
            }
        }
        if (this.f305561k && !TextUtils.isEmpty(dVar.b())) {
            ArrayList arrayList2 = new ArrayList();
            int o16 = com.tencent.mobileqq.uftransfer.depend.a.o(this.f305342a, dVar.b(), h16, 1, arrayList2);
            if (arrayList2.size() > 0) {
                if (o16 == 1) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                arrayList.addAll(0, arrayList2);
                z17 = true;
                if (this.f305563m && !z16 && !z17) {
                    arrayList.clear();
                    arrayList.add(0, "14.17.29.27:" + dVar.h());
                }
                a aVar = new a();
                aVar.f305565a = arrayList;
                aVar.f305566b = z16;
                aVar.f305567c = str;
                aVar.f305568d = z17;
                aVar.f305569e = z18;
                com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] c2c upload ftn host info is :" + aVar.toString());
                return aVar;
            }
        }
        z17 = false;
        z18 = false;
        if (this.f305563m) {
            arrayList.clear();
            arrayList.add(0, "14.17.29.27:" + dVar.h());
        }
        a aVar2 = new a();
        aVar2.f305565a = arrayList;
        aVar2.f305566b = z16;
        aVar2.f305567c = str;
        aVar2.f305568d = z17;
        aVar2.f305569e = z18;
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] c2c upload ftn host info is :" + aVar2.toString());
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return " cfg = useHttps:" + this.f305560j + " useIPv6:" + this.f305561k + " useExtf:" + this.f305562l + " ftnSpTst:" + this.f305563m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), dVar);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.f fVar = new com.tencent.mobileqq.uftransfer.task.taskinfo.f(dVar);
        UFTBaseOp.a aVar = new UFTBaseOp.a();
        if (!z16) {
            int i3 = dVar.i();
            String j3 = dVar.j();
            if (i3 == 0) {
                i3 = 9001;
            }
            if (TextUtils.isEmpty(j3)) {
                j3 = "request url rsp fail";
            }
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] request c2c upload url fail. errCode:" + i3);
            aVar.f(i3);
            aVar.g(j3);
            D(fVar);
            r(aVar);
            return;
        }
        if (dVar.i() != 0) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] request c2c upload url return error. errCode:" + dVar.i());
            aVar.f(dVar.i());
            aVar.g(dVar.j());
            D(fVar);
            r(aVar);
            return;
        }
        boolean z18 = !TextUtils.isEmpty(dVar.n());
        if (dVar.o() == null || dVar.o().length == 0) {
            z17 = true;
        }
        if (z18 && z17) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTFetchC2CUploadUrlOp", 1, "TId[" + p() + "] request c2c upload url return empty uuid.");
            aVar.f(9015);
            aVar.g("uuid_null[" + dVar.toString() + "]");
            D(fVar);
            r(aVar);
            return;
        }
        B(dVar);
    }
}
