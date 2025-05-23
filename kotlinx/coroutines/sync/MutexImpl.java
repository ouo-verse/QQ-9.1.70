package kotlinx.coroutines.sync;

import com.google.common.util.concurrent.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00018V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00018@@\u0000X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR$\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8V@\u0016X\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", JoinPoint.SYNCHRONIZATION_LOCK, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", JoinPoint.SYNCHRONIZATION_UNLOCK, "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public final class LockCont extends LockWaiter {

        @JvmField
        @NotNull
        public final CancellableContinuation<Unit> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.cont = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(@NotNull Object token) {
            this.cont.completeResume(token);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + "] for " + MutexImpl.this;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        @Nullable
        public Object tryResumeLockWaiter() {
            CancellableContinuation<Unit> cancellableContinuation = this.cont;
            Unit unit = Unit.INSTANCE;
            final MutexImpl mutexImpl = MutexImpl.this;
            return cancellableContinuation.tryResume(unit, null, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.this.unlock(this.owner);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BD\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016R1\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006X\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private final class LockSelect<R> extends LockWaiter {

        @JvmField
        @NotNull
        public final Function2<Mutex, Continuation<? super R>, Object> block;

        @JvmField
        @NotNull
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.select = selectInstance;
            this.block = function2;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter(@NotNull Object token) {
            Function2<Mutex, Continuation<? super R>, Object> function2 = this.block;
            MutexImpl mutexImpl = MutexImpl.this;
            Continuation<R> completion = this.select.getCompletion();
            final MutexImpl mutexImpl2 = MutexImpl.this;
            CancellableKt.startCoroutineCancellable(function2, mutexImpl, completion, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    MutexImpl.this.unlock(this.owner);
                }
            });
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockSelect[" + this.owner + ", " + this.select + "] for " + MutexImpl.this;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        @Nullable
        public Object tryResumeLockWaiter() {
            Symbol symbol;
            if (this.select.trySelect()) {
                symbol = MutexKt.SELECT_SUCCESS;
                return symbol;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00a2\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&J\u0006\u0010\t\u001a\u00020\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H&R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "completeResumeLockWaiter", "", "token", "dispose", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {

        @JvmField
        @Nullable
        public final Object owner;

        public LockWaiter(@Nullable Object obj) {
            this.owner = obj;
        }

        public abstract void completeResumeLockWaiter(@NotNull Object token);

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            remove();
        }

        @Nullable
        public abstract Object tryResumeLockWaiter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class LockedQueue extends LockFreeLinkedListHead {

        @JvmField
        @NotNull
        public Object owner;

        public LockedQueue(@NotNull Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private static final class TryLockDesc extends AtomicDesc {

        @JvmField
        @NotNull
        public final MutexImpl mutex;

        @JvmField
        @Nullable
        public final Object owner;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes28.dex */
        private final class PrepareOp extends OpDescriptor {

            @NotNull
            private final AtomicOp<?> atomicOp;

            public PrepareOp(@NotNull AtomicOp<?> atomicOp) {
                this.atomicOp = atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @NotNull
            public AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            @Nullable
            public Object perform(@Nullable Object affected) {
                Object atomicOp;
                if (getAtomicOp().isDecided()) {
                    atomicOp = MutexKt.EMPTY_UNLOCKED;
                } else {
                    atomicOp = getAtomicOp();
                }
                if (affected != null) {
                    b.a(MutexImpl._state$FU, (MutexImpl) affected, this, atomicOp);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public TryLockDesc(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            this.mutex = mutexImpl;
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(@NotNull AtomicOp<?> op5, @Nullable Object failure) {
            Empty empty;
            if (failure != null) {
                empty = MutexKt.EMPTY_UNLOCKED;
            } else {
                Object obj = this.owner;
                empty = obj == null ? MutexKt.EMPTY_LOCKED : new Empty(obj);
            }
            b.a(MutexImpl._state$FU, this.mutex, op5, empty);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        @Nullable
        public Object prepare(@NotNull AtomicOp<?> op5) {
            Empty empty;
            Symbol symbol;
            PrepareOp prepareOp = new PrepareOp(op5);
            MutexImpl mutexImpl = this.mutex;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl._state$FU;
            empty = MutexKt.EMPTY_UNLOCKED;
            if (!b.a(atomicReferenceFieldUpdater, mutexImpl, empty, prepareOp)) {
                symbol = MutexKt.LOCK_FAIL;
                return symbol;
            }
            return prepareOp.perform(this.mutex);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private static final class UnlockOp extends AtomicOp<MutexImpl> {

        @JvmField
        @NotNull
        public final LockedQueue queue;

        public UnlockOp(@NotNull LockedQueue lockedQueue) {
            this.queue = lockedQueue;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(@NotNull MutexImpl affected, @Nullable Object failure) {
            b.a(MutexImpl._state$FU, affected, this, failure == null ? MutexKt.EMPTY_UNLOCKED : this.queue);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        @Nullable
        public Object prepare(@NotNull MutexImpl affected) {
            Symbol symbol;
            if (this.queue.isEmpty()) {
                return null;
            }
            symbol = MutexKt.UNLOCK_FAIL;
            return symbol;
        }
    }

    public MutexImpl(boolean z16) {
        this._state = z16 ? MutexKt.EMPTY_LOCKED : MutexKt.EMPTY_UNLOCKED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object lockSuspend(final Object obj, Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Symbol symbol;
        Empty empty;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        boolean z16;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(intercepted);
        final LockCont lockCont = new LockCont(obj, orCreateCancellableContinuation);
        while (true) {
            final Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty2 = (Empty) obj2;
                Object obj3 = empty2.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj3 != symbol) {
                    b.a(_state$FU, this, obj2, new LockedQueue(empty2.locked));
                } else {
                    if (obj == null) {
                        empty = MutexKt.EMPTY_LOCKED;
                    } else {
                        empty = new Empty(obj);
                    }
                    if (b.a(_state$FU, this, obj2, empty)) {
                        orCreateCancellableContinuation.resume(Unit.INSTANCE, new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                MutexImpl.this.unlock(obj);
                            }
                        });
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                boolean z17 = false;
                if (((LockedQueue) obj2).owner != obj) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj2;
                    LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this, obj2) { // from class: kotlinx.coroutines.sync.MutexImpl$lockSuspend$lambda-6$lambda-5$$inlined$addLastIf$1
                        final /* synthetic */ Object $state$inlined;
                        final /* synthetic */ MutexImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(LockFreeLinkedListNode.this);
                            this.this$0 = this;
                            this.$state$inlined = obj2;
                        }

                        @Override // kotlinx.coroutines.internal.AtomicOp
                        @Nullable
                        public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                            if (this.this$0._state == this.$state$inlined) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = lockFreeLinkedListNode.getPrevNode().tryCondAddNext(lockCont, lockFreeLinkedListNode, condAddOp);
                        if (tryCondAddNext != 1) {
                            if (tryCondAddNext == 2) {
                                break;
                            }
                        } else {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        CancellableContinuationKt.removeOnCancellation(orCreateCancellableContinuation, lockCont);
                        break;
                    }
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).perform(this);
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
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

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@NotNull Object owner) {
        Object obj = this._state;
        if (obj instanceof Empty) {
            if (((Empty) obj).locked == owner) {
                return true;
            }
        } else if ((obj instanceof LockedQueue) && ((LockedQueue) obj).owner == owner) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    return true;
                }
                return false;
            }
            if (obj instanceof LockedQueue) {
                return true;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
        }
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if ((obj instanceof LockedQueue) && ((LockedQueue) obj).isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        Object lockSuspend = lockSuspend(obj, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (lockSuspend == coroutine_suspended) {
            return lockSuspend;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> select, @Nullable Object owner, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> block) {
        Symbol symbol;
        Symbol symbol2;
        boolean z16;
        while (!select.isSelected()) {
            final Object obj = this._state;
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                Object obj2 = empty.locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    b.a(_state$FU, this, obj, new LockedQueue(empty.locked));
                } else {
                    Object performAtomicTrySelect = select.performAtomicTrySelect(new TryLockDesc(this, owner));
                    if (performAtomicTrySelect == null) {
                        UndispatchedKt.startCoroutineUnintercepted(block, this, select.getCompletion());
                        return;
                    } else if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                        symbol2 = MutexKt.LOCK_FAIL;
                        if (performAtomicTrySelect != symbol2 && performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                            throw new IllegalStateException(Intrinsics.stringPlus("performAtomicTrySelect(TryLockDesc) returned ", performAtomicTrySelect).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj instanceof LockedQueue) {
                boolean z17 = false;
                if (((LockedQueue) obj).owner != owner) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    final LockSelect lockSelect = new LockSelect(owner, select, block);
                    LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(this, obj) { // from class: kotlinx.coroutines.sync.MutexImpl$registerSelectClause2$$inlined$addLastIf$1
                        final /* synthetic */ Object $state$inlined;
                        final /* synthetic */ MutexImpl this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(LockFreeLinkedListNode.this);
                            this.this$0 = this;
                            this.$state$inlined = obj;
                        }

                        @Override // kotlinx.coroutines.internal.AtomicOp
                        @Nullable
                        public Object prepare(@NotNull LockFreeLinkedListNode affected) {
                            if (this.this$0._state == this.$state$inlined) {
                                return null;
                            }
                            return LockFreeLinkedListKt.getCONDITION_FALSE();
                        }
                    };
                    while (true) {
                        int tryCondAddNext = lockFreeLinkedListNode.getPrevNode().tryCondAddNext(lockSelect, lockFreeLinkedListNode, condAddOp);
                        if (tryCondAddNext != 1) {
                            if (tryCondAddNext == 2) {
                                break;
                            }
                        } else {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        select.disposeOnSelect(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", owner).toString());
                }
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).locked + ']';
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else {
                if (obj instanceof LockedQueue) {
                    return "Mutex[" + ((LockedQueue) obj).owner + ']';
                }
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object owner) {
        Symbol symbol;
        Empty empty;
        while (true) {
            Object obj = this._state;
            boolean z16 = true;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).locked;
                symbol = MutexKt.UNLOCKED;
                if (obj2 != symbol) {
                    return false;
                }
                if (owner == null) {
                    empty = MutexKt.EMPTY_LOCKED;
                } else {
                    empty = new Empty(owner);
                }
                if (b.a(_state$FU, this, obj, empty)) {
                    return true;
                }
            } else {
                if (obj instanceof LockedQueue) {
                    if (((LockedQueue) obj).owner == owner) {
                        z16 = false;
                    }
                    if (z16) {
                        return false;
                    }
                    throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", owner).toString());
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).perform(this);
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object owner) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            boolean z16 = true;
            if (obj instanceof Empty) {
                if (owner == null) {
                    Object obj2 = ((Empty) obj).locked;
                    symbol = MutexKt.UNLOCKED;
                    if (obj2 == symbol) {
                        z16 = false;
                    }
                    if (!z16) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj;
                    if (empty2.locked != owner) {
                        z16 = false;
                    }
                    if (!z16) {
                        throw new IllegalStateException(("Mutex is locked by " + empty2.locked + " but expected " + owner).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
                empty = MutexKt.EMPTY_UNLOCKED;
                if (b.a(atomicReferenceFieldUpdater, this, obj, empty)) {
                    return;
                }
            } else if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).perform(this);
            } else if (obj instanceof LockedQueue) {
                if (owner != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj;
                    if (lockedQueue.owner != owner) {
                        z16 = false;
                    }
                    if (!z16) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + owner).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj;
                LockFreeLinkedListNode removeFirstOrNull = lockedQueue2.removeFirstOrNull();
                if (removeFirstOrNull == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (b.a(_state$FU, this, obj, unlockOp) && unlockOp.perform(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) removeFirstOrNull;
                    Object tryResumeLockWaiter = lockWaiter.tryResumeLockWaiter();
                    if (tryResumeLockWaiter != null) {
                        Object obj3 = lockWaiter.owner;
                        if (obj3 == null) {
                            obj3 = MutexKt.LOCKED;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.completeResumeLockWaiter(tryResumeLockWaiter);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }
}
