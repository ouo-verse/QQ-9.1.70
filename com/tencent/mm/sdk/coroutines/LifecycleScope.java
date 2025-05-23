package com.tencent.mm.sdk.coroutines;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.b;
import com.tencent.luggage.wxa.zp.h;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\bB%\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0007R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/LifecycleObserver;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "", "I", "threadCount", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "c", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "default", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;I)V", "d", "wechat-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class LifecycleScope implements CoroutineScope, LifecycleObserver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int threadCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy default;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f152537a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleScope f152538b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LifecycleOwner lifecycleOwner, LifecycleScope lifecycleScope) {
            super(0);
            this.f152537a = lifecycleOwner;
            this.f152538b = lifecycleScope;
        }

        public final void a() {
            if (this.f152537a.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                this.f152537a.getLifecycle().addObserver(this.f152538b);
            } else {
                w.d("MicroMsg.Mvvm.LifecycleScope", "leak this scope, because lifecycle is already destroy");
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ExecutorCoroutineDispatcher invoke() {
            if (LifecycleScope.this.threadCount <= 1) {
                b a16 = h.f146825d.a(LifecycleScope.this.getName());
                Intrinsics.checkNotNullExpressionValue(a16, "INSTANCE.forkSingleExecutorService(name)");
                return ExecutorsKt.from((ExecutorService) a16);
            }
            b a17 = h.f146825d.a(LifecycleScope.this.getName(), LifecycleScope.this.threadCount, LifecycleScope.this.threadCount, new LinkedBlockingQueue());
            Intrinsics.checkNotNullExpressionValue(a17, "INSTANCE.forkExecutorSer\u2026t, LinkedBlockingQueue())");
            return ExecutorsKt.from((ExecutorService) a17);
        }
    }

    public LifecycleScope(String name, LifecycleOwner lifecycleOwner, int i3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.threadCount = i3;
        if (lifecycleOwner != null) {
            com.tencent.luggage.wxa.rn.a.a(new a(lifecycleOwner, this));
        }
        lazy = LazyKt__LazyJVMKt.lazy(new c());
        this.default = lazy;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        w.d("MicroMsg.Mvvm.LifecycleScope", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        a().close();
    }

    public final ExecutorCoroutineDispatcher a() {
        return (ExecutorCoroutineDispatcher) this.default.getValue();
    }
}
