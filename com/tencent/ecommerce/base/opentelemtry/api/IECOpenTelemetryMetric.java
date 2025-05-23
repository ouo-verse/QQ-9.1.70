package com.tencent.ecommerce.base.opentelemtry.api;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH&J<\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bH&JO\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&\u00a2\u0006\u0002\u0010\u0012JO\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "", "addDoubleValue", "", "value", "", "counterName", "", "unit", "description", "attributes", "", "addLongValue", "", "recordDoubleValue", "histogramName", "buckets", "", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "recordLongValue", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECOpenTelemetryMetric {
    void addDoubleValue(double value, @NotNull String counterName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes);

    void addLongValue(long value, @NotNull String counterName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes);

    void recordDoubleValue(double value, @NotNull String histogramName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes, @NotNull Double[] buckets);

    void recordLongValue(long value, @NotNull String histogramName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes, @NotNull Double[] buckets);
}
