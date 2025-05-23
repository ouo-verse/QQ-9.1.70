package com.tencent.luggage.wxa.yi;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b0 {

    /* renamed from: h, reason: collision with root package name */
    public static final a f145835h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f145836a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Network f145837b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f145838c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f145839d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f145840e;

    /* renamed from: f, reason: collision with root package name */
    public volatile long f145841f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f145842g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a(Network network);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends b0 {

        /* renamed from: i, reason: collision with root package name */
        public static final c f145843i = new c();

        /* renamed from: j, reason: collision with root package name */
        public static final NetworkRequest f145844j;

        static {
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026\n                .build()");
            f145844j = build;
        }

        public c() {
            super(null);
        }

        @Override // com.tencent.luggage.wxa.yi.b0
        public NetworkRequest d() {
            return f145844j;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f145845a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConnectivityManager invoke() {
            Object systemService = com.tencent.luggage.wxa.tn.z.c().getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            return (ConnectivityManager) systemService;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e extends Lambda implements Function0 {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a extends ConnectivityManager.NetworkCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f145847a;

            public a(b0 b0Var) {
                this.f145847a = b0Var;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "onAvailable, network: " + network);
                super.onAvailable(network);
                this.f145847a.f145837b = network;
                this.f145847a.a(network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "onLost, network: " + network);
                super.onLost(network);
                this.f145847a.f145837b = null;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "onUnavailable");
                super.onUnavailable();
                this.f145847a.f145837b = null;
            }
        }

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(b0.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f145849b;

        public f(b bVar) {
            this.f145849b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b0.this.f145836a.remove(this.f145849b)) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "provide, timeout");
                this.f145849b.a(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class g extends Lambda implements Function0 {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f145851a;

            public a(b0 b0Var) {
                this.f145851a = b0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                long uptimeMillis = this.f145851a.f145841f - SystemClock.uptimeMillis();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "run#unregisterNetworkCallbackTask, timeToUnregisterMs: " + uptimeMillis);
                if (uptimeMillis <= 0) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "run#unregisterNetworkCallbackTask, unregisterNetworkCallback");
                    try {
                        this.f145851a.b().unregisterNetworkCallback(this.f145851a.c());
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.NetworkProvider", "run#unregisterNetworkCallbackTask, unregisterNetworkCallback fail since " + e16);
                    }
                    this.f145851a.f145839d.set(false);
                    this.f145851a.f145837b = null;
                    return;
                }
                com.tencent.luggage.wxa.zp.h.f146825d.a(this.f145851a.e(), uptimeMillis);
            }
        }

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Runnable invoke() {
            return new a(b0.this);
        }
    }

    public /* synthetic */ b0(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract NetworkRequest d();

    public b0() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        this.f145836a = new CopyOnWriteArraySet();
        lazy = LazyKt__LazyJVMKt.lazy(d.f145845a);
        this.f145838c = lazy;
        this.f145839d = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new e());
        this.f145840e = lazy2;
        this.f145841f = -1L;
        lazy3 = LazyKt__LazyJVMKt.lazy(new g());
        this.f145842g = lazy3;
    }

    public final e.a c() {
        return (e.a) this.f145840e.getValue();
    }

    public final Runnable e() {
        return (Runnable) this.f145842g.getValue();
    }

    public final void a(b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Network network = this.f145837b;
        if (network != null) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "provide, curNetwork not null");
            callback.a(network);
            return;
        }
        this.f145836a.add(callback);
        com.tencent.luggage.wxa.zp.h.f146825d.a(new f(callback), 4000L);
        this.f145841f = SystemClock.uptimeMillis() + 30000;
        if (this.f145839d.compareAndSet(false, true)) {
            a();
        }
    }

    public final ConnectivityManager b() {
        return (ConnectivityManager) this.f145838c.getValue();
    }

    public final void a() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "doRequest, requestNetwork");
        try {
            b().requestNetwork(d(), c());
            com.tencent.luggage.wxa.zp.h.f146825d.a(e(), 30000L);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.NetworkProvider", "doRequest, requestNetwork fail since " + e16);
            this.f145839d.set(false);
        }
    }

    public final void a(Network network) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.NetworkProvider", "consumePendingCallbacks, network: " + network);
        Iterator it = this.f145836a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(network);
        }
        this.f145836a.clear();
    }
}
