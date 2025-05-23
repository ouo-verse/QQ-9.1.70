package com.tencent.qqlive.module.videoreport.sample.samplenode;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleRateNode extends SampleNode {
    private final double rate;

    public SampleRateNode(double d16) {
        this.rate = d16;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && Double.compare(((SampleRateNode) obj).rate, this.rate) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Double.valueOf(this.rate));
    }

    public double rate() {
        return this.rate;
    }
}
