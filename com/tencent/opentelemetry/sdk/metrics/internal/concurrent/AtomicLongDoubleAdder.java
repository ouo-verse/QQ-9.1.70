package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AtomicLongDoubleAdder implements DoubleAdder {
    static IPatchRedirector $redirector_;
    private final AtomicLong atomicLong;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicLongDoubleAdder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.atomicLong = new AtomicLong();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public void add(double d16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Double.valueOf(d16));
        } else {
            do {
                j3 = this.atomicLong.get();
            } while (!this.atomicLong.compareAndSet(j3, Double.doubleToLongBits(Double.longBitsToDouble(j3) + d16)));
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public /* synthetic */ double doubleValue() {
        return a.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public /* synthetic */ float floatValue() {
        return a.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public /* synthetic */ int intValue() {
        return a.c(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public /* synthetic */ long longValue() {
        return a.d(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.atomicLong.set(0L);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public double sum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return Double.longBitsToDouble(this.atomicLong.get());
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public double sumThenReset() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        do {
            j3 = this.atomicLong.get();
        } while (!this.atomicLong.compareAndSet(j3, 0L));
        return Double.longBitsToDouble(j3);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return Double.toString(sum());
    }
}
