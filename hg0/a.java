package hg0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J:\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nJQ\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lhg0/a;", "", "", "counterName", "description", "", "b", "", "value", "unit", "", "attributes", "a", "histogramName", "", "", "buckets", "d", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "metricsProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f404850b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECOpenTelemetryMetric metricsProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOpenTelemetry().getMetricsManager();

    a() {
    }

    public final void a(long value, String counterName, String unit, String description, Map<String, String> attributes) {
        metricsProxy.addLongValue(value, counterName, unit, description, attributes);
    }

    public final void b(String counterName, String description) {
        Map<String, String> emptyMap;
        IECOpenTelemetryMetric iECOpenTelemetryMetric = metricsProxy;
        emptyMap = MapsKt__MapsKt.emptyMap();
        iECOpenTelemetryMetric.addLongValue(1L, counterName, "1", description, emptyMap);
    }

    public final void d(long value, String histogramName, String unit, String description, Map<String, String> attributes, Double[] buckets) {
        metricsProxy.recordLongValue(value, histogramName, unit, description, attributes, buckets);
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "normal counter report";
        }
        aVar.b(str, str2);
    }
}
