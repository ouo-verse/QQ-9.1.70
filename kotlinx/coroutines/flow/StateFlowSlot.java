package kotlinx.coroutines.flow;

import com.google.common.util.concurrent.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007\u00a2\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state = null;

    @Nullable
    public final Object awaitPending(@NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Symbol symbol;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        symbol = StateFlowKt.NONE;
        if (!b.a(atomicReferenceFieldUpdater, this, symbol, cancellableContinuationImpl)) {
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
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

    public final void makePending() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        while (true) {
            Object obj = this._state;
            if (obj != null) {
                symbol = StateFlowKt.PENDING;
                if (obj != symbol) {
                    symbol2 = StateFlowKt.NONE;
                    if (obj == symbol2) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                        symbol3 = StateFlowKt.PENDING;
                        if (b.a(atomicReferenceFieldUpdater, this, obj, symbol3)) {
                            return;
                        }
                    } else {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$FU;
                        symbol4 = StateFlowKt.NONE;
                        if (b.a(atomicReferenceFieldUpdater2, this, obj, symbol4)) {
                            ((CancellableContinuationImpl) obj).resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean takePending() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        symbol = StateFlowKt.NONE;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        Intrinsics.checkNotNull(andSet);
        symbol2 = StateFlowKt.PENDING;
        if (andSet == symbol2) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(@NotNull StateFlowImpl<?> flow) {
        Symbol symbol;
        if (this._state != null) {
            return false;
        }
        symbol = StateFlowKt.NONE;
        this._state = symbol;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    @NotNull
    public Continuation<Unit>[] freeLocked(@NotNull StateFlowImpl<?> flow) {
        this._state = null;
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }
}
