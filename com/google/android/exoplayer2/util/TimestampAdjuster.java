package com.google.android.exoplayer2.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestamp = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j3) {
        setFirstSampleTimestampUs(j3);
    }

    public static long ptsToUs(long j3) {
        return (j3 * 1000000) / 90000;
    }

    public static long usToPts(long j3) {
        return (j3 * 90000) / 1000000;
    }

    public long adjustSampleTimestamp(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestamp != -9223372036854775807L) {
            this.lastSampleTimestamp = j3;
        } else {
            long j16 = this.firstSampleTimestampUs;
            if (j16 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j16 - j3;
            }
            synchronized (this) {
                this.lastSampleTimestamp = j3;
                notifyAll();
            }
        }
        return j3 + this.timestampOffsetUs;
    }

    public long adjustTsTimestamp(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestamp != -9223372036854775807L) {
            long usToPts = usToPts(this.lastSampleTimestamp);
            long j16 = (4294967296L + usToPts) / 8589934592L;
            long j17 = ((j16 - 1) * 8589934592L) + j3;
            j3 += j16 * 8589934592L;
            if (Math.abs(j17 - usToPts) < Math.abs(j3 - usToPts)) {
                j3 = j17;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j3));
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestamp != -9223372036854775807L) {
            return this.lastSampleTimestamp;
        }
        long j3 = this.firstSampleTimestampUs;
        if (j3 == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j3;
    }

    public long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.lastSampleTimestamp == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.timestampOffsetUs;
    }

    public void reset() {
        this.lastSampleTimestamp = -9223372036854775807L;
    }

    public synchronized void setFirstSampleTimestampUs(long j3) {
        boolean z16;
        if (this.lastSampleTimestamp == -9223372036854775807L) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.firstSampleTimestampUs = j3;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestamp == -9223372036854775807L) {
            LockMethodProxy.wait(this);
        }
    }
}
