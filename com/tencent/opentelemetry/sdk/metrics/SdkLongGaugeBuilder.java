package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.metrics.LongGaugeBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableLongGauge;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkLongGaugeBuilder extends AbstractInstrumentBuilder<SdkLongGaugeBuilder> implements LongGaugeBuilder {
    static IPatchRedirector $redirector_;
    private static final ObservableLongGauge NOOP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            NOOP = new ObservableLongGauge() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkLongGaugeBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableLongGauge, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    com.tencent.opentelemetry.api.metrics.f.a(this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkLongGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
        super(meterProviderSharedState, meterSharedState, str, str2, str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str, str2, str3);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
    public ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ObservableLongGauge) iPatchRedirector.redirect((short) 3, (Object) this, (Object) consumer);
        }
        return new SdkObservableInstrument(this.meterSharedState, registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_GAUGE, consumer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    public SdkLongGaugeBuilder getThis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this : (SdkLongGaugeBuilder) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
    public /* bridge */ /* synthetic */ LongGaugeBuilder setDescription(String str) {
        return (LongGaugeBuilder) super.mo233setDescription(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.opentelemetry.api.metrics.LongGaugeBuilder
    public /* bridge */ /* synthetic */ LongGaugeBuilder setUnit(String str) {
        return (LongGaugeBuilder) super.mo234setUnit(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.SdkLongGaugeBuilder, com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder] */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    /* renamed from: setDescription */
    public /* bridge */ /* synthetic */ SdkLongGaugeBuilder mo233setDescription(String str) {
        return super.mo233setDescription(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.SdkLongGaugeBuilder, com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder] */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    /* renamed from: setUnit */
    public /* bridge */ /* synthetic */ SdkLongGaugeBuilder mo234setUnit(String str) {
        return super.mo234setUnit(str);
    }
}
