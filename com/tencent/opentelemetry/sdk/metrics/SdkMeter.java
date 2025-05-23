package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder;
import com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder;
import com.tencent.opentelemetry.api.metrics.LongCounterBuilder;
import com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import com.tencent.opentelemetry.api.metrics.Meter;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleHistogram;
import com.tencent.opentelemetry.sdk.metrics.SdkLongCounter;
import com.tencent.opentelemetry.sdk.metrics.SdkLongUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkMeter implements Meter {
    static IPatchRedirector $redirector_;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final MeterProviderSharedState meterProviderSharedState;
    private final MeterSharedState meterSharedState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeter(MeterProviderSharedState meterProviderSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) meterProviderSharedState, (Object) instrumentationScopeInfo);
            return;
        }
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.meterProviderSharedState = meterProviderSharedState;
        this.meterSharedState = MeterSharedState.create(instrumentationScopeInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<MetricData> collectAll(CollectionInfo collectionInfo, long j3, boolean z16) {
        return this.meterSharedState.collectAll(collectionInfo, this.meterProviderSharedState, j3, z16);
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public LongCounterBuilder counterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LongCounterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return new SdkLongCounter.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public DoubleGaugeBuilder gaugeBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DoubleGaugeBuilder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return new SdkDoubleGaugeBuilder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public DoubleHistogramBuilder histogramBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DoubleHistogramBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return new SdkDoubleHistogram.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }

    @Override // com.tencent.opentelemetry.api.metrics.Meter
    public LongUpDownCounterBuilder upDownCounterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LongUpDownCounterBuilder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return new SdkLongUpDownCounter.Builder(this.meterProviderSharedState, this.meterSharedState, str);
    }
}
