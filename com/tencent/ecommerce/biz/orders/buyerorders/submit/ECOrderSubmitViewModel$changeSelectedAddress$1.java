package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.AddressCheckResult;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderShop;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSubmitDetailInfo;
import com.tencent.ecommerce.biz.orders.common.BulletinInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$changeSelectedAddress$1", f = "ECOrderSubmitViewModel.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$changeSelectedAddress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ECAddress $address;
    final /* synthetic */ OrderSubmitDetailInfo $orderDetail;
    int label;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$changeSelectedAddress$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, ECAddress eCAddress, OrderSubmitDetailInfo orderSubmitDetailInfo, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitViewModel;
        this.$address = eCAddress;
        this.$orderDetail = orderSubmitDetailInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitViewModel$changeSelectedAddress$1(this.this$0, this.$address, this.$orderDetail, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitViewModel$changeSelectedAddress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        Object p26;
        OrderSubmitDetailInfo a16;
        MutableLiveData mutableLiveData2;
        OrderSubmitDetailInfo a17;
        String str;
        String str2;
        String str3;
        OrderShop orderShop;
        Boolean boxBoolean;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._pageState;
            mutableLiveData.setValue(ECOrderSubmitViewModel.g.c.f103527a);
            ECAddress eCAddress = this.$address;
            if (eCAddress == null) {
                this.this$0._isAddressReachable.setValue(Boxing.boxBoolean(true));
                MutableLiveData mutableLiveData3 = this.this$0._orderSubmitDetailInfo;
                a16 = r2.a((i3 & 1) != 0 ? r2.orderId : null, (i3 & 2) != 0 ? r2.address : null, (i3 & 4) != 0 ? r2.orderSkusDetail : null, (i3 & 8) != 0 ? r2.supportPayType : null, (i3 & 16) != 0 ? r2.selectedPayType : null, (i3 & 32) != 0 ? r2.priceInfo : null, (i3 & 64) != 0 ? r2.bulletinInfo : null, (i3 & 128) != 0 ? r2.enableCoupon : false, (i3 & 256) != 0 ? r2.couponInfo : null, (i3 & 512) != 0 ? r2.blindBoxAgreementVersion : null, (i3 & 1024) != 0 ? r2.qShopProductAgreementVersion : null, (i3 & 2048) != 0 ? r2.qShopPrivacyAgreementVersion : null, (i3 & 4096) != 0 ? r2.goodsLabelInfoList : null, (i3 & 8192) != 0 ? r2.boxOrderIds : null, (i3 & 16384) != 0 ? this.$orderDetail.deliveryMessage : null);
                mutableLiveData3.setValue(a16);
                mutableLiveData2 = this.this$0._pageState;
                mutableLiveData2.setValue(ECOrderSubmitViewModel.g.d.f103528a);
                return Unit.INSTANCE;
            }
            ECOrderSubmitViewModel eCOrderSubmitViewModel = this.this$0;
            OrderSubmitDetailInfo orderSubmitDetailInfo = this.$orderDetail;
            this.label = 1;
            p26 = eCOrderSubmitViewModel.p2(orderSubmitDetailInfo, eCAddress, this);
            if (p26 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            p26 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AddressCheckResult addressCheckResult = (AddressCheckResult) p26;
        MutableLiveData mutableLiveData4 = this.this$0._isAddressReachable;
        if (addressCheckResult != null && (boxBoolean = Boxing.boxBoolean(addressCheckResult.isReachable)) != null) {
            z16 = boxBoolean.booleanValue();
        }
        mutableLiveData4.setValue(Boxing.boxBoolean(z16));
        BulletinInfo bulletinInfo = addressCheckResult != null ? addressCheckResult.getBulletinInfo() : null;
        MutableLiveData mutableLiveData5 = this.this$0._orderSubmitDetailInfo;
        a17 = r3.a((i3 & 1) != 0 ? r3.orderId : null, (i3 & 2) != 0 ? r3.address : this.$address, (i3 & 4) != 0 ? r3.orderSkusDetail : null, (i3 & 8) != 0 ? r3.supportPayType : null, (i3 & 16) != 0 ? r3.selectedPayType : null, (i3 & 32) != 0 ? r3.priceInfo : null, (i3 & 64) != 0 ? r3.bulletinInfo : bulletinInfo, (i3 & 128) != 0 ? r3.enableCoupon : false, (i3 & 256) != 0 ? r3.couponInfo : null, (i3 & 512) != 0 ? r3.blindBoxAgreementVersion : null, (i3 & 1024) != 0 ? r3.qShopProductAgreementVersion : null, (i3 & 2048) != 0 ? r3.qShopPrivacyAgreementVersion : null, (i3 & 4096) != 0 ? r3.goodsLabelInfoList : null, (i3 & 8192) != 0 ? r3.boxOrderIds : null, (i3 & 16384) != 0 ? this.$orderDetail.deliveryMessage : null);
        mutableLiveData5.setValue(a17);
        if (bulletinInfo != null) {
            OrderSubmitDetailInfo orderSubmitDetailInfo2 = (OrderSubmitDetailInfo) this.this$0._orderSubmitDetailInfo.getValue();
            OrderSkuDetail orderSkuDetail = orderSubmitDetailInfo2 != null ? orderSubmitDetailInfo2.orderSkusDetail : null;
            com.tencent.ecommerce.biz.bulletin.b bVar = com.tencent.ecommerce.biz.bulletin.b.f101349a;
            String str4 = "";
            if (orderSkuDetail == null || (orderShop = orderSkuDetail.shop) == null || (str = orderShop.id) == null) {
                str = "";
            }
            if (orderSkuDetail == null || (str2 = orderSkuDetail.skuId) == null) {
                str2 = "";
            }
            if (orderSubmitDetailInfo2 != null && (str3 = orderSubmitDetailInfo2.orderId) != null) {
                str4 = str3;
            }
            bVar.d(str, str2, BulletinScene.ORDER_SUBMIT_PAGE, str4);
        }
        mutableLiveData2 = this.this$0._pageState;
        mutableLiveData2.setValue(ECOrderSubmitViewModel.g.d.f103528a);
        return Unit.INSTANCE;
    }
}
