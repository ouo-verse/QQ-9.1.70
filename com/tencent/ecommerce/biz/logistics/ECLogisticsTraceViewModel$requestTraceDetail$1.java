package com.tencent.ecommerce.biz.logistics;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.logistics.ECLogisticsTraceViewModel$requestTraceDetail$1", f = "ECLogisticsTraceViewModel.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECLogisticsTraceViewModel$requestTraceDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $logisticsCode;
    final /* synthetic */ String $orderId;
    int label;
    final /* synthetic */ ECLogisticsTraceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLogisticsTraceViewModel$requestTraceDetail$1(ECLogisticsTraceViewModel eCLogisticsTraceViewModel, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLogisticsTraceViewModel;
        this.$orderId = str;
        this.$logisticsCode = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLogisticsTraceViewModel$requestTraceDetail$1(this.this$0, this.$orderId, this.$logisticsCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECLogisticsTraceViewModel$requestTraceDetail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.ecommerce.repo.logistics.a h16 = ServiceLocator.f104891i.h();
            String str = this.$orderId;
            String str2 = this.$logisticsCode;
            this.label = 1;
            obj = h16.a(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData = this.this$0._logisticsInfo;
        mutableLiveData.setValue((LogisticsInfo) obj);
        return Unit.INSTANCE;
    }
}
