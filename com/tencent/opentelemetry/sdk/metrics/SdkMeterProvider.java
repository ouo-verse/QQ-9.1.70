package com.tencent.opentelemetry.sdk.metrics;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.metrics.Meter;
import com.tencent.opentelemetry.api.metrics.MeterBuilder;
import com.tencent.opentelemetry.api.metrics.MeterProvider;
import com.tencent.opentelemetry.sdk.common.Clock;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.internal.ComponentRegistry;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.export.MetricReader;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo;
import com.tencent.opentelemetry.sdk.metrics.internal.export.MetricProducer;
import com.tencent.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import com.tencent.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: classes22.dex */
public final class SdkMeterProvider implements MeterProvider, Closeable {
    static IPatchRedirector $redirector_ = null;
    static final String DEFAULT_METER_NAME = "unknown";
    private static final String TAG = "SdkMeterProvider";
    private final Map<CollectionHandle, CollectionInfo> collectionInfoMap;
    private final AtomicBoolean isClosed;
    private final AtomicLong lastCollectionTimestamp;
    private final long minimumCollectionIntervalNanos;
    private final ComponentRegistry<SdkMeter> registry;
    private final MeterProviderSharedState sharedState;

    /* loaded from: classes22.dex */
    private class LeasedMetricProducer implements MetricProducer {
        static IPatchRedirector $redirector_;
        private final CollectionHandle handle;

        LeasedMetricProducer(CollectionHandle collectionHandle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SdkMeterProvider.this, (Object) collectionHandle);
            } else {
                this.handle = collectionHandle;
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.export.MetricProducer
        public Collection<MetricData> collectAllMetrics() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Collection components = SdkMeterProvider.this.registry.getComponents();
            long nanoTime = SdkMeterProvider.this.sharedState.getClock().nanoTime();
            if (nanoTime - SdkMeterProvider.this.lastCollectionTimestamp.get() < SdkMeterProvider.this.minimumCollectionIntervalNanos) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                SdkMeterProvider.this.lastCollectionTimestamp.lazySet(nanoTime);
            }
            CollectionInfo collectionInfo = (CollectionInfo) SdkMeterProvider.this.collectionInfoMap.get(this.handle);
            if (collectionInfo != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = components.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((SdkMeter) it.next()).collectAll(collectionInfo, SdkMeterProvider.this.sharedState.getClock().now(), z16));
                }
                return Collections.unmodifiableCollection(arrayList);
            }
            throw new IllegalStateException("No collection info for handle, this is a bug in the OpenTelemetry SDK.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SdkMeterProvider(List<MetricReader> list, Clock clock, Resource resource, ViewRegistry viewRegistry, ExemplarFilter exemplarFilter, long j3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, clock, resource, viewRegistry, exemplarFilter, Long.valueOf(j3));
            return;
        }
        this.isClosed = new AtomicBoolean(false);
        this.sharedState = MeterProviderSharedState.create(clock, resource, viewRegistry, exemplarFilter);
        this.registry = new ComponentRegistry<>(new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.m
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                SdkMeter lambda$new$0;
                lambda$new$0 = SdkMeterProvider.this.lambda$new$0((InstrumentationScopeInfo) obj2);
                return lambda$new$0;
            }
        });
        this.lastCollectionTimestamp = new AtomicLong(clock.nanoTime() - j3);
        this.minimumCollectionIntervalNanos = j3;
        Set<CollectionHandle> mutableSet = CollectionHandle.mutableSet();
        this.collectionInfoMap = new HashMap();
        Supplier<CollectionHandle> createSupplier = CollectionHandle.createSupplier();
        for (MetricReader metricReader : list) {
            obj = createSupplier.get();
            CollectionHandle collectionHandle = (CollectionHandle) obj;
            this.collectionInfoMap.put(collectionHandle, CollectionInfo.create(collectionHandle, mutableSet, metricReader));
            metricReader.register(new LeasedMetricProducer(collectionHandle));
            mutableSet.add(collectionHandle);
        }
    }

    public static SdkMeterProviderBuilder builder() {
        return new SdkMeterProviderBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SdkMeter lambda$new$0(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkMeter(this.sharedState, instrumentationScopeInfo);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.collectionInfoMap.isEmpty()) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CollectionInfo> it = this.collectionInfoMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getReader().flush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public /* synthetic */ Meter get(String str) {
        return com.tencent.opentelemetry.api.metrics.a.a(this, str);
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public MeterBuilder meterBuilder(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MeterBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (this.collectionInfoMap.isEmpty()) {
            return com.tencent.opentelemetry.api.metrics.a.c().meterBuilder(str);
        }
        if (str == null || str.isEmpty()) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.i(TAG, "Meter requested without instrumentation scope name.");
            }
            str = "unknown";
        }
        return new SdkMeterBuilder(this.registry, str);
    }

    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (!this.isClosed.compareAndSet(false, true)) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.i(TAG, "Multiple close calls");
            }
            return CompletableResultCode.ofSuccess();
        }
        if (this.collectionInfoMap.isEmpty()) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<CollectionInfo> it = this.collectionInfoMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getReader().shutdown());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.api.metrics.MeterProvider
    public /* synthetic */ Meter get(String str, String str2, String str3) {
        return com.tencent.opentelemetry.api.metrics.a.b(this, str, str2, str3);
    }
}
