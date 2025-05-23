package kotlinx.coroutines.flow;

import com.tencent.qqmini.miniapp.core.EventListener;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u0002H\b\u00a2\u0006\u0002\u0010\n\u001a6\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u001a\u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u00a8\u0006\u0017"}, d2 = {"NONE", "Lkotlinx/coroutines/internal/Symbol;", "getNONE$annotations", "()V", "PENDING", "getPENDING$annotations", "MutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "T", "value", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "fuseStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/StateFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "increment", "", EventListener.KEY_DELTA, "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class StateFlowKt {

    @NotNull
    private static final Symbol NONE = new Symbol("NONE");

    @NotNull
    private static final Symbol PENDING = new Symbol("PENDING");

    @NotNull
    public static final <T> MutableStateFlow<T> MutableStateFlow(T t16) {
        if (t16 == null) {
            t16 = (T) NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(t16);
    }

    @NotNull
    public static final <T> Flow<T> fuseStateFlow(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i3, @NotNull BufferOverflow bufferOverflow) {
        boolean z16 = false;
        if (i3 >= 0 && i3 <= 1) {
            z16 = true;
        }
        if ((z16 || i3 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) {
            return stateFlow;
        }
        return SharedFlowKt.fuseSharedFlow(stateFlow, coroutineContext, i3, bufferOverflow);
    }

    public static final void increment(@NotNull MutableStateFlow<Integer> mutableStateFlow, int i3) {
        int intValue;
        do {
            intValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.compareAndSet(Integer.valueOf(intValue), Integer.valueOf(intValue + i3)));
    }

    private static /* synthetic */ void getNONE$annotations() {
    }

    private static /* synthetic */ void getPENDING$annotations() {
    }
}
