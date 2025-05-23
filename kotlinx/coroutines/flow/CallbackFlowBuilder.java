package kotlinx.coroutines.flow;

import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BU\u0012-\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u00a2\u0006\u0002\b\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R:\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u00a2\u0006\u0002\b\tX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlin/jvm/functions/Function2;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", OperateCustomButton.OPERATE_CREATE, "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CallbackFlowBuilder<T> extends ChannelFlowBuilder<T> {

    @NotNull
    private final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> block;

    public /* synthetic */ CallbackFlowBuilder(Function2 function2, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i16 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i16 & 4) != 0 ? -2 : i3, (i16 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.ChannelFlowBuilder, kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collectTo(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        CallbackFlowBuilder$collectTo$1 callbackFlowBuilder$collectTo$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof CallbackFlowBuilder$collectTo$1) {
            callbackFlowBuilder$collectTo$1 = (CallbackFlowBuilder$collectTo$1) continuation;
            int i16 = callbackFlowBuilder$collectTo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                callbackFlowBuilder$collectTo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = callbackFlowBuilder$collectTo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = callbackFlowBuilder$collectTo$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        producerScope = (ProducerScope) callbackFlowBuilder$collectTo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    callbackFlowBuilder$collectTo$1.L$0 = producerScope;
                    callbackFlowBuilder$collectTo$1.label = 1;
                    if (super.collectTo(producerScope, callbackFlowBuilder$collectTo$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (!producerScope.isClosedForSend()) {
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
            }
        }
        callbackFlowBuilder$collectTo$1 = new CallbackFlowBuilder$collectTo$1(this, continuation);
        Object obj2 = callbackFlowBuilder$collectTo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = callbackFlowBuilder$collectTo$1.label;
        if (i3 == 0) {
        }
        if (!producerScope.isClosedForSend()) {
        }
    }

    @Override // kotlinx.coroutines.flow.ChannelFlowBuilder, kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    protected ChannelFlow<T> create(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return new CallbackFlowBuilder(this.block, context, capacity, onBufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(@NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull CoroutineContext coroutineContext, int i3, @NotNull BufferOverflow bufferOverflow) {
        super(function2, coroutineContext, i3, bufferOverflow);
        this.block = function2;
    }
}
