package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.buyerorder.orderlist.ECQueryType;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b \b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u00020\u0016*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u00020\u0016*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010!\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u0018\u0010%\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010 R\u0018\u0010'\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010 R\u0018\u0010)\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010 R\u0018\u0010+\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010 R\u0018\u0010-\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010 R\u0018\u0010/\u001a\u00020\u0016*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0018\u00101\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010 R\u0018\u00103\u001a\u00020\u0004*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010 \u00a8\u00066"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/orderlist/ECOrderListReporter;", "", "Lorg/json/JSONObject;", "", "", "i", "", "B", "", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/repo/buyerorder/orderlist/ECQueryType;", "type", HippyTKDListViewAdapter.X, "orderInfo", "w", "v", "D", "eventType", "y", "", "a", "Ljava/util/Map;", "ptsEventTypeToReportBtnType", "k", "(Lorg/json/JSONObject;)I", "goodType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "refundState", "u", "(Lorg/json/JSONObject;)Ljava/lang/String;", "spuId", "t", "skuId", "r", "saasId", ReportConstant.COSTREPORT_PREFIX, "saasName", "o", "productName", "j", "firstCategoryId", "p", "productPrice", DomainData.DOMAIN_NAME, "orderStatus", "l", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "orderPrice", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderListReporter {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Integer> ptsEventTypeToReportBtnType;

    /* renamed from: b, reason: collision with root package name */
    public static final ECOrderListReporter f103395b = new ECOrderListReporter();

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cancelOrder", 0), TuplesKt.to("payGoods", 1), TuplesKt.to("viewShipping", 2), TuplesKt.to("confirmReceiveGoods", 3), TuplesKt.to("evaluateGoods", 4), TuplesKt.to("viewComment", 5), TuplesKt.to("buyAgain", 6), TuplesKt.to("updateAddress", 7), TuplesKt.to("copyOrderId", 8));
        ptsEventTypeToReportBtnType = mapOf;
    }

    ECOrderListReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        return (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("spu")) == null || (optJSONObject4 = optJSONObject3.optJSONObject("category")) == null || (optString = optJSONObject4.optString("first_cat_id")) == null) ? "" : optString;
    }

    private final int k(JSONObject jSONObject) {
        return jSONObject.optInt("goods_type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l(JSONObject jSONObject) {
        return jSONObject.optString("order_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(JSONObject jSONObject) {
        return jSONObject.optString("order_price");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(JSONObject jSONObject) {
        return jSONObject.optInt("state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        return (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("spu")) == null || (optString = optJSONObject3.optString("title")) == null) ? "" : optString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        return (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("sku")) == null || (optString = optJSONObject3.optString("price")) == null) ? "" : optString;
    }

    private final int q(JSONObject jSONObject) {
        return jSONObject.optInt("refund_state", -1);
    }

    private final String r(JSONObject jSONObject) {
        return jSONObject.optString("saas_id");
    }

    private final String s(JSONObject jSONObject) {
        return jSONObject.optString("saas_name");
    }

    private final String t(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        return (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("sku")) == null || (optString = optJSONObject3.optString("sku_id")) == null) ? "" : optString;
    }

    private final String u(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        String optString;
        JSONArray optJSONArray = jSONObject.optJSONArray("product_carts");
        return (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("order_sku")) == null || (optJSONObject3 = optJSONObject2.optJSONObject("spu")) == null || (optString = optJSONObject3.optString("spu_id")) == null) ? "" : optString;
    }

    public final void A() {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportPageExit$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_exit_by_customer", null, false, 4, null);
            }
        });
    }

    public final void B() {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_exp_to_customer", null, false, 4, null);
    }

    public final void C() {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportServiceClick$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_platform_customer_service_clk", null, false, 4, null);
            }
        });
    }

    public final void D(final JSONObject orderInfo) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportShopClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, String> i3;
                com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
                i3 = ECOrderListReporter.f103395b.i(JSONObject.this);
                IECDataReport.a.a(bVar, "order_list_order_card_top_clk", eVar.c(i3).f(), false, 4, null);
            }
        });
    }

    public final void v(final JSONObject orderInfo) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportCardClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, String> i3;
                com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
                i3 = ECOrderListReporter.f103395b.i(JSONObject.this);
                IECDataReport.a.a(bVar, "order_list_order_card_clk_by_customer", eVar.c(i3).f(), false, 4, null);
            }
        });
    }

    public final void w(final JSONObject orderInfo) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportCardExposure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map<String, String> i3;
                com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
                i3 = ECOrderListReporter.f103395b.i(JSONObject.this);
                IECDataReport.a.a(bVar, "order_list_order_card_exp_to_customer", eVar.c(i3).f(), false, 4, null);
            }
        });
    }

    public final void x(final ECQueryType type) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportListSelect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_order_sort_by_customer", new com.tencent.ecommerce.biz.common.e().b("order_sort_tab", String.valueOf(ECQueryType.this.type)).f(), false, 4, null);
            }
        });
    }

    public final void y(final String eventType, final JSONObject orderInfo) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListReporter$reportOperationBtnClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map;
                Map<String, String> i3;
                int n3;
                String o16;
                String j3;
                String p16;
                String m3;
                String l3;
                ECOrderListReporter eCOrderListReporter = ECOrderListReporter.f103395b;
                map = ECOrderListReporter.ptsEventTypeToReportBtnType;
                Integer num = (Integer) map.get(eventType);
                int intValue = num != null ? num.intValue() : -1;
                if (intValue >= 0) {
                    com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                    com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
                    i3 = eCOrderListReporter.i(orderInfo);
                    com.tencent.ecommerce.biz.common.e b16 = eVar.c(i3).b("button_type", String.valueOf(intValue));
                    n3 = eCOrderListReporter.n(orderInfo);
                    com.tencent.ecommerce.biz.common.e b17 = b16.b("order_status", String.valueOf(n3));
                    o16 = eCOrderListReporter.o(orderInfo);
                    com.tencent.ecommerce.biz.common.e b18 = b17.b("product_name", o16);
                    j3 = eCOrderListReporter.j(orderInfo);
                    com.tencent.ecommerce.biz.common.e b19 = b18.b("pri_sort_id", j3);
                    p16 = eCOrderListReporter.p(orderInfo);
                    com.tencent.ecommerce.biz.common.e b26 = b19.b("product_price", p16);
                    m3 = eCOrderListReporter.m(orderInfo);
                    com.tencent.ecommerce.biz.common.e b27 = b26.b("order_price", m3);
                    l3 = eCOrderListReporter.l(orderInfo);
                    IECDataReport.a.a(bVar, "order_list_order_card_button_clk", b27.b("order_id", l3).f(), false, 4, null);
                }
            }
        });
    }

    public final void z(long duration) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_duration_by_customer", new com.tencent.ecommerce.biz.common.e().b("order_detail_duration", String.valueOf(duration)).f(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> i(JSONObject jSONObject) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("goods_type", String.valueOf(k(jSONObject))), TuplesKt.to("refund_state", String.valueOf(q(jSONObject))), TuplesKt.to("spu_id", u(jSONObject)), TuplesKt.to("sku_id", t(jSONObject)), TuplesKt.to("saas_id", r(jSONObject)), TuplesKt.to("saas_name", s(jSONObject)));
        return mapOf;
    }
}
