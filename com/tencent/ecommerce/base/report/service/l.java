package com.tencent.ecommerce.base.report.service;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0005B#\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/l;", "", "", "params", "", "a", "", "Ljava/util/Map;", "reportData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReported", "", "c", "J", "startTime", "", "d", "Ljava/lang/String;", AdMetricTag.EVENT_NAME, "e", "getParams", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<Object, Object> reportData = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasReported = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long startTime = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String eventName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<Object, Object> params;

    public l(String str, Map<Object, ? extends Object> map) {
        this.eventName = str;
        this.params = map;
        this.reportData.putAll(map);
    }

    public final void a(Map<Object, ? extends Object> params) {
        if (this.hasReported.compareAndSet(false, true)) {
            if (this.eventName.length() == 0) {
                cg0.a.a("ECShowPageCostTimeModel", "report", "eventName invalid.");
            }
            this.reportData.putAll(params);
            this.reportData.put("cost_time", Long.valueOf(System.currentTimeMillis() - this.startTime));
            IECDataReport.a.a(b.f100913b, this.eventName, this.reportData, false, 4, null);
        }
    }
}
