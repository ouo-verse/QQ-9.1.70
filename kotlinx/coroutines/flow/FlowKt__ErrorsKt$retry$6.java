package kotlinx.coroutines.flow;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Throwable, Boolean> $predicate;
    final /* synthetic */ int $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$6(Function1<? super Throwable, Boolean> function1, int i3, Continuation<? super FlowKt__ErrorsKt$retry$6> continuation) {
        super(4, continuation);
        this.$predicate = function1;
        this.$retries = i3;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> flowCollector, Throwable th5, Long l3, Continuation<? super Boolean> continuation) {
        return invoke(flowCollector, th5, l3.longValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th5 = (Throwable) this.L$0;
            long j3 = this.J$0;
            if (this.$predicate.invoke(th5).booleanValue() && j3 < this.$retries) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boxing.boxBoolean(z16);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @NotNull Throwable th5, long j3, @Nullable Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.$predicate, this.$retries, continuation);
        flowKt__ErrorsKt$retry$6.L$0 = th5;
        flowKt__ErrorsKt$retry$6.J$0 = j3;
        return flowKt__ErrorsKt$retry$6.invokeSuspend(Unit.INSTANCE);
    }
}
