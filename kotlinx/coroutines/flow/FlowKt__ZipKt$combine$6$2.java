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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {292, 292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__ZipKt$combine$6$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object[], Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(Function2<? super Object[], ? super Continuation<Object>, ? extends Object> function2, Continuation<? super FlowKt__ZipKt$combine$6$2> continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            Function2<Object[], Continuation<Object>, Object> function2 = this.$transform;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = function2.invoke(objArr, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object invoke = this.$transform.invoke((Object[]) this.L$1, this);
        InlineMarker.mark(0);
        flowCollector.emit(invoke, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, continuation);
        flowKt__ZipKt$combine$6$2.L$0 = flowCollector;
        flowKt__ZipKt$combine$6$2.L$1 = objArr;
        return flowKt__ZipKt$combine$6$2.invokeSuspend(Unit.INSTANCE);
    }
}
