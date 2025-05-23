package kotlinx.coroutines.flow;

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
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__EmittersKt$transform$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_transform;
    final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, continuation);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow<T> flow = this.$this_transform;
            FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this.$transform, flowCollector);
            this.label = 1;
            if (flow.collect(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Flow<T> flow = this.$this_transform;
        FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 = new FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1(this.$transform, flowCollector);
        InlineMarker.mark(0);
        flow.collect(flowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
