package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.LongHistogram;
import com.tencent.opentelemetry.api.metrics.LongHistogramBuilder;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.SdkLongHistogram;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkLongHistogram extends AbstractInstrument implements LongHistogram {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SdkLongHistogram";
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongHistogramBuilder {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str, str2, str3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ SdkLongHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongHistogram(instrumentDescriptor, writeableMetricStorage, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this : (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public /* bridge */ /* synthetic */ LongHistogramBuilder setDescription(String str) {
            return (LongHistogramBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public /* bridge */ /* synthetic */ LongHistogramBuilder setUnit(String str) {
            return (LongHistogramBuilder) super.mo234setUnit(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongHistogramBuilder
        public SdkLongHistogram build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (SdkLongHistogram) buildSynchronousInstrument(InstrumentType.HISTOGRAM, InstrumentValueType.LONG, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.j
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkLongHistogram lambda$build$0;
                    lambda$build$0 = SdkLongHistogram.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            }) : (SdkLongHistogram) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* synthetic */ SdkLongHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    public BoundLongHistogram bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundLongHistogram) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
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

    @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
    public void record(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
            return;
        }
        if (j3 < 0) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Histograms can only record non-negative values. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
                return;
            }
            return;
        }
        this.storage.recordLong(j3, attributes, context);
    }

    SdkLongHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
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
    static final class BoundInstrument implements BoundLongHistogram {
        static IPatchRedirector $redirector_;
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, instrumentDescriptor, boundStorageHandle, attributes);
                return;
            }
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void record(long j3, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), context);
                return;
            }
            if (j3 < 0 && DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(SdkLongHistogram.TAG, "Histograms can only record non-negative values. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
            }
            this.handle.recordLong(j3, this.attributes, context);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.handle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void record(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                record(j3, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            }
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
    public void record(long j3, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            record(j3, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongHistogram
    public void record(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            record(j3, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }
}
