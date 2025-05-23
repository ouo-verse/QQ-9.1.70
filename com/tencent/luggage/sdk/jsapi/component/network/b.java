package com.tencent.luggage.sdk.jsapi.component.network;

import com.tencent.luggage.sdk.jsapi.component.network.WssNativeFixLeak;
import com.tencent.luggage.wxa.ei.j;
import com.tencent.luggage.wxa.ei.n;
import com.tencent.luggage.wxa.ei.v;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tk.k;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.mars.comm.AndroidCertVerifyResult;
import com.tencent.mars.comm.MultiNetLinkWaysUtil;
import com.tencent.mars.comm.X509Util;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: h, reason: collision with root package name */
    public WcwssNative f120214h;

    /* renamed from: i, reason: collision with root package name */
    public WcwssNative.IWcWssReportListener f120215i;

    /* renamed from: j, reason: collision with root package name */
    public WcwssNative.IWcWssWebSocketListener f120216j;

    /* renamed from: a, reason: collision with root package name */
    public String f120207a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f120208b = -1;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.yi.a f120209c = null;

    /* renamed from: d, reason: collision with root package name */
    public X509TrustManager f120210d = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f120211e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f120212f = true;

    /* renamed from: g, reason: collision with root package name */
    public String f120213g = null;

    /* renamed from: k, reason: collision with root package name */
    public final g f120217k = new g(new d());

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements WcwssNative.IWcWssReportListener {
        public a() {
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public int getNetworkType() {
            return b.a();
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
            w.a("Luggage.WcWssNativeInstallHelper", "MMWcWss onIdKeyStat");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                arrayList.add(new IDKey(iArr[i3], iArr2[i3], iArr3[i3]));
            }
            ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(arrayList, false);
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener
        public void onKvStat(int i3, String str) {
            w.a("Luggage.WcWssNativeInstallHelper", "MMWcWss onKvStat logId:%d", Integer.valueOf(i3));
            ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(i3, str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.sdk.jsapi.component.network.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C5969b implements WcwssNative.IWcWssWebSocketListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f120219a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WeakReference f120220b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.sdk.jsapi.component.network.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f120222a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f120223b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f120224c;

            public a(String str, long j3, int i3) {
                this.f120222a = str;
                this.f120223b = j3;
                this.f120224c = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                w.a("Luggage.WcWssNativeInstallHelper", "MMWcWss jsThreadHandler run onCallBack contextId:%s", this.f120222a);
                b.this.f120214h.updateInterface(this.f120223b, this.f120224c);
            }
        }

        public C5969b(WeakReference weakReference, WeakReference weakReference2) {
            this.f120219a = weakReference;
            this.f120220b = weakReference2;
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public WcwssNative.IWcWssWebSocketListener.BindAndDnsReturn bindSocketToCellularAndDnsByCellular(int i3, String str) {
            MultiNetLinkWaysUtil.BindAndDnsReturnKt bindSocketToCellularAndDnsByCellular = MultiNetLinkWaysUtil.INSTANCE.instance().bindSocketToCellularAndDnsByCellular(i3, str, z.c());
            w.a("Luggage.WcWssNativeInstallHelper", "bind and dns ip %s", bindSocketToCellularAndDnsByCellular.getHostIpStr());
            WcwssNative.IWcWssWebSocketListener.BindAndDnsReturn bindAndDnsReturn = new WcwssNative.IWcWssWebSocketListener.BindAndDnsReturn();
            bindAndDnsReturn.hostIpStr = bindSocketToCellularAndDnsByCellular.getHostIpStr();
            bindAndDnsReturn.resultCode = bindSocketToCellularAndDnsByCellular.getResultCode();
            return bindAndDnsReturn;
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public int doCertificateVerify(String str, long j3, String str2, byte[][] bArr) {
            com.tencent.luggage.wxa.xd.d dVar;
            if ((b.this.f120209c == null || b.this.f120210d == null) && (dVar = (com.tencent.luggage.wxa.xd.d) this.f120220b.get()) != null) {
                b.this.f120209c = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class);
                if (b.this.f120209c != null) {
                    b bVar = b.this;
                    bVar.f120210d = q.b(bVar.f120209c);
                    if (b.this.f120210d == null) {
                        w.b("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getTrustManager fail");
                    }
                } else {
                    w.b("Luggage.WcWssNativeInstallHelper", "MMWcWss doCertificateVerify getConfig fail");
                }
            }
            return b.a(str2, bArr, b.this.f120210d);
        }

        @Override // com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssWebSocketListener
        public void onStateChange(String str, long j3, int i3) {
            ((com.tencent.luggage.wxa.ei.q) this.f120219a.get()).a(new a(str, j3, i3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f120226a;

        public c(j jVar) {
            this.f120226a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback ");
            if (b.this.f120207a != null) {
                w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mContextId != null");
                return;
            }
            v vVar = (v) this.f120226a.a(v.class);
            if (vVar != null) {
                b.this.f120214h = new WcwssNative();
                if (b.this.f120214h != null) {
                    if (b.this.f120212f) {
                        b bVar = b.this;
                        bVar.f120207a = bVar.f120214h.initWcwss(vVar.f(), vVar.B(), vVar.j());
                    } else {
                        b bVar2 = b.this;
                        bVar2.f120207a = bVar2.f120214h.initWcwss(vVar.f(), vVar.B(), 0L);
                    }
                    b bVar3 = b.this;
                    bVar3.f120208b = bVar3.f120214h.setCallback(b.this.f120216j, b.this.f120215i);
                    w.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding setCallback mContextId:%s,mInitCallBack:%d", b.this.f120207a, Integer.valueOf(b.this.f120208b));
                    return;
                }
                w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding mWcwssNative = null");
                return;
            }
            w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding v8Addon is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                if (b.this.f120214h != null) {
                    w.d("Luggage.WcWssNativeInstallHelper", "destroyTask destroyWcWssBinding mContextId:%s", b.this.f120207a);
                    b.this.f120214h.destoryWcwss();
                    b.this.f120214h = null;
                } else {
                    w.b("Luggage.WcWssNativeInstallHelper", "destroyTask mWcwssNative is null");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.q f120229a;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f120214h != null) {
                    b.this.f120214h.doOnRunningState();
                }
            }
        }

        public e(com.tencent.luggage.wxa.ei.q qVar) {
            this.f120229a = qVar;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            if (com.tencent.luggage.wxa.qc.b.SUSPEND == bVar && b.this.f120214h != null) {
                this.f120229a.a(new a(), true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f120232a;

        public f(i iVar) {
            this.f120232a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            w.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", b.this.f120207a);
            if (b.this.f120214h == null) {
                w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
                return;
            }
            com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) this.f120232a.a(com.tencent.luggage.wxa.yi.a.class);
            if (aVar != null) {
                w.d("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", b.this.f120213g, Integer.valueOf(aVar.f145794d), aVar.K, aVar.M, Integer.valueOf(aVar.N));
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(ISchemeApi.KEY_REFERER, aVar.M);
                hashMap.put("User-Agent", aVar.K);
                hashMap.put("bzType", b.this.f120213g);
                hashMap.put("mode", String.valueOf(aVar.N));
                hashMap.put("timeout", String.valueOf(aVar.f145794d));
                b.this.f120214h.initConfig(hashMap);
                int i3 = aVar.N;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ArrayList arrayList3 = aVar.F;
                        if (arrayList3 != null && arrayList3.size() != 0) {
                            arrayList2 = aVar.F;
                        } else {
                            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
                            arrayList2 = null;
                        }
                        b.this.f120214h.initConfigWhiteBlack(null, arrayList2);
                        return;
                    }
                    if (i3 == 2) {
                        ArrayList arrayList4 = aVar.G;
                        if (arrayList4 != null && arrayList4.size() != 0) {
                            arrayList = aVar.G;
                        } else {
                            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
                            arrayList = null;
                        }
                        b.this.f120214h.initConfigWhiteBlack(arrayList, null);
                        return;
                    }
                    w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", Integer.valueOf(i3));
                    return;
                }
                w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", Integer.valueOf(i3));
                return;
            }
            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g extends k implements n.a {
        public g(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.luggage.wxa.ei.n.a
        public void onDestroy() {
            run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface h extends com.tencent.luggage.wxa.eo.c {
        boolean i();

        boolean isOpen();
    }

    public static void b() {
        com.tencent.luggage.wxa.aa.h.b("owl", b.class.getClassLoader());
        com.tencent.luggage.wxa.aa.h.b("wcwss", b.class.getClassLoader());
        com.tencent.luggage.wxa.aa.h.b("ssl", b.class.getClassLoader());
        com.tencent.luggage.wxa.aa.h.b("crypto", b.class.getClassLoader());
        com.tencent.luggage.wxa.gp.a.a();
    }

    public void a(j jVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        w.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
        h hVar = (h) com.tencent.luggage.wxa.eo.g.a(h.class);
        if (hVar != null) {
            this.f120211e = hVar.isOpen();
        }
        if (!this.f120211e) {
            w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
            return;
        }
        if (jVar == null) {
            w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
            return;
        }
        this.f120213g = String.valueOf(i3);
        b();
        com.tencent.luggage.wxa.ei.q qVar = (com.tencent.luggage.wxa.ei.q) jVar.a(com.tencent.luggage.wxa.ei.q.class);
        if (qVar == null) {
            w.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
            return;
        }
        WeakReference weakReference = new WeakReference(qVar);
        WeakReference weakReference2 = new WeakReference(dVar);
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.o4.d.class));
        this.f120215i = WssNativeFixLeak.a(new a(), (n) jVar.a(n.class));
        this.f120216j = WssNativeFixLeak.a(new C5969b(weakReference, weakReference2), (n) jVar.a(n.class));
        qVar.d(new c(jVar));
    }

    public void a(j jVar) {
        w.d("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", this.f120207a);
        if (!this.f120211e) {
            w.b("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
        } else if (jVar == null) {
            w.b("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
        } else {
            ((n) jVar.a(n.class)).b(this.f120217k);
        }
    }

    public void a(j jVar, i iVar) {
        w.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", this.f120207a);
        if (!this.f120211e) {
            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
            return;
        }
        if (jVar == null) {
            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
            return;
        }
        com.tencent.luggage.wxa.ei.q qVar = (com.tencent.luggage.wxa.ei.q) jVar.a(com.tencent.luggage.wxa.ei.q.class);
        if (qVar == null) {
            w.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
            return;
        }
        WcwssNative.IWcWssReportListener iWcWssReportListener = this.f120215i;
        if (iWcWssReportListener instanceof WssNativeFixLeak.ProxyReportListener) {
            ((WssNativeFixLeak.ProxyReportListener) iWcWssReportListener).a(iVar.getLifecycleOwner());
        }
        WcwssNative.IWcWssWebSocketListener iWcWssWebSocketListener = this.f120216j;
        if (iWcWssWebSocketListener instanceof WssNativeFixLeak.ProxySocketListener) {
            ((WssNativeFixLeak.ProxySocketListener) iWcWssWebSocketListener).a(iVar.getLifecycleOwner());
        }
        h hVar = (h) com.tencent.luggage.wxa.eo.g.a(h.class);
        boolean z16 = hVar != null && hVar.i();
        w.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", iVar.getAppId(), Boolean.valueOf(z16));
        if (z16) {
            iVar.getRuntime().c0().a(new e(qVar));
        }
        qVar.d(new f(iVar));
    }

    public static int a() {
        try {
            int d16 = h0.d(z.c());
            w.d("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", Integer.valueOf(d16));
            if (d16 == -1) {
                return -1;
            }
            if (h0.f(z.c())) {
                return 3;
            }
            if (h0.g(z.c())) {
                return 4;
            }
            if (h0.h(z.c())) {
                return 5;
            }
            if (h0.b(d16)) {
                return 1;
            }
            return h0.a(d16) ? 2 : 6;
        } catch (Exception e16) {
            w.a("Luggage.WcWssNativeInstallHelper", e16, "getStatisticsNetType_", new Object[0]);
            return -1;
        }
    }

    public static int a(String str, byte[][] bArr, X509TrustManager x509TrustManager) {
        w.d("Luggage.WcWssNativeInstallHelper", "certifivate verify for " + str);
        try {
            AndroidCertVerifyResult verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "RSA", str, 1, x509TrustManager);
            w.d("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
            if (verifyServerCertificates.getStatus() != 0) {
                verifyServerCertificates = X509Util.verifyServerCertificates(bArr, "ECDSA", str, 1, x509TrustManager);
                w.d("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", str, Integer.valueOf(verifyServerCertificates.getStatus()), Boolean.valueOf(verifyServerCertificates.isIssuedByKnownRoot()), Boolean.valueOf(verifyServerCertificates.isIssuedByHostMatched()));
            }
            if (verifyServerCertificates.getStatus() != 0) {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 7L, 1L, false);
            }
            if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByHostMatched()) {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 8L, 1L, false);
            }
            if (verifyServerCertificates.getStatus() == 0 && !verifyServerCertificates.isIssuedByKnownRoot()) {
                ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(972L, 9L, 1L, false);
            }
            if (verifyServerCertificates.getStatus() == 0) {
                return verifyServerCertificates.isIssuedByKnownRoot() ? 0 : -1;
            }
            return -1;
        } catch (Exception e16) {
            w.a("Luggage.WcWssNativeInstallHelper", e16, "doCertificateVerify Exception", new Object[0]);
            return -1;
        }
    }
}
