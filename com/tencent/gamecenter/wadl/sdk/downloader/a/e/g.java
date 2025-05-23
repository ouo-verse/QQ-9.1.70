package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import apollo_pcdn.ApolloNetworkState;
import apollo_pcdn.CallbackFuncPtrs;
import apollo_pcdn.DownEngineConfig;
import apollo_pcdn.IDownEngine;
import apollo_pcdn.PP_IDownEngine;
import apollo_pcdn.apollo_pcdn;
import com.tencent.gamecenter.wadl.sdk.common.c.b.h;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.PCDNInitParam;
import com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g extends com.tencent.gamecenter.wadl.sdk.downloader.a.e.a {
    private static volatile IDownEngine C;
    private static volatile long D;

    /* renamed from: u, reason: collision with root package name */
    private final Object f107311u;

    /* renamed from: v, reason: collision with root package name */
    private final AtomicLong f107312v;

    /* renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f107313w;

    /* renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f107314x;

    /* renamed from: y, reason: collision with root package name */
    private final com.tencent.gamecenter.wadl.sdk.downloader.task.i.d f107315y;

    /* renamed from: z, reason: collision with root package name */
    private volatile long f107316z;
    private static final Object A = new byte[0];
    private static final Object B = new byte[0];
    private static final List<CallbackFuncPtrs> E = new CopyOnWriteArrayList();
    private static final CallbackFuncPtrs F = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CallbackFuncPtrs f107321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b f107322b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.gamecenter.wadl.sdk.downloader.a.b f107323c;

        b(CallbackFuncPtrs callbackFuncPtrs, com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b bVar, com.tencent.gamecenter.wadl.sdk.downloader.a.b bVar2) {
            this.f107321a = callbackFuncPtrs;
            this.f107322b = bVar;
            this.f107323c = bVar2;
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.a
        public void a(int i3) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "[onFlush] onFailed,errorCode:" + i3 + ",errorMsg:" + com.tencent.gamecenter.wadl.sdk.downloader.pcdn.a.a(i3));
            IDownEngine iDownEngine = g.C;
            if (iDownEngine != null) {
                iDownEngine.StopTask(g.this.f107316z);
            }
            g.this.a(i3, this.f107321a, this.f107322b);
        }

        @Override // com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.a
        public void a(byte[] bArr, int i3, String str) {
            IDownEngine iDownEngine = g.C;
            if (g.this.A()) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "[onFlush] not read cause\uff0cisAbort:" + g.this.f107296p + ",isContinueRead:" + g.this.f107314x.get() + ",readLen:" + g.this.f107312v);
                if (iDownEngine != null) {
                    iDownEngine.StopTask(g.this.f107316z);
                }
                g.this.a(this.f107321a);
                g.this.a(this.f107322b);
                return;
            }
            if (this.f107323c != null) {
                g.this.f107314x.set(this.f107323c.a(bArr, i3, g.this.f107313w.get()));
                if (g.this.f107313w.get()) {
                    g.this.f107313w.set(false);
                }
                g.this.f107312v.addAndGet(i3);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "onFlush size: " + i3 + ",req:" + g.this.hashCode() + ",continueReadData:" + g.this.f107314x + ",readLen:" + g.this.f107312v);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f107325d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f107326e;

        c(long j3, Handler handler) {
            this.f107325d = j3;
            this.f107326e = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            long abs = Math.abs(SystemClock.elapsedRealtime() - g.D);
            if (abs > this.f107325d) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDN_P2PReq", "[checkIfDestroyEngineDelay] gap:" + abs + ",destroy engine");
                g.this.v();
                return;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDN_P2PReq", "[checkIfDestroyEngineDelay] continue check,gap:" + abs);
            this.f107326e.removeCallbacks(this);
            this.f107326e.postDelayed(this, this.f107325d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class d extends CallbackFuncPtrs {
        d() {
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnCompleteCallback(long j3) {
            Iterator it = g.E.iterator();
            while (it.hasNext()) {
                ((CallbackFuncPtrs) it.next()).OnCompleteCallback(j3);
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnDataCallback(long j3, byte[] bArr, long j16, long j17) {
            g.C();
            Iterator it = g.E.iterator();
            while (it.hasNext()) {
                ((CallbackFuncPtrs) it.next()).OnDataCallback(j3, bArr, j16, j17);
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnDestoryDownEngineCallback(String str) {
            Iterator it = g.E.iterator();
            while (it.hasNext()) {
                ((CallbackFuncPtrs) it.next()).OnDestoryDownEngineCallback(str);
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public int OnEngineUpdateAndGetNetStateCallback() {
            return ApolloNetworkState.kApolloReachableViaWiFi.pcdnValue();
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnErrorCallback(long j3, int i3) {
            Iterator it = g.E.iterator();
            while (it.hasNext()) {
                ((CallbackFuncPtrs) it.next()).OnErrorCallback(j3, i3);
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnHeaderCallback(String str) {
            Iterator it = g.E.iterator();
            while (it.hasNext()) {
                ((CallbackFuncPtrs) it.next()).OnHeaderCallback(str);
            }
        }
    }

    public g(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, Map<String, String> map, com.tencent.gamecenter.wadl.sdk.downloader.a.e.b bVar, boolean z16, boolean z17, com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar2, int i3, String str, com.tencent.gamecenter.wadl.sdk.downloader.task.i.d dVar) {
        super(aVar, map, bVar, z16, z17, bVar2, i3, str);
        this.f107311u = new byte[0];
        this.f107312v = new AtomicLong(0L);
        this.f107313w = new AtomicBoolean(true);
        this.f107314x = new AtomicBoolean(true);
        this.f107316z = 0L;
        this.f107315y = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (!this.f107296p && this.f107314x.get() && !this.f107315y.m()) {
            return false;
        }
        return true;
    }

    private void B() {
        this.f107312v.set(0L);
        this.f107313w.set(true);
        this.f107314x.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C() {
        D = SystemClock.elapsedRealtime();
    }

    private void t() {
        Handler g16 = com.tencent.gamecenter.wadl.sdk.common.a.g();
        long w3 = w();
        if (g16 != null) {
            g16.removeCallbacksAndMessages(B);
            g16.postDelayed(new c(w3, g16), w3);
        }
    }

    private IDownEngine u() {
        synchronized (A) {
            if (C == null) {
                DownEngineConfig x16 = x();
                C = apollo_pcdn.CreateDownEngine();
                C.InitDownEngine(x16);
                C.SetupCallBack(F);
                t();
            }
        }
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDN_P2PReq", "[destroyEngine]");
            synchronized (A) {
                if (C != null) {
                    apollo_pcdn.DestoryDownEngine(new PP_IDownEngine(IDownEngine.getCPtr(C), false));
                }
                C = null;
            }
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "[destroyEngine]", th5);
        }
    }

    private static long w() {
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null) {
            long j3 = pCDNInitParam.autoDestroyGap;
            if (j3 > 0) {
                return j3;
            }
        }
        return MiniBoxNoticeInfo.MIN_5;
    }

    private static DownEngineConfig x() {
        boolean z16;
        DownEngineConfig downEngineConfig = new DownEngineConfig();
        downEngineConfig.setUiAppId(z());
        downEngineConfig.setCurNetworkState(ApolloNetworkState.kApolloReachableViaWiFi);
        downEngineConfig.setLogSavePath(y());
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null && pCDNInitParam.isEnablePCDNP2P) {
            z16 = true;
        } else {
            z16 = false;
        }
        downEngineConfig.setIsEnableP2p(z16);
        downEngineConfig.setMaxUsableDiskSize(BigInteger.valueOf(17179869184L));
        return downEngineConfig;
    }

    private static String y() {
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null && !TextUtils.isEmpty(pCDNInitParam.pcdnLogDirPath)) {
            return pCDNInitParam.pcdnLogDirPath;
        }
        return com.tencent.gamecenter.wadl.sdk.common.a.b().getFilesDir().getAbsolutePath() + "/wadl/pcdn/logs";
    }

    private static long z() {
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null) {
            long j3 = pCDNInitParam.uiAppId;
            if (j3 != 0) {
                return j3;
            }
        }
        return 20006L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0101, code lost:
    
        if (r13.f107296p != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0111, code lost:
    
        e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x011a, code lost:
    
        return r13.f107312v.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010f, code lost:
    
        r13.f107294n = -66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010d, code lost:
    
        if (r13.f107296p == false) goto L39;
     */
    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.e.a, com.tencent.gamecenter.wadl.sdk.downloader.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(com.tencent.gamecenter.wadl.sdk.downloader.a.b bVar) {
        try {
            synchronized (this.f107311u) {
                B();
                com.tencent.gamecenter.wadl.sdk.downloader.a.e.b a16 = this.f107289i.a();
                long a17 = com.tencent.gamecenter.wadl.sdk.downloader.a.c.a(a16, this.f107293m.f107304a);
                long j3 = 0;
                if (a17 == 0) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "[readData] dataLen is 0");
                    return 0L;
                }
                com.tencent.gamecenter.wadl.sdk.downloader.pcdn.c.b(this.f107315y.h(), this.f107291k);
                if (a16 != null) {
                    j3 = a16.f107300a;
                }
                BigInteger valueOf = BigInteger.valueOf(j3);
                BigInteger valueOf2 = BigInteger.valueOf(a16 == null ? a17 - 1 : (a16.f107300a + a17) - 1);
                C();
                C = u();
                a(bVar, valueOf.longValue(), valueOf2.longValue());
                this.f107316z = C.StartTask(this.f107291k, valueOf, valueOf2);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "[readData] StartTask:" + valueOf + ",endOffset:" + valueOf2 + ",dataLen:" + a17 + ",totalLength:" + this.f107293m.f107304a + ",curTaskId:" + this.f107316z + ",this:" + hashCode());
                LockMethodProxy.wait(this.f107311u);
                com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDN_P2PReq", "[readData] readLock release,curTaskId:" + this.f107316z + ",P2PReq:" + hashCode() + ",transport:" + this.f107315y.hashCode());
            }
        } catch (Throwable th5) {
            try {
                a(th5);
            } finally {
                if (this.f107296p) {
                    this.f107294n = -66;
                }
                e();
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.e.a
    HttpURLConnection a(URL url) {
        boolean a16 = a(this.f107287g);
        URLConnection openConnection = url.openConnection();
        if (!a16) {
            return (HttpURLConnection) openConnection;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        httpsURLConnection.setSSLSocketFactory(new h(this.f107287g));
        httpsURLConnection.setHostnameVerifier(new com.tencent.gamecenter.wadl.sdk.common.c.b.e(this.f107287g));
        return httpsURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, CallbackFuncPtrs callbackFuncPtrs, com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b bVar) {
        this.f107295o = com.tencent.gamecenter.wadl.sdk.downloader.pcdn.a.a(i3);
        this.f107294n = i3;
        a(callbackFuncPtrs);
        com.tencent.gamecenter.wadl.sdk.downloader.pcdn.c.b(this.f107315y.h(), this.f107291k, i3);
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackFuncPtrs callbackFuncPtrs) {
        E.remove(callbackFuncPtrs);
        synchronized (this.f107311u) {
            this.f107311u.notify();
        }
    }

    private void a(com.tencent.gamecenter.wadl.sdk.downloader.a.b bVar, long j3, long j16) {
        com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b bVar2 = new com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b();
        bVar2.a(this.f107315y.h(), j3, j16);
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-PCDN_P2PReq", "addCallback :,this:" + this);
        a aVar = new a(bVar2, j3, j16);
        bVar2.a(new b(aVar, bVar2, bVar));
        E.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b bVar) {
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends CallbackFuncPtrs {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b f107317a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f107318b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f107319c;

        a(com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b bVar, long j3, long j16) {
            this.f107317a = bVar;
            this.f107318b = j3;
            this.f107319c = j16;
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnCompleteCallback(long j3) {
            if (g.this.f107316z == j3) {
                g.this.a(this);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "OnCompleteCallback  taskId:" + j3 + ",req:" + g.this.hashCode());
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnDataCallback(long j3, byte[] bArr, long j16, long j17) {
            if (g.this.f107316z != j3) {
                return;
            }
            try {
                if (g.C == null) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "OnDataCallback downEngine is null ");
                    return;
                }
                if (g.this.A()) {
                    g.C.StopTask(g.this.f107316z);
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "OnDataCallback stop task hashCode:" + g.this.hashCode() + ",isAbort:" + g.this.f107296p + ",isContinueRead:" + g.this.f107314x.get() + ",isDownloadTaskCompleted:" + g.this.f107315y.m() + ",curTaskId:" + g.this.f107316z);
                    g.this.a(this);
                    g.this.a(this.f107317a);
                    return;
                }
                float GetCurrentPCDNSharingRatio = g.C.GetCurrentPCDNSharingRatio();
                com.tencent.gamecenter.wadl.sdk.downloader.pcdn.b.a(g.this.f107315y.h(), GetCurrentPCDNSharingRatio);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "OnDataCallback taskId: " + j3 + ",shareRatio:" + GetCurrentPCDNSharingRatio + ",startOffset:" + this.f107318b + ",endOffset:" + this.f107319c + ",curStart:" + j16 + ",curEnd:" + ((bArr.length + j16) - 1) + ",P2PReq:" + g.this.hashCode() + ",thread:" + Thread.currentThread().getName());
                this.f107317a.b(bArr, j16);
            } catch (Throwable th5) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "OnDataCallback: " + th5);
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnDestoryDownEngineCallback(String str) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-downloader-PCDN_P2PReq", "OnDestoryDownEngineCallback  s:" + str);
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public int OnEngineUpdateAndGetNetStateCallback() {
            return ApolloNetworkState.kApolloReachableViaWiFi.pcdnValue();
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnErrorCallback(long j3, int i3) {
            if (g.this.f107316z == j3) {
                g.this.a(i3, this, this.f107317a);
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDN_P2PReq", "[onFlush] OnErrorCallback,taskId:" + j3 + "errorCode:" + i3 + ",errorMsg:" + com.tencent.gamecenter.wadl.sdk.downloader.pcdn.a.a(i3));
            }
        }

        @Override // apollo_pcdn.CallbackFuncPtrs
        public void OnHeaderCallback(String str) {
        }
    }
}
