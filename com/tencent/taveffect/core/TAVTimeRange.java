package com.tencent.taveffect.core;

import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVTimeRange {
    private long _duration;
    private long _start;
    private TimeUnit _unit = TimeUnit.MILLISECONDS;

    public TAVTimeRange() {
    }

    public boolean contain(long j3) {
        long j16 = this._duration;
        if (j16 > 0) {
            long j17 = this._start;
            if (j17 < j3 && j3 < j17 + j16) {
                return true;
            }
        }
        return false;
    }

    public long duration() {
        return this._duration;
    }

    public long end() {
        return this._start + this._duration;
    }

    public boolean equals(TAVTimeRange tAVTimeRange) {
        if (tAVTimeRange == this) {
            return true;
        }
        if (tAVTimeRange == null) {
            return false;
        }
        if (this._start == tAVTimeRange._start && this._duration == tAVTimeRange._duration) {
            return true;
        }
        return false;
    }

    public TimeUnit getUnit() {
        return this._unit;
    }

    public void setUnit(TimeUnit timeUnit) {
        this._unit = timeUnit;
    }

    public long start() {
        return this._start;
    }

    public String toString() {
        return "TAVTimeRange{_unit=" + this._unit + ", _start=" + this._start + ", _duration=" + this._duration + ", _end=" + (this._start + this._duration) + '}';
    }

    public void update(long j3, long j16) {
        this._start = j3;
        this._duration = j16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVTimeRange m266clone() {
        return new TAVTimeRange(this._start, this._duration);
    }

    public TAVTimeRange(long j3, long j16) {
        this._start = j3;
        this._duration = j16;
    }
}
