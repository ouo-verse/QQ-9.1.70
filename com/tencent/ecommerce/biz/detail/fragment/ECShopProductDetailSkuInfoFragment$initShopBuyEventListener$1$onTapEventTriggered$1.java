package com.tencent.ecommerce.biz.detail.fragment;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.SkuInfoType;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportCouponParams;
import com.tencent.ecommerce.biz.shophome.util.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1", f = "ECShopProductDetailSkuInfoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1(ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1 eCShopProductDetailSkuInfoFragment$initShopBuyEventListener$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailSkuInfoFragment$initShopBuyEventListener$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1$onTapEventTriggered$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String sb5;
        String str2;
        Map map;
        String str3;
        String str4;
        boolean z16;
        String str5;
        String str6;
        String str7;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject k3 = this.this$0.f102250a.mi().c2().k();
            String optString = k3.optString("sku_id", "");
            long optLong = k3.optLong("sku_num", 0L);
            JSONObject optJSONObject = k3.optJSONObject("sku_price");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (optString == null || optString.length() == 0) {
                return Unit.INSTANCE;
            }
            SkuInfoType type = this.this$0.f102250a.mi().getType();
            SkuInfoType skuInfoType = SkuInfoType.SAMPLE;
            if (type == skuInfoType) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("mqqapi://ecommerce/open?target=52&page_name=apply_sample_order_submit_page");
                sb6.append("&channel=");
                str5 = this.this$0.f102250a.channel;
                sb6.append(str5);
                sb6.append("&shop_id=");
                str6 = this.this$0.f102250a.shopId;
                sb6.append(str6);
                sb6.append("&spu_id=");
                sb6.append(this.this$0.f102250a.spuId);
                sb6.append("&sku_id=");
                sb6.append(optString);
                sb6.append("&token=");
                str7 = this.this$0.f102250a.token;
                sb6.append(str7);
                sb6.append("&count=1");
                sb5 = sb6.toString();
            } else {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("mqqapi://ecommerce/open?target=22&channel=");
                str = this.this$0.f102250a.channel;
                sb7.append(str);
                sb7.append("&sku_id=");
                sb7.append(optString);
                sb7.append("&spu_id=");
                sb7.append(this.this$0.f102250a.spuId);
                sb7.append("&sku_num=");
                sb7.append(optLong);
                sb7.append("&src_type=internal&version=1&active_id=");
                sb7.append(this.this$0.f102250a.activeId);
                sb5 = sb7.toString();
            }
            if (this.this$0.f102250a.mi().getType() != skuInfoType) {
                z16 = this.this$0.f102250a.isFloatMode;
                if (z16) {
                    sb5 = sb5 + "&is_trans_activity=1";
                }
            }
            str2 = this.this$0.f102250a.adClickId;
            if (str2.length() > 0) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(sb5);
                sb8.append("&qz_gdt=");
                str4 = this.this$0.f102250a.adClickId;
                sb8.append(str4);
                sb5 = sb8.toString();
            }
            if (this.this$0.f102250a.sourceFrom.length() > 0) {
                sb5 = sb5 + "&source_from=" + this.this$0.f102250a.sourceFrom;
            }
            if (this.this$0.f102250a.mi().getType() == skuInfoType) {
                b bVar = b.f100913b;
                e eVar = new e();
                str3 = this.this$0.f102250a.shopId;
                eVar.b("shop_id", str3);
                eVar.b("spu_id", this.this$0.f102250a.spuId);
                IECDataReport.a.a(bVar, "qstore_sample_sku_select_apply_clk", eVar.f(), false, 4, null);
            } else {
                JSONObject value = this.this$0.f102250a.mi().b2().getValue();
                if (value == null) {
                    value = new JSONObject();
                }
                ECShopReportCouponParams b16 = a.f104379a.b(value);
                b16.b(optJSONObject.optLong("off_price", 0L) * optLong);
                d.f102466a.b("qstore_prd_detail_pg_sku_select_confirm", this.this$0.f102250a.spuId, this.this$0.f102250a.contentId, this.this$0.f102250a.sourceFrom, this.this$0.f102250a.activeId, this.this$0.f102250a.activeType, b16);
            }
            map = this.this$0.f102250a.extUserDataMap;
            ECScheme.e(sb5, map);
            ECShopProductDetailSkuInfoFragment.Th(this.this$0.f102250a).E();
            cg0.a.b("ECShopProductDetailSkuInfoFragment", "[onTapEventTriggered] jumpUrl=" + sb5);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
