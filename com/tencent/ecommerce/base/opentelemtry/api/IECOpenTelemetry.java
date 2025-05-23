package com.tencent.ecommerce.base.opentelemtry.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "", "getLoggerManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryLogger;", "getMetricsManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "getSpanManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECOpenTelemetry {
    @NotNull
    IECOpenTelemetryLogger getLoggerManager();

    @NotNull
    IECOpenTelemetryMetric getMetricsManager();

    @NotNull
    IECSpan getSpanManager();
}
