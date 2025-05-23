package com.tencent.ecommerce.biz.detail.fragment;

import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailCustomViewModel;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment$requestData$1", f = "ECShopProductDetailPageFragment.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailPageFragment$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopProductDetailPageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailPageFragment$requestData$1(ECShopProductDetailPageFragment eCShopProductDetailPageFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailPageFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailPageFragment$requestData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailPageFragment$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(this.this$0.spuId);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("spu_id", this.this$0.spuId);
            jSONObject.put("shop_id", this.this$0.shopId);
            jSONObject.put("spu_ids", jSONArray);
            jSONObject.put("active_id", this.this$0.activeId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("spu_id", this.this$0.spuId);
            jSONObject2.put("spu_ids", jSONArray);
            jSONObject2.put("active_id", this.this$0.activeId);
            if (this.this$0.activeId.length() == 0) {
                str = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailByBuyer";
            } else {
                str = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetActiveProductDetailByBuyer";
            }
            String str2 = str;
            ECShopProductDetailCustomViewModel ui5 = ECShopProductDetailPageFragment.ui(this.this$0);
            this.label = 1;
            if (ui5.C2("trpc.ecom.qq_shop_detail_svr.ProductCard", str2, jSONObject, jSONObject2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECShopProductDetailPageFragment.ui(this.this$0).y2(this.this$0.spuId);
        return Unit.INSTANCE;
    }
}
