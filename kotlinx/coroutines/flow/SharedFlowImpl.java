package kotlinx.coroutines.flow;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001bB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u001f\u0010.\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0003H\u0014J\u001d\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u00106\u001a\u00020\bH\u0014\u00a2\u0006\u0002\u00107J\b\u00108\u001a\u00020'H\u0002J\u0019\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0019\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0012\u0010=\u001a\u00020'2\b\u0010>\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0014\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000eH\u0002\u00a2\u0006\u0002\u0010BJ&\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010\u000f2\u0006\u0010I\u001a\u00020\u0012H\u0002J7\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020'H\u0016J\u0015\u0010P\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010RJ\u0015\u0010S\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010RJ\u0015\u0010T\u001a\u00020Q2\u0006\u0010:\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010RJ\u0010\u0010U\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u0003H\u0002J(\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020\u0012H\u0002J%\u0010\\\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010@0\u000e2\u0006\u0010]\u001a\u00020\u0012H\u0000\u00a2\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\baR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006c"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", QCircleDaTongConstant.ElementParamValue.COLLECT, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    @Nullable
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;

    @NotNull
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Emitter implements DisposableHandle {

        @JvmField
        @NotNull
        public final Continuation<Unit> cont;

        @JvmField
        @NotNull
        public final SharedFlowImpl<?> flow;

        @JvmField
        public long index;

        @JvmField
        @Nullable
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j3, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j3;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SharedFlowImpl(int i3, int i16, @NotNull BufferOverflow bufferOverflow) {
        this.replay = i3;
        this.bufferCapacity = i16;
        this.onBufferOverflow = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            if (tryPeekLocked(sharedFlowSlot) < 0) {
                sharedFlowSlot.cont = cancellableContinuationImpl;
            } else {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        Object bufferAt;
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            bufferAt = SharedFlowKt.getBufferAt(objArr, emitter.index);
            if (bufferAt == emitter) {
                SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
                cleanupTailLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void cleanupTailLocked() {
        Object bufferAt;
        if (this.bufferCapacity == 0 && this.queueSize <= 1) {
            return;
        }
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        while (this.queueSize > 0) {
            bufferAt = SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1);
            if (bufferAt == SharedFlowKt.NO_VALUE) {
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            } else {
                return;
            }
        }
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j3 = sharedFlowSlot.index;
                    if (j3 >= 0 && j3 < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emitSuspend(T t16, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (!tryEmitLocked(t16)) {
                Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t16, cancellableContinuationImpl);
                enqueueLocked(emitter2);
                this.queueSize++;
                if (this.bufferCapacity == 0) {
                    continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            } else {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                continuationArr = findSlotsToResumeLocked(continuationArr2);
                emitter = null;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        int length = continuationArr.length;
        int i3 = 0;
        while (i3 < length) {
            Continuation<Unit> continuation2 = continuationArr[i3];
            i3++;
            if (continuation2 != null) {
                continuation2.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended2) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.setBufferAt(objArr, getHead() + totalSize, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = resumesIn.length;
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i3 = 0;
            resumesIn = resumesIn;
            while (i3 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i3];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        resumesIn = copyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i3++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object bufferAt;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        if (bufferAt instanceof Emitter) {
            return ((Emitter) bufferAt).value;
        }
        return bufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        boolean z16;
        Object bufferAt;
        int i3 = 0;
        if (newSize > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Object[] objArr = new Object[newSize];
            this.buffer = objArr;
            if (curBuffer == null) {
                return objArr;
            }
            long head = getHead();
            if (curSize > 0) {
                while (true) {
                    int i16 = i3 + 1;
                    long j3 = i3 + head;
                    bufferAt = SharedFlowKt.getBufferAt(curBuffer, j3);
                    SharedFlowKt.setBufferAt(objArr, j3, bufferAt);
                    if (i16 >= curSize) {
                        break;
                    }
                    i3 = i16;
                }
            }
            return objArr;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        enqueueLocked(value);
        int i16 = this.bufferSize + 1;
        this.bufferSize = i16;
        if (i16 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i3 = this.bufferSize + 1;
        this.bufferSize = i3;
        if (i3 > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j3 = slot.index;
        if (j3 < getBufferEndIndex()) {
            return j3;
        }
        if (this.bufferCapacity > 0 || j3 > getHead() || this.queueSize == 0) {
            return -1L;
        }
        return j3;
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            long tryPeekLocked = tryPeekLocked(slot);
            if (tryPeekLocked < 0) {
                obj = SharedFlowKt.NO_VALUE;
            } else {
                long j3 = slot.index;
                Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                slot.index = tryPeekLocked + 1;
                continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j3);
                obj = peekedValueLockedAt;
            }
        }
        int length = continuationArr.length;
        int i3 = 0;
        while (i3 < length) {
            Continuation<Unit> continuation = continuationArr[i3];
            i3++;
            if (continuation != null) {
                continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long min = Math.min(newMinCollectorIndex, newReplayIndex);
        long head = getHead();
        if (head < min) {
            while (true) {
                long j3 = 1 + head;
                Object[] objArr = this.buffer;
                Intrinsics.checkNotNull(objArr);
                SharedFlowKt.setBufferAt(objArr, head, null);
                if (j3 >= min) {
                    break;
                } else {
                    head = j3;
                }
            }
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - min);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c0 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:13:0x003b, B:17:0x00a1, B:28:0x00af, B:31:0x00ac, B:19:0x00c0, B:36:0x005a, B:38:0x006c, B:39:0x0093), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.SharedFlowSlot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.flow.SharedFlowSlot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlow] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00bd -> B:14:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        SharedFlowImpl$collect$1 sharedFlowImpl$collect$1;
        Object coroutine_suspended;
        SharedFlowSlot sharedFlowSlot;
        ?? r65;
        SharedFlowImpl<T> sharedFlowImpl;
        SharedFlowSlot sharedFlowSlot2;
        Job job;
        Job job2;
        ?? r56;
        Object tryTakeValue;
        SharedFlowImpl<T> sharedFlowImpl2;
        SharedFlowSlot sharedFlowSlot3;
        try {
            if (continuation instanceof SharedFlowImpl$collect$1) {
                sharedFlowImpl$collect$1 = (SharedFlowImpl$collect$1) continuation;
                int i3 = sharedFlowImpl$collect$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    sharedFlowImpl$collect$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = sharedFlowImpl$collect$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    sharedFlowSlot = sharedFlowImpl$collect$1.label;
                    if (sharedFlowSlot == 0) {
                        if (sharedFlowSlot != 1) {
                            if (sharedFlowSlot != 2) {
                                if (sharedFlowSlot == 3) {
                                    job2 = (Job) sharedFlowImpl$collect$1.L$3;
                                    SharedFlowSlot sharedFlowSlot4 = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                                    FlowCollector<? super T> flowCollector2 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                                    SharedFlowImpl<T> sharedFlowImpl3 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                    SharedFlowSlot sharedFlowSlot5 = sharedFlowSlot4;
                                    FlowCollector<? super T> flowCollector3 = flowCollector2;
                                    SharedFlowImpl<T> sharedFlowImpl4 = sharedFlowImpl3;
                                    job = job2;
                                    flowCollector = flowCollector3;
                                    sharedFlowSlot3 = sharedFlowSlot5;
                                    sharedFlowImpl2 = sharedFlowImpl4;
                                    r56 = flowCollector;
                                    job2 = job;
                                    sharedFlowSlot = sharedFlowSlot3;
                                    r65 = sharedFlowImpl2;
                                    do {
                                        tryTakeValue = r65.tryTakeValue(sharedFlowSlot);
                                        if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                                            if (job2 != null) {
                                                JobKt.ensureActive(job2);
                                            }
                                            sharedFlowImpl$collect$1.L$0 = r65;
                                            sharedFlowImpl$collect$1.L$1 = r56;
                                            sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                            sharedFlowImpl$collect$1.L$3 = job2;
                                            sharedFlowImpl$collect$1.label = 3;
                                            Object emit = r56.emit(tryTakeValue, sharedFlowImpl$collect$1);
                                            sharedFlowSlot5 = sharedFlowSlot;
                                            flowCollector3 = r56;
                                            sharedFlowImpl4 = r65;
                                            if (emit == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            job = job2;
                                            flowCollector = flowCollector3;
                                            sharedFlowSlot3 = sharedFlowSlot5;
                                            sharedFlowImpl2 = sharedFlowImpl4;
                                            r56 = flowCollector;
                                            job2 = job;
                                            sharedFlowSlot = sharedFlowSlot3;
                                            r65 = sharedFlowImpl2;
                                            tryTakeValue = r65.tryTakeValue(sharedFlowSlot);
                                            if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                                            }
                                        } else {
                                            sharedFlowImpl$collect$1.L$0 = r65;
                                            sharedFlowImpl$collect$1.L$1 = r56;
                                            sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                            sharedFlowImpl$collect$1.L$3 = job2;
                                            sharedFlowImpl$collect$1.label = 2;
                                        }
                                    } while (r65.awaitValue(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                                    return coroutine_suspended;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            job2 = (Job) sharedFlowImpl$collect$1.L$3;
                            SharedFlowSlot sharedFlowSlot6 = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                            FlowCollector flowCollector4 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                            SharedFlowImpl sharedFlowImpl5 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            sharedFlowSlot = sharedFlowSlot6;
                            r56 = flowCollector4;
                            r65 = sharedFlowImpl5;
                            do {
                                tryTakeValue = r65.tryTakeValue(sharedFlowSlot);
                                if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                                }
                            } while (r65.awaitValue(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                            return coroutine_suspended;
                        }
                        SharedFlowSlot sharedFlowSlot7 = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                        flowCollector = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                        SharedFlowImpl<T> sharedFlowImpl6 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        sharedFlowSlot2 = sharedFlowSlot7;
                        sharedFlowImpl = sharedFlowImpl6;
                    } else {
                        ResultKt.throwOnFailure(obj);
                        sharedFlowSlot = allocateSlot();
                        try {
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                sharedFlowImpl$collect$1.L$0 = this;
                                sharedFlowImpl$collect$1.L$1 = flowCollector;
                                sharedFlowImpl$collect$1.L$2 = sharedFlowSlot;
                                sharedFlowImpl$collect$1.label = 1;
                                if (((SubscribedFlowCollector) flowCollector).onSubscription(sharedFlowImpl$collect$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            sharedFlowImpl = this;
                            sharedFlowSlot2 = sharedFlowSlot;
                        } catch (Throwable th5) {
                            th = th5;
                            r65 = this;
                            r65.freeSlot(sharedFlowSlot);
                            throw th;
                        }
                    }
                    job = (Job) sharedFlowImpl$collect$1.get$context().get(Job.INSTANCE);
                    sharedFlowSlot3 = sharedFlowSlot2;
                    sharedFlowImpl2 = sharedFlowImpl;
                    r56 = flowCollector;
                    job2 = job;
                    sharedFlowSlot = sharedFlowSlot3;
                    r65 = sharedFlowImpl2;
                    do {
                        tryTakeValue = r65.tryTakeValue(sharedFlowSlot);
                        if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                        }
                    } while (r65.awaitValue(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
                    return coroutine_suspended;
                }
            }
            if (sharedFlowSlot == 0) {
            }
            job = (Job) sharedFlowImpl$collect$1.get$context().get(Job.INSTANCE);
            sharedFlowSlot3 = sharedFlowSlot2;
            sharedFlowImpl2 = sharedFlowImpl;
            r56 = flowCollector;
            job2 = job;
            sharedFlowSlot = sharedFlowSlot3;
            r65 = sharedFlowImpl2;
            do {
                tryTakeValue = r65.tryTakeValue(sharedFlowSlot);
                if (tryTakeValue != SharedFlowKt.NO_VALUE) {
                }
            } while (r65.awaitValue(sharedFlowSlot, sharedFlowImpl$collect$1) != coroutine_suspended);
            return coroutine_suspended;
        } catch (Throwable th6) {
            th = th6;
        }
        sharedFlowImpl$collect$1 = new SharedFlowImpl$collect$1(this, continuation);
        Object obj2 = sharedFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        sharedFlowSlot = sharedFlowImpl$collect$1.label;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (tryEmit(t16)) {
            return Unit.INSTANCE;
        }
        Object emitSuspend = emitSuspend(t16, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (emitSuspend == coroutine_suspended) {
            return emitSuspend;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        Object bufferAt;
        List<T> emptyList;
        synchronized (this) {
            int replaySize = getReplaySize();
            if (replaySize == 0) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            ArrayList arrayList = new ArrayList(replaySize);
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (replaySize > 0) {
                int i3 = 0;
                while (true) {
                    int i16 = i3 + 1;
                    bufferAt = SharedFlowKt.getBufferAt(objArr, this.replayIndex + i3);
                    arrayList.add(bufferAt);
                    if (i16 >= replaySize) {
                        break;
                    }
                    i3 = i16;
                }
            }
            return arrayList;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i3;
        boolean z16;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            i3 = 0;
            if (tryEmitLocked(value)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z16 = true;
            } else {
                z16 = false;
            }
        }
        int length = continuationArr.length;
        while (i3 < length) {
            Continuation<Unit> continuation = continuationArr[i3];
            i3++;
            if (continuation != null) {
                continuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
        }
        return z16;
    }

    @NotNull
    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        int i3;
        long j3;
        long j16;
        boolean z16;
        Object bufferAt;
        Object bufferAt2;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j17 = this.bufferSize + head;
        long j18 = 1;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j17++;
        }
        if (((AbstractSharedFlow) this).nCollectors != 0 && (abstractSharedFlowSlotArr = ((AbstractSharedFlow) this).slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    long j19 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j19 >= 0 && j19 < j17) {
                        j17 = j19;
                    }
                }
            }
        }
        if (j17 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        if (getNCollectors() > 0) {
            i3 = Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j17)));
        } else {
            i3 = this.queueSize;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j26 = this.queueSize + bufferEndIndex;
        if (i3 > 0) {
            continuationArr = new Continuation[i3];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            if (bufferEndIndex < j26) {
                long j27 = bufferEndIndex;
                int i16 = 0;
                while (true) {
                    long j28 = bufferEndIndex + j18;
                    bufferAt2 = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                    Symbol symbol = SharedFlowKt.NO_VALUE;
                    if (bufferAt2 != symbol) {
                        if (bufferAt2 != null) {
                            Emitter emitter = (Emitter) bufferAt2;
                            int i17 = i16 + 1;
                            j3 = j17;
                            continuationArr[i16] = emitter.cont;
                            SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                            long j29 = j27;
                            SharedFlowKt.setBufferAt(objArr, j29, emitter.value);
                            bufferEndIndex = j29 + 1;
                            if (i17 >= i3) {
                                break;
                            }
                            i16 = i17;
                            j27 = bufferEndIndex;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        }
                    } else {
                        j3 = j17;
                    }
                    if (j28 >= j26) {
                        bufferEndIndex = j27;
                        break;
                    }
                    bufferEndIndex = j28;
                    j17 = j3;
                    j18 = 1;
                }
            }
        }
        j3 = j17;
        int i18 = (int) (bufferEndIndex - head);
        if (getNCollectors() == 0) {
            j16 = bufferEndIndex;
        } else {
            j16 = j3;
        }
        long max = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i18));
        if (this.bufferCapacity == 0 && max < j26) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            bufferAt = SharedFlowKt.getBufferAt(objArr2, max);
            if (Intrinsics.areEqual(bufferAt, SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                max++;
            }
        }
        updateBufferLocked(max, j16, bufferEndIndex, j26);
        cleanupTailLocked();
        if (continuationArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return findSlotsToResumeLocked(continuationArr);
        }
        return continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j3 = this.replayIndex;
        if (j3 < this.minCollectorIndex) {
            this.minCollectorIndex = j3;
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }
}
