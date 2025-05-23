package com.google.android.exoplayer2.upstream;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface BandwidthMeter {
    public static final long NO_ESTIMATE = -1;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface EventListener {
        void onBandwidthSample(int i3, long j3, long j16);
    }

    long getBitrateEstimate();
}
