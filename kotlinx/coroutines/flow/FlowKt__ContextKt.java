package kotlinx.coroutines.flow;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u00a2\u0006\u0002\b\u0004\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a0\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0006\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2#\u0010\u0013\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u00060\u0014\u00a2\u0006\u0002\b\u0015H\u0007\u00a8\u0006\u0016"}, d2 = {"checkFlowContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "checkFlowContext$FlowKt__ContextKt", "buffer", "Lkotlinx/coroutines/flow/Flow;", "T", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "cancellable", "conflate", "flowOn", "flowWith", BdhLogUtil.LogTag.Tag_Req, "flowContext", "bufferSize", "builder", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__ContextKt {
    @NotNull
    public static final <T> Flow<T> buffer(@NotNull Flow<? extends T> flow, int i3, @NotNull BufferOverflow bufferOverflow) {
        int i16;
        BufferOverflow bufferOverflow2;
        boolean z16 = true;
        if (i3 >= 0 || i3 == -2 || i3 == -1) {
            if (i3 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z16 = false;
            }
            if (!z16) {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i3 == -1) {
                bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                i16 = 0;
            } else {
                i16 = i3;
                bufferOverflow2 = bufferOverflow;
            }
            return flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, null, i16, bufferOverflow2, 1, null) : new ChannelFlowOperatorImpl(flow, null, i16, bufferOverflow2, 2, null);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", Integer.valueOf(i3)).toString());
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i3, BufferOverflow bufferOverflow, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -2;
        }
        if ((i16 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, i3, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> cancellable(@NotNull Flow<? extends T> flow) {
        if (!(flow instanceof CancellableFlow)) {
            return new CancellableFlowImpl(flow);
        }
        return flow;
    }

    private static final void checkFlowContext$FlowKt__ContextKt(CoroutineContext coroutineContext) {
        boolean z16;
        if (coroutineContext.get(Job.INSTANCE) == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Flow context cannot contain job in it. Had ", coroutineContext).toString());
        }
    }

    @NotNull
    public static final <T> Flow<T> conflate(@NotNull Flow<? extends T> flow) {
        Flow<T> buffer$default;
        buffer$default = buffer$default(flow, -1, null, 2, null);
        return buffer$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Flow<T> flowOn(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        if (!Intrinsics.areEqual(coroutineContext, EmptyCoroutineContext.INSTANCE)) {
            if (flow instanceof FusibleFlow) {
                return FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, coroutineContext, 0, null, 6, null);
            }
            return new ChannelFlowOperatorImpl(flow, coroutineContext, 0, null, 12, null);
        }
        return flow;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "flowWith is deprecated without replacement, please refer to its KDoc for an explanation")
    @FlowPreview
    @NotNull
    public static final <T, R> Flow<R> flowWith(@NotNull final Flow<? extends T> flow, @NotNull final CoroutineContext coroutineContext, final int i3, @NotNull final Function1<? super Flow<? extends T>, ? extends Flow<? extends R>> function1) {
        checkFlowContext$FlowKt__ContextKt(coroutineContext);
        return new Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull final FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Flow buffer$default;
                Flow buffer$default2;
                Object coroutine_suspended;
                buffer$default = FlowKt__ContextKt.buffer$default(FlowKt.flowOn(Flow.this, continuation.get$context().minusKey(Job.INSTANCE)), i3, null, 2, null);
                buffer$default2 = FlowKt__ContextKt.buffer$default(FlowKt.flowOn((Flow) function1.invoke(buffer$default), coroutineContext), i3, null, 2, null);
                Object collect = buffer$default2.collect(new FlowCollector<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ContextKt$flowWith$lambda-3$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    public Object emit(R r16, @NotNull Continuation<? super Unit> continuation2) {
                        Object coroutine_suspended2;
                        Object emit = FlowCollector.this.emit(r16, continuation2);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (emit == coroutine_suspended2) {
                            return emit;
                        }
                        return Unit.INSTANCE;
                    }
                }, continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static /* synthetic */ Flow flowWith$default(Flow flow, CoroutineContext coroutineContext, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -2;
        }
        return FlowKt.flowWith(flow, coroutineContext, i3, function1);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i3, int i16, Object obj) {
        Flow buffer;
        if ((i16 & 1) != 0) {
            i3 = -2;
        }
        buffer = buffer(flow, i3);
        return buffer;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final /* synthetic */ Flow buffer(Flow flow, int i3) {
        Flow buffer$default;
        buffer$default = buffer$default(flow, i3, null, 2, null);
        return buffer$default;
    }
}
