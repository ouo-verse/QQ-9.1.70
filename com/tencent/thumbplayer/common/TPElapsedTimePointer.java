package com.tencent.thumbplayer.common;

import android.os.SystemClock;

/* loaded from: classes26.dex */
public class TPElapsedTimePointer {
    private long mLastPointTimeMs;
    private long mStartTimeMs;

    public long costTimeMsFromLastPoint() {
        return SystemClock.elapsedRealtime() - this.mLastPointTimeMs;
    }

    public long costTimeMsFromLastPointAndPoint() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = elapsedRealtime - this.mLastPointTimeMs;
        this.mLastPointTimeMs = elapsedRealtime;
        return j3;
    }

    public long costTimeMsFromStartPoint() {
        return SystemClock.elapsedRealtime() - this.mStartTimeMs;
    }

    public long costTimeMsFromStartPointAndPoint() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mLastPointTimeMs = elapsedRealtime;
        return elapsedRealtime - this.mStartTimeMs;
    }

    public void point() {
        this.mLastPointTimeMs = SystemClock.elapsedRealtime();
    }

    public void start() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mStartTimeMs = elapsedRealtime;
        this.mLastPointTimeMs = elapsedRealtime;
    }
}
