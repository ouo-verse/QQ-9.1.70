package com.tencent.oskplayer.datasource;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface BandwidthMeter extends TransferListener {
    public static final long NO_ESTIMATE = -1;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface EventListener {
        void onBandwidthSample(int i3, long j3, long j16);
    }

    long getBitrateEstimate();
}
