package com.tencent.ad.tangram.statistics.canvas;

import android.os.SystemClock;
import com.tencent.ad.tangram.annotation.AdKeep;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdTimeStatistics {
    private long startTime = -1;
    private long stopTime = -1;
    private long time = -1;

    private void update() {
        long j3;
        long j16 = this.stopTime;
        long j17 = this.startTime;
        if (j16 >= j17 && j17 != -1 && j16 != -1) {
            j3 = j16 - j17;
        } else {
            j3 = -1;
        }
        if (j3 != -1) {
            if (this.time == -1) {
                this.time = 0L;
            }
            this.time += j3;
        }
        this.startTime = -1L;
        this.stopTime = -1L;
    }

    public long getTime() {
        return this.time;
    }

    public void start() {
        this.startTime = SystemClock.elapsedRealtime();
    }

    public void stop() {
        this.stopTime = SystemClock.elapsedRealtime();
        update();
    }
}
