package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.LinkedHashSet;
import java.util.Set;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {134, 138, 160}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* loaded from: classes39.dex */
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9 A[Catch: all -> 0x0054, TryCatch #3 {all -> 0x0054, blocks: (B:15:0x00e5, B:17:0x00e9, B:21:0x00f3, B:25:0x0101, B:31:0x0117, B:33:0x0120, B:45:0x0143, B:46:0x0146, B:60:0x004c, B:27:0x010c, B:30:0x0114, B:41:0x013e, B:42:0x0141, B:29:0x0110), top: B:59:0x004c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0101 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #3 {all -> 0x0054, blocks: (B:15:0x00e5, B:17:0x00e9, B:21:0x00f3, B:25:0x0101, B:31:0x0117, B:33:0x0120, B:45:0x0143, B:46:0x0146, B:60:0x004c, B:27:0x010c, B:30:0x0114, B:41:0x013e, B:42:0x0141, B:29:0x0110), top: B:59:0x004c, inners: #1 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ObserverHandle observerHandle;
        FlowCollector flowCollector;
        final Set linkedHashSet;
        Function1<Object, Unit> function1;
        final Channel Channel$default;
        Snapshot takeSnapshot;
        Snapshot makeCurrent;
        Object obj2;
        Object obj3;
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
        boolean intersects$SnapshotStateKt__SnapshotFlowKt;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    obj2 = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    linkedHashSet = (Set) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                } else if (i3 == 2) {
                    int i16 = this.I$0;
                    Object obj4 = this.L$5;
                    ObserverHandle observerHandle2 = (ObserverHandle) this.L$4;
                    Channel channel = (Channel) this.L$3;
                    Function1<Object, Unit> function12 = (Function1) this.L$2;
                    Set set = (Set) this.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        obj3 = obj;
                        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1<T> snapshotStateKt__SnapshotFlowKt$snapshotFlow$12 = this;
                        Set set2 = (Set) obj3;
                        do {
                            if (i16 == 0) {
                                intersects$SnapshotStateKt__SnapshotFlowKt = SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(set, set2);
                                if (!intersects$SnapshotStateKt__SnapshotFlowKt) {
                                    i16 = 0;
                                    set2 = (Set) ChannelResult.m2013getOrNullimpl(channel.mo2002tryReceivePtdJZtk());
                                }
                            }
                            i16 = 1;
                            set2 = (Set) ChannelResult.m2013getOrNullimpl(channel.mo2002tryReceivePtdJZtk());
                        } while (set2 != null);
                        if (i16 != 0) {
                            set.clear();
                            takeSnapshot = Snapshot.INSTANCE.takeSnapshot(function12);
                            Function0<T> function0 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.$block;
                            try {
                                try {
                                    T invoke = function0.invoke();
                                    takeSnapshot.restoreCurrent(makeCurrent);
                                    takeSnapshot.dispose();
                                    if (!Intrinsics.areEqual(invoke, obj4)) {
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$0 = flowCollector2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$1 = set;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$2 = function12;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$3 = channel;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$4 = observerHandle2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.L$5 = invoke;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12.label = 3;
                                        if (flowCollector2.emit(invoke, snapshotStateKt__SnapshotFlowKt$snapshotFlow$12) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        observerHandle = observerHandle2;
                                        Channel$default = channel;
                                        function1 = function12;
                                        linkedHashSet = set;
                                        flowCollector = flowCollector2;
                                        obj2 = invoke;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                                        obj3 = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$12 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
                                        flowCollector2 = flowCollector;
                                        set = linkedHashSet;
                                        function12 = function1;
                                        channel = Channel$default;
                                        observerHandle2 = observerHandle;
                                        obj4 = obj2;
                                        i16 = 0;
                                        Set set22 = (Set) obj3;
                                        do {
                                            if (i16 == 0) {
                                            }
                                            i16 = 1;
                                            set22 = (Set) ChannelResult.m2013getOrNullimpl(channel.mo2002tryReceivePtdJZtk());
                                        } while (set22 != null);
                                        if (i16 != 0) {
                                        }
                                    }
                                } finally {
                                }
                                makeCurrent = takeSnapshot.makeCurrent();
                            } finally {
                            }
                        }
                        obj2 = obj4;
                        observerHandle = observerHandle2;
                        Channel$default = channel;
                        function1 = function12;
                        linkedHashSet = set;
                        flowCollector = flowCollector2;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = snapshotStateKt__SnapshotFlowKt$snapshotFlow$12;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
                        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
                        obj3 = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
                        if (obj3 == coroutine_suspended) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        observerHandle = observerHandle2;
                        observerHandle.dispose();
                        throw th;
                    }
                } else if (i3 == 3) {
                    obj2 = this.L$5;
                    observerHandle = (ObserverHandle) this.L$4;
                    Channel$default = (Channel) this.L$3;
                    function1 = (Function1) this.L$2;
                    linkedHashSet = (Set) this.L$1;
                    flowCollector = (FlowCollector) this.L$0;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                linkedHashSet = new LinkedHashSet();
                function1 = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj5) {
                        invoke2(obj5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        linkedHashSet.add(it);
                    }
                };
                Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                observerHandle = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set3, Snapshot snapshot) {
                        invoke2(set3, snapshot);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Set<? extends Object> changed, Snapshot snapshot) {
                        Intrinsics.checkNotNullParameter(changed, "changed");
                        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
                        Channel$default.mo2003trySendJP2dKIU(changed);
                    }
                });
                takeSnapshot = companion.takeSnapshot(function1);
                Function0<T> function02 = this.$block;
                try {
                    makeCurrent = takeSnapshot.makeCurrent();
                    try {
                        T invoke2 = function02.invoke();
                        takeSnapshot.restoreCurrent(makeCurrent);
                        takeSnapshot.dispose();
                        this.L$0 = flowCollector;
                        this.L$1 = linkedHashSet;
                        this.L$2 = function1;
                        this.L$3 = Channel$default;
                        this.L$4 = observerHandle;
                        this.L$5 = invoke2;
                        this.label = 1;
                        if (flowCollector.emit(invoke2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = invoke2;
                    } finally {
                        takeSnapshot.restoreCurrent(makeCurrent);
                    }
                } finally {
                }
            }
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = this;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = flowCollector;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$1 = linkedHashSet;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$2 = function1;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$3 = Channel$default;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$4 = observerHandle;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$5 = obj2;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.I$0 = 0;
            snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.label = 2;
            obj3 = Channel$default.receive(snapshotStateKt__SnapshotFlowKt$snapshotFlow$1);
            if (obj3 == coroutine_suspended) {
            }
        } catch (Throwable th6) {
            th = th6;
            observerHandle.dispose();
            throw th;
        }
    }
}
