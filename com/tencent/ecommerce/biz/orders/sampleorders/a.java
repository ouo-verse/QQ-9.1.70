package com.tencent.ecommerce.biz.orders.sampleorders;

import android.os.SystemClock;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/a;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "leftTimeMs", "", "c", "a", "b", "", "Ljava/util/Map;", "orderIdToStopTime", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f103795b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Long> orderIdToStopTime = new LinkedHashMap();

    a() {
    }

    public final long a(String orderId) {
        Long l3 = orderIdToStopTime.get(orderId);
        long longValue = l3 != null ? l3.longValue() : 0L;
        if (longValue < SystemClock.elapsedRealtime()) {
            return 0L;
        }
        return longValue - SystemClock.elapsedRealtime();
    }

    public final void b() {
        orderIdToStopTime.clear();
    }

    public final void c(String orderId, long leftTimeMs) {
        orderIdToStopTime.put(orderId, Long.valueOf(leftTimeMs + SystemClock.elapsedRealtime()));
    }
}
