package com.tencent.ecommerce.biz.common;

import android.text.TextUtils;
import ck0.Category;
import ck0.Product;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J0\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002JH\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/common/d;", "", "", "busId", "eventCode", "", "windowType", "", "c", "b", "sellerId", "buyerId", GetAdInfoRequest.SOURCE_FROM, "a", "Lck0/c;", "product", "Lorg/json/JSONArray;", "currentCardFilters", "e", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f101554a = new d();

    d() {
    }

    public final void a(String busId, String sellerId, String buyerId, String sourceFrom, String eventCode) {
        Map<Object, Object> f16 = new e().a(busId).d(sellerId).b("buyer_id", buyerId).b("source_from", sourceFrom).f();
        cg0.a.b("ECPageReportUtil", "[reportCustomWindowPageExp] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void b(String busId, String eventCode, int windowType) {
        e e16 = e.e(new e().a(busId), null, 1, null);
        if (windowType != 0) {
            e16.b("window_type", String.valueOf(windowType));
        }
        Map<Object, Object> f16 = e16.f();
        cg0.a.b("ECPageReportUtil", "[reportPageExit] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void c(String busId, String eventCode, int windowType) {
        e e16 = e.e(new e().a(busId), null, 1, null);
        if (windowType != 0) {
            e16.b("window_type", String.valueOf(windowType));
        }
        Map<Object, Object> f16 = e16.f();
        cg0.a.b("ECPageReportUtil", "[reportPageExp] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String busId, Product product, String eventCode, String sellerId, String buyerId, int windowType, JSONArray currentCardFilters) {
        String str;
        String str2;
        boolean contains$default;
        boolean z16;
        JSONObject dataJson;
        JSONObject dataJson2;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        boolean contains$default2;
        JSONObject optJSONObject3;
        e b16 = e.e(new e().a(busId), null, 1, null).b("media_product_id", product.getMediaProductId()).b("saas_id", product.getSaasTypeStr()).b(ReportDataBuilder.KEY_PRODUCT_ID, product.getSaasProductId()).b("product_name", product.getTitle());
        Category category = product.getCategory();
        if (category == null || (str = String.valueOf(category.id)) == null) {
            str = "";
        }
        e b17 = b16.b("pri_sort_id", str).b("product_sales", String.valueOf(product.getSales())).b("goods_type", String.valueOf(product.getGoodsType()));
        JSONObject dataJson3 = product.getDataJson();
        if (dataJson3 == null || (optJSONObject3 = dataJson3.optJSONObject(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) == null || (str2 = String.valueOf(optJSONObject3.optInt("type", 0))) == null) {
            str2 = "";
        }
        e b18 = b17.b("is_miaosha", str2).b("window_type", String.valueOf(windowType));
        if (product.getGoodsType() == 3) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) product.getSaasProductId(), (CharSequence) "txvideovip", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) product.getSaasProductId(), (CharSequence) "txvideojdunion", false, 2, (Object) null);
                if (!contains$default2) {
                    z16 = false;
                    b18.b("txvideo_type", String.valueOf(z16 ? 1 : 2));
                    dataJson = product.getDataJson();
                    if (dataJson != null || (optJSONObject2 = dataJson.optJSONObject("commission_range")) == null || (r3 = optJSONObject2.toString()) == null) {
                        String str3 = "";
                    }
                    b18.b("commission_range", str3);
                    dataJson2 = product.getDataJson();
                    if (dataJson2 != null || (optJSONObject = dataJson2.optJSONObject("price_range")) == null || (r3 = optJSONObject.toString()) == null) {
                        String str4 = "";
                    }
                    b18.b("price_range", str4);
                }
            }
            z16 = true;
            b18.b("txvideo_type", String.valueOf(z16 ? 1 : 2));
            dataJson = product.getDataJson();
            if (dataJson != null) {
            }
            String str32 = "";
            b18.b("commission_range", str32);
            dataJson2 = product.getDataJson();
            if (dataJson2 != null) {
            }
            String str42 = "";
            b18.b("price_range", str42);
        } else {
            b18.b("commission", String.valueOf(product.getCommission()));
            b18.b("product_price", String.valueOf(product.getPrice()));
        }
        if (!TextUtils.isEmpty(sellerId)) {
            b18.d(sellerId);
        }
        if (currentCardFilters != null) {
            b18.b("current_card_filters", currentCardFilters.toString());
        }
        JSONObject dataJson4 = product.getDataJson();
        JSONArray optJSONArray = dataJson4 != null ? dataJson4.optJSONArray("prices") : null;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            long optLong = optJSONArray.optLong(0);
            long optLong2 = optJSONArray.optLong(optJSONArray.length() - 1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lower", optLong);
            jSONObject.put("upper", optLong2);
            b18.b("price_range", jSONObject.toString());
        }
        JSONObject dataJson5 = product.getDataJson();
        JSONArray optJSONArray2 = dataJson5 != null ? dataJson5.optJSONArray("commissions") : null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            long optLong3 = optJSONArray2.optLong(0);
            long optLong4 = optJSONArray2.optLong(optJSONArray2.length() - 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("lower", optLong3);
            jSONObject2.put("upper", optLong4);
            b18.b("commissions_range", jSONObject2.toString());
        }
        JSONObject ext = product.getExt();
        if (ext.length() > 0) {
            Iterator keys = ext.keys();
            while (keys.hasNext()) {
                String str5 = (String) keys.next();
                b18.b(str5.toString(), ext.optString(str5).toString());
            }
        }
        JSONObject dataJson6 = product.getDataJson();
        JSONObject optJSONObject4 = dataJson6 != null ? dataJson6.optJSONObject("qshop_active_info") : null;
        if (optJSONObject4 != null && optJSONObject4.length() > 0) {
            String optString = optJSONObject4.optString("active_id", "");
            int optInt = optJSONObject4.optInt("active_type", 0);
            b18.b("activity_id", optString);
            b18.b("activity_type", String.valueOf(optInt));
        }
        Map<Object, Object> f16 = b18.f();
        if (cg0.a.c()) {
            cg0.a.b("ECPageReportUtil", "[reportProductItemExpOrClick] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public static /* synthetic */ void d(d dVar, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        dVar.c(str, str2, i3);
    }
}
