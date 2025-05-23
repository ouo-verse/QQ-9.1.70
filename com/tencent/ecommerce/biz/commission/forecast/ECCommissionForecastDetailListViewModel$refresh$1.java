package com.tencent.ecommerce.biz.commission.forecast;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.forecast.ECCommissionForecastDetailListViewModel$refresh$1", f = "ECCommissionForecastDetailListViewModel.kt", i = {}, l = {35, 36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECCommissionForecastDetailListViewModel$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ECCommissionForecastDetailListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCommissionForecastDetailListViewModel$refresh$1(ECCommissionForecastDetailListViewModel eCCommissionForecastDetailListViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCCommissionForecastDetailListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECCommissionForecastDetailListViewModel$refresh$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECCommissionForecastDetailListViewModel$refresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        ECCommissionForecastDetailListViewModel eCCommissionForecastDetailListViewModel;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._loadingStatus;
            mutableLiveData.setValue(LoadingStatus.REFRESHING);
            this.this$0.cookie = null;
            eCCommissionForecastDetailListViewModel = this.this$0;
            this.L$0 = eCCommissionForecastDetailListViewModel;
            this.label = 1;
            obj = eCCommissionForecastDetailListViewModel.O1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eCCommissionForecastDetailListViewModel = (ECCommissionForecastDetailListViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        eCCommissionForecastDetailListViewModel.summary = (CommissionSummaryInfo) obj;
        ECCommissionForecastDetailListViewModel eCCommissionForecastDetailListViewModel2 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (eCCommissionForecastDetailListViewModel2.S1(false, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
