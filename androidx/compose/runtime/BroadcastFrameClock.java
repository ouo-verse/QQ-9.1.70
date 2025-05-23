package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MonotonicFrameClock;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\u00042\f\b\u0002\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ+\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fR\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", JoinPoint.SYNCHRONIZATION_LOCK, "Landroidx/compose/runtime/SynchronizedObject;", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "sendFrame", "timeNanos", "", "withFrameNanos", BdhLogUtil.LogTag.Tag_Req, "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private List<FrameAwaiter<?>> awaiters;
    private Throwable failureCause;
    private final SynchronizedObject lock;
    private final Function0<Unit> onNewAwaiters;
    private List<FrameAwaiter<?>> spareList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", BdhLogUtil.LogTag.Tag_Req, "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class FrameAwaiter<R> {
        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;

        /* JADX WARN: Multi-variable type inference failed */
        public FrameAwaiter(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> continuation) {
            Intrinsics.checkNotNullParameter(onFrame, "onFrame");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            this.onFrame = onFrame;
            this.continuation = continuation;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long timeNanos) {
            Object m476constructorimpl;
            Continuation<R> continuation = this.continuation;
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(this.onFrame.invoke(Long.valueOf(timeNanos)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            continuation.resumeWith(m476constructorimpl);
        }
    }

    public BroadcastFrameClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(Throwable cause) {
        synchronized (this.lock) {
            if (this.failureCause != null) {
                return;
            }
            this.failureCause = cause;
            List<FrameAwaiter<?>> list = this.awaiters;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Continuation<?> continuation = list.get(i3).getContinuation();
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(cause)));
            }
            this.awaiters.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void cancel(CancellationException cancellationException) {
        Intrinsics.checkNotNullParameter(cancellationException, "cancellationException");
        fail(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r16, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) MonotonicFrameClock.DefaultImpls.fold(this, r16, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public final boolean getHasAwaiters() {
        boolean z16;
        synchronized (this.lock) {
            z16 = !this.awaiters.isEmpty();
        }
        return z16;
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock, kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        return d.a(this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    public final void sendFrame(long timeNanos) {
        synchronized (this.lock) {
            List<FrameAwaiter<?>> list = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = list;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                list.get(i3).resume(timeNanos);
            }
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter] */
    @Override // androidx.compose.runtime.MonotonicFrameClock
    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        Continuation intercepted;
        FrameAwaiter frameAwaiter;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            Throwable th5 = this.failureCause;
            if (th5 != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            } else {
                objectRef.element = new FrameAwaiter(function1, cancellableContinuationImpl);
                boolean z16 = !this.awaiters.isEmpty();
                List list = this.awaiters;
                T t16 = objectRef.element;
                if (t16 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                    frameAwaiter = null;
                } else {
                    frameAwaiter = (FrameAwaiter) t16;
                }
                list.add(frameAwaiter);
                boolean z17 = !z16;
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                        invoke2(th6);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th6) {
                        BroadcastFrameClock.FrameAwaiter frameAwaiter2;
                        SynchronizedObject synchronizedObject = BroadcastFrameClock.this.lock;
                        BroadcastFrameClock broadcastFrameClock = BroadcastFrameClock.this;
                        Ref.ObjectRef<BroadcastFrameClock.FrameAwaiter<R>> objectRef2 = objectRef;
                        synchronized (synchronizedObject) {
                            List list2 = broadcastFrameClock.awaiters;
                            Object obj = objectRef2.element;
                            if (obj == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                                frameAwaiter2 = null;
                            } else {
                                frameAwaiter2 = (BroadcastFrameClock.FrameAwaiter) obj;
                            }
                            list2.remove(frameAwaiter2);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
                if (z17 && this.onNewAwaiters != null) {
                    try {
                        this.onNewAwaiters.invoke();
                    } catch (Throwable th6) {
                        fail(th6);
                    }
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public BroadcastFrameClock(Function0<Unit> function0) {
        this.onNewAwaiters = function0;
        this.lock = SynchronizationKt.createSynchronizedObject();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0);
    }
}
