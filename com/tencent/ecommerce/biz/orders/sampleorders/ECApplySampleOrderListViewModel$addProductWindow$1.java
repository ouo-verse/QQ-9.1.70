package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel;
import com.tencent.ecommerce.biz.productcenter.repo.IECSelectProductDefaultRepository;
import com.tencent.ecommerce.biz.showwindow.repo.ECGlobalAddProductWindowRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import qi0.ECSelectProductAddWindowResponse;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderListViewModel$addProductWindow$1", f = "ECApplySampleOrderListViewModel.kt", i = {}, l = {64, 76}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderListViewModel$addProductWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderId;
    final /* synthetic */ String $spuId;
    int label;
    final /* synthetic */ ECApplySampleOrderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECApplySampleOrderListViewModel$addProductWindow$1(ECApplySampleOrderListViewModel eCApplySampleOrderListViewModel, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCApplySampleOrderListViewModel;
        this.$spuId = str;
        this.$orderId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECApplySampleOrderListViewModel$addProductWindow$1(this.this$0, this.$spuId, this.$orderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECApplySampleOrderListViewModel$addProductWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.ecommerce.biz.productcenter.repo.a aVar = com.tencent.ecommerce.biz.productcenter.repo.a.f103921a;
            ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest = new ECGlobalAddProductWindowRequest(null, this.$spuId, 101, 1, null);
            this.label = 1;
            obj = IECSelectProductDefaultRepository.a.a(aVar, eCGlobalAddProductWindowRequest, null, this, 2, null);
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
            ResultKt.throwOnFailure(obj);
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        if (eCNetworkResponse.getCode() != 0 || eCNetworkResponse.b() == null) {
            cg0.a.a("ECApplySampleOrderListViewModel", "addProductWindow", "apply sample order add product window error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        }
        mutableSharedFlow = this.this$0._operateEvent;
        ECApplySampleOrderListViewModel.b.a aVar2 = new ECApplySampleOrderListViewModel.b.a(this.$orderId, (ECSelectProductAddWindowResponse) eCNetworkResponse.b());
        this.label = 2;
        if (mutableSharedFlow.emit(aVar2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
