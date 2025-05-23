package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {744}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
/* loaded from: classes39.dex */
public final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", f = "Recomposer.kt", i = {}, l = {745}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.$parentFrameClock, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                this.label = 1;
                if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Job job;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl;
        ObserverHandle observerHandle;
        Throwable th5;
        SynchronizedObject synchronizedObject;
        Job job2;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl2;
        Job job3;
        Recomposer.RecomposerInfoImpl recomposerInfoImpl3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            this.this$0.registerRunnerJob(job);
            Snapshot.Companion companion = Snapshot.INSTANCE;
            final Recomposer recomposer = this.this$0;
            ObserverHandle registerApplyObserver = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                    invoke2(set, snapshot);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Set<? extends Object> changed, Snapshot snapshot) {
                    MutableStateFlow mutableStateFlow;
                    CancellableContinuation cancellableContinuation;
                    Intrinsics.checkNotNullParameter(changed, "changed");
                    Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                    SynchronizedObject synchronizedObject2 = Recomposer.this.stateLock;
                    Recomposer recomposer2 = Recomposer.this;
                    synchronized (synchronizedObject2) {
                        mutableStateFlow = recomposer2._state;
                        if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                            recomposer2.snapshotInvalidations.add(changed);
                            cancellableContinuation = recomposer2.deriveStateLocked();
                        } else {
                            cancellableContinuation = null;
                        }
                    }
                    if (cancellableContinuation != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                    }
                }
            });
            Recomposer.Companion companion2 = Recomposer.INSTANCE;
            recomposerInfoImpl = this.this$0.recomposerInfo;
            companion2.addRunning(recomposerInfoImpl);
            try {
                SynchronizedObject synchronizedObject2 = this.this$0.stateLock;
                Recomposer recomposer2 = this.this$0;
                synchronized (synchronizedObject2) {
                    List list = recomposer2.knownCompositions;
                    int size = list.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        ((ControlledComposition) list.get(i16)).invalidateAll();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.$parentFrameClock, null);
                this.L$0 = job;
                this.L$1 = registerApplyObserver;
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                observerHandle = registerApplyObserver;
            } catch (Throwable th6) {
                observerHandle = registerApplyObserver;
                th5 = th6;
                observerHandle.dispose();
                synchronizedObject = this.this$0.stateLock;
                Recomposer recomposer3 = this.this$0;
                synchronized (synchronizedObject) {
                    job2 = recomposer3.runnerJob;
                    if (job2 == job) {
                        recomposer3.runnerJob = null;
                    }
                    recomposer3.deriveStateLocked();
                }
                Recomposer.Companion companion3 = Recomposer.INSTANCE;
                recomposerInfoImpl2 = this.this$0.recomposerInfo;
                companion3.removeRunning(recomposerInfoImpl2);
                throw th5;
            }
        } else if (i3 == 1) {
            observerHandle = (ObserverHandle) this.L$1;
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th7) {
                th5 = th7;
                observerHandle.dispose();
                synchronizedObject = this.this$0.stateLock;
                Recomposer recomposer32 = this.this$0;
                synchronized (synchronizedObject) {
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        observerHandle.dispose();
        SynchronizedObject synchronizedObject3 = this.this$0.stateLock;
        Recomposer recomposer4 = this.this$0;
        synchronized (synchronizedObject3) {
            job3 = recomposer4.runnerJob;
            if (job3 == job) {
                recomposer4.runnerJob = null;
            }
            recomposer4.deriveStateLocked();
        }
        Recomposer.Companion companion4 = Recomposer.INSTANCE;
        recomposerInfoImpl3 = this.this$0.recomposerInfo;
        companion4.removeRunning(recomposerInfoImpl3);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
