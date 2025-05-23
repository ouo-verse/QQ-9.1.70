package com.tencent.ecommerce.base.ktx;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, null);
            this.label = 1;
            if (BuildersKt.withContext(immediate, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {186}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    /* renamed from: com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $this_coroutineScope;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, Continuation continuation) {
            super(2, continuation);
            this.$this_coroutineScope = coroutineScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_coroutineScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
        /* JADX WARN: Type inference failed for: r15v0, types: [com.tencent.ecommerce.base.ktx.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1, T] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            Continuation intercepted;
            Object coroutine_suspended2;
            Job job;
            LifecycleEventObserver lifecycleEventObserver;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                if (RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    return Unit.INSTANCE;
                }
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = null;
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                objectRef4.element = null;
                try {
                    this.L$0 = objectRef3;
                    this.L$1 = objectRef4;
                    this.L$2 = this;
                    this.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                    cancellableContinuationImpl.initCancellability();
                    ?? repeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1(Lifecycle.Event.upTo(RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$state), MutexKt.Mutex$default(false, 1, null), Lifecycle.Event.downFrom(RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$state), cancellableContinuationImpl, this, objectRef4, objectRef3);
                    objectRef4.element = repeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1;
                    RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$this_repeatOnLifecycle.addObserver((LifecycleEventObserver) repeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1);
                    Object result = cancellableContinuationImpl.getResult();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (result == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(this);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef3;
                    objectRef2 = objectRef4;
                } catch (Throwable th5) {
                    th = th5;
                    objectRef = objectRef3;
                    objectRef2 = objectRef4;
                    job = (Job) objectRef.element;
                    if (job != null) {
                    }
                    lifecycleEventObserver = (LifecycleEventObserver) objectRef2.element;
                    if (lifecycleEventObserver != null) {
                    }
                    throw th;
                }
            } else if (i3 == 1) {
                objectRef2 = (Ref.ObjectRef) this.L$1;
                objectRef = (Ref.ObjectRef) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th6) {
                    th = th6;
                    job = (Job) objectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    lifecycleEventObserver = (LifecycleEventObserver) objectRef2.element;
                    if (lifecycleEventObserver != null) {
                        RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                    }
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Job job2 = (Job) objectRef.element;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            LifecycleEventObserver lifecycleEventObserver2 = (LifecycleEventObserver) objectRef2.element;
            if (lifecycleEventObserver2 != null) {
                RepeatOnLifecycleKt$repeatOnLifecycle$3.this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
            }
            return Unit.INSTANCE;
        }
    }
}
