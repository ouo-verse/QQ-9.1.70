package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1, reason: invalid class name */
/* loaded from: classes28.dex */
public final class FlowKt__EmittersKt$unsafeTransform$lambda1$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ Function3 $transform$inlined;

    public FlowKt__EmittersKt$unsafeTransform$lambda1$$inlined$collect$1(Function3 function3, FlowCollector flowCollector) {
        this.$transform$inlined = function3;
        this.$this_unsafeFlow$inlined = flowCollector;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object invoke = this.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, t16, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (invoke == coroutine_suspended) {
            return invoke;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj2) {
                this.result = obj2;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__EmittersKt$unsafeTransform$lambda1$$inlined$collect$1.this.emit(null, this);
            }
        };
        InlineMarker.mark(5);
        this.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, obj, continuation);
        return Unit.INSTANCE;
    }
}
