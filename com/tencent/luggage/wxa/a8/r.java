package com.tencent.luggage.wxa.a8;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class r implements h {

    /* renamed from: a, reason: collision with root package name */
    public final String f120931a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f120932b;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f120933c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f120934d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f120935e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            HandlerThread b16 = com.tencent.luggage.wxa.cq.d.b(r.this.c(), 5);
            r rVar = r.this;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + rVar.c() + " created");
            b16.start();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + rVar.c() + " started");
            rVar.f120933c = b16;
            return new Handler(b16.getLooper());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.kq.f invoke() {
            com.tencent.luggage.wxa.kq.a serial = r.this.d();
            Intrinsics.checkNotNullExpressionValue(serial, "serial");
            return new com.tencent.luggage.wxa.kq.f(serial);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.kq.a invoke() {
            return com.tencent.luggage.wxa.kq.a.a(r.this.c());
        }
    }

    public r(String name) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(name, "name");
        this.f120931a = name;
        lazy = LazyKt__LazyJVMKt.lazy(new c());
        this.f120932b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new b());
        this.f120934d = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new a());
        this.f120935e = lazy3;
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public Handler b() {
        return (Handler) this.f120935e.getValue();
    }

    public String c() {
        return this.f120931a;
    }

    public final com.tencent.luggage.wxa.kq.a d() {
        return (com.tencent.luggage.wxa.kq.a) this.f120932b.getValue();
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public com.tencent.luggage.wxa.dq.a getHandler() {
        return (com.tencent.luggage.wxa.dq.a) this.f120934d.getValue();
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public boolean a() {
        d().f();
        HandlerThread handlerThread = this.f120933c;
        if (handlerThread == null) {
            return true;
        }
        boolean quitSafely = handlerThread.quitSafely();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + c() + " quited");
        return quitSafely;
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public void start() {
    }
}
