package ej0;

import ck0.Product;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.repo.live.ActivityPrice;
import com.tencent.ecommerce.repo.live.ActivitySellingPoint;
import com.tencent.ecommerce.repo.live.ECShopExt;
import com.tencent.ecommerce.repo.live.FeedSellingPoints;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveCouponInfo;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 82\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b6\u00107J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b#\u0010\u0012R\"\u0010&\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b%\u0010\u0012R(\u0010/\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b\r\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lej0/d;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "liveShowWindowProduct", "productJson", "Lcom/tencent/ecommerce/repo/live/l;", "a", "Lcom/tencent/ecommerce/repo/live/o;", "b", "data", "", "decodeData", "", "d", "I", h.F, "()I", "setTotal", "(I)V", "total", "", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setCookie", "(Ljava/lang/String;)V", "cookie", "f", "Z", "i", "()Z", "setEnd", "(Z)V", "isEnd", "setLiveProductCountLimit", "liveProductCountLimit", "setLiveProductSelectedCount", "liveProductSelectedCount", "", "Lck0/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "g", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "products", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", "<init>", "()V", "D", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class d implements IECResponse {

    /* renamed from: C, reason: from kotlin metadata */
    private JSONObject dataJson;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int liveProductSelectedCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String cookie = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int liveProductCountLimit = -1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<Product> products = new ArrayList();

    private final LiveActivity a(JSONObject liveShowWindowProduct, JSONObject productJson) {
        ActivitySellingPoint discountSellingPoint;
        JSONObject optJSONObject = liveShowWindowProduct.optJSONObject(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String str = null;
        LiveActivity a16 = optJSONObject != null ? LiveActivity.INSTANCE.a(optJSONObject) : null;
        if (a16 != null) {
            productJson.put("is_activity_shop_product", a16.getActivityId().length() > 0);
            productJson.put("activity_info", a16.getActivityInfo());
            com.tencent.ecommerce.biz.live.a aVar = com.tencent.ecommerce.biz.live.a.f102661d;
            ActivityPrice activityPrice = a16.getActivityPrice();
            productJson.put("activity_live_price", aVar.i(activityPrice != null ? activityPrice.getLiveSpecialPrice() : 0L));
            ActivityPrice activityPrice2 = a16.getActivityPrice();
            productJson.put("product_origin_price", aVar.i(activityPrice2 != null ? activityPrice2.livePrice : 0L));
            productJson.put("activity_stock_remain", "\u9650\u91cf" + a16.getActivityStock().activityRemain + '\u4ef6');
            FeedSellingPoints feedSellPoints = a16.getFeedSellPoints();
            if (feedSellPoints != null && (discountSellingPoint = feedSellPoints.getDiscountSellingPoint()) != null) {
                str = discountSellingPoint.label;
            }
            productJson.put("discount_price", str);
            productJson.put("activity_type", a16.getActivityType().value);
        }
        return a16;
    }

    private final LiveCouponInfo b(JSONObject liveShowWindowProduct, JSONObject productJson) {
        JSONObject optJSONObject = liveShowWindowProduct.optJSONObject("coupon");
        LiveCouponInfo a16 = LiveCouponInfo.INSTANCE.a(optJSONObject);
        if (a16 != null) {
            productJson.put("coupon", optJSONObject);
            productJson.put("discount_price", a16.getPriceWithCoupon().getPricesPre());
            productJson.put("activity_live_price", a16.getPriceWithCoupon().pricesTxt);
        }
        return a16;
    }

    /* renamed from: c, reason: from getter */
    public final String getCookie() {
        return this.cookie;
    }

    /* renamed from: d, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: e, reason: from getter */
    public final int getLiveProductCountLimit() {
        return this.liveProductCountLimit;
    }

    /* renamed from: f, reason: from getter */
    public final int getLiveProductSelectedCount() {
        return this.liveProductSelectedCount;
    }

    public final List<Product> g() {
        return this.products;
    }

    /* renamed from: h, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        ECShopExt eCShopExt;
        cg0.a.b("ECLiveQShopShowWindowGetProductRsp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        this.dataJson = data;
        this.total = data.optInt("total");
        this.cookie = data.optString("cookie");
        this.isEnd = data.optBoolean("is_end");
        this.liveProductCountLimit = data.optInt("live_window_limit", -1);
        this.liveProductSelectedCount = data.optInt("live_window_total");
        JSONArray optJSONArray = data.optJSONArray("products");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                JSONObject optJSONObject = jSONObject.optJSONObject("product");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("style_info");
                if (optJSONObject2 != null && optJSONObject != null) {
                    optJSONObject.put("style_info", optJSONObject2);
                }
                LiveShowItem a16 = optJSONObject2 != null ? LiveShowItem.INSTANCE.a(optJSONObject2.optJSONObject("live_active_style_info")) : null;
                LiveShowItem a17 = optJSONObject2 != null ? LiveShowItem.INSTANCE.a(optJSONObject2.optJSONObject("coupon_style_info")) : null;
                LiveShowItem a18 = optJSONObject2 != null ? LiveShowItem.INSTANCE.a(optJSONObject2.optJSONObject("normal_style_info")) : null;
                LiveCouponInfo b16 = optJSONObject != null ? b(jSONObject, optJSONObject) : null;
                LiveActivity a19 = optJSONObject != null ? a(jSONObject, optJSONObject) : null;
                JSONObject optJSONObject3 = jSONObject.optJSONObject("qshop_product_extra");
                ECShopExt eCShopExt2 = optJSONObject3 != null ? new ECShopExt(optJSONObject3.optString("shop_id"), optJSONObject3.optString("spu_id"), optJSONObject3.optString("sku_id"), a19, b16, a16, a17, a18) : null;
                if (eCShopExt2 == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("error, shopExt is null, productId=");
                    sb5.append(optJSONObject != null ? optJSONObject.optString("media_product_id") : null);
                    cg0.a.a("ECLiveQShopShowWindowGetProductRsp", "decodeData", sb5.toString());
                    eCShopExt = new ECShopExt("", "", "", null, null, null, null, null, 248, null);
                } else {
                    eCShopExt = eCShopExt2;
                }
                if (optJSONObject != null) {
                    optJSONObject.put("page_name", "live_window_product_card");
                }
                fj0.c cVar = fj0.c.f399474a;
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                Product c16 = cVar.c(optJSONObject, false, true, true, false, eCShopExt);
                c16.K(true);
                c16.V(jSONObject.optBoolean("is_selected"));
                this.products.add(c16);
            }
        }
        return true;
    }
}
