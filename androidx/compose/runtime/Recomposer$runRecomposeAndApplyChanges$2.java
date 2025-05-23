package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import com.tencent.luggage.wxa.se.i;
import com.tencent.luggage.wxa.yf.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {i.CTRL_INDEX, u.CTRL_INDEX}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes39.dex */
public final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
        List list2;
        List list3;
        list.clear();
        synchronized (recomposer.stateLock) {
            list2 = recomposer.compositionValuesAwaitingInsert;
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                list.add((MovableContentStateReference) list2.get(i3));
            }
            list3 = recomposer.compositionValuesAwaitingInsert;
            list3.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008f  */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00c9 -> B:7:0x0087). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00fa -> B:6:0x00fe). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MonotonicFrameClock monotonicFrameClock;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        LinkedHashSet linkedHashSet;
        LinkedHashSet linkedHashSet2;
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2;
        LinkedHashSet linkedHashSet3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$22;
        LinkedHashSet linkedHashSet4;
        SynchronizedObject synchronizedObject;
        boolean hasFrameWorkLocked;
        int i3;
        boolean hasFrameWorkLocked2;
        boolean shouldKeepRecomposing;
        Object awaitWorkAvailable;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        int i17 = 1;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            monotonicFrameClock = (MonotonicFrameClock) this.L$0;
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            linkedHashSet = new LinkedHashSet();
            linkedHashSet2 = new LinkedHashSet();
            recomposer$runRecomposeAndApplyChanges$2 = this;
            shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
            }
        } else if (i16 == 1) {
            ?? r26 = (Set) this.L$5;
            ?? r56 = (Set) this.L$4;
            ?? r65 = (List) this.L$3;
            ?? r75 = (List) this.L$2;
            ?? r85 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            recomposer$runRecomposeAndApplyChanges$22 = this;
            linkedHashSet4 = r26;
            linkedHashSet3 = r56;
            arrayList4 = r65;
            arrayList5 = r75;
            arrayList6 = r85;
            monotonicFrameClock = monotonicFrameClock2;
            synchronizedObject = recomposer$runRecomposeAndApplyChanges$22.this$0.stateLock;
            Recomposer recomposer = recomposer$runRecomposeAndApplyChanges$22.this$0;
            synchronized (synchronizedObject) {
            }
        } else if (i16 == 2) {
            ?? r27 = (Set) this.L$5;
            ?? r57 = (Set) this.L$4;
            ?? r66 = (List) this.L$3;
            ?? r76 = (List) this.L$2;
            ?? r86 = (List) this.L$1;
            MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(obj);
            recomposer$runRecomposeAndApplyChanges$2 = this;
            arrayList4 = r66;
            char c16 = 2;
            linkedHashSet2 = r27;
            monotonicFrameClock = monotonicFrameClock3;
            linkedHashSet = r57;
            arrayList = r86;
            ArrayList arrayList7 = r76;
            arrayList2 = arrayList7;
            arrayList3 = arrayList4;
            i17 = 1;
            shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
            if (!shouldKeepRecomposing) {
                Recomposer recomposer2 = recomposer$runRecomposeAndApplyChanges$2.this$0;
                recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
                recomposer$runRecomposeAndApplyChanges$2.L$1 = arrayList;
                recomposer$runRecomposeAndApplyChanges$2.L$2 = arrayList2;
                recomposer$runRecomposeAndApplyChanges$2.L$3 = arrayList3;
                recomposer$runRecomposeAndApplyChanges$2.L$4 = linkedHashSet;
                recomposer$runRecomposeAndApplyChanges$2.L$5 = linkedHashSet2;
                recomposer$runRecomposeAndApplyChanges$2.label = i17;
                awaitWorkAvailable = recomposer2.awaitWorkAvailable(recomposer$runRecomposeAndApplyChanges$2);
                if (awaitWorkAvailable == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList6 = arrayList;
                arrayList5 = arrayList2;
                arrayList4 = arrayList3;
                linkedHashSet3 = linkedHashSet;
                recomposer$runRecomposeAndApplyChanges$22 = recomposer$runRecomposeAndApplyChanges$2;
                linkedHashSet4 = linkedHashSet2;
                synchronizedObject = recomposer$runRecomposeAndApplyChanges$22.this$0.stateLock;
                Recomposer recomposer3 = recomposer$runRecomposeAndApplyChanges$22.this$0;
                synchronized (synchronizedObject) {
                    hasFrameWorkLocked = recomposer3.getHasFrameWorkLocked();
                    i3 = 0;
                    if (!hasFrameWorkLocked) {
                        recomposer3.recordComposerModificationsLocked();
                        hasFrameWorkLocked2 = recomposer3.getHasFrameWorkLocked();
                        if (!hasFrameWorkLocked2) {
                            i3 = i17;
                        }
                    }
                }
                if (i3 != 0) {
                    linkedHashSet2 = linkedHashSet4;
                    recomposer$runRecomposeAndApplyChanges$2 = recomposer$runRecomposeAndApplyChanges$22;
                    arrayList = arrayList6;
                    arrayList2 = arrayList5;
                    arrayList3 = arrayList4;
                    linkedHashSet = linkedHashSet3;
                    shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                        return Unit.INSTANCE;
                    }
                } else {
                    final Recomposer recomposer4 = recomposer$runRecomposeAndApplyChanges$22.this$0;
                    final ArrayList arrayList8 = arrayList6;
                    final ArrayList arrayList9 = arrayList5;
                    final LinkedHashSet linkedHashSet5 = linkedHashSet3;
                    final LinkedHashSet linkedHashSet6 = linkedHashSet4;
                    final ArrayList arrayList10 = arrayList4;
                    Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$23 = recomposer$runRecomposeAndApplyChanges$22;
                    Function1<Long, CancellableContinuation<? super Unit>> function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l3) {
                            return invoke(l3.longValue());
                        }

                        public final CancellableContinuation<Unit> invoke(long j3) {
                            BroadcastFrameClock broadcastFrameClock;
                            Object beginSection;
                            List performInsertValues;
                            ControlledComposition performRecompose;
                            CancellableContinuation<Unit> deriveStateLocked;
                            BroadcastFrameClock broadcastFrameClock2;
                            broadcastFrameClock = Recomposer.this.broadcastFrameClock;
                            if (broadcastFrameClock.getHasAwaiters()) {
                                Recomposer recomposer5 = Recomposer.this;
                                Trace trace = Trace.INSTANCE;
                                beginSection = trace.beginSection("Recomposer:animation");
                                try {
                                    broadcastFrameClock2 = recomposer5.broadcastFrameClock;
                                    broadcastFrameClock2.sendFrame(j3);
                                    Snapshot.INSTANCE.sendApplyNotifications();
                                    Unit unit = Unit.INSTANCE;
                                    trace.endSection(beginSection);
                                } finally {
                                }
                            }
                            Recomposer recomposer6 = Recomposer.this;
                            List<ControlledComposition> list = arrayList8;
                            List<MovableContentStateReference> list2 = arrayList9;
                            Set<ControlledComposition> set = linkedHashSet5;
                            List<ControlledComposition> list3 = arrayList10;
                            Set<ControlledComposition> set2 = linkedHashSet6;
                            beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                            try {
                                synchronized (recomposer6.stateLock) {
                                    recomposer6.recordComposerModificationsLocked();
                                    List list4 = recomposer6.compositionInvalidations;
                                    int size = list4.size();
                                    for (int i18 = 0; i18 < size; i18++) {
                                        list.add((ControlledComposition) list4.get(i18));
                                    }
                                    recomposer6.compositionInvalidations.clear();
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                IdentityArraySet identityArraySet = new IdentityArraySet();
                                IdentityArraySet identityArraySet2 = new IdentityArraySet();
                                while (true) {
                                    if (!(!list.isEmpty()) && !(!list2.isEmpty())) {
                                        break;
                                    }
                                    try {
                                        int size2 = list.size();
                                        for (int i19 = 0; i19 < size2; i19++) {
                                            ControlledComposition controlledComposition = list.get(i19);
                                            identityArraySet2.add(controlledComposition);
                                            performRecompose = recomposer6.performRecompose(controlledComposition, identityArraySet);
                                            if (performRecompose != null) {
                                                list3.add(performRecompose);
                                            }
                                        }
                                        list.clear();
                                        if (identityArraySet.isNotEmpty()) {
                                            synchronized (recomposer6.stateLock) {
                                                List list5 = recomposer6.knownCompositions;
                                                int size3 = list5.size();
                                                for (int i26 = 0; i26 < size3; i26++) {
                                                    ControlledComposition controlledComposition2 = (ControlledComposition) list5.get(i26);
                                                    if (!identityArraySet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(identityArraySet)) {
                                                        list.add(controlledComposition2);
                                                    }
                                                }
                                                Unit unit3 = Unit.INSTANCE;
                                            }
                                        }
                                        if (list.isEmpty()) {
                                            Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer6);
                                            while (!list2.isEmpty()) {
                                                performInsertValues = recomposer6.performInsertValues(list2, identityArraySet);
                                                CollectionsKt__MutableCollectionsKt.addAll(set, performInsertValues);
                                                Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend$fillToInsert(list2, recomposer6);
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        list.clear();
                                        throw th5;
                                    }
                                }
                                if (!list3.isEmpty()) {
                                    recomposer6.changeCount = recomposer6.getChangeCount() + 1;
                                    try {
                                        CollectionsKt__MutableCollectionsKt.addAll(set2, list3);
                                        int size4 = list3.size();
                                        for (int i27 = 0; i27 < size4; i27++) {
                                            list3.get(i27).applyChanges();
                                        }
                                        list3.clear();
                                    } catch (Throwable th6) {
                                        list3.clear();
                                        throw th6;
                                    }
                                }
                                if (!set.isEmpty()) {
                                    try {
                                        CollectionsKt__MutableCollectionsKt.addAll(set2, set);
                                        Iterator<T> it = set.iterator();
                                        while (it.hasNext()) {
                                            ((ControlledComposition) it.next()).applyLateChanges();
                                        }
                                        set.clear();
                                    } catch (Throwable th7) {
                                        set.clear();
                                        throw th7;
                                    }
                                }
                                if (!set2.isEmpty()) {
                                    try {
                                        Iterator<T> it5 = set2.iterator();
                                        while (it5.hasNext()) {
                                            ((ControlledComposition) it5.next()).changesApplied();
                                        }
                                        set2.clear();
                                    } catch (Throwable th8) {
                                        set2.clear();
                                        throw th8;
                                    }
                                }
                                recomposer6.discardUnusedValues();
                                synchronized (recomposer6.stateLock) {
                                    deriveStateLocked = recomposer6.deriveStateLocked();
                                }
                                return deriveStateLocked;
                            } finally {
                            }
                        }
                    };
                    recomposer$runRecomposeAndApplyChanges$23.L$0 = monotonicFrameClock;
                    recomposer$runRecomposeAndApplyChanges$23.L$1 = arrayList6;
                    recomposer$runRecomposeAndApplyChanges$23.L$2 = arrayList5;
                    recomposer$runRecomposeAndApplyChanges$23.L$3 = arrayList4;
                    recomposer$runRecomposeAndApplyChanges$23.L$4 = linkedHashSet3;
                    linkedHashSet2 = linkedHashSet6;
                    recomposer$runRecomposeAndApplyChanges$23.L$5 = linkedHashSet2;
                    c16 = 2;
                    recomposer$runRecomposeAndApplyChanges$23.label = 2;
                    if (monotonicFrameClock.withFrameNanos(function1, recomposer$runRecomposeAndApplyChanges$23) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    recomposer$runRecomposeAndApplyChanges$2 = recomposer$runRecomposeAndApplyChanges$23;
                    arrayList = arrayList6;
                    arrayList7 = arrayList5;
                    linkedHashSet = linkedHashSet3;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList4;
                    i17 = 1;
                    shouldKeepRecomposing = recomposer$runRecomposeAndApplyChanges$2.this$0.getShouldKeepRecomposing();
                    if (!shouldKeepRecomposing) {
                    }
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
