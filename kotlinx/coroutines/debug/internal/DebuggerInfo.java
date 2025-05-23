package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000f\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "source", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "coroutineId", "", "getCoroutineId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dispatcher", "", "getDispatcher", "()Ljava/lang/String;", "lastObservedStackTrace", "", "Ljava/lang/StackTraceElement;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedThreadName", "getLastObservedThreadName", "lastObservedThreadState", "getLastObservedThreadState", "name", "getName", "sequenceNumber", "getSequenceNumber", "()J", "state", "getState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@PublishedApi
/* loaded from: classes28.dex */
public final class DebuggerInfo implements Serializable {

    @Nullable
    private final Long coroutineId;

    @Nullable
    private final String dispatcher;

    @NotNull
    private final List<StackTraceElement> lastObservedStackTrace;

    @Nullable
    private final String lastObservedThreadName;

    @Nullable
    private final String lastObservedThreadState;

    @Nullable
    private final String name;
    private final long sequenceNumber;

    @NotNull
    private final String state;

    public DebuggerInfo(@NotNull DebugCoroutineInfo debugCoroutineInfo, @NotNull CoroutineContext coroutineContext) {
        Long valueOf;
        String obj;
        String name;
        Thread.State state;
        String obj2;
        CoroutineId coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.INSTANCE);
        if (coroutineId == null) {
            valueOf = null;
        } else {
            valueOf = Long.valueOf(coroutineId.getId());
        }
        this.coroutineId = valueOf;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (continuationInterceptor == null) {
            obj = null;
        } else {
            obj = continuationInterceptor.toString();
        }
        this.dispatcher = obj;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.INSTANCE);
        if (coroutineName == null) {
            name = null;
        } else {
            name = coroutineName.getName();
        }
        this.name = name;
        this.state = debugCoroutineInfo.get_state();
        Thread thread = debugCoroutineInfo.lastObservedThread;
        if (thread == null || (state = thread.getState()) == null) {
            obj2 = null;
        } else {
            obj2 = state.toString();
        }
        this.lastObservedThreadState = obj2;
        Thread thread2 = debugCoroutineInfo.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfo.lastObservedStackTrace();
        this.sequenceNumber = debugCoroutineInfo.sequenceNumber;
    }

    @Nullable
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @Nullable
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
