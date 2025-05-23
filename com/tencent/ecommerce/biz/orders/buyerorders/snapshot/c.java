package com.tencent.ecommerce.biz.orders.buyerorders.snapshot;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/snapshot/c;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "c", "shopId", "a", "spuId", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f103434a = new c();

    c() {
    }

    public final void a(String orderId, String shopId) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("order_id", orderId), TuplesKt.to("shop_id", shopId));
        IECDataReport.a.a(bVar, "qstore_order_detail_view_snapshot_enter_store", mapOf, false, 4, null);
    }

    public final void b(String orderId, String spuId) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("order_id", orderId), TuplesKt.to("spu_id", spuId));
        IECDataReport.a.a(bVar, "qstore_order_detail_view_snapshot_view_newest", mapOf, false, 4, null);
    }

    public final void c(String orderId) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("order_id", orderId));
        IECDataReport.a.a(bVar, "qstore_order_detail_view_snapshot_exp", mapOf, false, 4, null);
    }
}
