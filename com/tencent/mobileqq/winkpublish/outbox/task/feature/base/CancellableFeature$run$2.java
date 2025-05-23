package com.tencent.mobileqq.winkpublish.outbox.task.feature.base;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2", f = "CancellableFeature.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class CancellableFeature$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TaskContext $taskContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CancellableFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1", f = "CancellableFeature.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CancellableFeature this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"", "attempt", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1$1", f = "CancellableFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C90961 extends SuspendLambda implements Function3<Integer, Throwable, Continuation<? super Boolean>, Object> {
            /* synthetic */ int I$0;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CancellableFeature this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C90961(CancellableFeature cancellableFeature, Continuation<? super C90961> continuation) {
                super(3, continuation);
                this.this$0 = cancellableFeature;
            }

            public final Object invoke(int i3, Throwable th5, Continuation<? super Boolean> continuation) {
                C90961 c90961 = new C90961(this.this$0, continuation);
                c90961.I$0 = i3;
                c90961.L$0 = th5;
                return c90961.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    int i3 = this.I$0;
                    Throwable th5 = (Throwable) this.L$0;
                    if (i3 < this.this$0.j()) {
                        this.this$0.r(i3 + 1);
                        return Boxing.boxBoolean(true);
                    }
                    throw th5;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Throwable th5, Continuation<? super Boolean> continuation) {
                return invoke(num.intValue(), th5, continuation);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1$2", f = "CancellableFeature.kt", i = {}, l = {50, 55}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$1$2, reason: invalid class name */
        /* loaded from: classes35.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            int label;
            final /* synthetic */ CancellableFeature this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(CoroutineScope coroutineScope, CancellableFeature cancellableFeature, Continuation<? super AnonymousClass2> continuation) {
                super(1, continuation);
                this.$$this$launch = coroutineScope;
                this.this$0 = cancellableFeature;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass2(this.$$this$launch, this.this$0, continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x006c -> B:6:0x006f). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                AnonymousClass2 anonymousClass2;
                long t16;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = this;
                    if (!CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = this;
                    if (QLog.isColorLevel()) {
                    }
                    t16 = anonymousClass2.this$0.t();
                    anonymousClass2.label = 2;
                    if (DelayKt.delay(t16, anonymousClass2) == coroutine_suspended) {
                    }
                    if (CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                    }
                    if (!CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                    }
                } else if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = this;
                    if (CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                        anonymousClass2.this$0.n();
                    }
                    if (!CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                        long s16 = anonymousClass2.this$0.s();
                        anonymousClass2.label = 1;
                        if (DelayKt.delay(s16, anonymousClass2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("WinkPublish-upload2-CancellableFeature", 2, "[run] timeoutJob isActive=" + CoroutineScopeKt.isActive(anonymousClass2.$$this$launch));
                        }
                        t16 = anonymousClass2.this$0.t();
                        anonymousClass2.label = 2;
                        if (DelayKt.delay(t16, anonymousClass2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                        }
                        if (!CoroutineScopeKt.isActive(anonymousClass2.$$this$launch)) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CancellableFeature cancellableFeature, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = cancellableFeature;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                C90961 c90961 = new C90961(this.this$0, null);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(coroutineScope, this.this$0, null);
                this.label = 1;
                if (IFeatureKt.a(c90961, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancellableFeature$run$2(CancellableFeature cancellableFeature, TaskContext taskContext, Continuation<? super CancellableFeature$run$2> continuation) {
        super(2, continuation);
        this.this$0 = cancellableFeature;
        this.$taskContext = taskContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CancellableFeature$run$2 cancellableFeature$run$2 = new CancellableFeature$run$2(this.this$0, this.$taskContext, continuation);
        cancellableFeature$run$2.L$0 = obj;
        return cancellableFeature$run$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        CancellableContinuation cancellableContinuation;
        Object coroutine_suspended2;
        Job job;
        Job launch$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CancellableContinuation cancellableContinuation2 = null;
            if (this.this$0.k()) {
                job = this.this$0.timeoutJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                CancellableFeature cancellableFeature = this.this$0;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(cancellableFeature, null), 3, null);
                cancellableFeature.timeoutJob = launch$default;
            }
            final CancellableFeature cancellableFeature2 = this.this$0;
            final TaskContext taskContext = this.$taskContext;
            this.L$0 = cancellableFeature2;
            this.L$1 = taskContext;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            cancellableFeature2.continuation = cancellableContinuationImpl;
            cancellableContinuation = cancellableFeature2.continuation;
            if (cancellableContinuation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("continuation");
            } else {
                cancellableContinuation2 = cancellableContinuation;
            }
            cancellableContinuation2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.winkpublish.outbox.task.feature.base.CancellableFeature$run$2$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th5) {
                    CancellableFeature.this.l(taskContext);
                }
            });
            cancellableFeature2.m(taskContext);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                DebugProbes.probeCoroutineSuspended(this);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CancellableFeature$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
