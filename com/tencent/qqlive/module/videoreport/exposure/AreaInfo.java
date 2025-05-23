package com.tencent.qqlive.module.videoreport.exposure;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AreaInfo {
    public final long exposureArea;
    public final double exposureRate;
    public final long viewArea;

    public AreaInfo(long j3, long j16, double d16) {
        this.viewArea = j3;
        this.exposureArea = j16;
        this.exposureRate = d16;
    }

    public String toString() {
        return "ExposureInfo {viewArea = " + this.viewArea + ", exposureArea = " + this.exposureArea + ", exposureRate = " + this.exposureRate + '}';
    }
}
