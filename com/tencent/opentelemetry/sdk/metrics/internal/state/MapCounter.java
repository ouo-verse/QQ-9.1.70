package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MapCounter implements ExponentialCounter {
    static IPatchRedirector $redirector_ = null;
    private static final int NULL_INDEX = Integer.MIN_VALUE;
    private final Map<Integer, AtomicLong> backing;
    private int indexEnd;
    private int indexStart;
    private final int maxSize;

    public MapCounter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.maxSize = i3;
        this.backing = new ConcurrentHashMap(((int) Math.ceil(i3 / 0.75d)) + 1);
        this.indexEnd = Integer.MIN_VALUE;
        this.indexStart = Integer.MIN_VALUE;
    }

    private synchronized void doIncrement(int i3, long j3) {
        Object computeIfAbsent;
        computeIfAbsent = this.backing.computeIfAbsent(Integer.valueOf(i3), new Function() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.state.e
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                AtomicLong lambda$doIncrement$0;
                lambda$doIncrement$0 = MapCounter.lambda$doIncrement$0((Integer) obj);
                return lambda$doIncrement$0;
            }
        });
        if (((AtomicLong) computeIfAbsent).getAndAdd(j3) + j3 == 0) {
            this.backing.remove(Integer.valueOf(i3));
            if (isEmpty()) {
                this.indexStart = Integer.MIN_VALUE;
                this.indexEnd = Integer.MIN_VALUE;
            } else {
                this.indexStart = ((Integer) Collections.min(this.backing.keySet())).intValue();
                this.indexEnd = ((Integer) Collections.max(this.backing.keySet())).intValue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AtomicLong lambda$doIncrement$0(Integer num) {
        return new AtomicLong(0L);
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.backing.clear();
        this.indexStart = Integer.MIN_VALUE;
        this.indexEnd = Integer.MIN_VALUE;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public long get(int i3) {
        AtomicLong atomicLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        if (i3 < this.indexStart || i3 > this.indexEnd || (atomicLong = this.backing.get(Integer.valueOf(i3))) == null) {
            return 0L;
        }
        return atomicLong.longValue();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.indexEnd;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.indexStart;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getMaxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.maxSize;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean increment(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        int i16 = this.indexStart;
        if (i16 == Integer.MIN_VALUE) {
            this.indexStart = i3;
            this.indexEnd = i3;
            doIncrement(i3, j3);
            return true;
        }
        int i17 = this.indexEnd;
        if (i3 > i17) {
            if ((i3 - i16) + 1 > this.maxSize) {
                return false;
            }
            this.indexEnd = i3;
        } else if (i3 < i16) {
            if ((i17 - i3) + 1 > this.maxSize) {
                return false;
            }
            this.indexStart = i3;
        }
        doIncrement(i3, j3);
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.backing.isEmpty();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.backing.toString();
    }

    public MapCounter(ExponentialCounter exponentialCounter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) exponentialCounter);
            return;
        }
        int maxSize = exponentialCounter.getMaxSize();
        this.maxSize = maxSize;
        this.backing = new ConcurrentHashMap(((int) Math.ceil(maxSize / 0.75d)) + 1);
        this.indexStart = exponentialCounter.getIndexStart();
        this.indexEnd = exponentialCounter.getIndexEnd();
        for (int i3 = this.indexStart; i3 <= this.indexEnd; i3++) {
            long j3 = exponentialCounter.get(i3);
            if (j3 != 0) {
                this.backing.put(Integer.valueOf(i3), new AtomicLong(j3));
            }
        }
    }
}
