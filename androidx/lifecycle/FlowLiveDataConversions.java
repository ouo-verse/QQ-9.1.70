package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Landroidx/lifecycle/LiveData;", "asLiveData", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "timeoutInMs", "", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
@JvmName(name = "FlowLiveDataConversions")
/* loaded from: classes.dex */
public final class FlowLiveDataConversions {
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull LiveData<T> asFlow) {
        Intrinsics.checkParameterIsNotNull(asFlow, "$this$asFlow");
        return FlowKt.flow(new FlowLiveDataConversions$asFlow$1(asFlow, null));
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow) {
        return asLiveData$default(flow, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            j3 = 5000;
        }
        return asLiveData(flow, coroutineContext, j3);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return asLiveData$default(flow, coroutineContext, 0L, 2, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> asLiveData, @NotNull CoroutineContext context, long j3) {
        Intrinsics.checkParameterIsNotNull(asLiveData, "$this$asLiveData");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return CoroutineLiveDataKt.liveData(context, j3, new FlowLiveDataConversions$asLiveData$1(asLiveData, null));
    }

    public static /* synthetic */ LiveData asLiveData$default(Flow flow, CoroutineContext coroutineContext, Duration duration, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asLiveData(flow, coroutineContext, duration);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull Flow<? extends T> asLiveData, @NotNull CoroutineContext context, @NotNull Duration timeout) {
        long millis;
        Intrinsics.checkParameterIsNotNull(asLiveData, "$this$asLiveData");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(timeout, "timeout");
        millis = timeout.toMillis();
        return asLiveData(asLiveData, context, millis);
    }
}
