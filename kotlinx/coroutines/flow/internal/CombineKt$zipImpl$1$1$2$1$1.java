package kotlinx.coroutines.flow.internal;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", BdhLogUtil.LogTag.Tag_Req, "", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
final class CombineKt$zipImpl$1$1$2$1$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $second;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    final /* synthetic */ T1 $value;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$2$1$1(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, T1 t16, Continuation<? super CombineKt$zipImpl$1$1$2$1$1> continuation) {
        super(2, continuation);
        this.$second = receiveChannel;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
        this.$value = t16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CombineKt$zipImpl$1$1$2$1$1(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object mo2001receiveCatchingJP2dKIU;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 3;
                if (flowCollector.emit(obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            mo2001receiveCatchingJP2dKIU = ((ChannelResult) obj).getHolder();
        } else {
            ResultKt.throwOnFailure(obj);
            ReceiveChannel<Object> receiveChannel = this.$second;
            this.label = 1;
            mo2001receiveCatchingJP2dKIU = receiveChannel.mo2001receiveCatchingJP2dKIU(this);
            if (mo2001receiveCatchingJP2dKIU == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        flowCollector = this.$this_unsafeFlow;
        if (mo2001receiveCatchingJP2dKIU instanceof ChannelResult.Failed) {
            Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2001receiveCatchingJP2dKIU);
            if (m2012exceptionOrNullimpl == null) {
                throw new AbortFlowException(flowCollector);
            }
            throw m2012exceptionOrNullimpl;
        }
        Function3<T1, T2, Continuation<? super R>, Object> function3 = this.$transform;
        T1 t16 = this.$value;
        if (mo2001receiveCatchingJP2dKIU == NullSurrogateKt.NULL) {
            mo2001receiveCatchingJP2dKIU = null;
        }
        this.L$0 = flowCollector;
        this.label = 2;
        obj = function3.invoke(t16, mo2001receiveCatchingJP2dKIU, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.L$0 = null;
        this.label = 3;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull Unit unit, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1$2$1$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
