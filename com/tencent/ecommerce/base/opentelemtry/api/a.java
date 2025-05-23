package com.tencent.ecommerce.base.opentelemtry.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/a;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "getSpanManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "getMetricsManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryLogger;", "getLoggerManager", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECOpenTelemetry {
    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    @NotNull
    public IECOpenTelemetryLogger getLoggerManager() {
        return new b();
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    @NotNull
    public IECOpenTelemetryMetric getMetricsManager() {
        return new c();
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    @NotNull
    public IECSpan getSpanManager() {
        return new d();
    }
}
