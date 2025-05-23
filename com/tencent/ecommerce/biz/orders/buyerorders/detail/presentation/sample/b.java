package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.sample;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECOrderDetailReporter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J0\u0010\u000e\u001a\u00020\u00042(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R6\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/sample/b;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "state", "b", "f", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "d", "key", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "Z", "deferReportExposure", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: b, reason: from kotlin metadata */
    private static HashMap<String, String> com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    private static boolean deferReportExposure;

    /* renamed from: d */
    public static final b f103318d = new b();

    /* renamed from: a, reason: from kotlin metadata */
    private static OrderDetailEntrance common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String = OrderDetailEntrance.FROM_UNKNOWN;

    b() {
    }

    public final void a(OrderDetailEntrance r16) {
        common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String = r16;
    }

    public final void b(ECOrderDetailState state) {
        HashMap<String, String> hashMap = new HashMap<>();
        ECOrderDetailReporter eCOrderDetailReporter = ECOrderDetailReporter.f103294d;
        eCOrderDetailReporter.e(hashMap, state);
        eCOrderDetailReporter.d(hashMap, state);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String = hashMap;
        if (deferReportExposure) {
            f103318d.d(hashMap);
        }
    }

    public final void c(String key) {
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        HashMap<String, String> hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        IECDataReport.a.a(bVar, key, hashMap != null ? MapsKt__MapsKt.toMap(hashMap) : null, false, 4, null);
    }

    public final void f() {
        deferReportExposure = false;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String = null;
    }

    public final void d(HashMap<String, String> params) {
        Map map;
        if (params == null) {
            deferReportExposure = true;
            return;
        }
        deferReportExposure = false;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        params.put(IPhotoLogicFactory.ENTER_FROM, String.valueOf(common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String.value));
        Unit unit = Unit.INSTANCE;
        map = MapsKt__MapsKt.toMap(params);
        IECDataReport.a.a(bVar, "qstore_b_order_detail_page_exp", map, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(b bVar, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        }
        bVar.d(hashMap);
    }
}
