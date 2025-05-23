package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Timer {
    private long resetNanos;

    public Timer() {
        reset();
    }

    public float getMilliseconds() {
        return (((float) ((System.nanoTime() - this.resetNanos) / 1000)) * 1.0f) / 1000.0f;
    }

    public void reset() {
        this.resetNanos = System.nanoTime();
    }
}
