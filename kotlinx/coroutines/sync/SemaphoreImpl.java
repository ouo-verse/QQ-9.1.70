package kotlinx.coroutines.sync;

import com.google.common.util.concurrent.b;
import com.tencent.mtt.hippy.dom.node.TextNode;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.debug.internal.a;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00060\nH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00018V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00188\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "addAcquireToQueue", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "release", "()V", "tryAcquire", "()Z", "tryResumeNextFromQueue", "tryResumeAcquire", "getAvailablePermits", "()I", "availablePermits", "Lkotlin/Function1;", "", "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/sync/Semaphore;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SemaphoreImpl implements Semaphore {

    @NotNull
    volatile /* synthetic */ int _availablePermits;

    @NotNull
    private volatile /* synthetic */ long deqIdx = 0;

    @NotNull
    private volatile /* synthetic */ long enqIdx = 0;

    @NotNull
    private volatile /* synthetic */ Object head;

    @NotNull
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;

    @NotNull
    private volatile /* synthetic */ Object tail;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, TextNode.MODE_TAIL);
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i3, int i16) {
        boolean z16;
        this.permits = i3;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i16 >= 0 && i16 <= i3) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = i3 - i16;
                this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Throwable th5) {
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("The number of acquired permits should be in 0..", Integer.valueOf(i3)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Semaphore should have at least 1 permit, but had ", Integer.valueOf(i3)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        while (true) {
            if (addAcquireToQueue(orCreateCancellableContinuation)) {
                break;
            }
            if (_availablePermits$FU.getAndDecrement(this) > 0) {
                orCreateCancellableContinuation.resume(Unit.INSTANCE, this.onCancellationRelease);
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
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
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean addAcquireToQueue(CancellableContinuation<? super Unit> cont) {
        int i3;
        Object m2050constructorimpl;
        int i16;
        Symbol symbol;
        Symbol symbol2;
        boolean z16;
        Segment segment = (SemaphoreSegment) this.tail;
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        i3 = SemaphoreKt.SEGMENT_SIZE;
        long j3 = andIncrement / i3;
        do {
            Segment segment2 = segment;
            while (true) {
                if (segment2.getId() < j3 || segment2.getRemoved()) {
                    Object obj = segment2.get_next();
                    if (obj == ConcurrentLinkedListKt.CLOSED) {
                        m2050constructorimpl = SegmentOrClosed.m2050constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    Segment segment3 = (Segment) ((ConcurrentLinkedListNode) obj);
                    if (segment3 == null) {
                        segment3 = SemaphoreKt.createSegment(segment2.getId() + 1, (SemaphoreSegment) segment2);
                        if (segment2.trySetNext(segment3)) {
                            if (segment2.getRemoved()) {
                                segment2.remove();
                            }
                        }
                    }
                    segment2 = segment3;
                } else {
                    m2050constructorimpl = SegmentOrClosed.m2050constructorimpl(segment2);
                    break;
                }
            }
            if (!SegmentOrClosed.m2055isClosedimpl(m2050constructorimpl)) {
                Segment m2053getSegmentimpl = SegmentOrClosed.m2053getSegmentimpl(m2050constructorimpl);
                while (true) {
                    Segment segment4 = (Segment) this.tail;
                    if (segment4.getId() >= m2053getSegmentimpl.getId()) {
                        break;
                    }
                    if (!m2053getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z16 = false;
                        break;
                    }
                    if (b.a(tail$FU, this, segment4, m2053getSegmentimpl)) {
                        if (segment4.decPointers$kotlinx_coroutines_core()) {
                            segment4.remove();
                        }
                    } else if (m2053getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m2053getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        } while (!z16);
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.m2053getSegmentimpl(m2050constructorimpl);
        i16 = SemaphoreKt.SEGMENT_SIZE;
        int i17 = (int) (andIncrement % i16);
        if (!a.a(semaphoreSegment.acquirers, i17, null, cont)) {
            symbol = SemaphoreKt.PERMIT;
            symbol2 = SemaphoreKt.TAKEN;
            if (!a.a(semaphoreSegment.acquirers, i17, symbol, symbol2)) {
                return false;
            }
            cont.resume(Unit.INSTANCE, this.onCancellationRelease);
            return true;
        }
        cont.invokeOnCancellation(new CancelSemaphoreAcquisitionHandler(semaphoreSegment, i17));
        return true;
    }

    private final boolean tryResumeAcquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean tryResumeNextFromQueue() {
        int i3;
        Object m2050constructorimpl;
        int i16;
        int i17;
        Symbol symbol;
        Symbol symbol2;
        int i18;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        boolean z16;
        Segment segment = (SemaphoreSegment) this.head;
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        i3 = SemaphoreKt.SEGMENT_SIZE;
        long j3 = andIncrement / i3;
        do {
            Segment segment2 = segment;
            while (true) {
                if (segment2.getId() < j3 || segment2.getRemoved()) {
                    Object obj = segment2.get_next();
                    if (obj == ConcurrentLinkedListKt.CLOSED) {
                        m2050constructorimpl = SegmentOrClosed.m2050constructorimpl(ConcurrentLinkedListKt.CLOSED);
                        break;
                    }
                    Segment segment3 = (Segment) ((ConcurrentLinkedListNode) obj);
                    if (segment3 == null) {
                        segment3 = SemaphoreKt.createSegment(segment2.getId() + 1, (SemaphoreSegment) segment2);
                        if (segment2.trySetNext(segment3)) {
                            if (segment2.getRemoved()) {
                                segment2.remove();
                            }
                        }
                    }
                    segment2 = segment3;
                } else {
                    m2050constructorimpl = SegmentOrClosed.m2050constructorimpl(segment2);
                    break;
                }
            }
            if (SegmentOrClosed.m2055isClosedimpl(m2050constructorimpl)) {
                break;
            }
            Segment m2053getSegmentimpl = SegmentOrClosed.m2053getSegmentimpl(m2050constructorimpl);
            while (true) {
                Segment segment4 = (Segment) this.head;
                if (segment4.getId() >= m2053getSegmentimpl.getId()) {
                    break;
                }
                if (!m2053getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z16 = false;
                    break;
                }
                if (b.a(head$FU, this, segment4, m2053getSegmentimpl)) {
                    if (segment4.decPointers$kotlinx_coroutines_core()) {
                        segment4.remove();
                    }
                } else if (m2053getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m2053getSegmentimpl.remove();
                }
            }
        } while (!z16);
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.m2053getSegmentimpl(m2050constructorimpl);
        semaphoreSegment.cleanPrev();
        if (semaphoreSegment.getId() <= j3) {
            i17 = SemaphoreKt.SEGMENT_SIZE;
            int i19 = (int) (andIncrement % i17);
            symbol = SemaphoreKt.PERMIT;
            Object andSet = semaphoreSegment.acquirers.getAndSet(i19, symbol);
            if (andSet == null) {
                i18 = SemaphoreKt.MAX_SPIN_CYCLES;
                for (i16 = 0; i16 < i18; i16++) {
                    Object obj2 = semaphoreSegment.acquirers.get(i19);
                    symbol5 = SemaphoreKt.TAKEN;
                    if (obj2 == symbol5) {
                        return true;
                    }
                }
                symbol3 = SemaphoreKt.PERMIT;
                symbol4 = SemaphoreKt.BROKEN;
                return !a.a(semaphoreSegment.acquirers, i19, symbol3, symbol4);
            }
            symbol2 = SemaphoreKt.CANCELLED;
            if (andSet == symbol2) {
                return false;
            }
            return tryResumeAcquire((CancellableContinuation) andSet);
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    @Nullable
    public Object acquire(@NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (_availablePermits$FU.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object acquireSlowPath = acquireSlowPath(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (acquireSlowPath == coroutine_suspended) {
            return acquireSlowPath;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public int getAvailablePermits() {
        return Math.max(this._availablePermits, 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        boolean z16;
        while (true) {
            int i3 = this._availablePermits;
            int i16 = this.permits;
            if (i3 < i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (_availablePermits$FU.compareAndSet(this, i3, i3 + 1) && (i3 >= 0 || tryResumeNextFromQueue())) {
                    return;
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("The number of released permits cannot be greater than ", Integer.valueOf(i16)).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public boolean tryAcquire() {
        int i3;
        do {
            i3 = this._availablePermits;
            if (i3 <= 0) {
                return false;
            }
        } while (!_availablePermits$FU.compareAndSet(this, i3, i3 - 1));
        return true;
    }
}
