package com.tencent.ecommerce.biz.orders.common;

import ak0.ECSellerOrder;
import android.text.TextUtils;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/d;", "", "", "eventCode", "Lak0/a;", "sellerOrder", WadlProxyConsts.CHANNEL, "mediaId", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f103680a = new d();

    d() {
    }

    public final void a(String eventCode, ECSellerOrder sellerOrder, String channel, String mediaId) {
        JSONObject jSONObject;
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        String str4;
        JSONObject jSONObject3 = sellerOrder.dataJSONObject;
        JSONObject optJSONObject2 = jSONObject3.optJSONObject("basic_info");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        JSONObject optJSONObject3 = jSONObject3.optJSONObject("commission_info");
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        com.tencent.ecommerce.biz.common.e e16 = com.tencent.ecommerce.biz.common.e.e(new com.tencent.ecommerce.biz.common.e().a(channel), null, 1, null);
        if (!Intrinsics.areEqual(jSONObject3.optString("saas_order_info"), "null")) {
            JSONObject optJSONObject4 = jSONObject3.optJSONObject("saas_order_info");
            if (optJSONObject4 == null || (jSONObject2 = optJSONObject4.optJSONObject("saas_product_info")) == null) {
                jSONObject2 = new JSONObject();
            }
            com.tencent.ecommerce.biz.common.e b16 = e16.b(ReportDataBuilder.KEY_PRODUCT_ID, jSONObject2.optString(ReportDataBuilder.KEY_PRODUCT_ID)).b("product_name", jSONObject2.optString("product_name")).b("product_price", jSONObject2.optString("product_price"));
            JSONObject optJSONObject5 = jSONObject3.optJSONObject("saas_order_info");
            if (optJSONObject5 == null || (str4 = optJSONObject5.optString("saas_type")) == null) {
                str4 = "";
            }
            b16.b("saas_id", str4);
        } else if (true ^ Intrinsics.areEqual(jSONObject3.optString("qshop_order_info"), "null")) {
            JSONObject optJSONObject6 = jSONObject3.optJSONObject("qshop_order_info");
            if (optJSONObject6 == null || (optJSONObject = optJSONObject6.optJSONObject("product_cart")) == null || (jSONObject = optJSONObject.optJSONObject("order_sku")) == null) {
                jSONObject = new JSONObject();
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("sku");
            if (optJSONObject7 == null || (str = optJSONObject7.optString("sku_id")) == null) {
                str = "";
            }
            JSONObject optJSONObject8 = jSONObject.optJSONObject("spu");
            if (optJSONObject8 == null || (str2 = optJSONObject8.optString("title")) == null) {
                str2 = "";
            }
            JSONObject optJSONObject9 = jSONObject.optJSONObject("sku");
            if (optJSONObject9 == null || (str3 = optJSONObject9.optString("price")) == null) {
                str3 = "";
            }
            e16.b(ReportDataBuilder.KEY_PRODUCT_ID, str).b("product_name", str2).b("product_price", str3);
        }
        e16.b("pri_sort_id", "").b("commission", optJSONObject3.optString("commission")).b("commission_proportion", optJSONObject3.optString("commission_rate")).b("order_price", optJSONObject2.optString("order_price")).b("order_id", optJSONObject2.optString("order_id")).b("goods_type", String.valueOf(optJSONObject2.optInt("goods_type"))).b("order_os", String.valueOf(optJSONObject2.optInt("os_type"))).b("order_status", optJSONObject2.optString("state")).b("date", optJSONObject2.optString(AlbumCacheData.CREATE_TIME));
        if (!TextUtils.isEmpty(mediaId)) {
            e16.d(mediaId);
        }
        Map<Object, Object> f16 = e16.f();
        if (cg0.a.c()) {
            cg0.a.b("ECOrderDataReport", "[reportSellerOrderItemExp] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }
}
