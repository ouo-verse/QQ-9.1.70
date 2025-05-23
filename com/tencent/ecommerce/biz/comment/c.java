package com.tencent.ecommerce.biz.comment;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qzone.QzoneIPCModule;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J&\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/c;", "", "", "eventCode", "Lorg/json/JSONObject;", "orderData", WadlProxyConsts.CHANNEL, "", "b", "rating", "c", "", QzoneIPCModule.RESULT_CODE, "", "duration", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f101424a = new c();

    c() {
    }

    public final void a(int resultCode, long duration) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_comment_asset_upload", new com.tencent.ecommerce.biz.common.e().b("result_code", String.valueOf(resultCode)).b("duration", String.valueOf(duration)).f(), false, 4, null);
    }

    public final void b(String eventCode, JSONObject orderData, String channel) {
        String str;
        JSONObject optJSONObject = orderData.optJSONObject("basic_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = orderData.optJSONObject("product");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        JSONObject optJSONObject3 = orderData.optJSONObject("seller");
        if (optJSONObject3 == null || (str = optJSONObject3.optString("user_id")) == null) {
            str = "";
        }
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().a(channel).d(str).b("saas_id", optJSONObject.optString("saas_type")).b("order_id", optJSONObject.optString("order_id")).b("order_price", i.f104869a.c(optJSONObject.optString("order_price"))).b("goods_type", String.valueOf(optJSONObject.optInt("goods_type"))).b(ReportDataBuilder.KEY_PRODUCT_ID, optJSONObject2.optString(ReportDataBuilder.KEY_PRODUCT_ID)).b("product_name", optJSONObject2.optString("product_name")).b("product_amount", optJSONObject2.optString("product_num")).f();
        if (cg0.a.c()) {
            cg0.a.b("ECCommentPageDataReport", "[reportCommentPageExp] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void c(String eventCode, String rating, String channel, JSONObject orderData) {
        String str;
        JSONObject optJSONObject = orderData.optJSONObject("basic_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = orderData.optJSONObject("seller");
        if (optJSONObject2 == null || (str = optJSONObject2.optString("user_id")) == null) {
            str = "";
        }
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().a(channel).d(str).b("saas_id", optJSONObject.optString("saas_type")).b("rate", rating).b("goods_type", String.valueOf(optJSONObject.optInt("goods_type"))).f();
        if (cg0.a.c()) {
            cg0.a.b("ECCommentPageDataReport", "[reportCommitBtnClick] eventCode = " + eventCode + ", params = " + f16);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }
}
