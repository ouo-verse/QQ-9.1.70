package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public class MultiWritableMetricStorage implements WriteableMetricStorage {
    static IPatchRedirector $redirector_;
    private final List<? extends WriteableMetricStorage> underlyingMetrics;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiWritableMetricStorage(List<? extends WriteableMetricStorage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.underlyingMetrics = list;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BoundStorageHandle) iPatchRedirector.redirect((short) 2, (Object) this, (Object) attributes);
        }
        ArrayList arrayList = new ArrayList(this.underlyingMetrics.size());
        Iterator<? extends WriteableMetricStorage> it = this.underlyingMetrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().bind(attributes));
        }
        return new MultiBoundStorageHandle(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordDouble(double d16, Attributes attributes, Context context) {
        t.a(this, d16, attributes, context);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public /* synthetic */ void recordLong(long j3, Attributes attributes, Context context) {
        t.b(this, j3, attributes, context);
    }
}
