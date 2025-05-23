package com.tencent.luggage.wxa.yi;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Base64;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes9.dex */
public enum a0 {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    public final Map f145806a = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements NsdManager.DiscoveryListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f145807a;

        public a(d dVar) {
            this.f145807a = dVar;
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStarted(String str) {
            this.f145807a.onDiscoveryStarted(str);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onDiscoveryStarted " + str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onDiscoveryStopped(String str) {
            this.f145807a.onDiscoveryStopped(str);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onDiscoveryStopped " + str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            this.f145807a.b(new e(nsdServiceInfo));
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onServicesFound " + nsdServiceInfo.getServiceType());
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            this.f145807a.a(new e(nsdServiceInfo));
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onServiceLost " + nsdServiceInfo.getServiceType());
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStartDiscoveryFailed(String str, int i3) {
            this.f145807a.onStartDiscoveryFailed(str, i3);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onStartDiscoveryFailed " + str);
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public void onStopDiscoveryFailed(String str, int i3) {
            this.f145807a.onStopDiscoveryFailed(str, i3);
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "onStopDiscoveryFailed " + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f145809a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f145810b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements NsdManager.ResolveListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f145812a;

            public a(CountDownLatch countDownLatch) {
                this.f145812a = countDownLatch;
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i3) {
                b.this.f145810b.a(new e(nsdServiceInfo), i3);
                this.f145812a.countDown();
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                b.this.f145810b.a(new e(nsdServiceInfo));
                this.f145812a.countDown();
            }
        }

        public b(e eVar, c cVar) {
            this.f145809a = eVar;
            this.f145810b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "start reslove " + this.f145809a.f145815b);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceName(this.f145809a.f145815b);
            nsdServiceInfo.setServiceType(this.f145809a.f145816c);
            a0.this.b().resolveService(nsdServiceInfo, new a(countDownLatch));
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tn.w.a("LocalServiceMgr", e16, "", new Object[0]);
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.LocalServiceMgr", "finish reslove " + this.f145809a.f145815b + " trhead id=" + Thread.currentThread().getId());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(e eVar);

        void a(e eVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(e eVar);

        void b(e eVar);

        void onDiscoveryStarted(String str);

        void onDiscoveryStopped(String str);

        void onStartDiscoveryFailed(String str, int i3);

        void onStopDiscoveryFailed(String str, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public Map f145814a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public String f145815b;

        /* renamed from: c, reason: collision with root package name */
        public String f145816c;

        /* renamed from: d, reason: collision with root package name */
        public String f145817d;

        /* renamed from: e, reason: collision with root package name */
        public int f145818e;

        public e(NsdServiceInfo nsdServiceInfo) {
            InetAddress host = nsdServiceInfo.getHost();
            if (host != null) {
                this.f145817d = host.getHostAddress();
            }
            this.f145818e = nsdServiceInfo.getPort();
            this.f145815b = nsdServiceInfo.getServiceName();
            this.f145816c = nsdServiceInfo.getServiceType();
            Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
            if (attributes != null) {
                for (String str : attributes.keySet()) {
                    byte[] bArr = attributes.get(str);
                    if (bArr != null) {
                        this.f145814a.put(str, new String(Base64.encode(bArr, 2)));
                    }
                }
            }
        }
    }

    a0() {
    }

    public final NsdManager b() {
        return (NsdManager) com.tencent.luggage.wxa.tn.z.c().getSystemService("servicediscovery");
    }

    public void a(String str, d dVar) {
        NsdManager b16 = b();
        a aVar = new a(dVar);
        this.f145806a.put(dVar, aVar);
        b16.discoverServices(str, 1, aVar);
    }

    public void a(d dVar) {
        synchronized (this.f145806a) {
            if (this.f145806a.containsKey(dVar)) {
                try {
                    b().stopServiceDiscovery((NsdManager.DiscoveryListener) this.f145806a.get(dVar));
                } catch (Throwable th5) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.LocalServiceMgr", th5, "Throwable: stopScanServices", new Object[0]);
                }
                this.f145806a.remove(dVar);
            }
        }
    }

    public void a(e eVar, c cVar) {
        com.tencent.luggage.wxa.zp.h.f146825d.b(new b(eVar, cVar), "LocalServiceMgr#resolveService");
    }
}
