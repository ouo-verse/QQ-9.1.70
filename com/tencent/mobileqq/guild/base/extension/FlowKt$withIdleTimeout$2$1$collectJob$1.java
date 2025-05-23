package com.tencent.mobileqq.guild.base.extension;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$collectJob$1", f = "Flow.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
final class FlowKt$withIdleTimeout$2$1$collectJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProducerScope<T> $$this$channelFlow;
    final /* synthetic */ Ref.ObjectRef<CancellationException> $collectCancelationCause;
    final /* synthetic */ Job $detectJob;
    final /* synthetic */ Flow<T> $flow;
    final /* synthetic */ Ref.LongRef $lastEmissionTime;
    int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a<T> implements FlowCollector<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f214724d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ProducerScope f214725e;

        public a(Ref.LongRef longRef, ProducerScope producerScope) {
            this.f214724d = longRef;
            this.f214725e = producerScope;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
            Object coroutine_suspended;
            this.f214724d.element = System.currentTimeMillis();
            Object send = this.f214725e.send(t16, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (send == coroutine_suspended) {
                return send;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt$withIdleTimeout$2$1$collectJob$1(Flow<? extends T> flow, Ref.ObjectRef<CancellationException> objectRef, Job job, ProducerScope<? super T> producerScope, Ref.LongRef longRef, Continuation<? super FlowKt$withIdleTimeout$2$1$collectJob$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$collectCancelationCause = objectRef;
        this.$detectJob = job;
        this.$$this$channelFlow = producerScope;
        this.$lastEmissionTime = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlowKt$withIdleTimeout$2$1$collectJob$1(this.$flow, this.$collectCancelationCause, this.$detectJob, this.$$this$channelFlow, this.$lastEmissionTime, continuation);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Throwable, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = this.$flow;
                a aVar = new a(this.$lastEmissionTime, this.$$this$channelFlow);
                this.label = 1;
                if (flow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("FlowEx", 1, "collect interrupt: " + th5.getMessage());
            }
            if (th5 instanceof CancellationException) {
                this.$collectCancelationCause.element = th5;
            }
        }
        this.$detectJob.cancel(this.$collectCancelationCause.element);
        this.$$this$channelFlow.invokeOnClose(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$collectJob$1.3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                invoke2(th6);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th6) {
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("FlowEx", 1, "collectJob: invokeOnClose " + th6);
                }
            }
        });
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt$withIdleTimeout$2$1$collectJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
