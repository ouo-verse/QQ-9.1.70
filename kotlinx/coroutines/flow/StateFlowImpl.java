package kotlinx.coroutines.flow;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010052\b\u0012\u0004\u0012\u00028\u0000062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u000008B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b)\u0010\u000fR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000*8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e\u00a2\u0006\u0012\u0012\u0004\b3\u0010$\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", QCircleDaTongConstant.ElementParamValue.COLLECT, "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", HippyTextInputController.COMMAND_setValue, "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    @NotNull
    private volatile /* synthetic */ Object _state;
    private int sequence;

    public StateFlowImpl(@NotNull Object obj) {
        this._state = obj;
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i3;
        StateFlowSlot[] slots;
        getSlots();
        synchronized (this) {
            Object obj = this._state;
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            this._state = newState;
            int i16 = this.sequence;
            if ((i16 & 1) == 0) {
                int i17 = i16 + 1;
                this.sequence = i17;
                StateFlowSlot[] slots2 = getSlots();
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = slots2;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                stateFlowSlot.makePending();
                            }
                        }
                    }
                    synchronized (this) {
                        i3 = this.sequence;
                        if (i3 == i17) {
                            this.sequence = i17 + 1;
                            return true;
                        }
                        slots = getSlots();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    slots2 = slots;
                    i17 = i3;
                }
            } else {
                this.sequence = i16 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b5, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r11, (java.lang.Object) r12) == false) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1 A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:13:0x003e, B:14:0x00a7, B:18:0x00b1, B:20:0x00d2, B:22:0x00d8, B:26:0x00b7, B:29:0x00be, B:34:0x00ac, B:39:0x005d, B:41:0x0070, B:42:0x0098), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d8 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #0 {all -> 0x0074, blocks: (B:13:0x003e, B:14:0x00a7, B:18:0x00b1, B:20:0x00d2, B:22:0x00d8, B:26:0x00b7, B:29:0x00be, B:34:0x00ac, B:39:0x005d, B:41:0x0070, B:42:0x0098), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac A[Catch: all -> 0x0074, TryCatch #0 {all -> 0x0074, blocks: (B:13:0x003e, B:14:0x00a7, B:18:0x00b1, B:20:0x00d2, B:22:0x00d8, B:26:0x00b7, B:29:0x00be, B:34:0x00ac, B:39:0x005d, B:41:0x0070, B:42:0x0098), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00d6 -> B:14:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e8 -> B:14:0x00a7). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        int i3;
        StateFlowImpl<T> stateFlowImpl;
        StateFlowSlot stateFlowSlot;
        FlowCollector flowCollector2;
        Job job;
        Object obj;
        StateFlowSlot stateFlowSlot2;
        boolean takePending;
        ?? r122;
        T t16;
        try {
            if (continuation instanceof StateFlowImpl$collect$1) {
                stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
                int i16 = stateFlowImpl$collect$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    stateFlowImpl$collect$1.label = i16 - Integer.MIN_VALUE;
                    Object obj2 = stateFlowImpl$collect$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = stateFlowImpl$collect$1.label;
                    ?? r65 = 1;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    obj = stateFlowImpl$collect$1.L$4;
                                    job = (Job) stateFlowImpl$collect$1.L$3;
                                    StateFlowSlot stateFlowSlot3 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                    flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                    stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                    r65 = stateFlowSlot3;
                                    r122 = stateFlowImpl._state;
                                    if (job != null) {
                                        JobKt.ensureActive(job);
                                    }
                                    if (obj != null) {
                                        stateFlowSlot2 = r65;
                                    }
                                    if (r122 == NullSurrogateKt.NULL) {
                                        t16 = null;
                                    } else {
                                        t16 = r122;
                                    }
                                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                                    stateFlowImpl$collect$1.L$2 = r65;
                                    stateFlowImpl$collect$1.L$3 = job;
                                    stateFlowImpl$collect$1.L$4 = r122;
                                    stateFlowImpl$collect$1.label = 2;
                                    if (flowCollector2.emit(t16, stateFlowImpl$collect$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = r122;
                                    stateFlowSlot2 = r65;
                                    takePending = stateFlowSlot2.takePending();
                                    r65 = stateFlowSlot2;
                                    if (!takePending) {
                                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                        stateFlowImpl$collect$1.L$1 = flowCollector2;
                                        stateFlowImpl$collect$1.L$2 = stateFlowSlot2;
                                        stateFlowImpl$collect$1.L$3 = job;
                                        stateFlowImpl$collect$1.L$4 = obj;
                                        stateFlowImpl$collect$1.label = 3;
                                        Object awaitPending = stateFlowSlot2.awaitPending(stateFlowImpl$collect$1);
                                        r65 = stateFlowSlot2;
                                        if (awaitPending == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    r122 = stateFlowImpl._state;
                                    if (job != null) {
                                    }
                                    if (obj != null) {
                                    }
                                    if (r122 == NullSurrogateKt.NULL) {
                                    }
                                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                                    stateFlowImpl$collect$1.L$2 = r65;
                                    stateFlowImpl$collect$1.L$3 = job;
                                    stateFlowImpl$collect$1.L$4 = r122;
                                    stateFlowImpl$collect$1.label = 2;
                                    if (flowCollector2.emit(t16, stateFlowImpl$collect$1) == coroutine_suspended) {
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                obj = stateFlowImpl$collect$1.L$4;
                                job = (Job) stateFlowImpl$collect$1.L$3;
                                StateFlowSlot stateFlowSlot4 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                                flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                                stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                stateFlowSlot2 = stateFlowSlot4;
                                takePending = stateFlowSlot2.takePending();
                                r65 = stateFlowSlot2;
                                if (!takePending) {
                                }
                                r122 = stateFlowImpl._state;
                                if (job != null) {
                                }
                                if (obj != null) {
                                }
                                if (r122 == NullSurrogateKt.NULL) {
                                }
                                stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                                stateFlowImpl$collect$1.L$1 = flowCollector2;
                                stateFlowImpl$collect$1.L$2 = r65;
                                stateFlowImpl$collect$1.L$3 = job;
                                stateFlowImpl$collect$1.L$4 = r122;
                                stateFlowImpl$collect$1.label = 2;
                                if (flowCollector2.emit(t16, stateFlowImpl$collect$1) == coroutine_suspended) {
                                }
                            }
                        } else {
                            StateFlowSlot stateFlowSlot5 = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                            flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                            stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                            stateFlowSlot = stateFlowSlot5;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        StateFlowSlot allocateSlot = allocateSlot();
                        try {
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                stateFlowImpl$collect$1.L$0 = this;
                                stateFlowImpl$collect$1.L$1 = flowCollector;
                                stateFlowImpl$collect$1.L$2 = allocateSlot;
                                stateFlowImpl$collect$1.label = 1;
                                if (((SubscribedFlowCollector) flowCollector).onSubscription(stateFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            stateFlowImpl = this;
                            stateFlowSlot = allocateSlot;
                        } catch (Throwable th5) {
                            th = th5;
                            stateFlowImpl = this;
                            r65 = allocateSlot;
                            stateFlowImpl.freeSlot(r65);
                            throw th;
                        }
                    }
                    flowCollector2 = flowCollector;
                    job = (Job) stateFlowImpl$collect$1.getContext().get(Job.INSTANCE);
                    obj = null;
                    r65 = stateFlowSlot;
                    r122 = stateFlowImpl._state;
                    if (job != null) {
                    }
                    if (obj != null) {
                    }
                    if (r122 == NullSurrogateKt.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                    stateFlowImpl$collect$1.L$2 = r65;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = r122;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector2.emit(t16, stateFlowImpl$collect$1) == coroutine_suspended) {
                    }
                }
            }
            if (i3 == 0) {
            }
            flowCollector2 = flowCollector;
            job = (Job) stateFlowImpl$collect$1.getContext().get(Job.INSTANCE);
            obj = null;
            r65 = stateFlowSlot;
            r122 = stateFlowImpl._state;
            if (job != null) {
            }
            if (obj != null) {
            }
            if (r122 == NullSurrogateKt.NULL) {
            }
            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
            stateFlowImpl$collect$1.L$1 = flowCollector2;
            stateFlowImpl$collect$1.L$2 = r65;
            stateFlowImpl$collect$1.L$3 = job;
            stateFlowImpl$collect$1.L$4 = r122;
            stateFlowImpl$collect$1.label = 2;
            if (flowCollector2.emit(t16, stateFlowImpl$collect$1) == coroutine_suspended) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj22 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = stateFlowImpl$collect$1.label;
        ?? r652 = 1;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.NULL;
        }
        return updateState(expect, update);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        setValue(t16);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        List<T> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(getValue());
        return listOf;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t16 = (T) this._state;
        if (t16 == symbol) {
            return null;
        }
        return t16;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t16) {
        if (t16 == null) {
            t16 = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t16);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        setValue(value);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
