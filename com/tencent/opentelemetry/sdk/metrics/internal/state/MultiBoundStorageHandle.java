package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
class MultiBoundStorageHandle implements BoundStorageHandle {
    static IPatchRedirector $redirector_;
    private final List<BoundStorageHandle> underlyingHandles;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiBoundStorageHandle(List<BoundStorageHandle> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.underlyingHandles = list;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void recordDouble(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16), attributes, context);
            return;
        }
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().recordDouble(d16, attributes, context);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void recordLong(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), attributes, context);
            return;
        }
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().recordLong(j3, attributes, context);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<BoundStorageHandle> it = this.underlyingHandles.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
