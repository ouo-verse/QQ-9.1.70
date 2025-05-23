package com.tencent.ecommerce.base.opentelemtry.api;

import android.util.Log;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J<\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0016J<\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0016JQ\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012JQ\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/c;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "", "value", "", "counterName", "unit", "description", "", "attributes", "", "addDoubleValue", "", "addLongValue", "histogramName", "", "buckets", "recordDoubleValue", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "recordLongValue", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "<init>", "()V", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class c implements IECOpenTelemetryMetric {
    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void addDoubleValue(double value, @NotNull String counterName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes) {
        Log.i("ECDefaultOTMetric", "IECOpenTelemetryMetric is not implement, use default addDoubleValue");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void addLongValue(long value, @NotNull String counterName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes) {
        Log.i("ECDefaultOTMetric", "IECOpenTelemetryMetric is not implement, use default addDoubleValue");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void recordDoubleValue(double value, @NotNull String histogramName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes, @NotNull Double[] buckets) {
        Log.i("ECDefaultOTMetric", "IECOpenTelemetryMetric is not implement, use default recordDoubleValue");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void recordLongValue(long value, @NotNull String histogramName, @NotNull String unit, @NotNull String description, @NotNull Map<String, String> attributes, @NotNull Double[] buckets) {
        Log.i("ECDefaultOTMetric", "IECOpenTelemetryMetric is not implement, use default recordLongValue");
    }
}
