package com.tencent.ecommerce.biz.detail.fragment;

import android.text.TextUtils;
import ck0.Product;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.ecommerce.biz.detail.utils.c;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageHostViewModel;
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
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECDetailHostPageFragment$requestData$1", f = "ECDetailHostPageFragment.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECDetailHostPageFragment$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECDetailHostPageFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECDetailHostPageFragment$requestData$1(ECDetailHostPageFragment eCDetailHostPageFragment, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCDetailHostPageFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECDetailHostPageFragment$requestData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECDetailHostPageFragment$requestData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        c cVar;
        String str;
        Long boxLong;
        Long boxLong2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("saas_type", this.this$0.saasType);
            jSONObject.put("saas_product_id", this.this$0.saasProductId);
            if (!TextUtils.isEmpty(this.this$0.goodsType)) {
                jSONObject.put("goods_type", this.this$0.goodsType);
            }
            ECDetailPageHostViewModel ji5 = this.this$0.ji();
            this.label = 1;
            if (ji5.j2("trpc.ecom.shop_product_detail_server.ProductInfo", "/trpc.ecom.shop_product_detail_server.ProductInfo/GetProductDetailBySeller", jSONObject, jSONObject, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        cVar = this.this$0.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        if (cVar != null) {
            d.f102466a.f(cVar, null, "product_details_page_exp");
        }
        Product value = this.this$0.ji().b2().getValue();
        if (value == null || (str = value.getSaasProductId()) == null) {
            str = "";
        }
        String str2 = str;
        String str3 = this.this$0.saasType;
        Product value2 = this.this$0.ji().b2().getValue();
        long j3 = 0;
        long longValue = (value2 == null || (boxLong2 = Boxing.boxLong(value2.getPrice())) == null) ? 0L : boxLong2.longValue();
        Product value3 = this.this$0.ji().b2().getValue();
        if (value3 != null && (boxLong = Boxing.boxLong(value3.getCommission())) != null) {
            j3 = boxLong.longValue();
        }
        g.b(str2, str3, longValue, j3);
        this.this$0.ri();
        return Unit.INSTANCE;
    }
}
