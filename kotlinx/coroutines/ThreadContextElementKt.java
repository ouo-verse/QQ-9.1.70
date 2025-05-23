package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.ThreadLocal;
import kotlinx.coroutines.internal.ThreadLocalKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u0002H\u0002\u00a2\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u0003H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0003H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"asContextElement", "Lkotlinx/coroutines/ThreadContextElement;", "T", "Ljava/lang/ThreadLocal;", "value", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/ThreadContextElement;", "ensurePresent", "", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPresent", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ThreadContextElementKt {
    @NotNull
    public static final <T> ThreadContextElement<T> asContextElement(@NotNull ThreadLocal<T> threadLocal, T t16) {
        return new ThreadLocal(t16, threadLocal);
    }

    public static /* synthetic */ ThreadContextElement asContextElement$default(ThreadLocal threadLocal, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = threadLocal.get();
        }
        return asContextElement(threadLocal, obj);
    }

    @Nullable
    public static final Object ensurePresent(@NotNull ThreadLocal<?> threadLocal, @NotNull Continuation<? super Unit> continuation) {
        boolean z16;
        if (continuation.get$context().get(new ThreadLocalKey(threadLocal)) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Boxing.boxBoolean(z16).booleanValue()) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + continuation.get$context()).toString());
    }

    private static final Object ensurePresent$$forInline(ThreadLocal<?> threadLocal, Continuation<? super Unit> continuation) {
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    public static final Object isPresent(@NotNull ThreadLocal<?> threadLocal, @NotNull Continuation<? super Boolean> continuation) {
        boolean z16;
        if (continuation.get$context().get(new ThreadLocalKey(threadLocal)) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boxing.boxBoolean(z16);
    }

    private static final Object isPresent$$forInline(ThreadLocal<?> threadLocal, Continuation<? super Boolean> continuation) {
        InlineMarker.mark(3);
        throw null;
    }
}
