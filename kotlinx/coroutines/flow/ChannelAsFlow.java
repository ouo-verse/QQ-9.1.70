package kotlinx.coroutines.flow;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u001aB;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0017\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b#\u0010$R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lkotlinx/coroutines/flow/ChannelAsFlow;", "T", "Lkotlinx/coroutines/channels/ReceiveChannel;", WadlProxyConsts.CHANNEL, "", "consume", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "", "additionalToStringProps", "()Ljava/lang/String;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", QCircleDaTongConstant.ElementParamValue.COLLECT, "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", OperateCustomButton.OPERATE_CREATE, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "markConsumed", "()V", "Lkotlinx/coroutines/CoroutineScope;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ChannelAsFlow<T> extends ChannelFlow<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumed$FU = AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed");

    @NotNull
    private final ReceiveChannel<T> channel;
    private final boolean consume;

    @NotNull
    private volatile /* synthetic */ int consumed;

    public /* synthetic */ ChannelAsFlow(ReceiveChannel receiveChannel, boolean z16, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(receiveChannel, z16, (i16 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i16 & 8) != 0 ? -3 : i3, (i16 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void markConsumed() {
        if (this.consume) {
            boolean z16 = true;
            if (consumed$FU.getAndSet(this, 1) != 0) {
                z16 = false;
            }
            if (!z16) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    protected String additionalToStringProps() {
        return Intrinsics.stringPlus("channel=", this.channel);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object emitAllImpl$FlowKt__ChannelsKt;
        Object coroutine_suspended2;
        if (this.capacity == -3) {
            markConsumed();
            emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector, this.channel, this.consume, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emitAllImpl$FlowKt__ChannelsKt == coroutine_suspended2) {
                return emitAllImpl$FlowKt__ChannelsKt;
            }
            return Unit.INSTANCE;
        }
        Object collect = super.collect(flowCollector, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (collect == coroutine_suspended) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt;
        Object coroutine_suspended;
        emitAllImpl$FlowKt__ChannelsKt = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(new SendingCollector(producerScope), this.channel, this.consume, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (emitAllImpl$FlowKt__ChannelsKt == coroutine_suspended) {
            return emitAllImpl$FlowKt__ChannelsKt;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    protected ChannelFlow<T> create(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return new ChannelAsFlow(this.channel, this.consume, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public Flow<T> dropChannelOperators() {
        return new ChannelAsFlow(this.channel, this.consume, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ReceiveChannel<T> produceImpl(@NotNull CoroutineScope scope) {
        markConsumed();
        if (this.capacity == -3) {
            return this.channel;
        }
        return super.produceImpl(scope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel, boolean z16, @NotNull CoroutineContext coroutineContext, int i3, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i3, bufferOverflow);
        this.channel = receiveChannel;
        this.consume = z16;
        this.consumed = 0;
    }
}
