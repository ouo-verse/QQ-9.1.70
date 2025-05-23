package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailBuyFloatPageInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailSkuInfoData;
import com.tencent.ecommerce.biz.detail.utils.f;
import java.util.List;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel$requestPtsData$1", f = "ECShopDetailSkuInfoViewModel.kt", i = {}, l = {79, 88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopDetailSkuInfoViewModel$requestPtsData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ECShopDetailSkuInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopDetailSkuInfoViewModel$requestPtsData$1(ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopDetailSkuInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopDetailSkuInfoViewModel$requestPtsData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopDetailSkuInfoViewModel$requestPtsData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        JSONObject infoData;
        Boolean boxBoolean;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopProductDetailSkuInfoData c26 = this.this$0.c2();
            this.label = 1;
            obj = c26.l(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    eCShopDetailSkuInfoViewModel = (ECShopDetailSkuInfoViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    eCShopDetailSkuInfoViewModel.j2((ECShopProductDetailBuyFloatPageInfo) obj);
                    ECShopProductDetailBuyFloatPageInfo floatSkuInfoData = this.this$0.getFloatSkuInfoData();
                    boolean booleanValue = (floatSkuInfoData != null || (infoData = floatSkuInfoData.getInfoData()) == null || (boxBoolean = Boxing.boxBoolean(f.d(infoData))) == null) ? false : boxBoolean.booleanValue();
                    mutableLiveData3 = this.this$0._isSoldOutStatus;
                    mutableLiveData3.postValue(Boxing.boxBoolean(this.this$0.c2().d()));
                    mutableLiveData4 = this.this$0._isDiscountActiveSoldOutStatus;
                    mutableLiveData4.postValue(Boxing.boxBoolean(booleanValue));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        mutableLiveData = this.this$0._productDetailData;
        mutableLiveData.postValue(jSONObject);
        List<ECBasePtsViewData> h16 = this.this$0.c2().h(jSONObject);
        mutableLiveData2 = this.this$0._adapterPtsData;
        mutableLiveData2.postValue(h16);
        ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel2 = this.this$0;
        eCShopDetailSkuInfoViewModel2._isActiveSoldOutStatus = eCShopDetailSkuInfoViewModel2.c2().c();
        ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel3 = this.this$0;
        ECShopProductDetailSkuInfoData c27 = eCShopDetailSkuInfoViewModel3.c2();
        this.L$0 = eCShopDetailSkuInfoViewModel3;
        this.label = 2;
        Object m3 = c27.m(this);
        if (m3 == coroutine_suspended) {
            return coroutine_suspended;
        }
        eCShopDetailSkuInfoViewModel = eCShopDetailSkuInfoViewModel3;
        obj = m3;
        eCShopDetailSkuInfoViewModel.j2((ECShopProductDetailBuyFloatPageInfo) obj);
        ECShopProductDetailBuyFloatPageInfo floatSkuInfoData2 = this.this$0.getFloatSkuInfoData();
        if (floatSkuInfoData2 != null) {
        }
        mutableLiveData3 = this.this$0._isSoldOutStatus;
        mutableLiveData3.postValue(Boxing.boxBoolean(this.this$0.c2().d()));
        mutableLiveData4 = this.this$0._isDiscountActiveSoldOutStatus;
        mutableLiveData4.postValue(Boxing.boxBoolean(booleanValue));
        return Unit.INSTANCE;
    }
}
