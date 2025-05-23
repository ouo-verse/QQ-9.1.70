package com.tencent.ecommerce.biz.comment;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJF\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J>\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/comment/d;", "", "Lcom/tencent/ecommerce/biz/common/e;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "spuId", "skuId", "a", "", "d", "", "duration", "c", "", "productScore", "logisticsScore", "shopScore", "imageNum", "", "hasCommentText", "b", "e", WSAutoShowCommentParams.KEY_COMMENT_ID, "f", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f101425a = new d();

    d() {
    }

    private final com.tencent.ecommerce.biz.common.e a(com.tencent.ecommerce.biz.common.e eVar, String str, String str2, String str3) {
        return eVar.a(String.valueOf(ug0.b.f438933d.e())).b("sku_id", str3).b("spu_id", str2).b("order_id", str);
    }

    public final void b(String orderId, String spuId, String skuId, int productScore, int logisticsScore, int shopScore, int imageNum, boolean hasCommentText) {
        String str;
        com.tencent.ecommerce.biz.common.e b16 = a(new com.tencent.ecommerce.biz.common.e(), orderId, spuId, skuId).b("rate_product", String.valueOf(productScore)).b("rate_seller", String.valueOf(shopScore)).b("rate_express", String.valueOf(logisticsScore)).b("attachment_counts", String.valueOf(imageNum));
        if (hasCommentText) {
            str = "0";
        } else {
            str = "1";
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_rate_submit", b16.b("comments_upload", str).f(), false, 4, null);
    }

    public final void c(String orderId, String spuId, String skuId, long duration) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_rate_exit", a(new com.tencent.ecommerce.biz.common.e(), orderId, spuId, skuId).b("duration", String.valueOf(duration)).f(), false, 4, null);
    }

    public final void d(String orderId, String spuId, String skuId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_order_rate_exp", a(new com.tencent.ecommerce.biz.common.e(), orderId, spuId, skuId).f(), false, 4, null);
    }

    public final void e(String orderId, String spuId, String skuId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_view_order_rate_clk", a(new com.tencent.ecommerce.biz.common.e(), orderId, spuId, skuId).f(), false, 4, null);
    }

    public final void f(String orderId, String spuId, String skuId, String commentId, int productScore, int logisticsScore, int shopScore) {
        com.tencent.ecommerce.biz.common.e b16 = a(new com.tencent.ecommerce.biz.common.e(), orderId, spuId, skuId).b("rate_product", String.valueOf(productScore)).b("rate_seller", String.valueOf(shopScore)).b("rate_express", String.valueOf(logisticsScore));
        if (commentId.length() == 0) {
            b16.b("comment_id", commentId);
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "qstore_view_order_rate_exp", b16.f(), false, 4, null);
    }
}
