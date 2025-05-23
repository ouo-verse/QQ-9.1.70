package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbstractInstrumentBuilder<BuilderT extends AbstractInstrumentBuilder<?>> {
    static IPatchRedirector $redirector_;
    private String description;
    protected final String instrumentName;
    private final MeterProviderSharedState meterProviderSharedState;
    protected final MeterSharedState meterSharedState;
    private String unit;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @FunctionalInterface
    /* loaded from: classes22.dex */
    public interface SwapBuilder<T> {
        T newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractInstrumentBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, meterProviderSharedState, meterSharedState, str, str2, str3);
            return;
        }
        this.instrumentName = str;
        this.description = str2;
        this.unit = str3;
        this.meterProviderSharedState = meterProviderSharedState;
        this.meterSharedState = meterSharedState;
    }

    private InstrumentDescriptor makeDescriptor(InstrumentType instrumentType, InstrumentValueType instrumentValueType) {
        return InstrumentDescriptor.create(this.instrumentName, this.description, this.unit, instrumentType, instrumentValueType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <I extends AbstractInstrument> I buildSynchronousInstrument(InstrumentType instrumentType, InstrumentValueType instrumentValueType, BiFunction<InstrumentDescriptor, WriteableMetricStorage, I> biFunction) {
        Object apply;
        InstrumentDescriptor makeDescriptor = makeDescriptor(instrumentType, instrumentValueType);
        apply = biFunction.apply(makeDescriptor, this.meterSharedState.registerSynchronousMetricStorage(makeDescriptor, this.meterProviderSharedState));
        return (I) apply;
    }

    protected abstract BuilderT getThis();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CallbackRegistration<ObservableDoubleMeasurement> registerDoubleAsynchronousInstrument(InstrumentType instrumentType, Consumer<ObservableDoubleMeasurement> consumer) {
        return this.meterSharedState.registerDoubleAsynchronousInstrument(makeDescriptor(instrumentType, InstrumentValueType.DOUBLE), this.meterProviderSharedState, consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final CallbackRegistration<ObservableLongMeasurement> registerLongAsynchronousInstrument(InstrumentType instrumentType, Consumer<ObservableLongMeasurement> consumer) {
        return this.meterSharedState.registerLongAsynchronousInstrument(makeDescriptor(instrumentType, InstrumentValueType.LONG), this.meterProviderSharedState, consumer);
    }

    /* renamed from: setDescription */
    public BuilderT mo233setDescription(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BuilderT) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.description = str;
        return getThis();
    }

    /* renamed from: setUnit */
    public BuilderT mo234setUnit(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BuilderT) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.unit = str;
        return getThis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T swapBuilder(SwapBuilder<T> swapBuilder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this, (Object) swapBuilder);
        }
        return swapBuilder.newBuilder(this.meterProviderSharedState, this.meterSharedState, this.instrumentName, this.description, this.unit);
    }
}
