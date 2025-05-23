package com.tencent.ecommerce.biz.bulletin;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002J(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/bulletin/b;", "", "", "storeId", "spuId", "Lcom/tencent/ecommerce/biz/bulletin/BulletinScene;", "scene", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "a", "", "d", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f101349a = new b();

    b() {
    }

    public final void b(String storeId, String spuId, BulletinScene scene, String orderId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "report_notice_cli", a(storeId, spuId, scene, orderId), false, 4, null);
    }

    public final void d(String storeId, String spuId, BulletinScene scene, String orderId) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "report_notice_exp", a(storeId, spuId, scene, orderId), false, 4, null);
    }

    private final Map<Object, Object> a(String storeId, String spuId, BulletinScene scene, String orderId) {
        Map<Object, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("store_id", storeId), TuplesKt.to("spu_id", spuId), TuplesKt.to("order_id", orderId), TuplesKt.to("notice_scene", Integer.valueOf(scene.scene)));
        return mapOf;
    }

    public static /* synthetic */ void c(b bVar, String str, String str2, BulletinScene bulletinScene, String str3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        bVar.b(str, str2, bulletinScene, str3);
    }

    public static /* synthetic */ void e(b bVar, String str, String str2, BulletinScene bulletinScene, String str3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str3 = "";
        }
        bVar.d(str, str2, bulletinScene, str3);
    }
}
