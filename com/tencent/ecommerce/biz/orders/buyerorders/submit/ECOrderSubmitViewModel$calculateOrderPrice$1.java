package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.MutableLiveData;
import bi0.ECHREvent;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.IECOrderSubmitRepo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.l;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.CalculatePriceScene;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.span.ECOrderOperation;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpan;
import com.tencent.ecommerce.biz.orders.span.ECOrderSpanScene;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.apache.httpcore.HttpStatus;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$calculateOrderPrice$1", f = "ECOrderSubmitViewModel.kt", i = {2, 3, 3}, l = {412, HttpStatus.SC_TOO_MANY_REQUESTS, com.tencent.luggage.wxa.j2.b.CTRL_INDEX, 457}, m = "invokeSuspend", n = {"resultRsp", "resultRsp", "result"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$calculateOrderPrice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceUpdateQuantity;
    final /* synthetic */ OrderSubmitDetailInfo $oldOrderDetail;
    final /* synthetic */ String $orderGoodsId;
    final /* synthetic */ int $quantity;
    final /* synthetic */ CalculatePriceScene $scene;
    final /* synthetic */ List $selectedCouponIds;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$calculateOrderPrice$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, boolean z16, int i3, OrderSubmitDetailInfo orderSubmitDetailInfo, String str, CalculatePriceScene calculatePriceScene, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitViewModel;
        this.$forceUpdateQuantity = z16;
        this.$quantity = i3;
        this.$oldOrderDetail = orderSubmitDetailInfo;
        this.$orderGoodsId = str;
        this.$scene = calculatePriceScene;
        this.$selectedCouponIds = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitViewModel$calculateOrderPrice$1(this.this$0, this.$forceUpdateQuantity, this.$quantity, this.$oldOrderDetail, this.$orderGoodsId, this.$scene, this.$selectedCouponIds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitViewModel$calculateOrderPrice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object v26;
        int i3;
        OrderSubmitDetailInfo b36;
        MutableLiveData mutableLiveData;
        IECOrderSubmitRepo iECOrderSubmitRepo;
        String str;
        String str2;
        String str3;
        Boolean bool;
        Object calculateOrderPrice;
        ECNetworkResponse<?> eCNetworkResponse;
        final IECOrderSubmitRepo.CalculateOrderPriceResult calculateOrderPriceResult;
        MutableLiveData mutableLiveData2;
        MutableSharedFlow mutableSharedFlow;
        l.ErrorCommonEvent errorCommonEvent;
        ECNetworkResponse<?> eCNetworkResponse2;
        MutableSharedFlow mutableSharedFlow2;
        OrderSubmitDetailInfo b37;
        OrderSubmitDetailInfo a16;
        MutableLiveData mutableLiveData3;
        Map<String, String> mapOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$forceUpdateQuantity) {
                i3 = this.$quantity;
                int i17 = i3;
                MutableLiveData mutableLiveData4 = this.this$0._orderSubmitDetailInfo;
                b36 = this.this$0.b3(this.$oldOrderDetail, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$calculateOrderPrice$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                        OrderSkuDetail a17;
                        a17 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : ECOrderSubmitViewModel$calculateOrderPrice$1.this.$quantity, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : null);
                        return a17;
                    }
                });
                mutableLiveData4.setValue(b36);
                mutableLiveData = this.this$0._pageState;
                mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
                iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
                String str4 = this.$orderGoodsId;
                str = this.this$0.pageExt;
                CalculatePriceScene calculatePriceScene = this.$scene;
                List<String> list = this.$selectedCouponIds;
                str2 = this.this$0.activityId;
                str3 = this.this$0.groupId;
                bool = this.this$0.isBuyAll;
                List<String> c16 = this.$oldOrderDetail.c();
                this.label = 2;
                calculateOrderPrice = iECOrderSubmitRepo.calculateOrderPrice(str4, i17, str, calculatePriceScene, list, str2, str3, bool, c16, this);
                if (calculateOrderPrice == coroutine_suspended) {
                    return coroutine_suspended;
                }
                eCNetworkResponse = (ECNetworkResponse) calculateOrderPrice;
                calculateOrderPriceResult = (IECOrderSubmitRepo.CalculateOrderPriceResult) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0) {
                }
                mutableLiveData2 = this.this$0._pageState;
                mutableLiveData2.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                mutableSharedFlow = this.this$0._errorEvent;
                errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage());
                this.L$0 = eCNetworkResponse;
                this.label = 3;
                if (mutableSharedFlow.emit(errorCommonEvent, this) == coroutine_suspended) {
                }
            } else {
                ECOrderSubmitViewModel eCOrderSubmitViewModel = this.this$0;
                int i18 = this.$quantity;
                int i19 = this.$oldOrderDetail.orderSkusDetail.maxQuantity;
                this.label = 1;
                v26 = eCOrderSubmitViewModel.v2(i18, i19, this);
                if (v26 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        eCNetworkResponse2 = (ECNetworkResponse) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        this.this$0._orderSubmitDetailInfo.setValue(this.$oldOrderDetail);
                        cg0.a.a("ECOrderSubmitViewModel", "updateOrderGoodsQuantity", "network error, code=" + eCNetworkResponse2.getCode());
                        if (this.$scene == CalculatePriceScene.CHANGE_SELECT_COUPON) {
                            LifecycleEventBus.f100688b.f(new ECHREvent("select_coupon_fail", new JSONObject()));
                        }
                        ECOrderSpan eCOrderSpan = ECOrderSpan.f103884c;
                        ECOrderSpan.c(eCOrderSpan, this.$oldOrderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.CalculateOrderPrice, eCOrderSpan.d(eCNetworkResponse2), null, 16, null);
                        return Unit.INSTANCE;
                    }
                    if (i16 == 4) {
                        calculateOrderPriceResult = (IECOrderSubmitRepo.CalculateOrderPriceResult) this.L$1;
                        eCNetworkResponse = (ECNetworkResponse) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        cg0.a.b("ECOrderSubmitViewModel", "exceedLimit, " + calculateOrderPriceResult.exceedLimitMsg);
                        MutableLiveData mutableLiveData5 = this.this$0._orderSubmitDetailInfo;
                        b37 = this.this$0.b3(this.$oldOrderDetail, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$calculateOrderPrice$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                                OrderSkuDetail a17;
                                IECOrderSubmitRepo.CalculateOrderPriceResult calculateOrderPriceResult2 = IECOrderSubmitRepo.CalculateOrderPriceResult.this;
                                a17 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : calculateOrderPriceResult2.quantity, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : calculateOrderPriceResult2.originUnitPrice, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : calculateOrderPriceResult2.maxQuantity, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : null);
                                return a17;
                            }
                        });
                        a16 = b37.a((i3 & 1) != 0 ? b37.orderId : null, (i3 & 2) != 0 ? b37.address : null, (i3 & 4) != 0 ? b37.orderSkusDetail : null, (i3 & 8) != 0 ? b37.supportPayType : null, (i3 & 16) != 0 ? b37.selectedPayType : null, (i3 & 32) != 0 ? b37.priceInfo : calculateOrderPriceResult.priceInfo, (i3 & 64) != 0 ? b37.bulletinInfo : null, (i3 & 128) != 0 ? b37.enableCoupon : false, (i3 & 256) != 0 ? b37.couponInfo : calculateOrderPriceResult.orderCouponInfo, (i3 & 512) != 0 ? b37.blindBoxAgreementVersion : null, (i3 & 1024) != 0 ? b37.qShopProductAgreementVersion : null, (i3 & 2048) != 0 ? b37.qShopPrivacyAgreementVersion : null, (i3 & 4096) != 0 ? b37.goodsLabelInfoList : null, (i3 & 8192) != 0 ? b37.boxOrderIds : null, (i3 & 16384) != 0 ? b37.deliveryMessage : null);
                        mutableLiveData5.setValue(a16);
                        mutableLiveData3 = this.this$0._pageState;
                        mutableLiveData3.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                        ECOrderSpan eCOrderSpan2 = ECOrderSpan.f103884c;
                        String str5 = this.$oldOrderDetail.orderId;
                        ECOrderSpanScene eCOrderSpanScene = ECOrderSpanScene.OrderSubmit;
                        ECOrderOperation eCOrderOperation = ECOrderOperation.CalculateOrderPrice;
                        ECOrderSpan.OrderRequestInfo d16 = eCOrderSpan2.d(eCNetworkResponse);
                        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", String.valueOf(calculateOrderPriceResult)));
                        eCOrderSpan2.b(str5, eCOrderSpanScene, eCOrderOperation, d16, mapOf);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                calculateOrderPrice = obj;
                eCNetworkResponse = (ECNetworkResponse) calculateOrderPrice;
                calculateOrderPriceResult = (IECOrderSubmitRepo.CalculateOrderPriceResult) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() == 0 || calculateOrderPriceResult == null) {
                    mutableLiveData2 = this.this$0._pageState;
                    mutableLiveData2.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                    mutableSharedFlow = this.this$0._errorEvent;
                    errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage());
                    this.L$0 = eCNetworkResponse;
                    this.label = 3;
                    if (mutableSharedFlow.emit(errorCommonEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCNetworkResponse2 = eCNetworkResponse;
                    this.this$0._orderSubmitDetailInfo.setValue(this.$oldOrderDetail);
                    cg0.a.a("ECOrderSubmitViewModel", "updateOrderGoodsQuantity", "network error, code=" + eCNetworkResponse2.getCode());
                    if (this.$scene == CalculatePriceScene.CHANGE_SELECT_COUPON) {
                    }
                    ECOrderSpan eCOrderSpan3 = ECOrderSpan.f103884c;
                    ECOrderSpan.c(eCOrderSpan3, this.$oldOrderDetail.orderId, ECOrderSpanScene.OrderSubmit, ECOrderOperation.CalculateOrderPrice, eCOrderSpan3.d(eCNetworkResponse2), null, 16, null);
                    return Unit.INSTANCE;
                }
                if (calculateOrderPriceResult.isExceedLimit) {
                    mutableSharedFlow2 = this.this$0._errorEvent;
                    l.ErrorToastWithMsgEvent errorToastWithMsgEvent = new l.ErrorToastWithMsgEvent(calculateOrderPriceResult.exceedLimitMsg);
                    this.L$0 = eCNetworkResponse;
                    this.L$1 = calculateOrderPriceResult;
                    this.label = 4;
                    if (mutableSharedFlow2.emit(errorToastWithMsgEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cg0.a.b("ECOrderSubmitViewModel", "exceedLimit, " + calculateOrderPriceResult.exceedLimitMsg);
                }
                MutableLiveData mutableLiveData52 = this.this$0._orderSubmitDetailInfo;
                b37 = this.this$0.b3(this.$oldOrderDetail, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$calculateOrderPrice$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                        OrderSkuDetail a17;
                        IECOrderSubmitRepo.CalculateOrderPriceResult calculateOrderPriceResult2 = IECOrderSubmitRepo.CalculateOrderPriceResult.this;
                        a17 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : calculateOrderPriceResult2.quantity, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : calculateOrderPriceResult2.originUnitPrice, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : calculateOrderPriceResult2.maxQuantity, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : null);
                        return a17;
                    }
                });
                a16 = b37.a((i3 & 1) != 0 ? b37.orderId : null, (i3 & 2) != 0 ? b37.address : null, (i3 & 4) != 0 ? b37.orderSkusDetail : null, (i3 & 8) != 0 ? b37.supportPayType : null, (i3 & 16) != 0 ? b37.selectedPayType : null, (i3 & 32) != 0 ? b37.priceInfo : calculateOrderPriceResult.priceInfo, (i3 & 64) != 0 ? b37.bulletinInfo : null, (i3 & 128) != 0 ? b37.enableCoupon : false, (i3 & 256) != 0 ? b37.couponInfo : calculateOrderPriceResult.orderCouponInfo, (i3 & 512) != 0 ? b37.blindBoxAgreementVersion : null, (i3 & 1024) != 0 ? b37.qShopProductAgreementVersion : null, (i3 & 2048) != 0 ? b37.qShopPrivacyAgreementVersion : null, (i3 & 4096) != 0 ? b37.goodsLabelInfoList : null, (i3 & 8192) != 0 ? b37.boxOrderIds : null, (i3 & 16384) != 0 ? b37.deliveryMessage : null);
                mutableLiveData52.setValue(a16);
                mutableLiveData3 = this.this$0._pageState;
                mutableLiveData3.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                ECOrderSpan eCOrderSpan22 = ECOrderSpan.f103884c;
                String str52 = this.$oldOrderDetail.orderId;
                ECOrderSpanScene eCOrderSpanScene2 = ECOrderSpanScene.OrderSubmit;
                ECOrderOperation eCOrderOperation2 = ECOrderOperation.CalculateOrderPrice;
                ECOrderSpan.OrderRequestInfo d162 = eCOrderSpan22.d(eCNetworkResponse);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", String.valueOf(calculateOrderPriceResult)));
                eCOrderSpan22.b(str52, eCOrderSpanScene2, eCOrderOperation2, d162, mapOf);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            v26 = obj;
        }
        i3 = ((Number) v26).intValue();
        int i172 = i3;
        MutableLiveData mutableLiveData42 = this.this$0._orderSubmitDetailInfo;
        b36 = this.this$0.b3(this.$oldOrderDetail, new Function1<OrderSkuDetail, OrderSkuDetail>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$calculateOrderPrice$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final OrderSkuDetail invoke(OrderSkuDetail orderSkuDetail) {
                OrderSkuDetail a17;
                a17 = orderSkuDetail.a((r34 & 1) != 0 ? orderSkuDetail.skuId : null, (r34 & 2) != 0 ? orderSkuDetail.spuId : null, (r34 & 4) != 0 ? orderSkuDetail.quantity : ECOrderSubmitViewModel$calculateOrderPrice$1.this.$quantity, (r34 & 8) != 0 ? orderSkuDetail.shop : null, (r34 & 16) != 0 ? orderSkuDetail.coverUrl : null, (r34 & 32) != 0 ? orderSkuDetail.name : null, (r34 & 64) != 0 ? orderSkuDetail.specifications : null, (r34 & 128) != 0 ? orderSkuDetail.logisticsPolicy : null, (r34 & 256) != 0 ? orderSkuDetail.unitPrice : 0L, (r34 & 512) != 0 ? orderSkuDetail.originUnitPrice : 0L, (r34 & 1024) != 0 ? orderSkuDetail.note : null, (r34 & 2048) != 0 ? orderSkuDetail.freight : null, (r34 & 4096) != 0 ? orderSkuDetail.maxQuantity : 0, (r34 & 8192) != 0 ? orderSkuDetail.minQuantity : 0, (r34 & 16384) != 0 ? orderSkuDetail.productType : null);
                return a17;
            }
        });
        mutableLiveData42.setValue(b36);
        mutableLiveData = this.this$0._pageState;
        mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
        iECOrderSubmitRepo = this.this$0.orderSubmitRepo;
        String str42 = this.$orderGoodsId;
        str = this.this$0.pageExt;
        CalculatePriceScene calculatePriceScene2 = this.$scene;
        List<String> list2 = this.$selectedCouponIds;
        str2 = this.this$0.activityId;
        str3 = this.this$0.groupId;
        bool = this.this$0.isBuyAll;
        List<String> c162 = this.$oldOrderDetail.c();
        this.label = 2;
        calculateOrderPrice = iECOrderSubmitRepo.calculateOrderPrice(str42, i172, str, calculatePriceScene2, list2, str2, str3, bool, c162, this);
        if (calculateOrderPrice == coroutine_suspended) {
        }
        eCNetworkResponse = (ECNetworkResponse) calculateOrderPrice;
        calculateOrderPriceResult = (IECOrderSubmitRepo.CalculateOrderPriceResult) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() == 0) {
        }
        mutableLiveData2 = this.this$0._pageState;
        mutableLiveData2.setValue(ECOrderSubmitViewModel.g.d.f103528a);
        mutableSharedFlow = this.this$0._errorEvent;
        errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage());
        this.L$0 = eCNetworkResponse;
        this.label = 3;
        if (mutableSharedFlow.emit(errorCommonEvent, this) == coroutine_suspended) {
        }
    }
}
