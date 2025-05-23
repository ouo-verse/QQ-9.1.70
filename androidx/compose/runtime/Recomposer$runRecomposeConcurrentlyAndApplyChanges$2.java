package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {com.tencent.luggage.wxa.v6.d.CTRL_INDEX, 612, 613}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes39.dex */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0197 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0173  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ab -> B:17:0x00ad). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Job launch$default;
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
        CoroutineScope coroutineScope;
        ProduceFrameSignal produceFrameSignal;
        boolean shouldKeepRecomposing;
        Object obj2;
        Object awaitWorkAvailable;
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$22;
        boolean hasConcurrentFrameWorkLocked;
        Continuation<Unit> requestFrameLocked;
        int i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                launch$default = (Job) this.L$0;
                ResultKt.throwOnFailure(obj);
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
                obj2 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = obj2;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 3;
                if (JobKt.cancelAndJoin(launch$default, recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            launch$default = (Job) this.L$2;
            produceFrameSignal = (ProduceFrameSignal) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$23 = this;
            CoroutineScope coroutineScope3 = coroutineScope2;
            SynchronizedObject synchronizedObject = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0.stateLock;
            Recomposer recomposer = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0;
            synchronized (synchronizedObject) {
                if (!recomposer.snapshotInvalidations.isEmpty()) {
                    List list = recomposer.snapshotInvalidations;
                    int size = list.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        Set<? extends Object> set = (Set) list.get(i17);
                        List list2 = recomposer.knownCompositions;
                        int size2 = list2.size();
                        for (int i18 = 0; i18 < size2; i18++) {
                            ((ControlledComposition) list2.get(i18)).recordModificationsOf(set);
                        }
                    }
                    recomposer.snapshotInvalidations.clear();
                }
                List list3 = recomposer.compositionInvalidations;
                int size3 = list3.size();
                int i19 = 0;
                while (i19 < size3) {
                    ControlledComposition controlledComposition = (ControlledComposition) list3.get(i19);
                    i3 = recomposer.concurrentCompositionsOutstanding;
                    recomposer.concurrentCompositionsOutstanding = i3 + 1;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope3, CompositionKt.getRecomposeCoroutineContext(controlledComposition), null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(recomposer, controlledComposition, null), 2, null);
                    i19++;
                    recomposer$runRecomposeConcurrentlyAndApplyChanges$23 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23;
                    recomposer = recomposer;
                }
                Recomposer recomposer2 = recomposer;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$22 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23;
                recomposer2.compositionInvalidations.clear();
                if (recomposer2.deriveStateLocked() == null) {
                    hasConcurrentFrameWorkLocked = recomposer2.getHasConcurrentFrameWorkLocked();
                    requestFrameLocked = hasConcurrentFrameWorkLocked ? produceFrameSignal.requestFrameLocked() : null;
                } else {
                    throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                }
            }
            if (requestFrameLocked != null) {
                Result.Companion companion = Result.INSTANCE;
                requestFrameLocked.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
            recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = recomposer$runRecomposeConcurrentlyAndApplyChanges$22;
            coroutineScope = coroutineScope3;
            shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                Recomposer recomposer3 = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = produceFrameSignal;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = launch$default;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 1;
                awaitWorkAvailable = recomposer3.awaitWorkAvailable(recomposer$runRecomposeConcurrentlyAndApplyChanges$2);
                if (awaitWorkAvailable == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope3 = coroutineScope;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$23 = recomposer$runRecomposeConcurrentlyAndApplyChanges$2;
                SynchronizedObject synchronizedObject2 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0.stateLock;
                Recomposer recomposer4 = recomposer$runRecomposeConcurrentlyAndApplyChanges$23.this$0;
                synchronized (synchronizedObject2) {
                }
            } else {
                Job job = JobKt.getJob(coroutineScope.getCoroutineContext());
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = launch$default;
                obj2 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$2 = null;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 2;
                if (JobKt.cancelAndJoin(job, recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = obj2;
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2.label = 3;
                if (JobKt.cancelAndJoin(launch$default, recomposer$runRecomposeConcurrentlyAndApplyChanges$2) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) this.L$1;
            CoroutineContext coroutineContext = this.$recomposeCoroutineContext;
            Job.Companion companion2 = Job.INSTANCE;
            boolean z16 = coroutineContext.get(companion2) == null;
            CoroutineContext coroutineContext2 = this.$recomposeCoroutineContext;
            if (z16) {
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineScope4.getCoroutineContext().plus(this.$recomposeCoroutineContext).plus(JobKt.Job(JobKt.getJob(coroutineScope4.getCoroutineContext()))));
                ProduceFrameSignal produceFrameSignal2 = new ProduceFrameSignal();
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope4, null, null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, monotonicFrameClock, produceFrameSignal2, null), 3, null);
                recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = this;
                coroutineScope = CoroutineScope;
                produceFrameSignal = produceFrameSignal2;
                shouldKeepRecomposing = recomposer$runRecomposeConcurrentlyAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                if (!shouldKeepRecomposing) {
                }
            } else {
                throw new IllegalArgumentException(("recomposeCoroutineContext may not contain a Job; found " + coroutineContext2.get(companion2)).toString());
            }
        }
    }
}
