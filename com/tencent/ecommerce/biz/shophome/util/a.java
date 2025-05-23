package com.tencent.ecommerce.biz.shophome.util;

import android.os.Bundle;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108J$\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u001e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J.\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0017JD\u0010#\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u0003JD\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u0003Jf\u0010.\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010-\u001a\u00020,Jf\u0010/\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010-\u001a\u00020,J6\u00101\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0017J&\u00103\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0017J\u000e\u00106\u001a\u00020,2\u0006\u00105\u001a\u000204\u00a8\u00069"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/util/a;", "", "Lcom/tencent/ecommerce/biz/common/e;", "", "role", "shopId", "source", "a", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/ecommerce/biz/shophome/util/d;", "c", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "couponId", "", "e", "f", "j", "k", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "resultEmpty", "t", "tabType", "v", "sorterKey", "sorterValue", "u", "spuId", "priSortId", "contentId", "roomId", "r", "p", "skuId", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomeScene;", "scene", "Lcom/tencent/ecommerce/biz/shophome/util/ECShopHomePageType;", "pageType", "activeId", "activeType", "Lcom/tencent/ecommerce/biz/shophome/util/c;", "couponParams", "i", h.F, "productId", "g", "shareAction", "d", "Lorg/json/JSONObject;", "productJson", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f104379a = new a();

    a() {
    }

    private final com.tencent.ecommerce.biz.common.e a(com.tencent.ecommerce.biz.common.e eVar, String str, String str2, String str3) {
        return eVar.a(String.valueOf(ug0.b.f438933d.e())).b("role", str).b("shop_id", str2).b("source", str3);
    }

    public final ECShopReportCouponParams b(JSONObject productJson) {
        long optLong;
        JSONArray optJSONArray = productJson.optJSONArray("coupons");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        if (productJson.has("off_price")) {
            optLong = productJson.optLong("off_price", 0L);
        } else {
            JSONObject optJSONObject = productJson.optJSONObject("price");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optLong = optJSONObject.optLong("off_price", 0L);
        }
        long j3 = optLong;
        int i3 = optJSONArray.length() > 0 ? 1 : 0;
        int length = optJSONArray.length();
        String str = "";
        String str2 = str;
        for (int i16 = 0; i16 < length; i16++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
            String optString = optJSONObject2.optString("id", "");
            if (optString.length() > 0) {
                str2 = str2 + optString + ';';
            }
            String optString2 = optJSONObject2.optString("issuer_id", "");
            if (optString2.length() > 0) {
                str = str + optString2 + ';';
            }
        }
        return new ECShopReportCouponParams(i3, str, str2, j3);
    }

    public final ECShopReportParams c(Bundle arguments) {
        String str;
        String str2;
        String str3;
        String str4;
        str = "";
        if (arguments == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
        } else {
            str3 = arguments.getString("shop_id");
            if (str3 == null) {
                str3 = "";
            }
            String string = arguments.getString("role", "");
            if (string == null) {
                string = "";
            }
            str4 = arguments.getString("source", "");
            if (str4 == null) {
                str4 = "";
            }
            String string2 = arguments.getString("request_id", "");
            str2 = string2 != null ? string2 : "";
            str = string;
        }
        return new ECShopReportParams(str, str3, str4, str2);
    }

    public final void d(String role, String shopId, String source, int shareAction) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_store_share_success", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("role", role).b("source", source).b("shared_to", aj0.a.f26146a.a(shareAction)).f(), false, 4, null);
    }

    public final void e(String role, String shopId, String source, String requestId, String couponId) {
        com.tencent.ecommerce.biz.common.e a16 = a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source);
        a16.b("request_id", requestId);
        a16.b("related_batch_coupon_id", couponId);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_page_exp", a16.f(), false, 4, null);
        g.d("qstore_page_exp", a16.f());
    }

    public final void f(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_logo_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void g(String role, String shopId, String source, String productId, String activeId, int activeType) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_card_add_to_vid_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b(ReportDataBuilder.KEY_PRODUCT_ID, productId).b("activity_id", activeId).b("activity_type", String.valueOf(activeType)).f(), false, 4, null);
    }

    public final void h(String role, String shopId, String source, String spuId, String skuId, ECShopHomeScene scene, String sorterKey, int sorterValue, ECShopHomePageType pageType, String activeId, int activeType, ECShopReportCouponParams couponParams) {
        String valueOf;
        com.tencent.ecommerce.biz.common.e b16 = a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("spu_id", spuId).b("sku_id", skuId).b(ReportDataBuilder.KEY_PRODUCT_ID, spuId).b("scene", String.valueOf(scene.sceneValue)).b("sorter_key", sorterKey);
        if (sorterValue < 0) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(sorterValue);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_card_ck", b16.b("sorter_value", valueOf).b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(pageType.typeValue)).b("activity_id", activeId).b("activity_type", String.valueOf(activeType)).b("is_coupon", String.valueOf(couponParams.isCoupon)).b("coupon_owner", couponParams.couponOwner).b("related_batch_coupon_id", couponParams.couponIds).b("off_price", String.valueOf(couponParams.getOffPrice())).f(), false, 4, null);
    }

    public final void i(String role, String shopId, String source, String spuId, String skuId, ECShopHomeScene scene, String sorterKey, int sorterValue, ECShopHomePageType pageType, String activeId, int activeType, ECShopReportCouponParams couponParams) {
        String valueOf;
        com.tencent.ecommerce.biz.common.e b16 = a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("spu_id", spuId).b("sku_id", skuId).b(ReportDataBuilder.KEY_PRODUCT_ID, spuId).b("scene", String.valueOf(scene.sceneValue)).b("sorter_key", sorterKey);
        if (sorterValue < 0) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(sorterValue);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_card_exp", b16.b("sorter_value", valueOf).b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(pageType.typeValue)).b("activity_id", activeId).b("activity_type", String.valueOf(activeType)).b("is_coupon", String.valueOf(couponParams.isCoupon)).b("coupon_owner", couponParams.couponOwner).b("related_batch_coupon_id", couponParams.couponIds).b("off_price", String.valueOf(couponParams.getOffPrice())).f(), false, 4, null);
    }

    public final void j(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_qualification_check_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void k(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void l(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_go", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void m(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_history_clean", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void n(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_history_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void o(String role, String shopId, String source) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_history_delete", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).f(), false, 4, null);
    }

    public final void p(String role, String shopId, String source, String spuId, String priSortId, String contentId, String roomId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_detail_pg_recommend_ck", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("spu_id", "").b("to_spu_id", spuId).b("scene", "5").b("pri_sort_id", priSortId).b("content_id", contentId).b(AudienceReportConst.ROOM_ID, roomId).f(), false, 4, null);
    }

    public final void r(String role, String shopId, String source, String spuId, String priSortId, String contentId, String roomId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_detail_pg_recommend_exp", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("spu_id", "").b("to_spu_id", spuId).b("scene", "5").b("pri_sort_id", priSortId).b("content_id", contentId).b(AudienceReportConst.ROOM_ID, roomId).f(), false, 4, null);
    }

    public final void t(String role, String shopId, String source, int resultEmpty) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_search_result_exp", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("result_empty", String.valueOf(resultEmpty)).f(), false, 4, null);
    }

    public final void u(String role, String shopId, String source, String sorterKey, int sorterValue) {
        String valueOf;
        com.tencent.ecommerce.biz.common.e b16 = a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b("sorter_key", sorterKey);
        if (sorterValue < 0) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(sorterValue);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_tab_sorter_ck", b16.b("sorter_value", valueOf).f(), false, 4, null);
    }

    public final void v(String role, String shopId, String source, String tabType) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_shop_tab_switch", a(new com.tencent.ecommerce.biz.common.e(), role, shopId, source).b(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, tabType).f(), false, 4, null);
    }
}
