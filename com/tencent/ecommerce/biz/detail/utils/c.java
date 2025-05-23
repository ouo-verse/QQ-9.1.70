package com.tencent.ecommerce.biz.detail.utils;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.detail.ProductActiveStatus;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportCouponParams;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bT\u0010AJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010!\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\"\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010(\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR\"\u0010.\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b)\u0010\u0015R\"\u00101\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\"\u00105\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R\"\u00109\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\t\u001a\u0004\b:\u0010\u000b\"\u0004\b\"\u0010\rR\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b<\u0010\u0013\"\u0004\b\b\u0010\u0015R(\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b8\u0010\t\u0012\u0004\b@\u0010A\u001a\u0004\b>\u0010\u000b\"\u0004\b?\u0010\rR\"\u0010E\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010\u0013\"\u0004\b2\u0010\u0015R\"\u0010G\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\t\u001a\u0004\bF\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\bH\u0010\u0013\"\u0004\b6\u0010\u0015R\"\u0010K\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\bJ\u0010\u0013\"\u0004\bC\u0010\u0015R\"\u0010M\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\bL\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010S\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010O\u001a\u0004\bP\u0010Q\"\u0004\b\u001e\u0010R\u00a8\u0006U"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/utils/c;", "", "Lcom/tencent/ecommerce/biz/common/e;", "u", "", "status", "", "j", "a", "I", "getPgType", "()I", "g", "(I)V", "pgType", "", "b", "Ljava/lang/String;", "getContentId", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "contentId", "c", "getSellerId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sellerId", "getShopId", "r", "shopId", "e", "getProductId", "i", "productId", "f", "getProductName", "setProductName", "productName", "getSpuId", "t", "spuId", h.F, "getRole", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "role", "getPriSortId", "priSortId", "getSourceFrom", ReportConstant.COSTREPORT_PREFIX, GetAdInfoRequest.SOURCE_FROM, "k", "getRoomId", DomainData.DOMAIN_NAME, "roomId", "l", "getSassId", "o", "sassId", "getPageType", "pageType", "getActivityId", "activityId", "getActivityState", "setActivityState", "getActivityState$annotations", "()V", "activityState", "p", "getProgramId", "programId", "getActivityType", "activityType", "getRequestId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "getSealTransfer", "sealTransfer", "getAdClickId", "adClickId", "Lcom/tencent/ecommerce/biz/shophome/util/c;", "Lcom/tencent/ecommerce/biz/shophome/util/c;", "getCouponParams", "()Lcom/tencent/ecommerce/biz/shophome/util/c;", "(Lcom/tencent/ecommerce/biz/shophome/util/c;)V", "couponParams", "<init>", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int activityState;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int activityType;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private ECShopReportCouponParams couponParams;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int pgType = 2;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String contentId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String sellerId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String shopId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String productId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String productName = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String spuId = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int role = 1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String priSortId = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom = "-100";

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String roomId = "";

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String sassId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int pageType = 2;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String activityId = "";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String programId = "";

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String requestId = "";

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String sealTransfer = "";

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String adClickId = "";

    public final void a(String str) {
        this.activityId = str;
    }

    public final void b(int i3) {
        this.activityType = i3;
    }

    public final void c(String str) {
        this.adClickId = str;
    }

    public final void d(String str) {
        this.contentId = str;
    }

    public final void e(ECShopReportCouponParams eCShopReportCouponParams) {
        this.couponParams = eCShopReportCouponParams;
    }

    public final void f(int i3) {
        this.pageType = i3;
    }

    public final void g(int i3) {
        this.pgType = i3;
    }

    public final void h(String str) {
        this.priSortId = str;
    }

    public final void i(String str) {
        this.productId = str;
    }

    public final void j(@ProductActiveStatus int status) {
        this.activityState = status;
    }

    public final void k(String str) {
        this.programId = str;
    }

    public final void l(String str) {
        this.requestId = str;
    }

    public final void m(int i3) {
        this.role = i3;
    }

    public final void n(String str) {
        this.roomId = str;
    }

    public final void o(String str) {
        this.sassId = str;
    }

    public final void p(String str) {
        this.sealTransfer = str;
    }

    public final void q(String str) {
        this.sellerId = str;
    }

    public final void r(String str) {
        this.shopId = str;
    }

    public final void s(String str) {
        this.sourceFrom = str;
    }

    public final void t(String str) {
        this.spuId = str;
    }

    public final com.tencent.ecommerce.biz.common.e u() {
        com.tencent.ecommerce.biz.common.e eVar = new com.tencent.ecommerce.biz.common.e();
        eVar.a(String.valueOf(ug0.b.f438933d.e())).b("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount())).b(QAdVrReportParams.ParamKey.PG_TYPE, String.valueOf(this.pgType)).b("seller_id", this.sellerId).b("shop_id", this.shopId).b(ReportDataBuilder.KEY_PRODUCT_ID, this.productId).b("product_name", this.productName).b("spu_id", this.spuId).b("role", String.valueOf(this.role)).b("pri_sort_id", this.priSortId).b("source_from", this.sourceFrom).b("content_id", this.contentId).b("little_world_feed_id", this.contentId).b(AudienceReportConst.ROOM_ID, this.roomId).b("saas_id", this.sassId).b(MiniAppPlugin.ATTR_PAGE_TYPE, String.valueOf(this.pageType)).b("activity_id", this.activityId).b("activity_state", String.valueOf(this.activityState)).b("program_id", this.programId).b("activity_type", String.valueOf(this.activityType)).b("request_id", this.requestId).b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, this.sealTransfer).b("click_id", this.adClickId);
        ECShopReportCouponParams eCShopReportCouponParams = this.couponParams;
        if (eCShopReportCouponParams != null) {
            eVar.b("is_coupon", String.valueOf(eCShopReportCouponParams.isCoupon)).b("coupon_owner", eCShopReportCouponParams.couponOwner).b("related_batch_coupon_id", eCShopReportCouponParams.couponIds).b("off_price", String.valueOf(eCShopReportCouponParams.getOffPrice()));
        }
        return eVar;
    }
}
