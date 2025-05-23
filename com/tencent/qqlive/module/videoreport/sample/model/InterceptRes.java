package com.tencent.qqlive.module.videoreport.sample.model;

/* compiled from: P */
/* loaded from: classes22.dex */
public class InterceptRes {
    private static final InterceptRes res = new InterceptRes();
    private boolean intercepted = false;
    private double sampleRate = 1.0d;

    public static InterceptRes defRes() {
        return res;
    }

    public boolean intercepted() {
        return this.intercepted;
    }

    public double rate() {
        return this.sampleRate;
    }

    public InterceptRes reset() {
        this.intercepted = false;
        this.sampleRate = 1.0d;
        return this;
    }

    public void setIntercepted(boolean z16) {
        this.intercepted = z16;
    }

    public void setSampleRate(double d16) {
        this.sampleRate = d16;
    }
}
