package ii0;

import com.tencent.ecommerce.biz.hr.module.e;
import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponBasicInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponShowInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponShowStyleInfo;
import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$Issuer;
import com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$ShowDiscount;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponInfo;
import com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr.ECQshopOrderQuerySvr$CouponOrderInfo;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\t\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\r\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponInfo;", "", "a", "Lorg/json/JSONObject;", "g", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_query_svr/ECQshopOrderQuerySvr$CouponOrderInfo;", h.F, "Lcom/tencent/ecommerce/repo/proto/ecom/common_coupon_common/ECCouponCommon$CouponShowInfo;", "c", "Lcom/tencent/ecommerce/repo/proto/ecom/common_coupon_common/ECCouponCommon$CouponBasicInfo;", "b", "Lcom/tencent/ecommerce/repo/proto/ecom/common_coupon_common/ECCouponCommon$Issuer;", "e", "Lcom/tencent/ecommerce/repo/proto/ecom/common_coupon_common/ECCouponCommon$CouponShowStyleInfo;", "d", "Lcom/tencent/ecommerce/repo/proto/ecom/common_coupon_common/ECCouponCommon$ShowDiscount;", "f", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final void a(ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo) {
        if (eCQshopOrderQuerySvr$CouponInfo == null) {
            e.f102613b.c("select_coupon_info");
        } else {
            e.f102613b.b("select_coupon_info", g(eCQshopOrderQuerySvr$CouponInfo).toString());
        }
    }

    public static final JSONObject b(ECCouponCommon$CouponBasicInfo eCCouponCommon$CouponBasicInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("issuer", e(eCCouponCommon$CouponBasicInfo.issuer.get()));
        return jSONObject;
    }

    public static final JSONObject c(ECCouponCommon$CouponShowInfo eCCouponCommon$CouponShowInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("basic_info", b(eCCouponCommon$CouponShowInfo.basic_info.get()));
        jSONObject.put("coupon_list_style", d(eCCouponCommon$CouponShowInfo.coupon_list_style.get()));
        return jSONObject;
    }

    public static final JSONObject d(ECCouponCommon$CouponShowStyleInfo eCCouponCommon$CouponShowStyleInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("coupon_type_name", eCCouponCommon$CouponShowStyleInfo.coupon_type_name.get());
        jSONObject.put("coupon_issuer_name", eCCouponCommon$CouponShowStyleInfo.coupon_issuer_name.get());
        jSONObject.put("coupon_usable_range", eCCouponCommon$CouponShowStyleInfo.coupon_usable_range.get());
        jSONObject.put("coupon_use_rule", eCCouponCommon$CouponShowStyleInfo.coupon_use_rule.get());
        jSONObject.put("coupon_time_scope", eCCouponCommon$CouponShowStyleInfo.coupon_time_scope.get());
        jSONObject.put("coupon_show_discount", f(eCCouponCommon$CouponShowStyleInfo.coupon_show_discount.get()));
        return jSONObject;
    }

    public static final JSONObject e(ECCouponCommon$Issuer eCCouponCommon$Issuer) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", eCCouponCommon$Issuer.type.get());
        jSONObject.put("id", eCCouponCommon$Issuer.f105226id.get());
        jSONObject.put("name", eCCouponCommon$Issuer.name.get());
        return jSONObject;
    }

    public static final JSONObject f(ECCouponCommon$ShowDiscount eCCouponCommon$ShowDiscount) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("discount_amount", eCCouponCommon$ShowDiscount.discount_amount.get());
        jSONObject.put("discount_threshold", eCCouponCommon$ShowDiscount.discount_threshold.get());
        jSONObject.put("type", eCCouponCommon$ShowDiscount.type.get());
        return jSONObject;
    }

    public static final JSONObject g(ECQshopOrderQuerySvr$CouponInfo eCQshopOrderQuerySvr$CouponInfo) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = eCQshopOrderQuerySvr$CouponInfo.coupon_order_info.get().iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(h((ECQshopOrderQuerySvr$CouponOrderInfo) it.next()));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("coupon_order_info", jSONArray);
        jSONObject.put("is_best_discount", eCQshopOrderQuerySvr$CouponInfo.is_best_discount.get());
        jSONObject.put("discount_price", eCQshopOrderQuerySvr$CouponInfo.discount_price.get());
        jSONObject.put("can_use_coupon_num", eCQshopOrderQuerySvr$CouponInfo.can_use_coupon_num.get());
        return jSONObject;
    }

    public static final JSONObject h(ECQshopOrderQuerySvr$CouponOrderInfo eCQshopOrderQuerySvr$CouponOrderInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("coupon_show_info", c(eCQshopOrderQuerySvr$CouponOrderInfo.coupon_show_info.get()));
        jSONObject.put("coupon_id", eCQshopOrderQuerySvr$CouponOrderInfo.coupon_id.get());
        jSONObject.put("is_in_best_options", eCQshopOrderQuerySvr$CouponOrderInfo.is_in_best_options.get());
        jSONObject.put("is_user_select", eCQshopOrderQuerySvr$CouponOrderInfo.is_user_select.get());
        jSONObject.put("can_use", eCQshopOrderQuerySvr$CouponOrderInfo.can_use.get());
        return jSONObject;
    }
}
