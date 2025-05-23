package com.tencent.kuikly.core.coroutines;

import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\u001aQ\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u000e*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001f\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/b;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lcom/tencent/kuikly/core/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lcom/tencent/kuikly/core/coroutines/f;", "d", "(Lcom/tencent/kuikly/core/coroutines/b;Lkotlin/coroutines/CoroutineContext;Lcom/tencent/kuikly/core/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/tencent/kuikly/core/coroutines/f;", "T", "Lcom/tencent/kuikly/core/coroutines/c;", "a", "(Lcom/tencent/kuikly/core/coroutines/b;Lkotlin/coroutines/CoroutineContext;Lcom/tencent/kuikly/core/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lcom/tencent/kuikly/core/coroutines/c;", "", "timeMs", "c", "(Lcom/tencent/kuikly/core/coroutines/b;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "f", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BuildersKt {
    public static final <T> c<T> a(b bVar, CoroutineContext context, CoroutineStart start, Function2<? super b, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        d dVar = new d(context, true);
        dVar.a(start, bVar, new BuildersKt$async$1(block, null));
        return dVar;
    }

    public static final Object c(b bVar, int i3, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        TimerKt.e(BridgeManager.f117344a.u(), i3, new Function0<Unit>() { // from class: com.tencent.kuikly.core.coroutines.BuildersKt$delay$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Continuation<Unit> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                } catch (Throwable th5) {
                    BuildersKt.f(th5);
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return orThrow == coroutine_suspended2 ? orThrow : Unit.INSTANCE;
    }

    public static final f d(b bVar, CoroutineContext context, CoroutineStart start, Function2<? super b, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        h hVar = new h(context, true);
        hVar.a(start, bVar, new BuildersKt$launch$1(block, null));
        return hVar;
    }

    public static final void f(final Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.kuikly.core.coroutines.BuildersKt$throwCoroutineScopeException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                throw e16;
            }
        }, 1, null);
    }

    public static /* synthetic */ c b(b bVar, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.ATOMIC;
        }
        return a(bVar, coroutineContext, coroutineStart, function2);
    }

    public static /* synthetic */ f e(b bVar, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.ATOMIC;
        }
        return d(bVar, coroutineContext, coroutineStart, function2);
    }
}
