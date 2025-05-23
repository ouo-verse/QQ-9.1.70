package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import com.tencent.opentelemetry.api.metrics.LongUpDownCounter;
import com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.SdkLongUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkLongUpDownCounter extends AbstractInstrument implements LongUpDownCounter {
    static IPatchRedirector $redirector_;
    private static final ObservableLongUpDownCounter NOOP;
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class BoundInstrument implements BoundLongUpDownCounter {
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

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void add(long j3, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.handle.recordLong(j3, this.attributes, context);
            } else {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), context);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.handle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void add(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                add(j3, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongUpDownCounterBuilder {
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
        public static /* synthetic */ SdkLongUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongUpDownCounter(instrumentDescriptor, writeableMetricStorage, null);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (LongUpDownCounter) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return (LongUpDownCounter) buildSynchronousInstrument(InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.LONG, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.k
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkLongUpDownCounter lambda$build$0;
                    lambda$build$0 = SdkLongUpDownCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            });
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ObservableLongUpDownCounter) iPatchRedirector.redirect((short) 6, (Object) this, (Object) consumer);
            }
            return new SdkObservableInstrument(this.meterSharedState, registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this : (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public DoubleUpDownCounterBuilder ofDoubles() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (DoubleUpDownCounterBuilder) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return (DoubleUpDownCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: com.tencent.opentelemetry.sdk.metrics.l
                @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleUpDownCounter.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public /* bridge */ /* synthetic */ LongUpDownCounterBuilder setDescription(String str) {
            return (LongUpDownCounterBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public /* bridge */ /* synthetic */ LongUpDownCounterBuilder setUnit(String str) {
            return (LongUpDownCounterBuilder) super.mo234setUnit(str);
        }

        Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, meterProviderSharedState, meterSharedState, str, str2, str3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            NOOP = new ObservableLongUpDownCounter() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkLongUpDownCounter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableLongUpDownCounter, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    com.tencent.opentelemetry.api.metrics.g.a(this);
                }
            };
        }
    }

    /* synthetic */ SdkLongUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.storage.recordLong(j3, attributes, context);
        } else {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
        }
    }

    public BoundLongUpDownCounter bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundLongUpDownCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
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

    SdkLongUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.storage = writeableMetricStorage;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentDescriptor, (Object) writeableMetricStorage);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j3, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            add(j3, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            add(j3, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }
}
