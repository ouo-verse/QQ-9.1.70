package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u001aB\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u0016*\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001aH\u0086H\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u001b\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\"\u0016\u0010\u000f\u001a\u00020\u00078\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "getEMPTY_UNLOCKED$annotations", "LOCKED", "Lkotlinx/coroutines/internal/Symbol;", "getLOCKED$annotations", "LOCK_FAIL", "getLOCK_FAIL$annotations", "SELECT_SUCCESS", "getSELECT_SUCCESS$annotations", "UNLOCKED", "getUNLOCKED$annotations", "UNLOCK_FAIL", "getUNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", "T", "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MutexKt {

    @NotNull
    private static final Empty EMPTY_LOCKED;

    @NotNull
    private static final Empty EMPTY_UNLOCKED;

    @NotNull
    private static final Symbol LOCKED;

    @NotNull
    private static final Symbol UNLOCKED;

    @NotNull
    private static final Symbol LOCK_FAIL = new Symbol("LOCK_FAIL");

    @NotNull
    private static final Symbol UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");

    @NotNull
    private static final Symbol SELECT_SUCCESS = new Symbol("SELECT_SUCCESS");

    static {
        Symbol symbol = new Symbol("LOCKED");
        LOCKED = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        UNLOCKED = symbol2;
        EMPTY_LOCKED = new Empty(symbol);
        EMPTY_UNLOCKED = new Empty(symbol2);
    }

    @NotNull
    public static final Mutex Mutex(boolean z16) {
        return new MutexImpl(z16);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return Mutex(z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withLock(@NotNull Mutex mutex, @Nullable Object obj, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        MutexKt$withLock$1 mutexKt$withLock$1;
        Object coroutine_suspended;
        int i3;
        try {
            if (continuation instanceof MutexKt$withLock$1) {
                mutexKt$withLock$1 = (MutexKt$withLock$1) continuation;
                int i16 = mutexKt$withLock$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    mutexKt$withLock$1.label = i16 - Integer.MIN_VALUE;
                    Object obj2 = mutexKt$withLock$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = mutexKt$withLock$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            function0 = (Function0) mutexKt$withLock$1.L$2;
                            obj = mutexKt$withLock$1.L$1;
                            mutex = (Mutex) mutexKt$withLock$1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        mutexKt$withLock$1.L$0 = mutex;
                        mutexKt$withLock$1.L$1 = obj;
                        mutexKt$withLock$1.L$2 = function0;
                        mutexKt$withLock$1.label = 1;
                        if (mutex.lock(obj, mutexKt$withLock$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return function0.invoke();
                }
            }
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
        mutexKt$withLock$1 = new MutexKt$withLock$1(continuation);
        Object obj22 = mutexKt$withLock$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = mutexKt$withLock$1.label;
        if (i3 == 0) {
        }
    }

    private static final <T> Object withLock$$forInline(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    private static /* synthetic */ void getEMPTY_LOCKED$annotations() {
    }

    private static /* synthetic */ void getEMPTY_UNLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCK_FAIL$annotations() {
    }

    private static /* synthetic */ void getSELECT_SUCCESS$annotations() {
    }

    private static /* synthetic */ void getUNLOCKED$annotations() {
    }

    private static /* synthetic */ void getUNLOCK_FAIL$annotations() {
    }
}
