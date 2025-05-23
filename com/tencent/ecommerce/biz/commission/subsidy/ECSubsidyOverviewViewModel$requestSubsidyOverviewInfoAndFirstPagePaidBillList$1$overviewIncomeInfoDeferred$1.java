package com.tencent.ecommerce.biz.commission.subsidy;

import com.tencent.ecommerce.repo.ServiceLocator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tj0.ECSubsidyIncomeInfo;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ltj0/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1", f = "ECSubsidyOverviewViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ECSubsidyIncomeInfo>, Object> {
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ECSubsidyIncomeInfo> continuation) {
        return ((ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.ecommerce.repo.commission.subsidy.a r16 = ServiceLocator.f104891i.r();
            this.label = 1;
            obj = r16.b(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1(Continuation continuation) {
        super(2, continuation);
    }
}
