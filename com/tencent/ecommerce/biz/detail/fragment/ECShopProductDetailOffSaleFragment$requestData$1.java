package com.tencent.ecommerce.biz.detail.fragment;

import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailOffSaleViewModel;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailOffSaleFragment$requestData$1", f = "ECShopProductDetailOffSaleFragment.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailOffSaleFragment$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopProductDetailOffSaleFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailOffSaleFragment$requestData$1(ECShopProductDetailOffSaleFragment eCShopProductDetailOffSaleFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailOffSaleFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailOffSaleFragment$requestData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailOffSaleFragment$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONArray jSONArray = new JSONArray();
            str = this.this$0.spuId;
            jSONArray.mo162put(str);
            JSONObject jSONObject = new JSONObject();
            str2 = this.this$0.spuId;
            jSONObject.put("spu_id", str2);
            str3 = this.this$0.shopId;
            jSONObject.put("shop_id", str3);
            jSONObject.put("spu_ids", jSONArray);
            str4 = this.this$0.activeId;
            jSONObject.put("active_id", str4);
            JSONObject jSONObject2 = new JSONObject();
            str5 = this.this$0.spuId;
            jSONObject2.put("spu_id", str5);
            jSONObject2.put("spu_ids", jSONArray);
            str6 = this.this$0.activeId;
            jSONObject2.put("active_id", str6);
            str7 = this.this$0.activeId;
            if (str7.length() == 0) {
                str8 = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailByBuyer";
            } else {
                str8 = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetActiveProductDetailByBuyer";
            }
            String str9 = str8;
            ECShopProductDetailOffSaleViewModel Zh = ECShopProductDetailOffSaleFragment.Zh(this.this$0);
            this.label = 1;
            if (Zh.C2("trpc.ecom.qq_shop_detail_svr.ProductCard", str9, jSONObject, jSONObject2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
