package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.DoubleHistogram;
import com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder;
import com.tencent.opentelemetry.api.metrics.LongHistogramBuilder;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleHistogram;
import com.tencent.opentelemetry.sdk.metrics.SdkLongHistogram;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkDoubleHistogram extends AbstractInstrument implements DoubleHistogram {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SdkDoubleHistogram";
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleHistogramBuilder {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            this(meterProviderSharedState, meterSharedState, str, "", "1");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ SdkDoubleHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleHistogram(instrumentDescriptor, writeableMetricStorage, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this : (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public LongHistogramBuilder ofLongs() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (LongHistogramBuilder) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return (LongHistogramBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: com.tencent.opentelemetry.sdk.metrics.e
                @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkLongHistogram.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public /* bridge */ /* synthetic */ DoubleHistogramBuilder setDescription(String str) {
            return (DoubleHistogramBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public /* bridge */ /* synthetic */ DoubleHistogramBuilder setUnit(String str) {
            return (DoubleHistogramBuilder) super.mo234setUnit(str);
        }

        Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, meterProviderSharedState, meterSharedState, str, str2, str3);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogramBuilder
        public SdkDoubleHistogram build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (SdkDoubleHistogram) buildSynchronousInstrument(InstrumentType.HISTOGRAM, InstrumentValueType.DOUBLE, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.f
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkDoubleHistogram lambda$build$0;
                    lambda$build$0 = SdkDoubleHistogram.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            }) : (SdkDoubleHistogram) iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* synthetic */ SdkDoubleHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    public BoundDoubleHistogram bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundDoubleHistogram) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
        }
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrument
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrument
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
            return;
        }
        if (d16 < 0.0d) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Histograms can only record non-negative values. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
                return;
            }
            return;
        }
        this.storage.recordDouble(d16, attributes, context);
    }

    SdkDoubleHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.storage = writeableMetricStorage;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor, (Object) writeableMetricStorage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class BoundInstrument implements BoundDoubleHistogram {
        static IPatchRedirector $redirector_;
        private final BoundStorageHandle aggregatorHandle;
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, instrumentDescriptor, boundStorageHandle, attributes);
                return;
            }
            this.descriptor = instrumentDescriptor;
            this.aggregatorHandle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void record(double d16, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), context);
                return;
            }
            if (d16 < 0.0d) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(SdkDoubleHistogram.TAG, "Histograms can only record non-negative values. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
                    return;
                }
                return;
            }
            this.aggregatorHandle.recordDouble(d16, this.attributes, context);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.aggregatorHandle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void record(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                record(d16, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
            }
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d16, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            record(d16, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            record(d16, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }
    }
}
