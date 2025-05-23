package com.tencent.luggage.wxa.n3;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.tencent.ilinkservice.IlinkDeviceInterface;
import com.tencent.ilinkservice.IlinkServiceCallback;
import com.tencent.ilinkservice.IlinkServiceInterface;
import com.tencent.ilinkservice.IlinkServiceLogCallback;
import com.tencent.ilinkservice.IlinkServiceProto;
import com.tencent.ilinkservice.IlinkTdiCloneSessionInterface;
import com.tencent.ilinkservice.IlinkTdiSessionInterface;
import com.tencent.luggage.wxa.n3.h0;
import com.tencent.luggage.wxa.s3.h;
import com.tencent.luggage.wxa.u3.d;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h0 extends com.tencent.luggage.wxa.s3.h {

    /* renamed from: q, reason: collision with root package name */
    public static final h0 f135186q = new h0();

    /* renamed from: j, reason: collision with root package name */
    public IlinkDeviceInterface f135187j;

    /* renamed from: k, reason: collision with root package name */
    public IlinkDeviceInterface f135188k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.p0.a f135189l;

    /* renamed from: n, reason: collision with root package name */
    public int f135191n;

    /* renamed from: p, reason: collision with root package name */
    public String f135193p;

    /* renamed from: m, reason: collision with root package name */
    public h.b f135190m = h.b.DEVICE_MODE;

    /* renamed from: o, reason: collision with root package name */
    public final IlinkServiceCallback f135192o = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements IlinkServiceCallback {
        public a() {
        }

        @Override // com.tencent.ilinkservice.IlinkServiceCallback
        public void onAllResourceNeedRecreate() {
            if (h.b.APP_MODE == h0.this.f135190m) {
                com.tencent.luggage.wxa.tn.w.b("WMPF.WxaIlinkManager", "onAllResourceNeedRecreate");
                if (com.tencent.luggage.wxa.tn.e.f141559a) {
                    com.tencent.luggage.wxa.tn.c0.a(new Runnable() { // from class: com.tencent.luggage.wxa.n3.af
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), "WxaIlinkManagerImpl\nonAllResourceNeedRecreate", 1).show();
                        }
                    });
                }
                h0.this.a(new Function1() { // from class: com.tencent.luggage.wxa.n3.ag
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h0.a.a((h.a) obj);
                    }
                });
                return;
            }
            com.tencent.luggage.wxa.tn.w.f("WMPF.WxaIlinkManager", "onAllResourceNeedRecreate: exit WMPF process");
            h0.this.c();
            Runtime.getRuntime().exit(0);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceCallback
        public void onCloneMultiProcessTdiSession(int i3, String str, IlinkTdiCloneSessionInterface ilinkTdiCloneSessionInterface) {
            Object[] objArr = new Object[3];
            boolean z16 = false;
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = str;
            if (ilinkTdiCloneSessionInterface != null) {
                z16 = true;
            }
            objArr[2] = Boolean.valueOf(z16);
            com.tencent.luggage.wxa.tn.w.d("WMPF.WxaIlinkManager", "onCloneMultiProcessTdiSession:%d appId:%s tdiCloneSession!=null?%b", objArr);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceCallback
        public void onDeviceInfoNotMatch() {
            com.tencent.luggage.wxa.tn.w.b("WMPF.WxaIlinkManager", "onDeviceInfoNotMatch");
        }

        public static /* synthetic */ Void a(h.a aVar) {
            aVar.onAllResourceNeedRecreate();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements IlinkServiceLogCallback {
        public b() {
        }

        @Override // com.tencent.ilinkservice.IlinkServiceLogCallback
        public void d(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, str2, objArr);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceLogCallback
        public void e(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceLogCallback
        public void i(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceLogCallback
        public void v(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.g(str, str2, objArr);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceLogCallback
        public void w(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.h(str, str2, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements h.a {
        public c() {
        }

        public static /* synthetic */ Void a(int i3, h.a aVar) {
            aVar.onUploadLogComplete(i3);
            return null;
        }

        @Override // com.tencent.luggage.wxa.s3.h.a
        public /* synthetic */ void onAllResourceNeedRecreate() {
            b41.a.a(this);
        }

        @Override // com.tencent.luggage.wxa.s3.h.a
        public void onUploadLogComplete(final int i3) {
            h0.this.a(new Function1() { // from class: com.tencent.luggage.wxa.n3.ah
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return h0.c.a(i3, (h.a) obj);
                }
            });
        }
    }

    static {
        IlinkServiceInterface.setIlinkLoadDelegate(new IlinkServiceInterface.IIlinkLoadDelegate() { // from class: com.tencent.luggage.wxa.n3.ad
            @Override // com.tencent.ilinkservice.IlinkServiceInterface.IIlinkLoadDelegate
            public final void loadLibrary(String str) {
                com.tencent.luggage.wxa.aa.h.g(str);
            }
        });
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void c() {
        super.c();
        IlinkDeviceInterface ilinkDeviceInterface = this.f135187j;
        if (ilinkDeviceInterface != null) {
            ilinkDeviceInterface.setCallback(null);
            this.f135187j = null;
        }
        this.f135189l = null;
    }

    public final IlinkServiceProto.InitParameter d(com.tencent.luggage.wxa.s3.g gVar) {
        IlinkServiceProto.InitParameter.Builder signatureTimestamp = IlinkServiceProto.InitParameter.newBuilder().setProductId(gVar.i()).setDeviceId(gVar.d()).setDeviceSignature(gVar.j()).setSignatureVersion(gVar.h()).setAuthType(gVar.a()).setSignatureTimestamp(0);
        if (gVar.a() == 1) {
            signatureTimestamp.setSignatureTimestamp(gVar.k());
        }
        int b16 = b(gVar.c());
        com.tencent.luggage.wxa.tn.w.d("WMPF.WxaIlinkManager", "loginDevice: debugNet=[%d]", Integer.valueOf(b16));
        signatureTimestamp.setDebugNet(b16);
        if (b16 == 1) {
            String b17 = gVar.b();
            if (TextUtils.isEmpty(b17)) {
                b17 = "101.91.22.184";
            }
            signatureTimestamp.setDebugIp(b17);
        }
        if (h.b.APP_MODE == this.f135190m) {
            signatureTimestamp.setDeviceId("");
            signatureTimestamp.setDeviceSignature("");
            signatureTimestamp.setSignatureVersion(0);
            signatureTimestamp.setRunningMode(1);
        }
        return signatureTimestamp.build();
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public String e() {
        IlinkDeviceInterface ilinkDeviceInterface = this.f135187j;
        if (ilinkDeviceInterface == null) {
            com.tencent.luggage.wxa.tn.w.f("WMPF.WxaIlinkManager", "getDeviceToken: device is null");
            return "";
        }
        return ilinkDeviceInterface.getToken();
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public String f() {
        if (h.b.APP_MODE == this.f135190m) {
            return "hardcode_linkid";
        }
        com.tencent.luggage.wxa.p0.a aVar = this.f135189l;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f("WMPF.WxaIlinkManager", "getDeviceUserName: device is null");
            return "";
        }
        return aVar.f137099a;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public String g() {
        File externalFilesDir;
        if (TextUtils.isEmpty(this.f135193p) && (externalFilesDir = com.tencent.luggage.wxa.tn.z.c().getExternalFilesDir("ilinkservice")) != null) {
            this.f135193p = externalFilesDir.getPath();
        }
        return this.f135193p;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public long h() {
        com.tencent.luggage.wxa.p0.a aVar = this.f135189l;
        if (aVar == null) {
            com.tencent.luggage.wxa.tn.w.f("WMPF.WxaIlinkManager", "getIlinkUin: profile is null");
            return 0L;
        }
        return aVar.f137100b;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public boolean l() {
        if (this.f135187j != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void m() {
        IlinkServiceInterface.getInstance().unregistCallback(this.f135192o);
        IlinkServiceInterface.getInstance().registCallback(this.f135192o);
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public boolean b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) com.tencent.luggage.wxa.tn.z.c().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        for (int i3 = 0; i3 < runningAppProcesses.size(); i3++) {
            if ("com.tencent.ilink.ServiceProcess".equals(runningAppProcesses.get(i3).processName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void a(h.b bVar, int i3) {
        this.f135190m = bVar;
        this.f135191n = i3;
        IlinkServiceInterface.getInstance().setLogCallback(new b());
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void a(com.tencent.luggage.wxa.s3.d dVar) {
        IlinkServiceProto.IlinkUploadLogInfo.Builder newBuilder = IlinkServiceProto.IlinkUploadLogInfo.newBuilder();
        if (dVar.i() != null) {
            newBuilder.setToken(dVar.i());
        }
        if (dVar.e() != null) {
            newBuilder.setExtBuffer(dVar.e());
        }
        if (dVar.a() != null) {
            newBuilder.setCapath(dVar.a());
        }
        newBuilder.setDeviceType(dVar.b()).setProductId(dVar.h()).addAllLogPath(dVar.g()).setIncludeDevLog(dVar.f()).setUin(dVar.c()).setUsername(dVar.d());
        this.f135187j.startUploadLog(newBuilder.build());
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public t a(String str) {
        IlinkTdiSessionInterface createTdiSession = IlinkServiceInterface.getInstance().createTdiSession(str);
        if (createTdiSession != null) {
            return new com.tencent.luggage.wxa.u3.c(createTdiSession, str);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void a(final CountDownLatch countDownLatch, com.tencent.luggage.wxa.s3.g gVar, final AtomicReference atomicReference) {
        IlinkServiceProto.InitParameter d16 = d(gVar);
        IlinkServiceInterface.getInstance().start(com.tencent.luggage.wxa.tn.z.c(), d16);
        final IlinkDeviceInterface createDeviceInterface = IlinkServiceInterface.getInstance().createDeviceInterface();
        createDeviceInterface.setCallback(new com.tencent.luggage.wxa.u3.d(new d.a() { // from class: com.tencent.luggage.wxa.n3.ae
            @Override // com.tencent.luggage.wxa.u3.d.a
            public final void onLoginComplete(int i3, int i16) {
                h0.this.a(createDeviceInterface, atomicReference, countDownLatch, i3, i16);
            }
        }, new c()));
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            createDeviceInterface.setLogLevel(0);
            createDeviceInterface.setConsoleLogOpen(true);
        }
        createDeviceInterface.autoLogin();
        this.f135188k = createDeviceInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IlinkDeviceInterface ilinkDeviceInterface, AtomicReference atomicReference, CountDownLatch countDownLatch, int i3, int i16) {
        com.tencent.luggage.wxa.tn.w.d("WMPF.WxaIlinkManager", "startLoginDeviceSync: errCode:%d detailRet:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        if (i3 == 0) {
            this.f135187j = ilinkDeviceInterface;
            this.f135189l = new com.tencent.luggage.wxa.p0.a(ilinkDeviceInterface.getProfile());
        }
        h.d a16 = a(i3);
        atomicReference.set(a16);
        if (a16 == h.d.KICK_OUT) {
            c();
            c(i16);
        }
        this.f135188k = null;
        countDownLatch.countDown();
    }

    @Override // com.tencent.luggage.wxa.s3.h
    public void a() {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.f135188k != null);
        com.tencent.luggage.wxa.tn.w.d("WMPF.WxaIlinkManager", "cancelLoginDeviceSync lastDevice:%b", objArr);
        IlinkDeviceInterface ilinkDeviceInterface = this.f135188k;
        if (ilinkDeviceInterface != null) {
            ilinkDeviceInterface.setCallback(null);
            this.f135188k = null;
        }
    }
}
