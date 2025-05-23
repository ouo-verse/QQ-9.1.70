package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.opentelemetry.api.metrics.ObservableLongMeasurement;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MeterSharedState {
    static IPatchRedirector $redirector_;
    private final Object callbackLock;
    private final List<CallbackRegistration<?>> callbackRegistrations;
    private final Object collectLock;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final MetricStorageRegistry metricStorageRegistry;

    MeterSharedState(InstrumentationScopeInfo instrumentationScopeInfo, MetricStorageRegistry metricStorageRegistry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) instrumentationScopeInfo, (Object) metricStorageRegistry);
            return;
        }
        this.collectLock = new Object();
        this.callbackLock = new Object();
        this.callbackRegistrations = new ArrayList();
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.metricStorageRegistry = metricStorageRegistry;
    }

    public static MeterSharedState create(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new MeterSharedState(instrumentationScopeInfo, new MetricStorageRegistry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AsynchronousMetricStorage lambda$registerAsynchronousInstrument$2(InstrumentDescriptor instrumentDescriptor, RegisteredView registeredView) {
        return AsynchronousMetricStorage.create(registeredView, instrumentDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$registerAsynchronousInstrument$3(AsynchronousMetricStorage asynchronousMetricStorage) {
        return !asynchronousMetricStorage.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SynchronousMetricStorage lambda$registerSynchronousMetricStorage$0(InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState, RegisteredView registeredView) {
        return s.a(registeredView, instrumentDescriptor, meterProviderSharedState.getExemplarFilter());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$registerSynchronousMetricStorage$1(SynchronousMetricStorage synchronousMetricStorage) {
        return !synchronousMetricStorage.isEmpty();
    }

    private List<AsynchronousMetricStorage<?>> registerAsynchronousInstrument(final InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState) {
        Stream stream;
        Stream map;
        Stream filter;
        Collector list;
        Object collect;
        stream = meterProviderSharedState.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo()).stream();
        map = stream.map(new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AsynchronousMetricStorage lambda$registerAsynchronousInstrument$2;
                lambda$registerAsynchronousInstrument$2 = MeterSharedState.lambda$registerAsynchronousInstrument$2(InstrumentDescriptor.this, (RegisteredView) obj);
                return lambda$registerAsynchronousInstrument$2;
            }
        });
        filter = map.filter(new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$registerAsynchronousInstrument$3;
                lambda$registerAsynchronousInstrument$3 = MeterSharedState.lambda$registerAsynchronousInstrument$3((AsynchronousMetricStorage) obj);
                return lambda$registerAsynchronousInstrument$3;
            }
        });
        list = Collectors.toList();
        collect = filter.collect(list);
        List list2 = (List) collect;
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((AsynchronousMetricStorage) getMetricStorageRegistry().register((AsynchronousMetricStorage) it.next()));
        }
        return arrayList;
    }

    public List<MetricData> collectAll(CollectionInfo collectionInfo, MeterProviderSharedState meterProviderSharedState, long j3, boolean z16) {
        ArrayList arrayList;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, collectionInfo, meterProviderSharedState, Long.valueOf(j3), Boolean.valueOf(z16));
        }
        synchronized (this.callbackLock) {
            arrayList = new ArrayList(this.callbackRegistrations);
        }
        synchronized (this.collectLock) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((CallbackRegistration) it.next()).invokeCallback();
            }
            Collection<MetricStorage> metrics = getMetricStorageRegistry().getMetrics();
            arrayList2 = new ArrayList(metrics.size());
            Iterator<MetricStorage> it5 = metrics.iterator();
            while (it5.hasNext()) {
                MetricData collectAndReset = it5.next().collectAndReset(collectionInfo, meterProviderSharedState.getResource(), getInstrumentationScopeInfo(), meterProviderSharedState.getStartEpochNanos(), j3, z16);
                if (!collectAndReset.isEmpty()) {
                    arrayList2.add(collectAndReset);
                }
            }
        }
        return arrayList2;
    }

    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InstrumentationScopeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.instrumentationScopeInfo;
    }

    MetricStorageRegistry getMetricStorageRegistry() {
        return this.metricStorageRegistry;
    }

    public final CallbackRegistration<ObservableDoubleMeasurement> registerDoubleAsynchronousInstrument(InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState, Consumer<ObservableDoubleMeasurement> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CallbackRegistration) iPatchRedirector.redirect((short) 7, this, instrumentDescriptor, meterProviderSharedState, consumer);
        }
        CallbackRegistration<ObservableDoubleMeasurement> createDouble = CallbackRegistration.createDouble(instrumentDescriptor, consumer, registerAsynchronousInstrument(instrumentDescriptor, meterProviderSharedState));
        synchronized (this.callbackLock) {
            this.callbackRegistrations.add(createDouble);
        }
        return createDouble;
    }

    public final CallbackRegistration<ObservableLongMeasurement> registerLongAsynchronousInstrument(InstrumentDescriptor instrumentDescriptor, MeterProviderSharedState meterProviderSharedState, Consumer<ObservableLongMeasurement> consumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CallbackRegistration) iPatchRedirector.redirect((short) 6, this, instrumentDescriptor, meterProviderSharedState, consumer);
        }
        CallbackRegistration<ObservableLongMeasurement> createLong = CallbackRegistration.createLong(instrumentDescriptor, consumer, registerAsynchronousInstrument(instrumentDescriptor, meterProviderSharedState));
        synchronized (this.callbackLock) {
            this.callbackRegistrations.add(createLong);
        }
        return createLong;
    }

    public final WriteableMetricStorage registerSynchronousMetricStorage(final InstrumentDescriptor instrumentDescriptor, final MeterProviderSharedState meterProviderSharedState) {
        Stream stream;
        Stream map;
        Stream filter;
        Collector list;
        Object collect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            stream = meterProviderSharedState.getViewRegistry().findViews(instrumentDescriptor, getInstrumentationScopeInfo()).stream();
            map = stream.map(new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    SynchronousMetricStorage lambda$registerSynchronousMetricStorage$0;
                    lambda$registerSynchronousMetricStorage$0 = MeterSharedState.lambda$registerSynchronousMetricStorage$0(InstrumentDescriptor.this, meterProviderSharedState, (RegisteredView) obj);
                    return lambda$registerSynchronousMetricStorage$0;
                }
            });
            filter = map.filter(new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.g
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$registerSynchronousMetricStorage$1;
                    lambda$registerSynchronousMetricStorage$1 = MeterSharedState.lambda$registerSynchronousMetricStorage$1((SynchronousMetricStorage) obj);
                    return lambda$registerSynchronousMetricStorage$1;
                }
            });
            list = Collectors.toList();
            collect = filter.collect(list);
            List list2 = (List) collect;
            ArrayList arrayList = new ArrayList(list2.size());
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add((SynchronousMetricStorage) getMetricStorageRegistry().register((SynchronousMetricStorage) it.next()));
            }
            if (arrayList.size() == 1) {
                return (WriteableMetricStorage) arrayList.get(0);
            }
            return new MultiWritableMetricStorage(arrayList);
        }
        return (WriteableMetricStorage) iPatchRedirector.redirect((short) 5, (Object) this, (Object) instrumentDescriptor, (Object) meterProviderSharedState);
    }

    public void removeCallback(CallbackRegistration<?> callbackRegistration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callbackRegistration);
            return;
        }
        synchronized (this.callbackLock) {
            this.callbackRegistrations.remove(callbackRegistration);
        }
    }
}
