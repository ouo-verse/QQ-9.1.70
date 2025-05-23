package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.DoubleCounterBuilder;
import com.tencent.opentelemetry.api.metrics.LongCounter;
import com.tencent.opentelemetry.api.metrics.LongCounterBuilder;
import com.tencent.opentelemetry.api.metrics.ObservableLongCounter;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import com.tencent.opentelemetry.sdk.metrics.SdkDoubleCounter;
import com.tencent.opentelemetry.sdk.metrics.SdkLongCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SdkLongCounter extends AbstractInstrument implements LongCounter {
    static IPatchRedirector $redirector_ = null;
    private static final ObservableLongCounter NOOP;
    private static final String TAG = "SdkLongCounter";
    private final WriteableMetricStorage storage;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static final class Builder extends AbstractInstrumentBuilder<Builder> implements LongCounterBuilder {
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
        public static /* synthetic */ SdkLongCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongCounter(instrumentDescriptor, writeableMetricStorage, null);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (ObservableLongCounter) iPatchRedirector.redirect((short) 6, (Object) this, (Object) consumer);
            }
            return new SdkObservableInstrument(this.meterSharedState, registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public Builder getThis() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this : (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public DoubleCounterBuilder ofDoubles() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (DoubleCounterBuilder) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return (DoubleCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: com.tencent.opentelemetry.sdk.metrics.h
                @Override // com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleCounter.Builder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public /* bridge */ /* synthetic */ LongCounterBuilder setDescription(String str) {
            return (LongCounterBuilder) super.mo233setDescription(str);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public /* bridge */ /* synthetic */ LongCounterBuilder setUnit(String str) {
            return (LongCounterBuilder) super.mo234setUnit(str);
        }

        Builder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, str, str2, str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, meterProviderSharedState, meterSharedState, str, str2, str3);
        }

        @Override // com.tencent.opentelemetry.api.metrics.LongCounterBuilder
        public SdkLongCounter build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (SdkLongCounter) buildSynchronousInstrument(InstrumentType.COUNTER, InstrumentValueType.LONG, new BiFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.i
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    SdkLongCounter lambda$build$0;
                    lambda$build$0 = SdkLongCounter.Builder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                    return lambda$build$0;
                }
            }) : (SdkLongCounter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            NOOP = new ObservableLongCounter() { // from class: com.tencent.opentelemetry.sdk.metrics.SdkLongCounter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.opentelemetry.api.metrics.ObservableLongCounter, java.lang.AutoCloseable
                public /* synthetic */ void close() {
                    com.tencent.opentelemetry.api.metrics.e.a(this);
                }
            };
        }
    }

    /* synthetic */ SdkLongCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage, AnonymousClass1 anonymousClass1) {
        this(instrumentDescriptor, writeableMetricStorage);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, writeableMetricStorage, anonymousClass1);
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongCounter
    public void add(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
            return;
        }
        if (j3 < 0) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.w(TAG, "Counters can only increase. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
                return;
            }
            return;
        }
        this.storage.recordLong(j3, attributes, context);
    }

    public BoundLongCounter bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BoundLongCounter) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
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

    SdkLongCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
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
    static final class BoundInstrument implements BoundLongCounter {
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

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void add(long j3, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), context);
                return;
            }
            if (j3 < 0) {
                if (DefaultPrintLogger.isDebug()) {
                    DefaultPrintLogger.w(SdkLongCounter.TAG, "Counters can only increase. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
                    return;
                }
                return;
            }
            this.handle.recordLong(j3, this.attributes, context);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void unbind() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.handle.release();
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void add(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                add(j3, com.tencent.opentelemetry.context.e.k());
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            }
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongCounter
    public void add(long j3, Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            add(j3, attributes, com.tencent.opentelemetry.context.e.k());
        } else {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), attributes);
        }
    }

    @Override // com.tencent.opentelemetry.api.metrics.LongCounter
    public void add(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            add(j3, com.tencent.opentelemetry.api.common.f.b());
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        }
    }
}
