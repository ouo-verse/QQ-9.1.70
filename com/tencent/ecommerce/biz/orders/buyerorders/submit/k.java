package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponOrderInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$OrderPageDetailRsp;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a(\u0010\f\u001a\u00020\u000b*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$OrderPageDetailRsp;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "payType", "", "addressIsEmpty", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$f;", "b", "", "action", GetAdInfoRequest.SOURCE_FROM, "contentId", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class k {
    public static final void a(ECOrderSubmitViewModel.OrderSubmitReportInfo orderSubmitReportInfo, String str, String str2, String str3) {
        String str4;
        String joinToString$default;
        String joinToString$default2;
        com.tencent.ecommerce.biz.common.e b16 = new com.tencent.ecommerce.biz.common.e().b("seller_id", orderSubmitReportInfo.sellerId).b("shop_id", orderSubmitReportInfo.shopId).b("spu_id", orderSubmitReportInfo.spuId).b("sku_id", orderSubmitReportInfo.skuId).b("source_from", str2).b("pri_sort_id", orderSubmitReportInfo.priSortId);
        if (orderSubmitReportInfo.addressIsEmpty) {
            str4 = "0";
        } else {
            str4 = "1";
        }
        com.tencent.ecommerce.biz.common.e b17 = b16.b("address_is_empty", str4).b("activity_id", orderSubmitReportInfo.activityId);
        ECOrderSubmitViewModel.CouponReportInfo couponReportInfo = orderSubmitReportInfo.couponInfo;
        if (couponReportInfo != null) {
            com.tencent.ecommerce.biz.common.e b18 = b17.b("is_coupon", "1");
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(couponReportInfo.c(), ";", null, null, 0, null, null, 62, null);
            com.tencent.ecommerce.biz.common.e b19 = b18.b("coupon_owner", joinToString$default);
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(couponReportInfo.a(), ";", null, null, 0, null, null, 62, null);
            b19.b("related_batch_coupon_id", joinToString$default2).b("off_price", String.valueOf(couponReportInfo.getDiscountInFen()));
        } else {
            b17.b("is_coupon", "0");
        }
        if (str3 != null) {
            b17.b("content_id", str3);
        }
        PayType payType = orderSubmitReportInfo.payType;
        if (payType != null) {
            b17.b("payment_method", String.valueOf(payType.id));
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, str, b17.f(), false, 4, null);
    }

    public static final ECOrderSubmitViewModel.OrderSubmitReportInfo b(ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, PayType payType, boolean z16) {
        String jSONObject;
        String str;
        ECOrderSubmitViewModel.CouponReportInfo couponReportInfo;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (eCQshopOrderQuerySvr$OrderPageDetailRsp.page_biz_popup.has()) {
            jSONObject = eCQshopOrderQuerySvr$OrderPageDetailRsp.page_biz_popup.refresh_req_ext.get();
        } else {
            jSONObject = ug0.b.f438933d.f().toString();
        }
        try {
            str = new JSONObject(jSONObject).optString("active_id");
        } catch (JSONException unused) {
            cg0.a.a("ECOrderSubmitViewModel", "toOrderSubmitReportInfo", "pageExt error: " + jSONObject);
            str = "";
        }
        String str2 = str;
        List<ECQshopOrderQuerySvr$CouponOrderInfo> list = eCQshopOrderQuerySvr$OrderPageDetailRsp.coupon_info.get().coupon_order_info.get();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ECQshopOrderQuerySvr$CouponOrderInfo) obj).is_user_select.get()) {
                arrayList.add(obj);
            }
        }
        if (com.tencent.ecommerce.base.ktx.c.a(arrayList)) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ECQshopOrderQuerySvr$CouponOrderInfo) it.next()).coupon_show_info.basic_info.issuer.f105226id.get());
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList3.add(((ECQshopOrderQuerySvr$CouponOrderInfo) it5.next()).coupon_show_info.coupon_batch_id.get());
            }
            couponReportInfo = new ECOrderSubmitViewModel.CouponReportInfo(arrayList2, arrayList3, eCQshopOrderQuerySvr$OrderPageDetailRsp.discount.get());
        } else {
            couponReportInfo = null;
        }
        return new ECOrderSubmitViewModel.OrderSubmitReportInfo(eCQshopOrderQuerySvr$OrderPageDetailRsp.seller_id.get(), eCQshopOrderQuerySvr$OrderPageDetailRsp.shop_info.shop_id.get(), eCQshopOrderQuerySvr$OrderPageDetailRsp.product_cart.order_sku.spu.spu_id.get(), eCQshopOrderQuerySvr$OrderPageDetailRsp.product_cart.order_sku.sku.sku_id.get(), eCQshopOrderQuerySvr$OrderPageDetailRsp.product_cart.order_sku.spu.category.first_cat_id.get(), str2, couponReportInfo, z16, payType);
    }

    public static /* synthetic */ ECOrderSubmitViewModel.OrderSubmitReportInfo c(ECQshopOrderQuerySvr$OrderPageDetailRsp eCQshopOrderQuerySvr$OrderPageDetailRsp, PayType payType, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            payType = null;
        }
        return b(eCQshopOrderQuerySvr$OrderPageDetailRsp, payType, z16);
    }
}
