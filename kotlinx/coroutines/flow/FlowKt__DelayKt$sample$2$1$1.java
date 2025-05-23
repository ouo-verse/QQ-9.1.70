package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ChannelResult;", "", "result", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
final class FlowKt__DelayKt$sample$2$1$1 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    final /* synthetic */ ReceiveChannel<Unit> $ticker;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$1$1(Ref.ObjectRef<Object> objectRef, ReceiveChannel<Unit> receiveChannel, Continuation<? super FlowKt__DelayKt$sample$2$1$1> continuation) {
        super(2, continuation);
        this.$lastValue = objectRef;
        this.$ticker = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$1$1 flowKt__DelayKt$sample$2$1$1 = new FlowKt__DelayKt$sample$2$1$1(this.$lastValue, this.$ticker, continuation);
        flowKt__DelayKt$sample$2$1$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ChannelResult<? extends Object> channelResult, Continuation<? super Unit> continuation) {
        return m2032invokeWpGqRn0(channelResult.getHolder(), continuation);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m2032invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$1$1) create(ChannelResult.m2008boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.internal.Symbol, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ?? holder = ((ChannelResult) this.L$0).getHolder();
            Ref.ObjectRef<Object> objectRef = this.$lastValue;
            boolean z16 = holder instanceof ChannelResult.Failed;
            if (!z16) {
                objectRef.element = holder;
            }
            ReceiveChannel<Unit> receiveChannel = this.$ticker;
            if (z16) {
                Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(holder);
                if (m2012exceptionOrNullimpl == null) {
                    receiveChannel.cancel((CancellationException) new ChildCancelledException());
                    objectRef.element = NullSurrogateKt.DONE;
                } else {
                    throw m2012exceptionOrNullimpl;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
