package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter;
import com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkDoubleUpDownCounter extends AbstractInstrument implements DoubleUpDownCounter {
    static IPatchRedirector $redirector_;
    private static final ObservableDoubleUpDownCounter NOOP;
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class BoundInstrument implements BoundDoubleUpDownCounter {
        static IPatchRedirector $redirector_;
        private final Attributes attributes;
        private final BoundStorageHandle handle;

        BoundInstrument(BoundStorageHandle boundStorageHandle, Attributes attributes) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) boundStorageHandle, (Object) attributes);
            } else {
                this.handle = boundStorageHandle;
                this.attributes = attributes;
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void add(double d16, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.handle.recordDouble(d16, this.attributes, context);
            } else {
                iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), context);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.handle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void add(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                add(d16, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements DoubleUpDownCounterBuilder {
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
        public static /* synthetic */ SdkDoubleUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleUpDownCounter(instrumentDescriptor, writeableMetricStorage, null);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (DoubleUpDownCounter) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (DoubleUpDownCounter) buildSynchronousInstrument(InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.DOUBLE, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.g
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkDoubleUpDownCounter lambda$build$0;
                    lambda$build$0 = SdkDoubleUpDownCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            });
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ObservableDoubleUpDownCounter) iPatchRedirector.redirect((short) 4, (Object) this, (Object) consumer);
            }
            return new SdkObservableInstrument(this.meterSharedState, registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this : (Builder) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setDescription(String str) {
            return (DoubleUpDownCounterBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setUnit(String str) {
            return (DoubleUpDownCounterBuilder) super.mo234setUnit(str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12715);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            NOOP = new ObservableDoubleUpDownCounter() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableDoubleUpDownCounter, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    com.tencent.opentelemetry.api.metrics.d.a(this);
                }
            };
        }
    }

    /* synthetic */ SdkDoubleUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.storage.recordDouble(d16, attributes, context);
        } else {
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16), attributes, context);
        }
    }

    public BoundDoubleUpDownCounter bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundDoubleUpDownCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
        }
        return new BoundInstrument(this.storage.bind(attributes), attributes);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrument
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrument
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    SdkDoubleUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.storage = writeableMetricStorage;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor, (Object) writeableMetricStorage);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d16, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            add(d16, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            add(d16, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
        }
    }
}
