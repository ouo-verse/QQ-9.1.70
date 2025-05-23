package com.tencent.guild.aio.util.flowbus;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.util.flowbus.FlowEventReceiver$subscribeTo$job$1", f = "FlowEventReceiver.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FlowEventReceiver$subscribeTo$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $callback;
    final /* synthetic */ Class<T> $clazz;
    final /* synthetic */ boolean $skipRetained;
    int label;
    final /* synthetic */ FlowEventReceiver this$0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a<T> implements FlowCollector<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowEventReceiver f112392d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2 f112393e;

        public a(FlowEventReceiver flowEventReceiver, Function2 function2) {
            this.f112392d = flowEventReceiver;
            this.f112393e = function2;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
            CoroutineDispatcher coroutineDispatcher;
            Object coroutine_suspended;
            coroutineDispatcher = this.f112392d.returnDispatcher;
            Object withContext = BuildersKt.withContext(coroutineDispatcher, new FlowEventReceiver$subscribeTo$job$1$1$1(this.f112393e, t16, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowEventReceiver$subscribeTo$job$1(FlowEventReceiver flowEventReceiver, Class<T> cls, boolean z16, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super FlowEventReceiver$subscribeTo$job$1> continuation) {
        super(2, continuation);
        this.this$0 = flowEventReceiver;
        this.$clazz = cls;
        this.$skipRetained = z16;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlowEventReceiver$subscribeTo$job$1(this.this$0, this.$clazz, this.$skipRetained, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        com.tencent.guild.aio.util.flowbus.a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            aVar = this.this$0.bus;
            Flow filterNotNull = FlowKt.filterNotNull(FlowKt.drop(aVar.b(this.$clazz), this.$skipRetained ? 1 : 0));
            a aVar2 = new a(this.this$0, this.$callback);
            this.label = 1;
            if (filterNotNull.collect(aVar2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowEventReceiver$subscribeTo$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
