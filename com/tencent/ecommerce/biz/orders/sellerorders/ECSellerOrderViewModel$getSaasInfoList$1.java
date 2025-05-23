package com.tencent.ecommerce.biz.orders.sellerorders;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sellerorders.ECSellerOrderViewModel$getSaasInfoList$1", f = "ECSellerOrderViewModel.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSellerOrderViewModel$getSaasInfoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECSellerOrderViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSellerOrderViewModel$getSaasInfoList$1(ECSellerOrderViewModel eCSellerOrderViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSellerOrderViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSellerOrderViewModel$getSaasInfoList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSellerOrderViewModel$getSaasInfoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        List l26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECSellerOrderRepository eCSellerOrderRepository = ECSellerOrderRepository.f103821a;
            this.label = 1;
            obj = ECSellerOrderRepository.c(eCSellerOrderRepository, null, this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONArray jSONArray = (JSONArray) obj;
        ECSellerOrderViewModel eCSellerOrderViewModel = this.this$0;
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        eCSellerOrderViewModel.saasInfoJsonArray = jSONArray;
        mutableLiveData = this.this$0._saasPlatforms;
        ECSellerOrderViewModel eCSellerOrderViewModel2 = this.this$0;
        l26 = eCSellerOrderViewModel2.l2(eCSellerOrderViewModel2.getSaasInfoJsonArray());
        mutableLiveData.postValue(l26);
        return Unit.INSTANCE;
    }
}
