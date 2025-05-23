package com.tencent.luggage.wxa.oh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiNetworkSpecifier;
import com.tencent.luggage.wxa.nh.a;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.zp.h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f136498a = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f136499a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f136500b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f136501c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f136502d;

        public b(String str, String str2, Ref.ObjectRef objectRef, e eVar) {
            this.f136499a = str;
            this.f136500b = str2;
            this.f136501c = objectRef;
            this.f136502d = eVar;
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void b(com.tencent.luggage.wxa.nh.e wiFiItem) {
            Intrinsics.checkNotNullParameter(wiFiItem, "wiFiItem");
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onConnect#sysListener");
        }

        public final void c(com.tencent.luggage.wxa.nh.e eVar) {
            boolean z16;
            if (w0.a(this.f136499a, eVar.f135822a)) {
                if (this.f136500b.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 || w0.a(this.f136500b, eVar.f135823b)) {
                    w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectInternal#sysListener, match");
                    com.tencent.luggage.wxa.jq.c cVar = (com.tencent.luggage.wxa.jq.c) this.f136501c.element;
                    if (cVar != null) {
                        cVar.cancel(true);
                    }
                    com.tencent.luggage.wxa.nh.a.b(this);
                    this.f136502d.a();
                }
            }
        }

        @Override // com.tencent.luggage.wxa.nh.a.b
        public void a(com.tencent.luggage.wxa.nh.e wiFiItem) {
            Intrinsics.checkNotNullParameter(wiFiItem, "wiFiItem");
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectAcceptIncomplete#sysListener");
            c(wiFiItem);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.oh.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class RunnableC6551c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f136503a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f136504b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f136505c;

        public RunnableC6551c(ConnectivityManager connectivityManager, d dVar, e eVar) {
            this.f136503a = connectivityManager;
            this.f136504b = dVar;
            this.f136505c = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "timeout");
            this.f136503a.unregisterNetworkCallback(this.f136504b);
            this.f136505c.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f136506a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f136507b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f136508c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f136509d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f136510e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f136511f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f136512g;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Network f136513a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f136514b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f136515c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e f136516d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ConnectivityManager f136517e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ d f136518f;

            public a(Network network, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, e eVar, ConnectivityManager connectivityManager, d dVar) {
                this.f136513a = network;
                this.f136514b = objectRef;
                this.f136515c = objectRef2;
                this.f136516d = eVar;
                this.f136517e = connectivityManager;
                this.f136518f = dVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onLost, network: " + this.f136513a + ", timeout");
                com.tencent.luggage.wxa.jq.c cVar = (com.tencent.luggage.wxa.jq.c) this.f136514b.element;
                if (cVar != null) {
                    cVar.cancel(true);
                }
                com.tencent.luggage.wxa.nh.a.b((a.b) this.f136515c.element);
                this.f136516d.b();
                this.f136517e.bindProcessToNetwork(null);
                this.f136517e.unregisterNetworkCallback(this.f136518f);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f136519a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f136520b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f136521c;

            public b(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, e eVar) {
                this.f136519a = objectRef;
                this.f136520b = objectRef2;
                this.f136521c = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable, timeout");
                com.tencent.luggage.wxa.jq.c cVar = (com.tencent.luggage.wxa.jq.c) this.f136519a.element;
                if (cVar != null) {
                    cVar.cancel(true);
                }
                com.tencent.luggage.wxa.nh.a.b((a.b) this.f136520b.element);
                this.f136521c.b();
            }
        }

        public d(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Ref.ObjectRef objectRef4, e eVar, ConnectivityManager connectivityManager, long j3) {
            this.f136506a = objectRef;
            this.f136507b = objectRef2;
            this.f136508c = objectRef3;
            this.f136509d = objectRef4;
            this.f136510e = eVar;
            this.f136511f = connectivityManager;
            this.f136512g = j3;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onAvailable(network);
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, network: " + network);
            com.tencent.luggage.wxa.jq.c cVar = (com.tencent.luggage.wxa.jq.c) this.f136506a.element;
            if (cVar != null) {
                cVar.cancel(true);
            }
            com.tencent.luggage.wxa.jq.c cVar2 = (com.tencent.luggage.wxa.jq.c) this.f136507b.element;
            if (cVar2 != null) {
                cVar2.cancel(true);
            }
            com.tencent.luggage.wxa.jq.c cVar3 = (com.tencent.luggage.wxa.jq.c) this.f136508c.element;
            if (cVar3 != null) {
                cVar3.cancel(true);
            }
            com.tencent.luggage.wxa.nh.a.b((a.b) this.f136509d.element);
            this.f136510e.a();
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onAvailable, success: " + this.f136511f.bindProcessToNetwork(network));
        }

        /* JADX WARN: Type inference failed for: r11v1, types: [com.tencent.luggage.wxa.jq.c, T] */
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onLost, network: " + network);
            this.f136508c.element = h.f146825d.a(new a(network, this.f136506a, this.f136509d, this.f136510e, this.f136511f, this), this.f136512g);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.luggage.wxa.jq.c, T] */
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onUnavailable");
            this.f136507b.element = h.f146825d.a(new b(this.f136506a, this.f136509d, this.f136510e), this.f136512g);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f136522a = new AtomicBoolean(false);

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f136523b;

        public e(a aVar) {
            this.f136523b = aVar;
        }

        @Override // com.tencent.luggage.wxa.oh.c.a
        public void a() {
            if (this.f136522a.compareAndSet(false, true)) {
                this.f136523b.a();
            } else {
                w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectSuccess, already call");
            }
        }

        @Override // com.tencent.luggage.wxa.oh.c.a
        public void b() {
            if (this.f136522a.compareAndSet(false, true)) {
                this.f136523b.b();
            } else {
                w.d("MicroMsg.AppBrand.WifiConnector29Impl", "onConnectFailure, already call");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.tencent.luggage.wxa.jq.c, T] */
    /* JADX WARN: Type inference failed for: r8v6, types: [T, com.tencent.luggage.wxa.oh.c$b] */
    public final void a(Context context, String str, String str2, String str3, long j3, a listener) {
        Object obj;
        WifiNetworkSpecifier build;
        String str4;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        NetworkRequest.Builder networkSpecifier;
        boolean z16;
        MacAddress fromString;
        Context applicationContext;
        Intrinsics.checkNotNullParameter(listener, "listener");
        w.d("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, ssid: " + str + ", bssid: " + str2 + ", timeoutMs: " + j3);
        e eVar = new e(listener);
        ConnectivityManager connectivityManager = null;
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            obj = applicationContext.getSystemService("connectivity");
        } else {
            obj = null;
        }
        if (obj instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) obj;
        }
        if (connectivityManager == null) {
            w.f("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connectivityManager is null");
            eVar.b();
            return;
        }
        if (str != null && str2 != null && str3 != null) {
            try {
                WifiNetworkSpecifier.Builder builder = new WifiNetworkSpecifier.Builder();
                builder.setSsid(str);
                boolean z17 = false;
                try {
                    if (str2.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        fromString = MacAddress.fromString(str2);
                        builder.setBssid(fromString);
                    }
                } catch (Exception unused) {
                }
                if (str3.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    builder.setWpa2Passphrase(str3);
                }
                build = builder.build();
                Intrinsics.checkNotNullExpressionValue(build, "try {\n                Wi\u2026     return\n            }");
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                try {
                    networkSpecifier = new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(build);
                    NetworkRequest build2 = networkSpecifier.build();
                    objectRef6.element = new b(str, str2, objectRef3, eVar);
                    objectRef = objectRef6;
                    str4 = "MicroMsg.AppBrand.WifiConnector29Impl";
                    objectRef2 = objectRef3;
                    try {
                        d dVar = new d(objectRef3, objectRef4, objectRef5, objectRef6, eVar, connectivityManager, 3000L);
                        if (-1 != j3) {
                            objectRef2.element = h.f146825d.a(new RunnableC6551c(connectivityManager, dVar, eVar), j3);
                        }
                        com.tencent.luggage.wxa.nh.a.a((a.b) objectRef.element);
                        connectivityManager.requestNetwork(build2, dVar);
                    } catch (Exception e16) {
                        e = e16;
                        w.f(str4, "connectWifi, fail since " + e);
                        com.tencent.luggage.wxa.jq.c cVar = (com.tencent.luggage.wxa.jq.c) objectRef2.element;
                        if (cVar != null) {
                            cVar.cancel(true);
                        }
                        a.b bVar = (a.b) objectRef.element;
                        if (bVar != null) {
                            com.tencent.luggage.wxa.nh.a.b(bVar);
                        }
                        eVar.b();
                    }
                } catch (Exception e17) {
                    e = e17;
                    str4 = "MicroMsg.AppBrand.WifiConnector29Impl";
                    objectRef = objectRef6;
                    objectRef2 = objectRef3;
                }
            } catch (Exception e18) {
                w.f("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, build network specifier fail since " + e18);
                eVar.b();
            }
        } else {
            w.f("MicroMsg.AppBrand.WifiConnector29Impl", "connectWifi, connect params illegal");
            eVar.b();
        }
    }
}
