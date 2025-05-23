package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final int DEFAULT_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;
    private final Handler eventHandler;
    private final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    public DefaultBandwidthMeter() {
        this(null, null);
    }

    private void notifyBandwidthSample(final int i3, final long j3, final long j16) {
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i3, j3, j16);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(Object obj, int i3) {
        this.sampleBytesTransferred += i3;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(Object obj) {
        boolean z16;
        long j3;
        if (this.streamCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i3 = (int) (elapsedRealtime - this.sampleStartTimeMs);
        long j16 = i3;
        this.totalElapsedTimeMs += j16;
        long j17 = this.totalBytesTransferred;
        long j18 = this.sampleBytesTransferred;
        this.totalBytesTransferred = j17 + j18;
        if (i3 > 0) {
            this.slidingPercentile.addSample((int) Math.sqrt(j18), (float) ((8000 * j18) / j16));
            if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= 524288) {
                float percentile = this.slidingPercentile.getPercentile(0.5f);
                if (Float.isNaN(percentile)) {
                    j3 = -1;
                } else {
                    j3 = percentile;
                }
                this.bitrateEstimate = j3;
            }
        }
        notifyBandwidthSample(i3, this.sampleBytesTransferred, this.bitrateEstimate);
        int i16 = this.streamCount - 1;
        this.streamCount = i16;
        if (i16 > 0) {
            this.sampleStartTimeMs = elapsedRealtime;
        }
        this.sampleBytesTransferred = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        if (this.streamCount == 0) {
            this.sampleStartTimeMs = this.clock.elapsedRealtime();
        }
        this.streamCount++;
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i3) {
        this(handler, eventListener, i3, Clock.DEFAULT);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i3, Clock clock) {
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.slidingPercentile = new SlidingPercentile(i3);
        this.clock = clock;
        this.bitrateEstimate = -1L;
    }
}
