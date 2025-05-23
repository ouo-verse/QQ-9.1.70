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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2", f = "Flow.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class FlowKt$withIdleTimeout$2<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Flow<T>> $onTimeout;
    final /* synthetic */ Flow<T> $this_withIdleTimeout;
    final /* synthetic */ long $timeoutMillis;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1", f = "Flow.kt", i = {0, 0, 1}, l = {116, 146}, m = "invokeSuspend", n = {"$this$supervisorScope", "collectCancelationCause", "collectCancelationCause"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope<T> $$this$channelFlow;
        final /* synthetic */ Flow<T> $flow;
        final /* synthetic */ Ref.LongRef $lastEmissionTime;
        final /* synthetic */ Function0<Flow<T>> $onTimeout;
        final /* synthetic */ long $timeoutMillis;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.base.extension.FlowKt$withIdleTimeout$2$1$a */
        /* loaded from: classes12.dex */
        public static final class a implements FlowCollector<T> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ProducerScope f214721d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Ref.LongRef f214722e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f214723f;

            public a(ProducerScope producerScope, Ref.LongRef longRef, CoroutineScope coroutineScope) {
                this.f214721d = producerScope;
                this.f214722e = longRef;
                this.f214723f = coroutineScope;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
                Object coroutine_suspended;
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("FlowEx", 1, "collect[2] emit " + t16 + " / " + this.f214722e.element + " isActive=" + CoroutineScopeKt.isActive(this.f214723f));
                }
                Object send = this.f214721d.send(t16, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (send == coroutine_suspended) {
                    return send;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends Flow<? extends T>> function0, ProducerScope<? super T> producerScope, Ref.LongRef longRef, long j3, Flow<? extends T> flow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onTimeout = function0;
            this.$$this$channelFlow = producerScope;
            this.$lastEmissionTime = longRef;
            this.$timeoutMillis = j3;
            this.$flow = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onTimeout, this.$$this$channelFlow, this.$lastEmissionTime, this.$timeoutMillis, this.$flow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0112  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x00ef  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Job launch$default;
            final Job launch$default2;
            Ref.ObjectRef objectRef;
            CoroutineScope coroutineScope;
            Job[] jobArr;
            Ref.ObjectRef objectRef2;
            String str;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        objectRef2 = (Ref.ObjectRef) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("FlowEx", 1, "cancel channelFlow with: " + objectRef2.element);
                        }
                        Logger logger2 = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            Logger.a d16 = logger2.d();
                            CancellationException cancellationException = (CancellationException) objectRef2.element;
                            if (cancellationException == null || (str = cancellationException.getMessage()) == null) {
                                str = "Successful";
                            }
                            d16.d("FlowEx", 1, "supervisorScope close: " + str);
                        }
                        this.$$this$channelFlow.cancel((Throwable) objectRef2.element);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th5) {
                    th = th5;
                    Logger logger3 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger3.d().d("FlowEx", 1, "joinAll exception: " + th.getMessage());
                    }
                    objectRef2 = objectRef;
                    if (objectRef2.element instanceof TimeoutCancellationException) {
                    }
                    Logger logger22 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                    }
                    this.$$this$channelFlow.cancel((Throwable) objectRef2.element);
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new FlowKt$withIdleTimeout$2$1$detectJob$1(this.$lastEmissionTime, this.$timeoutMillis, null), 3, null);
                launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new FlowKt$withIdleTimeout$2$1$collectJob$1(this.$flow, objectRef3, launch$default, this.$$this$channelFlow, this.$lastEmissionTime, null), 3, null);
                launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.base.extension.FlowKt.withIdleTimeout.2.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                        invoke2(th6);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th6) {
                        Logger logger4 = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger4.d().d("FlowEx", 1, "detectJob completed " + th6);
                        }
                        if (th6 instanceof TimeoutCancellationException) {
                            CancellationException cancellationException2 = (CancellationException) th6;
                            if (!Job.this.isCancelled()) {
                                if (QLog.isColorLevel()) {
                                    logger4.d().d("FlowEx", 1, "cancel collectJob with: " + cancellationException2);
                                }
                                Job.this.cancel(cancellationException2);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                logger4.d().d("FlowEx", 1, "collectJob already cancelled, no need to cancel again");
                            }
                        }
                    }
                });
                try {
                    jobArr = new Job[]{launch$default, launch$default2};
                    this.L$0 = coroutineScope2;
                    objectRef = objectRef3;
                } catch (Throwable th6) {
                    th = th6;
                    objectRef = objectRef3;
                }
                try {
                    this.L$1 = objectRef;
                    this.label = 1;
                    if (AwaitKt.joinAll(jobArr, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope = coroutineScope2;
                } catch (Throwable th7) {
                    th = th7;
                    coroutineScope = coroutineScope2;
                    Logger logger32 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                    }
                    objectRef2 = objectRef;
                    if (objectRef2.element instanceof TimeoutCancellationException) {
                    }
                    Logger logger222 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                    }
                    this.$$this$channelFlow.cancel((Throwable) objectRef2.element);
                    return Unit.INSTANCE;
                }
            }
            objectRef2 = objectRef;
            if (objectRef2.element instanceof TimeoutCancellationException) {
                Flow<T> invoke = this.$onTimeout.invoke();
                a aVar = new a(this.$$this$channelFlow, this.$lastEmissionTime, coroutineScope);
                this.L$0 = objectRef2;
                this.L$1 = null;
                this.label = 2;
                if (invoke.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Logger logger4 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                }
            }
            Logger logger2222 = Logger.f235387a;
            if (QLog.isColorLevel()) {
            }
            this.$$this$channelFlow.cancel((Throwable) objectRef2.element);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt$withIdleTimeout$2(Flow<? extends T> flow, Function0<? extends Flow<? extends T>> function0, long j3, Continuation<? super FlowKt$withIdleTimeout$2> continuation) {
        super(2, continuation);
        this.$this_withIdleTimeout = flow;
        this.$onTimeout = function0;
        this.$timeoutMillis = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt$withIdleTimeout$2 flowKt$withIdleTimeout$2 = new FlowKt$withIdleTimeout$2(this.$this_withIdleTimeout, this.$onTimeout, this.$timeoutMillis, continuation);
        flowKt$withIdleTimeout$2.L$0 = obj;
        return flowKt$withIdleTimeout$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            ProducerScope producerScope = (ProducerScope) this.L$0;
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = System.currentTimeMillis();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onTimeout, producerScope, longRef, this.$timeoutMillis, this.$this_withIdleTimeout, null);
            this.label = 1;
            if (SupervisorKt.supervisorScope(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super T> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt$withIdleTimeout$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
