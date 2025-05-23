package com.tencent.ecommerce.biz.detail.utils;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.live.SourceFrom;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportCouponParams;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLDecoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bQ\u0010RJX\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u00b0\u0001\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002J.\u0010\"\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010 2\u0006\u0010\u001b\u001a\u00020\u0002J\u00d0\u0001\u00103\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00102\u0006\u00102\u001a\u000201J~\u00104\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002J~\u00105\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002J>\u00108\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010J>\u00109\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0010JF\u0010;\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010JF\u0010<\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004JV\u0010=\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002Jf\u0010@\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0002J\u001e\u0010E\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020\u0010J\u0016\u0010G\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002J:\u0010H\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0010J>\u0010K\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00102\u0006\u00102\u001a\u000201JJ\u0010N\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00022\b\b\u0002\u0010J\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0010J.\u0010P\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u00a8\u0006S"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/utils/d;", "", "", "busId", "", "uin", "sellerId", "sassId", "productId", "productName", "priSortId", "productPrice", "productSales", "contendId", "Lcom/tencent/ecommerce/biz/common/e;", "a", "", "pgType", "shopId", "spuId", "roomId", "buyerId", "duration", GetAdInfoRequest.SOURCE_FROM, "sealTransfer", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "role", AdMetricTag.EVENT_NAME, "", "d", "Lcom/tencent/ecommerce/biz/detail/utils/c;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "extMap", "f", "commission", "priceUpper", "priceLower", "commissionUpper", "commissionLower", "", "addStatus", "bannerId", "mediaProductId", "txVideoType", "bannerName", "goodsType", "activeId", "activeType", "Lcom/tencent/ecommerce/biz/shophome/util/c;", "coupons", "g", "i", "o", "saasId", "pageType", "k", "l", "clickArea", "j", h.F, "p", "shareAction", "shareStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "isHost", QzoneIPCModule.RESULT_CODE, "r", "rankType", "e", "c", "action", "contentId", "b", "sortId", "source", DomainData.DOMAIN_NAME, "isFloatMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f102466a = new d();

    d() {
    }

    private final com.tencent.ecommerce.biz.common.e a(String busId, long uin, String sellerId, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String contendId) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.d(sellerId);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        eVar.b("content_id", contendId);
        return eVar;
    }

    public final void b(String action, String spuId, String contentId, String sourceFrom, String activeId, int activeType, ECShopReportCouponParams coupons) {
        String str;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String optString;
        JSONObject jSONObject2;
        JSONObject optJSONObject3;
        JSONObject jSONObject3;
        JSONObject optJSONObject4;
        ECShopProductDetailInfo f16 = com.tencent.ecommerce.biz.detail.repo.shop.data.d.f(com.tencent.ecommerce.biz.detail.repo.shop.data.d.f102363c, spuId, null, 2, null);
        String str2 = "";
        if (f16 == null || (jSONObject3 = f16.infoData) == null || (optJSONObject4 = jSONObject3.optJSONObject("shop")) == null || (str = optJSONObject4.optString("id")) == null) {
            str = "";
        }
        int i3 = 1;
        if (f16 != null && (jSONObject2 = f16.infoData) != null && (optJSONObject3 = jSONObject2.optJSONObject("user_right")) != null) {
            i3 = optJSONObject3.optInt("role_id", 1);
        }
        if (f16 != null && (jSONObject = f16.infoData) != null && (optJSONObject = jSONObject.optJSONObject("product")) != null && (optJSONObject2 = optJSONObject.optJSONObject("category")) != null && (optString = optJSONObject2.optString("first_cat_id")) != null) {
            str2 = optString;
        }
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(String.valueOf(ug0.b.f438933d.e()));
        eVar.b("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        eVar.b("shop_id", str);
        eVar.b("spu_id", spuId);
        eVar.b("pri_sort_id", str2);
        eVar.b("role", String.valueOf(i3));
        eVar.b("content_id", contentId);
        eVar.b("source_from", sourceFrom);
        eVar.b("activity_id", activeId);
        eVar.b("activity_type", String.valueOf(activeType));
        eVar.b("is_coupon", String.valueOf(coupons.isCoupon));
        eVar.b("coupon_owner", coupons.couponOwner);
        eVar.b("related_batch_coupon_id", coupons.couponIds);
        eVar.b("off_price", String.valueOf(coupons.getOffPrice()));
        Map<Object, Object> f17 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportActionWithCommonParam] action:" + action + ", param:" + f17);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, action, f17, false, 4, null);
    }

    public final void c(String busId, String shopId, String spuId, int role, String activeId, int activeType) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        eVar.b("shop_id", shopId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, spuId);
        eVar.b("role", String.valueOf(role));
        eVar.b("activity_id", activeId);
        eVar.b("activity_type", String.valueOf(activeType));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportBuyBtnClick] action: qstore_prd_card_add_to_vid_ck, param:" + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_card_add_to_vid_ck", f16, false, 4, null);
    }

    public final void d(int pgType, String shopId, String spuId, String roomId, String busId, long uin, String sellerId, String buyerId, String duration, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String sourceFrom, String contendId, String sealTransfer, String requestId, int role, String eventName) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b(QAdVrReportParams.ParamKey.PG_TYPE, String.valueOf(pgType));
        eVar.b("shop_id", shopId);
        eVar.b("spu_id", spuId);
        eVar.b(AudienceReportConst.ROOM_ID, roomId);
        eVar.b("uin", String.valueOf(uin));
        eVar.d(sellerId);
        eVar.b("buyer_id", buyerId);
        eVar.b("duration", duration);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        eVar.b("source_from", sourceFrom);
        eVar.b("feed_id", contendId);
        eVar.b("content_id", contendId);
        eVar.b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, sealTransfer);
        eVar.b("request_id", requestId);
        eVar.b("role", String.valueOf(role));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportAllPageDurationExp] eventName:" + eventName + ",params:" + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventName, f16, false, 4, null);
        g.d(eventName, f16);
    }

    public final void e(int rankType, String spuId) {
        String str;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        ECShopProductDetailInfo f16 = com.tencent.ecommerce.biz.detail.repo.shop.data.d.f(com.tencent.ecommerce.biz.detail.repo.shop.data.d.f102363c, spuId, null, 2, null);
        if (f16 == null || (jSONObject = f16.infoData) == null || (optJSONObject = jSONObject.optJSONObject("shop")) == null || (str = optJSONObject.optString("id")) == null) {
            str = "";
        }
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.b("rank_type", String.valueOf(rankType));
        eVar.b("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        eVar.b("spu_id", spuId);
        eVar.b("bus_id", String.valueOf(ug0.b.f438933d.e()));
        eVar.b("shop_id", str);
        Map<Object, Object> f17 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportCommentListRankClick] action = qstore_prd_detail_pg_comment_list_rank_ck, params = " + f17);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_detail_pg_comment_list_rank_ck", f17, false, 4, null);
    }

    public final void g(String busId, long uin, String sellerId, String sassId, String productId, String productName, String priSortId, long commission, long productPrice, long priceUpper, long priceLower, long commissionUpper, long commissionLower, long productSales, boolean addStatus, String sourceFrom, String bannerId, String mediaProductId, String txVideoType, String bannerName, int goodsType, String activeId, int activeType, ECShopReportCouponParams coupons) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lower", commissionLower);
        jSONObject.put("upper", commissionUpper);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lower", priceLower);
        jSONObject2.put("upper", priceUpper);
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.d(sellerId);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("goods_type", String.valueOf(goodsType));
        if (goodsType == 3) {
            eVar.b("txvideo_type", txVideoType);
            eVar.b("price_range", jSONObject2.toString());
            eVar.b("commission_range", jSONObject.toString());
        }
        eVar.b("product_name", productName);
        eVar.b("media_product_id", mediaProductId);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("commission", String.valueOf(commission));
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        eVar.b("add_status", String.valueOf(addStatus));
        if (Intrinsics.areEqual(sourceFrom, String.valueOf(SourceFrom.ACTIVITY_BANNER_H5.ordinal()))) {
            eVar.b("goods_card_location", "1");
            eVar.b("banner_id", URLDecoder.decode(bannerId, "UTF-8"));
            eVar.b("banner_name", URLDecoder.decode(bannerName, "UTF-8"));
        }
        eVar.b("activity_id", activeId);
        eVar.b("activity_type", String.valueOf(activeType));
        eVar.b("is_coupon", String.valueOf(coupons.isCoupon));
        eVar.b("coupon_owner", coupons.couponOwner);
        eVar.b("related_batch_coupon_id", coupons.couponIds);
        eVar.b("off_price", String.valueOf(coupons.getOffPrice()));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[s] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_goods_card_add", f16, false, 4, null);
    }

    public final void h(String sellerId, String sassId, String productId, String productName, String priSortId, long commission, long productPrice, long productSales) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.d(sellerId);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("commission", String.valueOf(commission));
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportGotoSaasClk] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_goto_saas_clk", f16, false, 4, null);
    }

    public final void j(String busId, long uin, int goodsType, String saasId, String productId, String productName, int pageType, int clickArea) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.b("goods_type", String.valueOf(goodsType));
        eVar.b("saas_id", saasId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(pageType));
        eVar.b("click_area", String.valueOf(clickArea));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportMainPicClick] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_main_pic_clk", f16, false, 4, null);
    }

    public final void k(String busId, long uin, int goodsType, String saasId, String productId, String productName, int pageType) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.b("goods_type", String.valueOf(goodsType));
        eVar.b("saas_id", saasId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(pageType));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportMainPicExp] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_main_pic_exp", f16, false, 4, null);
    }

    public final void l(String busId, long uin, int goodsType, String saasId, String productId, String productName, int pageType) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.b("goods_type", String.valueOf(goodsType));
        eVar.b("saas_id", saasId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(pageType));
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportMainPicSlide] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_main_pic_slide", f16, false, 4, null);
    }

    public final void m(boolean isFloatMode, String sellerId, String shopId, String spuId, String role) {
        String str;
        com.tencent.ecommerce.biz.common.e a16 = new com.tencent.ecommerce.biz.common.e().a(String.valueOf(ug0.b.f438933d.e()));
        if (isFloatMode) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.ecommerce.biz.common.e b16 = a16.b(QAdVrReportParams.ParamKey.PG_TYPE, str).b("seller_id", sellerId).b("shop_id", shopId).b("spu_id", spuId).b("role", role);
        cg0.a.b("ECDetailPageReportUtil", "[reportPriceReduceClk] action = qstore_prd_detail_price_reduce_clk paramsBuilder = " + b16.f());
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_detail_price_reduce_clk", b16.f(), false, 4, null);
    }

    public final void n(String sellerId, String shopId, String spuId, String sortId, String source, String contentId, String roomId, int shareAction) {
        com.tencent.ecommerce.biz.common.e b16 = new com.tencent.ecommerce.biz.common.e().a(String.valueOf(ug0.b.f438933d.e())).b("shop_id", shopId).b("shared_to", aj0.a.f26146a.a(shareAction)).b("seller_id", sellerId).b("spu_id", spuId).b("pri_sort_id", sortId).b("source_from", source);
        if (Intrinsics.areEqual(source, "1")) {
            b16.b("content_id", contentId);
        }
        if (Intrinsics.areEqual(source, "9")) {
            b16.b(AudienceReportConst.ROOM_ID, roomId);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_prd_share_success", b16.f(), false, 4, null);
    }

    public final void p(String busId, long uin, String sellerId, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String contendId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_share_clk_by_customer", a(busId, uin, sellerId, sassId, productId, productName, priSortId, productPrice, productSales, contendId).f(), false, 4, null);
    }

    public final void r(k showPageCostTime, boolean isHost, int resultCode) {
        Map<Object, Object> d16 = new m().a(isHost).c(resultCode).d();
        showPageCostTime.b(d16);
        cg0.a.b("ECDetailPageReportUtil", "[reportShowPageCost] params = " + d16);
    }

    public final void f(c reportParams, Map<String, String> extMap, String eventName) {
        if (reportParams != null) {
            com.tencent.ecommerce.biz.common.e u16 = reportParams.u();
            if (extMap != null) {
                u16.c(extMap);
            }
            cg0.a.b("ECDetailPageReportUtil", "[reportDetailPageEvent] eventName:" + eventName + ",extMap:" + extMap);
            IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventName, u16.f(), false, 4, null);
            g.d(eventName, u16.f());
        }
    }

    public final void i(String busId, long uin, String sellerId, String buyerId, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String sourceFrom, String contendId, String sealTransfer, String roomId, String requestId) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.d(sellerId);
        eVar.b("buyer_id", buyerId);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        eVar.b("source_from", sourceFrom);
        eVar.b("content_id", contendId);
        eVar.b("feed_id", contendId);
        eVar.b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, sealTransfer);
        eVar.b(AudienceReportConst.ROOM_ID, roomId);
        eVar.b("request_id", requestId);
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportGotoWindowByCustomer] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_goto_window_by_customer", f16, false, 4, null);
        g.d("product_details_page_goto_window_by_customer", f16);
    }

    public final void o(String busId, long uin, String sellerId, String buyerId, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String sourceFrom, String contendId, String sealTransfer, String roomId, String requestId) {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(busId);
        eVar.b("uin", String.valueOf(uin));
        eVar.d(sellerId);
        eVar.b("buyer_id", buyerId);
        eVar.b("saas_id", sassId);
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, productId);
        eVar.b("product_name", productName);
        eVar.b("pri_sort_id", priSortId);
        eVar.b("product_price", String.valueOf(productPrice));
        eVar.b("product_sales", String.valueOf(productSales));
        eVar.b("source_from", sourceFrom);
        eVar.b("content_id", contendId);
        eVar.b("feed_id", contendId);
        eVar.b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, sealTransfer);
        eVar.b(AudienceReportConst.ROOM_ID, roomId);
        eVar.b("request_id", requestId);
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECDetailPageReportUtil", "[reportPurchaseClkByCustomer] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_purchase_clk_by_customer", f16, false, 4, null);
        g.d("product_details_page_purchase_clk_by_customer", f16);
    }

    public final void q(String busId, long uin, String sellerId, String sassId, String productId, String productName, String priSortId, long productPrice, long productSales, String contendId, int shareAction, String shareStatus) {
        int i3;
        if (shareAction != 2) {
            if (shareAction == 9) {
                i3 = 3;
            } else if (shareAction == 72) {
                i3 = 4;
            } else if (shareAction != 73) {
                i3 = 0;
            }
            IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_share_channel_clk_by_customer", a(busId, uin, sellerId, sassId, productId, productName, priSortId, productPrice, productSales, contendId).b(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL, String.valueOf(i3)).b("share_status", shareStatus).f(), false, 4, null);
        }
        i3 = 1;
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "product_details_page_share_channel_clk_by_customer", a(busId, uin, sellerId, sassId, productId, productName, priSortId, productPrice, productSales, contendId).b(MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL, String.valueOf(i3)).b("share_status", shareStatus).f(), false, 4, null);
    }
}
