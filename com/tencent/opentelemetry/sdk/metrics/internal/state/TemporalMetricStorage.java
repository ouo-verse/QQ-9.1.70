package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.metrics.data.AggregationTemporality;
import com.tencent.opentelemetry.sdk.metrics.data.MetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.EmptyMetricData;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionHandle;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
class TemporalMetricStorage<T> {
    static IPatchRedirector $redirector_;
    private final Aggregator<T> aggregator;
    private final boolean isSynchronous;
    private final Map<CollectionHandle, LastReportedAccumulation<T>> reportHistory;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class LastReportedAccumulation<T> {
        static IPatchRedirector $redirector_;

        @Nullable
        private final Map<Attributes, T> accumulation;
        private final long epochNanos;

        LastReportedAccumulation(@Nullable Map<Attributes, T> map, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, map, Long.valueOf(j3));
            } else {
                this.accumulation = map;
                this.epochNanos = j3;
            }
        }

        @Nullable
        public Map<Attributes, T> getAccumulation() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.accumulation;
        }

        long getEpochNanos() {
            return this.epochNanos;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TemporalMetricStorage(Aggregator<T> aggregator, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aggregator, Boolean.valueOf(z16));
            return;
        }
        this.reportHistory = new HashMap();
        this.aggregator = aggregator;
        this.isSynchronous = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized MetricData buildMetricFor(CollectionHandle collectionHandle, Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, AggregationTemporality aggregationTemporality, Map<Attributes, T> map, long j3, long j16) {
        long j17;
        Map<Attributes, T> map2;
        Map<Attributes, T> accumulation;
        if (this.reportHistory.containsKey(collectionHandle)) {
            LastReportedAccumulation<T> lastReportedAccumulation = this.reportHistory.get(collectionHandle);
            long epochNanos = lastReportedAccumulation.getEpochNanos();
            if (aggregationTemporality == AggregationTemporality.DELTA && !this.isSynchronous) {
                MetricStorageUtils.diffInPlace(lastReportedAccumulation.getAccumulation(), map, this.aggregator);
                accumulation = lastReportedAccumulation.getAccumulation();
            } else if (aggregationTemporality == AggregationTemporality.CUMULATIVE && this.isSynchronous) {
                MetricStorageUtils.mergeAndPreserveInPlace(lastReportedAccumulation.getAccumulation(), map, this.aggregator);
                if (lastReportedAccumulation.getAccumulation() != null && lastReportedAccumulation.getAccumulation().size() > 2000) {
                    MetricStorageUtils.removeUnseen(lastReportedAccumulation.getAccumulation(), map);
                }
                accumulation = lastReportedAccumulation.getAccumulation();
            } else {
                map2 = map;
                j17 = epochNanos;
            }
            map2 = accumulation;
            j17 = epochNanos;
        } else {
            j17 = j3;
            map2 = map;
        }
        if (this.isSynchronous) {
            this.reportHistory.put(collectionHandle, new LastReportedAccumulation<>(map2, j16));
        } else {
            this.reportHistory.put(collectionHandle, new LastReportedAccumulation<>(map, j16));
        }
        if (map2 != null && !map2.isEmpty()) {
            return this.aggregator.toMetricData(resource, instrumentationScopeInfo, metricDescriptor, map2, aggregationTemporality, j3, j17, j16);
        }
        return EmptyMetricData.getInstance();
    }
}
