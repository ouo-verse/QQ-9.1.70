package com.tencent.mobileqq.wink.editor.aielimination;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAIEliminationFragment$countDownByFlow$3", f = "WinkAIEliminationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAIEliminationFragment$countDownByFlow$3 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFinish;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIEliminationFragment$countDownByFlow$3(Function0<Unit> function0, Continuation<? super WinkAIEliminationFragment$countDownByFlow$3> continuation) {
        super(3, continuation);
        this.$onFinish = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function0<Unit> function0;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((Throwable) this.L$0) == null && (function0 = this.$onFinish) != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Integer> flowCollector, @Nullable Throwable th5, @Nullable Continuation<? super Unit> continuation) {
        WinkAIEliminationFragment$countDownByFlow$3 winkAIEliminationFragment$countDownByFlow$3 = new WinkAIEliminationFragment$countDownByFlow$3(this.$onFinish, continuation);
        winkAIEliminationFragment$countDownByFlow$3.L$0 = th5;
        return winkAIEliminationFragment$countDownByFlow$3.invokeSuspend(Unit.INSTANCE);
    }
}
