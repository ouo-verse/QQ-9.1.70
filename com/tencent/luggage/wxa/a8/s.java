package com.tencent.luggage.wxa.a8;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.wxa.tn.b0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s implements h {

    /* renamed from: a, reason: collision with root package name */
    public final String f120939a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerThread f120940b;

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f120941c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f120942d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(s.this.f120940b.getLooper());
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
        public final b0 invoke() {
            return new b0(s.this.f120940b.getLooper());
        }
    }

    public s(String name) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(name, "name");
        this.f120939a = name;
        HandlerThread b16 = com.tencent.luggage.wxa.cq.d.b(c(), 5);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + c() + " created");
        this.f120940b = b16;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f120941c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new a());
        this.f120942d = lazy2;
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public Handler b() {
        return (Handler) this.f120942d.getValue();
    }

    public String c() {
        return this.f120939a;
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public com.tencent.luggage.wxa.dq.a getHandler() {
        return (com.tencent.luggage.wxa.dq.a) this.f120941c.getValue();
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public void start() {
        this.f120940b.start();
        Unit unit = Unit.INSTANCE;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + c() + " started");
    }

    @Override // com.tencent.luggage.wxa.a8.h
    public boolean a() {
        boolean quitSafely = this.f120940b.quitSafely();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.SameLayerPluginHandlerThreadProvider", "Thread " + c() + " quited");
        return quitSafely;
    }
}
