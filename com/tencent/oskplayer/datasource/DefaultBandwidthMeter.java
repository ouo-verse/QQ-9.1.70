package com.tencent.oskplayer.datasource;

import android.os.Handler;
import com.tencent.oskplayer.datasource.BandwidthMeter;
import com.tencent.oskplayer.util.Assertions;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultBandwidthMeter implements BandwidthMeter {
    public static final int DEFAULT_MAX_WEIGHT = 2000;
    private static long bitrateEstimate;
    private static int elapsedMs;
    private static long sBitrate;
    private long bytesAccumulator;
    private final Clock clock;
    private final Handler eventHandler;
    private final BandwidthMeter.EventListener eventListener;
    private final SlidingPercentile slidingPercentile;
    private long startTimeMs;
    private int streamCount;

    public DefaultBandwidthMeter() {
        this(null, null);
    }

    public static synchronized long getBitrate() {
        long j3;
        synchronized (DefaultBandwidthMeter.class) {
            j3 = sBitrate;
        }
        return j3;
    }

    public static synchronized int getElapsedMs() {
        int i3;
        synchronized (DefaultBandwidthMeter.class) {
            i3 = elapsedMs;
        }
        return i3;
    }

    private void notifyBandwidthSample(final int i3, final long j3, final long j16) {
        Handler handler = this.eventHandler;
        if (handler != null && this.eventListener != null) {
            handler.post(new Runnable() { // from class: com.tencent.oskplayer.datasource.DefaultBandwidthMeter.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i3, j3, j16);
                }
            });
        }
    }

    @Override // com.tencent.oskplayer.datasource.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return bitrateEstimate;
    }

    @Override // com.tencent.oskplayer.datasource.TransferListener
    public synchronized void onBytesTransferred(int i3) {
        this.bytesAccumulator += i3;
    }

    @Override // com.tencent.oskplayer.datasource.TransferListener
    public synchronized void onTransferEnd() {
        boolean z16;
        long j3;
        if (this.streamCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        long elapsedRealtime = this.clock.elapsedRealtime();
        int i3 = (int) (elapsedRealtime - this.startTimeMs);
        elapsedMs = i3;
        if (i3 > 0) {
            long j16 = this.bytesAccumulator;
            this.slidingPercentile.addSample((int) Math.sqrt(j16), (float) ((8000 * j16) / i3));
            float percentile = this.slidingPercentile.getPercentile(0.5f);
            if (Float.isNaN(percentile)) {
                j3 = -1;
            } else {
                j3 = percentile;
            }
            long j17 = j3;
            bitrateEstimate = j17;
            sBitrate = j17;
            notifyBandwidthSample(elapsedMs, this.bytesAccumulator, j17);
        }
        int i16 = this.streamCount - 1;
        this.streamCount = i16;
        if (i16 > 0) {
            this.startTimeMs = elapsedRealtime;
        }
        this.bytesAccumulator = 0L;
    }

    @Override // com.tencent.oskplayer.datasource.TransferListener
    public synchronized void onTransferStart() {
        if (this.streamCount == 0) {
            this.startTimeMs = this.clock.elapsedRealtime();
        }
        this.streamCount++;
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, new SystemClock());
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, Clock clock) {
        this(handler, eventListener, clock, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i3) {
        this(handler, eventListener, new SystemClock(), i3);
    }

    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, Clock clock, int i3) {
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.clock = clock;
        this.slidingPercentile = new SlidingPercentile(i3);
        bitrateEstimate = -1L;
    }
}
