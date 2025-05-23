package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MetricStorageRegistry {
    static IPatchRedirector $redirector_;
    private final ConcurrentMap<String, MetricStorage> registry;

    public MetricStorageRegistry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.registry = new ConcurrentHashMap();
        }
    }

    public Collection<MetricStorage> getMetrics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Collection) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Collections.unmodifiableCollection(new ArrayList(this.registry.values()));
    }

    public <I extends MetricStorage> I register(final I i3) {
        Object computeIfAbsent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (I) iPatchRedirector.redirect((short) 3, (Object) this, (Object) i3);
        }
        MetricDescriptor metricDescriptor = i3.getMetricDescriptor();
        computeIfAbsent = this.registry.computeIfAbsent(metricDescriptor.getName().toLowerCase(), new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                MetricStorage lambda$register$0;
                lambda$register$0 = MetricStorageRegistry.lambda$register$0(MetricStorage.this, (String) obj);
                return lambda$register$0;
            }
        });
        I i16 = (I) computeIfAbsent;
        if (i16.getMetricDescriptor().isCompatibleWith(metricDescriptor)) {
            if (i3.getClass().equals(i16.getClass())) {
                return i16;
            }
            throw new DuplicateMetricStorageException(i16.getMetricDescriptor(), metricDescriptor, "Metric with same name and different instrument already created.");
        }
        throw new DuplicateMetricStorageException(i16.getMetricDescriptor(), metricDescriptor, "Metric with same name and different descriptor already created.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MetricStorage lambda$register$0(MetricStorage metricStorage, String str) {
        return metricStorage;
    }
}
