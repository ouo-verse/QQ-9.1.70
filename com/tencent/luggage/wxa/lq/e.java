package com.tencent.luggage.wxa.lq;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements com.tencent.luggage.wxa.lq.a {

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f133783c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f133784d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map f133785e;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f133781a = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "stubExecutor", "getStubExecutor()Ljava/util/concurrent/ScheduledExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(e.class), "stubHandlerThreads", "getStubHandlerThreads()Ljava/util/List;"))};

    /* renamed from: f, reason: collision with root package name */
    public static final e f133786f = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f133782b = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f133787a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ScheduledExecutorService invoke() {
            return ProxyExecutors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f133788a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 1; i3 <= 50; i3++) {
                arrayList.add(new BaseHandlerThread("#StubHT-" + i3));
            }
            return arrayList;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) a.f133787a);
        f133783c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) b.f133788a);
        f133784d = lazy2;
        f133785e = new LinkedHashMap();
    }

    public final ScheduledExecutorService a() {
        Lazy lazy = f133783c;
        KProperty kProperty = f133781a[0];
        return (ScheduledExecutorService) lazy.getValue();
    }

    @Override // com.tencent.luggage.wxa.lq.a
    public Future execute(Runnable runnable) {
        FutureTask a16 = c.a(runnable);
        a().execute(a16);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.lq.a
    public Future a(Runnable runnable) {
        FutureTask a16 = c.a(runnable);
        f133782b.post(a16);
        return new g(a16);
    }

    @Override // com.tencent.luggage.wxa.lq.a
    public Future a(Runnable runnable, long j3) {
        ScheduledFuture<?> schedule = a().schedule(runnable, j3, TimeUnit.MILLISECONDS);
        Intrinsics.checkExpressionValueIsNotNull(schedule, "stubExecutor.schedule(ru\u2026s, TimeUnit.MILLISECONDS)");
        return schedule;
    }
}
