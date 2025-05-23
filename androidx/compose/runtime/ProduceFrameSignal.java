package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.aspectj.lang.JoinPoint;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", JoinPoint.SYNCHRONIZATION_LOCK, "Landroidx/compose/runtime/SynchronizedObject;", "(Landroidx/compose/runtime/SynchronizedObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ProduceFrameSignal {
    private Object pendingFrameContinuation;

    public final Object awaitFrameRequest(SynchronizedObject synchronizedObject, Continuation<? super Unit> continuation) {
        Object obj;
        Continuation intercepted;
        Object obj2;
        CancellableContinuationImpl cancellableContinuationImpl;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object obj3;
        Object obj4;
        synchronized (synchronizedObject) {
            Object obj5 = this.pendingFrameContinuation;
            obj = RecomposerKt.ProduceAnotherFrame;
            if (obj5 == obj) {
                obj4 = RecomposerKt.FramePending;
                this.pendingFrameContinuation = obj4;
                return Unit.INSTANCE;
            }
            Unit unit = Unit.INSTANCE;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl2.initCancellability();
            synchronized (synchronizedObject) {
                Object obj6 = this.pendingFrameContinuation;
                obj2 = RecomposerKt.ProduceAnotherFrame;
                if (obj6 == obj2) {
                    obj3 = RecomposerKt.FramePending;
                    this.pendingFrameContinuation = obj3;
                    cancellableContinuationImpl = cancellableContinuationImpl2;
                } else {
                    this.pendingFrameContinuation = cancellableContinuationImpl2;
                    cancellableContinuationImpl = null;
                }
            }
            if (cancellableContinuationImpl != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
            Object result = cancellableContinuationImpl2.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return result == coroutine_suspended2 ? result : Unit.INSTANCE;
        }
    }

    public final Continuation<Unit> requestFrameLocked() {
        Object obj;
        Object obj2;
        boolean areEqual;
        Object obj3;
        Object obj4;
        Object obj5 = this.pendingFrameContinuation;
        if (obj5 instanceof Continuation) {
            obj4 = RecomposerKt.FramePending;
            this.pendingFrameContinuation = obj4;
            return (Continuation) obj5;
        }
        obj = RecomposerKt.ProduceAnotherFrame;
        if (Intrinsics.areEqual(obj5, obj)) {
            areEqual = true;
        } else {
            obj2 = RecomposerKt.FramePending;
            areEqual = Intrinsics.areEqual(obj5, obj2);
        }
        if (!areEqual) {
            if (obj5 == null) {
                obj3 = RecomposerKt.ProduceAnotherFrame;
                this.pendingFrameContinuation = obj3;
            } else {
                throw new IllegalStateException(("invalid pendingFrameContinuation " + obj5).toString());
            }
        }
        return null;
    }

    public final void takeFrameRequestLocked() {
        Object obj;
        Object obj2 = this.pendingFrameContinuation;
        obj = RecomposerKt.FramePending;
        if (obj2 == obj) {
            this.pendingFrameContinuation = null;
            return;
        }
        throw new IllegalStateException("frame not pending".toString());
    }
}
