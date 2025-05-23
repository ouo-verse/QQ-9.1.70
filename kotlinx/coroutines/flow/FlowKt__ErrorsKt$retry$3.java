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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
public final class FlowKt__ErrorsKt$retry$3<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long j3, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super FlowKt__ErrorsKt$retry$3> continuation) {
        super(4, continuation);
        this.$retries = j3;
        this.$predicate = function2;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th5, Long l3, Continuation<? super Boolean> continuation) {
        return invoke((FlowCollector) obj, th5, l3.longValue(), continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0038, code lost:
    
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Throwable th5 = (Throwable) this.L$0;
            if (this.J$0 < this.$retries) {
                Function2<Throwable, Continuation<? super Boolean>, Object> function2 = this.$predicate;
                this.label = 1;
                obj = function2.invoke(th5, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            z16 = false;
            return Boxing.boxBoolean(z16);
        }
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th5, long j3, @Nullable Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, continuation);
        flowKt__ErrorsKt$retry$3.L$0 = th5;
        flowKt__ErrorsKt$retry$3.J$0 = j3;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(Unit.INSTANCE);
    }
}
