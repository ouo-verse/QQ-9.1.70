package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
class DeltaMetricStorage<T> {
    static IPatchRedirector $redirector_ = null;
    private static final BoundStorageHandle NOOP_STORAGE_HANDLE;
    private static final String TAG = "DeltaMetricStorage";
    private final ConcurrentHashMap<Attributes, AggregatorHandle<T>> activeCollectionStorage;
    private final Aggregator<T> aggregator;
    private final InstrumentDescriptor instrument;
    private final List<DeltaAccumulation<T>> unreportedDeltas;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class NoopBoundHandle implements BoundStorageHandle {
        static IPatchRedirector $redirector_;

        NoopBoundHandle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d16, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j3, Attributes attributes, Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
            }
        }

        @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        /* synthetic */ NoopBoundHandle(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            NOOP_STORAGE_HANDLE = new NoopBoundHandle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeltaMetricStorage(Aggregator<T> aggregator, InstrumentDescriptor instrumentDescriptor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aggregator, (Object) instrumentDescriptor);
            return;
        }
        this.activeCollectionStorage = new ConcurrentHashMap<>();
        this.unreportedDeltas = new ArrayList();
        this.aggregator = aggregator;
        this.instrument = instrumentDescriptor;
    }

    private synchronized void collectSynchronousDeltaAccumulationAndReset() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Attributes, AggregatorHandle<T>> entry : this.activeCollectionStorage.entrySet()) {
            if (entry.getValue().tryUnmap()) {
                this.activeCollectionStorage.remove(entry.getKey(), entry.getValue());
            }
            T accumulateThenReset = entry.getValue().accumulateThenReset(entry.getKey());
            if (accumulateThenReset != null) {
                hashMap.put(entry.getKey(), accumulateThenReset);
            }
        }
        if (!hashMap.isEmpty()) {
            this.unreportedDeltas.add(new DeltaAccumulation<>(hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$collectFor$0(Set set, DeltaAccumulation deltaAccumulation) {
        return deltaAccumulation.wasReadByAll(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$mergeInPlace$1(Map map, Aggregator aggregator, Attributes attributes, Object obj) {
        if (map.containsKey(attributes)) {
            map.put(attributes, aggregator.merge(map.get(attributes), obj));
        } else {
            map.put(attributes, obj);
        }
    }

    static <T> void mergeInPlace(final Map<Attributes, T> map, Map<Attributes, T> map2, final Aggregator<T> aggregator) {
        map2.forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.c
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DeltaMetricStorage.lambda$mergeInPlace$1(map, aggregator, (Attributes) obj, obj2);
            }
        });
    }

    public BoundStorageHandle bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BoundStorageHandle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes);
        }
        AggregatorHandle<T> aggregatorHandle = this.activeCollectionStorage.get(attributes);
        if (aggregatorHandle != null && aggregatorHandle.acquire()) {
            return aggregatorHandle;
        }
        AggregatorHandle<T> createHandle = this.aggregator.createHandle();
        while (this.activeCollectionStorage.size() < 2000) {
            AggregatorHandle<T> putIfAbsent = this.activeCollectionStorage.putIfAbsent(attributes, createHandle);
            if (putIfAbsent != null) {
                if (putIfAbsent.acquire()) {
                    return putIfAbsent;
                }
                this.activeCollectionStorage.remove(attributes, putIfAbsent);
            } else {
                return createHandle;
            }
        }
        if (DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.w(TAG, "Instrument " + this.instrument.getName() + " has exceeded the maximum allowed accumulations (2000).");
        }
        return NOOP_STORAGE_HANDLE;
    }

    public synchronized Map<Attributes, T> collectFor(CollectionHandle collectionHandle, final Set<CollectionHandle> set, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, this, collectionHandle, set, Boolean.valueOf(z16));
        }
        if (!z16) {
            collectSynchronousDeltaAccumulationAndReset();
        }
        HashMap hashMap = new HashMap();
        for (DeltaAccumulation<T> deltaAccumulation : this.unreportedDeltas) {
            if (!deltaAccumulation.wasReadBy(collectionHandle)) {
                MetricStorageUtils.mergeInPlace(hashMap, deltaAccumulation.read(collectionHandle), this.aggregator);
            }
        }
        this.unreportedDeltas.removeIf(new Predicate() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lambda$collectFor$0;
                lambda$collectFor$0 = DeltaMetricStorage.lambda$collectFor$0(set, (DeltaAccumulation) obj);
                return lambda$collectFor$0;
            }
        });
        return hashMap;
    }
}
