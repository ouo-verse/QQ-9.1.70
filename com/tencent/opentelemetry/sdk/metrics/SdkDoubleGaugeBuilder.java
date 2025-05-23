package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder;
import com.tencent.opentelemetry.api.metrics.LongGaugeBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleGauge;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkDoubleGaugeBuilder extends AbstractInstrumentBuilder<SdkDoubleGaugeBuilder> implements DoubleGaugeBuilder {
    static IPatchRedirector $redirector_;
    private static final ObservableDoubleGauge NOOP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            NOOP = new ObservableDoubleGauge() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkDoubleGaugeBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleGauge, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    com.tencent.opentelemetry.api.metrics.c.a(this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkDoubleGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
        this(meterProviderSharedState, meterSharedState, str, "", "1");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str);
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
    public ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ObservableDoubleGauge) iPatchRedirector.redirect((short) 5, (Object) this, (Object) consumer);
        }
        return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_GAUGE, consumer));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    public SdkDoubleGaugeBuilder getThis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this : (SdkDoubleGaugeBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
    public LongGaugeBuilder ofLongs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LongGaugeBuilder) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (LongGaugeBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: com.tencent.opentelemetry.sdk.metrics.d
            @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
            public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                return new SdkLongGaugeBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
    public /* bridge */ /* synthetic */ DoubleGaugeBuilder setDescription(String str) {
        return (DoubleGaugeBuilder) super.mo233setDescription(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.opentelemetry.api.metrics.DoubleGaugeBuilder
    public /* bridge */ /* synthetic */ DoubleGaugeBuilder setUnit(String str) {
        return (DoubleGaugeBuilder) super.mo234setUnit(str);
    }

    SdkDoubleGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
        super(meterProviderSharedState, meterSharedState, str, str2, str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, meterProviderSharedState, meterSharedState, str, str2, str3);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder, com.tencent.opentelemetry.sdk.metrics.SdkDoubleGaugeBuilder] */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    /* renamed from: setDescription, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SdkDoubleGaugeBuilder mo233setDescription(String str) {
        return super.mo233setDescription(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder, com.tencent.opentelemetry.sdk.metrics.SdkDoubleGaugeBuilder] */
    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    /* renamed from: setUnit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ SdkDoubleGaugeBuilder mo234setUnit(String str) {
        return super.mo234setUnit(str);
    }
}
