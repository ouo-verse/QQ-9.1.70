package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.DoubleCounter;
import com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleCounter;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkDoubleCounter extends AbstractInstrument implements DoubleCounter {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SdkDoubleCounter";
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleCounterBuilder {
        static IPatchRedirector $redirector_;
        private static final ObservableDoubleCounter NOOP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13650);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                NOOP = new ObservableDoubleCounter() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkDoubleCounter.Builder.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleCounter, java.lang.AutoCloseable
                    public /* synthetic */ void close() {
                        com.tencent.opentelemetry.api.metrics.b.a(this);
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str, str2, str3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ SdkDoubleCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleCounter(instrumentDescriptor, writeableMetricStorage, null);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ObservableDoubleCounter) iPatchRedirector.redirect((short) 4, (Object) this, (Object) consumer);
            }
            return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this : (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public /* bridge */ /* synthetic */ DoubleCounterBuilder setDescription(String str) {
            return (DoubleCounterBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public /* bridge */ /* synthetic */ DoubleCounterBuilder setUnit(String str) {
            return (DoubleCounterBuilder) super.mo234setUnit(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder
        public SdkDoubleCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (SdkDoubleCounter) buildSynchronousInstrument(InstrumentType.COUNTER, InstrumentValueType.DOUBLE, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.c
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkDoubleCounter lambda$build$0;
                    lambda$build$0 = SdkDoubleCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            }) : (SdkDoubleCounter) iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    /* synthetic */ SdkDoubleCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
    public void add(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
            return;
        }
        if (d16 < 0.0d) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Counters can only increase. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
                return;
            }
            return;
        }
        this.storage.recordDouble(d16, attributes, context);
    }

    public BoundDoubleCounter bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundDoubleCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
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

    SdkDoubleCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
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
    static final class BoundInstrument implements BoundDoubleCounter {
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

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void add(double d16, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), context);
                return;
            }
            if (d16 < 0.0d) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(SdkDoubleCounter.TAG, "Counters can only increase. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
                    return;
                }
                return;
            }
            this.handle.recordDouble(d16, this.attributes, context);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.handle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void add(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                add(d16, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
            }
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
    public void add(double d16, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            add(d16, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleCounter
    public void add(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            add(d16, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }
    }
}
