package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes22.dex */
final class AtomicLongLongAdder implements LongAdder {
    static IPatchRedirector $redirector_;
    private final AtomicLong atomicLong;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicLongLongAdder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.atomicLong = new AtomicLong();
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public void add(long j3) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        do {
            j16 = this.atomicLong.get();
        } while (!this.atomicLong.compareAndSet(j16, j16 + j3));
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ void decrement() {
        b.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ double doubleValue() {
        return b.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ float floatValue() {
        return b.c(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ void increment() {
        b.d(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ int intValue() {
        return b.e(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public /* synthetic */ long longValue() {
        return b.f(this);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.atomicLong.set(0L);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public long sum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.atomicLong.get();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public long sumThenReset() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        do {
            j3 = this.atomicLong.get();
        } while (!this.atomicLong.compareAndSet(j3, 0L));
        return j3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return Long.toString(sum());
    }
}
