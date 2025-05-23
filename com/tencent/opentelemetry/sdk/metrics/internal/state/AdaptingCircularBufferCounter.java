package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AdaptingCircularBufferCounter implements ExponentialCounter {
    static IPatchRedirector $redirector_ = null;
    private static final int NULL_INDEX = Integer.MIN_VALUE;
    private final AdaptingIntegerArray backing;
    private int baseIndex;
    private int endIndex;
    private int startIndex;

    public AdaptingCircularBufferCounter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.backing = new AdaptingIntegerArray(i3);
    }

    private int toBufferIndex(int i3) {
        int i16 = i3 - this.baseIndex;
        if (i16 >= this.backing.length()) {
            return i16 - this.backing.length();
        }
        if (i16 < 0) {
            return i16 + this.backing.length();
        }
        return i16;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.backing.clear();
        this.baseIndex = Integer.MIN_VALUE;
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public long get(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, i3)).longValue();
        }
        if (i3 >= this.startIndex && i3 <= this.endIndex) {
            return this.backing.get(toBufferIndex(i3));
        }
        return 0L;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.endIndex;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getIndexStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.startIndex;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public int getMaxSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.backing.length();
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean increment(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (this.baseIndex == Integer.MIN_VALUE) {
            this.startIndex = i3;
            this.endIndex = i3;
            this.baseIndex = i3;
            this.backing.increment(0, j3);
            return true;
        }
        int i16 = this.endIndex;
        if (i3 > i16) {
            if ((i3 - this.startIndex) + 1 > this.backing.length()) {
                return false;
            }
            this.endIndex = i3;
        } else if (i3 < this.startIndex) {
            if ((i16 - i3) + 1 > this.backing.length()) {
                return false;
            }
            this.startIndex = i3;
        }
        this.backing.increment(toBufferIndex(i3), j3);
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.metrics.internal.state.ExponentialCounter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.baseIndex == Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("{");
        for (int i16 = this.startIndex; i16 <= this.endIndex && (i3 = this.startIndex) != Integer.MIN_VALUE; i16++) {
            if (i16 != i3) {
                sb5.append(',');
            }
            sb5.append(i16);
            sb5.append('=');
            sb5.append(get(i16));
        }
        sb5.append("}");
        return sb5.toString();
    }

    public AdaptingCircularBufferCounter(ExponentialCounter exponentialCounter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) exponentialCounter);
            return;
        }
        this.endIndex = Integer.MIN_VALUE;
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        if (exponentialCounter instanceof AdaptingCircularBufferCounter) {
            this.backing = ((AdaptingCircularBufferCounter) exponentialCounter).backing.copy();
            this.startIndex = exponentialCounter.getIndexStart();
            this.endIndex = exponentialCounter.getIndexEnd();
            this.baseIndex = ((AdaptingCircularBufferCounter) exponentialCounter).baseIndex;
            return;
        }
        this.backing = new AdaptingIntegerArray(exponentialCounter.getMaxSize());
        this.startIndex = Integer.MIN_VALUE;
        this.baseIndex = Integer.MIN_VALUE;
        this.endIndex = Integer.MIN_VALUE;
        for (int indexStart = exponentialCounter.getIndexStart(); indexStart <= exponentialCounter.getIndexEnd(); indexStart++) {
            increment(indexStart, exponentialCounter.get(indexStart));
        }
    }
}
