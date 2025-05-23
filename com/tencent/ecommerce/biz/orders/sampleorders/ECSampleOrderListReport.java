package com.tencent.ecommerce.biz.orders.sampleorders;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b*\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0015\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0017\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u0018*\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECSampleOrderListReport;", "", "", "eventType", "Lorg/json/JSONObject;", "cardJson", "", "k", "", "c", "j", "i", "a", "Ljava/util/Map;", "ptsEventTypeToReportBtnType", "e", "(Lorg/json/JSONObject;)Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "g", "spuId", h.F, "spuName", "d", "firstCategoryId", "", "f", "(Lorg/json/JSONObject;)Ljava/lang/Integer;", "orderStatus", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSampleOrderListReport {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> ptsEventTypeToReportBtnType;

    /* renamed from: b, reason: collision with root package name */
    public static final ECSampleOrderListReport f103793b = new ECSampleOrderListReport();

    static {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cancelApply", "0"), TuplesKt.to("viewShipping", "1"), TuplesKt.to("confirmReceiveGoods", "2"), TuplesKt.to("viewConsignDetail", "3"), TuplesKt.to("abortConsign", "4"), TuplesKt.to("addWindow", "5"), TuplesKt.to("cancelApplyAbortConsign", "6"), TuplesKt.to("updateAddress", "7"));
        ptsEventTypeToReportBtnType = mapOf;
    }

    ECSampleOrderListReport() {
    }

    private final String d(JSONObject jSONObject) {
        String optString;
        JSONObject optJSONObject = jSONObject.optJSONObject("product");
        return (optJSONObject == null || (optString = optJSONObject.optString("first_cat_id")) == null) ? "" : optString;
    }

    private final String e(JSONObject jSONObject) {
        String optString;
        JSONObject optJSONObject = jSONObject.optJSONObject("order");
        return (optJSONObject == null || (optString = optJSONObject.optString("order_id")) == null) ? "" : optString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("order");
        if (optJSONObject != null) {
            return Integer.valueOf(optJSONObject.optInt("order_status"));
        }
        return null;
    }

    private final String g(JSONObject jSONObject) {
        String optString;
        JSONObject optJSONObject = jSONObject.optJSONObject("product");
        return (optJSONObject == null || (optString = optJSONObject.optString("spu_id")) == null) ? "" : optString;
    }

    private final String h(JSONObject jSONObject) {
        String optString;
        JSONObject optJSONObject = jSONObject.optJSONObject("product");
        return (optJSONObject == null || (optString = optJSONObject.optString("title")) == null) ? "" : optString;
    }

    private final void k(String eventType, final JSONObject cardJson) {
        final String str = ptsEventTypeToReportBtnType.get(eventType);
        if (str != null) {
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderListReport$reportCardOperateEvent$1
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
                    Map c16;
                    Map<String, String> mutableMap;
                    c16 = ECSampleOrderListReport.f103793b.c(JSONObject.this);
                    mutableMap = MapsKt__MapsKt.toMutableMap(c16);
                    mutableMap.put("button_type", str);
                    IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_sample_order_card_operate", new com.tencent.ecommerce.biz.common.e().c(mutableMap).f(), false, 4, null);
                }
            });
        }
    }

    public final void i(String eventType, final JSONObject cardJson) {
        final String str;
        int hashCode = eventType.hashCode();
        if (hashCode != 616865398) {
            if (hashCode == 912152989 && eventType.equals("enterShopPage")) {
                str = "1";
                ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderListReport$reportCardClick$1
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
                        Map c16;
                        Map<String, String> mutableMap;
                        Integer f16;
                        ECSampleOrderListReport eCSampleOrderListReport = ECSampleOrderListReport.f103793b;
                        c16 = eCSampleOrderListReport.c(JSONObject.this);
                        mutableMap = MapsKt__MapsKt.toMutableMap(c16);
                        f16 = eCSampleOrderListReport.f(JSONObject.this);
                        if (f16 != null) {
                            mutableMap.put("order_status", String.valueOf(f16.intValue()));
                        }
                        mutableMap.put("click_area", str);
                        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_sample_order_card_clk", new com.tencent.ecommerce.biz.common.e().c(mutableMap).f(), false, 4, null);
                    }
                });
                return;
            }
            k(eventType, cardJson);
        }
        if (eventType.equals("enterOrderDetailPage")) {
            str = "2";
            ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderListReport$reportCardClick$1
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
                    Map c16;
                    Map<String, String> mutableMap;
                    Integer f16;
                    ECSampleOrderListReport eCSampleOrderListReport = ECSampleOrderListReport.f103793b;
                    c16 = eCSampleOrderListReport.c(JSONObject.this);
                    mutableMap = MapsKt__MapsKt.toMutableMap(c16);
                    f16 = eCSampleOrderListReport.f(JSONObject.this);
                    if (f16 != null) {
                        mutableMap.put("order_status", String.valueOf(f16.intValue()));
                    }
                    mutableMap.put("click_area", str);
                    IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_sample_order_card_clk", new com.tencent.ecommerce.biz.common.e().c(mutableMap).f(), false, 4, null);
                }
            });
            return;
        }
        k(eventType, cardJson);
    }

    public final void j(final JSONObject cardJson) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECSampleOrderListReport$reportCardExposure$1
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
                Map c16;
                Map<String, String> mutableMap;
                Integer f16;
                ECSampleOrderListReport eCSampleOrderListReport = ECSampleOrderListReport.f103793b;
                c16 = eCSampleOrderListReport.c(JSONObject.this);
                mutableMap = MapsKt__MapsKt.toMutableMap(c16);
                f16 = eCSampleOrderListReport.f(JSONObject.this);
                if (f16 != null) {
                    mutableMap.put("order_status", String.valueOf(f16.intValue()));
                }
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "order_list_sample_order_card_exp", new com.tencent.ecommerce.biz.common.e().c(mutableMap).f(), false, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> c(JSONObject jSONObject) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("spu_id", g(jSONObject)), TuplesKt.to("spu_name", h(jSONObject)), TuplesKt.to("pri_sort_id", d(jSONObject)), TuplesKt.to("order_id", e(jSONObject)));
        return mapOf;
    }
}
