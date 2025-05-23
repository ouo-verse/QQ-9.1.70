package com.airbnb.lottie.utils;

/* compiled from: P */
/* loaded from: classes.dex */
public class MeanCalculator {

    /* renamed from: n, reason: collision with root package name */
    private int f31254n;
    private float sum;

    public void add(float f16) {
        float f17 = this.sum + f16;
        this.sum = f17;
        int i3 = this.f31254n + 1;
        this.f31254n = i3;
        if (i3 == Integer.MAX_VALUE) {
            this.sum = f17 / 2.0f;
            this.f31254n = i3 / 2;
        }
    }

    public float getMean() {
        int i3 = this.f31254n;
        if (i3 == 0) {
            return 0.0f;
        }
        return this.sum / i3;
    }
}
