package com.tencent.opentelemetry.sdk.metrics.internal.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.export.MetricReader;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public final class AutoValue_CollectionInfo extends CollectionInfo {
    static IPatchRedirector $redirector_;
    private final Set<CollectionHandle> allCollectors;
    private final CollectionHandle collector;
    private final MetricReader reader;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CollectionInfo(CollectionHandle collectionHandle, Set<CollectionHandle> set, MetricReader metricReader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, collectionHandle, set, metricReader);
            return;
        }
        if (collectionHandle != null) {
            this.collector = collectionHandle;
            if (set != null) {
                this.allCollectors = set;
                if (metricReader != null) {
                    this.reader = metricReader;
                    return;
                }
                throw new NullPointerException("Null reader");
            }
            throw new NullPointerException("Null allCollectors");
        }
        throw new NullPointerException("Null collector");
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionInfo)) {
            return false;
        }
        CollectionInfo collectionInfo = (CollectionInfo) obj;
        if (this.collector.equals(collectionInfo.getCollector()) && this.allCollectors.equals(collectionInfo.getAllCollectors()) && this.reader.equals(collectionInfo.getReader())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo
    public Set<CollectionHandle> getAllCollectors() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.allCollectors;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo
    public CollectionHandle getCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CollectionHandle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.collector;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionInfo
    public MetricReader getReader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MetricReader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.reader;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return ((((this.collector.hashCode() ^ 1000003) * 1000003) ^ this.allCollectors.hashCode()) * 1000003) ^ this.reader.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "CollectionInfo{collector=" + this.collector + ", allCollectors=" + this.allCollectors + ", reader=" + this.reader + "}";
    }
}
