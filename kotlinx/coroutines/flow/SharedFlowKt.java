package kotlinx.coroutines.flow;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a6\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a#\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u00a2\u0006\u0002\u0010\u0017\u001a+\u0010\u0018\u001a\u00020\u0019*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0002\u0010\u001b\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u00a8\u0006\u001c"}, d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "getNO_VALUE$annotations", "()V", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SharedFlowKt {

    @JvmField
    @NotNull
    public static final Symbol NO_VALUE = new Symbol("NO_VALUE");

    @NotNull
    public static final <T> MutableSharedFlow<T> MutableSharedFlow(int i3, int i16, @NotNull BufferOverflow bufferOverflow) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (i16 >= 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (i3 <= 0 && i16 <= 0 && bufferOverflow != BufferOverflow.SUSPEND) {
                    z18 = false;
                }
                if (z18) {
                    int i17 = i16 + i3;
                    if (i17 < 0) {
                        i17 = Integer.MAX_VALUE;
                    }
                    return new SharedFlowImpl(i3, i17, bufferOverflow);
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ", bufferOverflow).toString());
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("extraBufferCapacity cannot be negative, but was ", Integer.valueOf(i16)).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("replay cannot be negative, but was ", Integer.valueOf(i3)).toString());
    }

    public static /* synthetic */ MutableSharedFlow MutableSharedFlow$default(int i3, int i16, BufferOverflow bufferOverflow, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        if ((i17 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return MutableSharedFlow(i3, i16, bufferOverflow);
    }

    @NotNull
    public static final <T> Flow<T> fuseSharedFlow(@NotNull SharedFlow<? extends T> sharedFlow, @NotNull CoroutineContext coroutineContext, int i3, @NotNull BufferOverflow bufferOverflow) {
        if ((i3 == 0 || i3 == -3) && bufferOverflow == BufferOverflow.SUSPEND) {
            return sharedFlow;
        }
        return new ChannelFlowOperatorImpl(sharedFlow, coroutineContext, i3, bufferOverflow);
    }

    public static final Object getBufferAt(Object[] objArr, long j3) {
        return objArr[((int) j3) & (objArr.length - 1)];
    }

    public static final void setBufferAt(Object[] objArr, long j3, Object obj) {
        objArr[((int) j3) & (objArr.length - 1)] = obj;
    }

    public static /* synthetic */ void getNO_VALUE$annotations() {
    }
}
