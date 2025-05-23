package com.tencent.ecommerce.biz.customerservice;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import wg0.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.customerservice.ECCustomerServiceViewModel$startCustomerServicePage$1", f = "ECCustomerServiceViewModel.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECCustomerServiceViewModel$startCustomerServicePage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ CustomerServiceScene $scene;
    final /* synthetic */ String $shopId;
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECCustomerServiceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCustomerServiceViewModel$startCustomerServicePage$1(ECCustomerServiceViewModel eCCustomerServiceViewModel, CustomerServiceScene customerServiceScene, String str, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCCustomerServiceViewModel;
        this.$scene = customerServiceScene;
        this.$shopId = str;
        this.$spuId = str2;
        this.$orderId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECCustomerServiceViewModel$startCustomerServicePage$1(this.this$0, this.$scene, this.$shopId, this.$spuId, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECCustomerServiceViewModel$startCustomerServicePage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableStateFlow mutableStateFlow;
        IECCustomerServiceRepo iECCustomerServiceRepo;
        boolean isBlank;
        MutableStateFlow mutableStateFlow2;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._pageState;
            mutableStateFlow.setValue(ECOrderSubmitViewModel.g.c.f103527a);
            iECCustomerServiceRepo = this.this$0.repo;
            CustomerServiceScene customerServiceScene = this.$scene;
            String str = this.$shopId;
            String str2 = this.$spuId;
            String str3 = this.$orderId;
            this.label = 1;
            obj = iECCustomerServiceRepo.fetchCustomerServiceInfo(customerServiceScene, str, str2, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IECCustomerServiceRepo.CustomerServiceResult customerServiceResult = (IECCustomerServiceRepo.CustomerServiceResult) obj;
        if (customerServiceResult.errorCode == 0) {
            if (customerServiceResult.url.length() > 0) {
                this.this$0.O1().putAll(customerServiceResult.a());
                mutableLiveData = this.this$0._urlData;
                mutableLiveData.setValue(customerServiceResult.url);
                return Unit.INSTANCE;
            }
        }
        String str4 = customerServiceResult.errorMsg;
        isBlank = StringsKt__StringsJVMKt.isBlank(str4);
        if (isBlank) {
            str4 = a.a().getString(R.string.wo9);
        }
        mutableStateFlow2 = this.this$0._pageState;
        mutableStateFlow2.setValue(new ECOrderSubmitViewModel.g.Error(customerServiceResult.errorCode, str4));
        return Unit.INSTANCE;
    }
}
