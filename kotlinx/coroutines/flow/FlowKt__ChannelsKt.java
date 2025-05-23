package kotlinx.coroutines.flow;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n\u001a/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a&\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", WadlProxyConsts.CHANNEL, "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.valuesCustom().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all coreresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull final BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object coroutine_suspended;
                Object emitAll = FlowKt.emitAll(flowCollector, BroadcastChannel.this.openSubscription(), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (emitAll == coroutine_suspended) {
                    return emitAll;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, SharingStarted.Lazily, 0)", imports = {}))
    @NotNull
    public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        int produceCapacity$kotlinx_coroutines_core;
        ChannelFlow asChannelFlow = ChannelFlowKt.asChannelFlow(flow);
        int i3 = WhenMappings.$EnumSwitchMapping$0[asChannelFlow.onBufferOverflow.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalArgumentException("Broadcast channel does not support BufferOverflow.DROP_LATEST");
            }
            produceCapacity$kotlinx_coroutines_core = -1;
        } else {
            produceCapacity$kotlinx_coroutines_core = asChannelFlow.getProduceCapacity$kotlinx_coroutines_core();
        }
        return BroadcastKt.broadcast$default(coroutineScope, asChannelFlow.context, produceCapacity$kotlinx_coroutines_core, coroutineStart, null, new FlowKt__ChannelsKt$broadcastIn$1(flow, null), 8, null);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @NotNull
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    @Nullable
    public static final <T> Object emitAll(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (emitAllImpl$FlowKt__ChannelsKt == coroutine_suspended) {
            return emitAllImpl$FlowKt__ChannelsKt;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:12:0x0032, B:20:0x0070, B:22:0x0076, B:28:0x0085, B:30:0x0086, B:46:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:12:0x0032, B:20:0x0070, B:22:0x0076, B:28:0x0085, B:30:0x0086, B:46:0x004c), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v3, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0096 -> B:13:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z16, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        Object coroutine_suspended;
        int i3;
        Object obj;
        ?? r85;
        Object obj2;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                int i16 = flowKt__ChannelsKt$emitAllImpl$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label = i16 - Integer.MIN_VALUE;
                    Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = flowKt__ChannelsKt$emitAllImpl$1.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                boolean z17 = (FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                                receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                                FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                boolean z18 = z17;
                                FlowCollector flowCollector3 = flowCollector2;
                                FlowCollector flowCollector4 = flowCollector3;
                                z16 = z18;
                                obj2 = (FlowCollector<? super T>) flowCollector4;
                                try {
                                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z16;
                                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                                    obj = receiveChannel.mo2001receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    boolean z19 = z16;
                                    r85 = obj2;
                                    flowCollector = (FlowCollector<? super T>) (z19 ? 1 : 0);
                                    if (!ChannelResult.m2016isClosedimpl(obj)) {
                                        Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(obj);
                                        if (m2012exceptionOrNullimpl == null) {
                                            if (flowCollector != 0) {
                                                ChannelsKt.cancelConsumed(receiveChannel, null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                        throw m2012exceptionOrNullimpl;
                                    }
                                    Object m2014getOrThrowimpl = ChannelResult.m2014getOrThrowimpl(obj);
                                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = r85;
                                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = (boolean) flowCollector;
                                    flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                                    Object emit = r85.emit(m2014getOrThrowimpl, flowKt__ChannelsKt$emitAllImpl$1);
                                    z18 = flowCollector;
                                    flowCollector3 = r85;
                                    if (emit == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    FlowCollector flowCollector42 = flowCollector3;
                                    z16 = z18;
                                    obj2 = (FlowCollector<? super T>) flowCollector42;
                                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z16;
                                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                                    obj = receiveChannel.mo2001receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                                    if (obj == coroutine_suspended) {
                                    }
                                } catch (Throwable th5) {
                                    boolean z26 = z16;
                                    th = th5;
                                    flowCollector = z26;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        if (flowCollector != 0) {
                                            ChannelsKt.cancelConsumed(receiveChannel, th);
                                        }
                                        throw th6;
                                    }
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            boolean z27 = (FlowCollector<? super T>) flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                            receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                            FlowCollector flowCollector5 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            obj = ((ChannelResult) obj3).getHolder();
                            flowCollector = z27;
                            r85 = flowCollector5;
                            if (!ChannelResult.m2016isClosedimpl(obj)) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj3);
                        FlowKt.ensureActive(flowCollector);
                        obj2 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = obj2;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z16;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        obj = receiveChannel.mo2001receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$1);
                        if (obj == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i3 == 0) {
            }
        } catch (Throwable th7) {
            th = th7;
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj32 = flowKt__ChannelsKt$emitAllImpl$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__ChannelsKt$emitAllImpl$1.label;
    }

    @FlowPreview
    @NotNull
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @NotNull
    public static final <T> Flow<T> receiveAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }
}
