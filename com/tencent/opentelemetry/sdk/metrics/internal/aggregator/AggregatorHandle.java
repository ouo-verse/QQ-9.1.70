package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public abstract class AggregatorHandle<T> implements BoundStorageHandle {
    static IPatchRedirector $redirector_;
    private final ExemplarReservoir exemplarReservoir;
    private volatile boolean hasRecordings;
    private final AtomicLong refCountMapped;

    /* JADX INFO: Access modifiers changed from: protected */
    public AggregatorHandle(ExemplarReservoir exemplarReservoir) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) exemplarReservoir);
            return;
        }
        this.hasRecordings = false;
        this.refCountMapped = new AtomicLong(2L);
        this.exemplarReservoir = exemplarReservoir;
    }

    @Nullable
    public final T accumulateThenReset(Attributes attributes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributes);
        }
        if (!this.hasRecordings) {
            return null;
        }
        this.hasRecordings = false;
        return doAccumulateThenReset(this.exemplarReservoir.collectAndReset(attributes));
    }

    public final boolean acquire() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ((this.refCountMapped.addAndGet(2L) & 1) == 0) {
            return true;
        }
        return false;
    }

    protected abstract T doAccumulateThenReset(List<ExemplarData> list);

    protected void doRecordDouble(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Double.valueOf(d16));
            return;
        }
        throw new UnsupportedOperationException("This aggregator does not support recording double values.");
    }

    protected void doRecordLong(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
            return;
        }
        throw new UnsupportedOperationException("This aggregator does not support recording long values.");
    }

    public final void recordDouble(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16));
        } else {
            doRecordDouble(d16);
            this.hasRecordings = true;
        }
    }

    public final void recordLong(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            doRecordLong(j3);
            this.hasRecordings = true;
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.refCountMapped.getAndAdd(-2L);
        }
    }

    public final boolean tryUnmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.refCountMapped.get() != 0) {
            return false;
        }
        return this.refCountMapped.compareAndSet(0L, 1L);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void recordDouble(double d16, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16), attributes, context);
        } else {
            this.exemplarReservoir.offerMeasurement(d16, attributes, context);
            recordDouble(d16);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
    public final void recordLong(long j3, Attributes attributes, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), attributes, context);
        } else {
            this.exemplarReservoir.offerMeasurement(j3, attributes, context);
            recordLong(j3);
        }
    }
}
