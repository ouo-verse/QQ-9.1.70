package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.metrics.internal.export.CollectionHandle;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class DeltaAccumulation<T> {
    static IPatchRedirector $redirector_;
    private final Set<CollectionHandle> readers;
    private final Map<Attributes, T> recording;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeltaAccumulation(Map<Attributes, T> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        } else {
            this.recording = map;
            this.readers = CollectionHandle.mutableSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<Attributes, T> read(CollectionHandle collectionHandle) {
        this.readers.add(collectionHandle);
        return this.recording;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasReadBy(CollectionHandle collectionHandle) {
        return this.readers.contains(collectionHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean wasReadByAll(Set<CollectionHandle> set) {
        return this.readers.containsAll(set);
    }
}
