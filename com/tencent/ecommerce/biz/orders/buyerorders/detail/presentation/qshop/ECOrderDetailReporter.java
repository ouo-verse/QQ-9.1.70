package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop;

import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderDetailEntrance;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.OrderSpuDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.OrderSkuDetail;
import com.tencent.ecommerce.biz.orders.common.QShopOrderCouponInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoInfo;
import com.tencent.ecommerce.biz.orders.common.QShopOrderPromoType;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J0\u0010\b\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0007J0\u0010\u000f\u001a\u00020\u00072(\b\u0002\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003J.\u0010\u0018\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u0005J.\u0010\u0019\u001a\u00020\u0007*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aR6\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/qshop/ECOrderDetailReporter;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/domain/qshop/ECOrderDetailState;", "state", "", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "a", "b", "k", "params", "i", "", "durationMs", h.F, "key", "", "buttonType", "f", "g", "e", "d", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/OrderDetailEntrance;", "Ljava/util/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "Z", "deferReportExposure", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderDetailReporter {

    /* renamed from: b, reason: from kotlin metadata */
    private static HashMap<String, String> com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    private static boolean deferReportExposure;

    /* renamed from: d */
    public static final ECOrderDetailReporter f103294d = new ECOrderDetailReporter();

    /* renamed from: a, reason: from kotlin metadata */
    private static OrderDetailEntrance common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String = OrderDetailEntrance.FROM_UNKNOWN;

    ECOrderDetailReporter() {
    }

    private final void c(HashMap<String, String> hashMap, ECOrderDetailState eCOrderDetailState) {
        Object obj;
        String joinToString$default;
        String joinToString$default2;
        Iterator<T> it = eCOrderDetailState.g().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((QShopOrderPromoInfo) obj).type == QShopOrderPromoType.COUPON) {
                    break;
                }
            }
        }
        QShopOrderPromoInfo qShopOrderPromoInfo = (QShopOrderPromoInfo) obj;
        if (qShopOrderPromoInfo != null) {
            hashMap.put("is_coupon", "1");
            hashMap.put("off_price", String.valueOf(qShopOrderPromoInfo.price));
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(eCOrderDetailState.i(), ";", null, null, 0, null, new Function1<QShopOrderCouponInfo, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECOrderDetailReporter$putCouponInfo$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(QShopOrderCouponInfo qShopOrderCouponInfo) {
                    return qShopOrderCouponInfo.issuerId;
                }
            }, 30, null);
            hashMap.put("coupon_owner", joinToString$default);
            joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(eCOrderDetailState.i(), ";", null, null, 0, null, new Function1<QShopOrderCouponInfo, CharSequence>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.qshop.ECOrderDetailReporter$putCouponInfo$2
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(QShopOrderCouponInfo qShopOrderCouponInfo) {
                    return qShopOrderCouponInfo.batchId;
                }
            }, 30, null);
            hashMap.put("related_batch_coupon_id", joinToString$default2);
            return;
        }
        hashMap.put("is_coupon", "0");
    }

    public final void a(OrderDetailEntrance r16) {
        common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String = r16;
    }

    public final void b(ECOrderDetailState state) {
        HashMap<String, String> hashMap = new HashMap<>();
        ECOrderDetailReporter eCOrderDetailReporter = f103294d;
        eCOrderDetailReporter.e(hashMap, state);
        eCOrderDetailReporter.d(hashMap, state);
        eCOrderDetailReporter.c(hashMap, state);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String = hashMap;
        if (deferReportExposure) {
            eCOrderDetailReporter.i(hashMap);
        }
    }

    public final void d(HashMap<String, String> hashMap, ECOrderDetailState eCOrderDetailState) {
        Object first;
        Object first2;
        Object first3;
        Object first4;
        Object first5;
        Object first6;
        List<OrderSkuDetail> list = eCOrderDetailState.orderSkuInfo;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        hashMap.put("sku_id", ((OrderSkuDetail) first).skuId);
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        hashMap.put("shop_id", ((OrderSkuDetail) first2).shop.id);
        first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        hashMap.put("product_name", ((OrderSkuDetail) first3).name);
        first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        hashMap.put("product_price", String.valueOf(((OrderSkuDetail) first4).unitPrice));
        List<OrderSpuDetail> list2 = eCOrderDetailState.orderSpuInfo;
        first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
        hashMap.put("spu_id", ((OrderSpuDetail) first5).id);
        first6 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
        hashMap.put("pri_sort_id", ((OrderSpuDetail) first6).firstCategoryId);
    }

    public final void e(HashMap<String, String> hashMap, ECOrderDetailState eCOrderDetailState) {
        String str;
        hashMap.put("order_id", eCOrderDetailState.orderId);
        hashMap.put("order_status", String.valueOf(eCOrderDetailState.orderStateVal));
        long j3 = 1000;
        hashMap.put("order_time", String.valueOf(eCOrderDetailState.createTimestampMs / j3));
        hashMap.put("pay_method", String.valueOf(eCOrderDetailState.payInfo.payType.id));
        hashMap.put("pay_time", String.valueOf(eCOrderDetailState.payInfo.payTimestampMs / j3));
        hashMap.put("order_price", String.valueOf(eCOrderDetailState.payInfo.orderPrice));
        if (eCOrderDetailState.hasComment) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("comment_status", str);
    }

    public final void f(String key, int buttonType) {
        Map map;
        b bVar = b.f100913b;
        HashMap<String, String> hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        if (hashMap != null) {
            hashMap.put("button_type", String.valueOf(buttonType));
            Unit unit = Unit.INSTANCE;
            map = MapsKt__MapsKt.toMap(hashMap);
        } else {
            map = null;
        }
        IECDataReport.a.a(bVar, key, map, false, 4, null);
    }

    public final void g(String key) {
        b bVar = b.f100913b;
        HashMap<String, String> hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        IECDataReport.a.a(bVar, key, hashMap != null ? MapsKt__MapsKt.toMap(hashMap) : null, false, 4, null);
    }

    public final void h(long j3) {
        Map map;
        b bVar = b.f100913b;
        HashMap<String, String> hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        if (hashMap != null) {
            hashMap.put("order_detail_page_duration", String.valueOf(j3));
            Unit unit = Unit.INSTANCE;
            map = MapsKt__MapsKt.toMap(hashMap);
        } else {
            map = null;
        }
        IECDataReport.a.a(bVar, "qstore_order_detail_page_duration", map, false, 4, null);
    }

    public final void k() {
        deferReportExposure = false;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String = null;
    }

    public final void i(HashMap<String, String> params) {
        Map map;
        if (params == null) {
            deferReportExposure = true;
            return;
        }
        deferReportExposure = false;
        b bVar = b.f100913b;
        params.put(IPhotoLogicFactory.ENTER_FROM, String.valueOf(common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String.value));
        Unit unit = Unit.INSTANCE;
        map = MapsKt__MapsKt.toMap(params);
        IECDataReport.a.a(bVar, "qstore_order_detail_page_exp", map, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(ECOrderDetailReporter eCOrderDetailReporter, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hashMap = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS java.lang.String;
        }
        eCOrderDetailReporter.i(hashMap);
    }
}
