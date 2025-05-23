package com.tencent.mobileqq.qqecommerce.base.somanager;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0005B#\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/somanager/b;", "", "", "params", "", "a", "", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "b", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "", "c", "reportData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasReported", "", "e", "J", "startTime", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "f", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String eventName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Object, Object> params;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Map<Object, Object> reportData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasReported;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    public b(String eventName, Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        this.eventName = eventName;
        this.params = params;
        this.reportData = new LinkedHashMap();
        this.hasReported = new AtomicBoolean(false);
        this.startTime = System.currentTimeMillis();
        this.reportData.putAll(params);
    }

    public final void a(Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.hasReported.compareAndSet(false, true)) {
            if (this.eventName.length() == 0) {
                QLog.e("ECShowPageCostTimeModel", 1, "eventName invalid.");
            }
            this.reportData.putAll(params);
            this.reportData.put("cost_time", Long.valueOf(System.currentTimeMillis() - this.startTime));
            IECDataReport.a.a(new ECDataReportManager(), this.eventName, this.reportData, false, 4, null);
        }
    }
}
