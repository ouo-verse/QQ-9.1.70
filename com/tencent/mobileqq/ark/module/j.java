package com.tencent.mobileqq.ark.module;

/* compiled from: P */
/* loaded from: classes11.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private long f199578a;

    /* renamed from: b, reason: collision with root package name */
    private long f199579b;

    /* renamed from: c, reason: collision with root package name */
    private double f199580c;

    /* renamed from: d, reason: collision with root package name */
    private long f199581d = System.currentTimeMillis();

    public j(long j3, long j16) {
        this.f199579b = j16;
        this.f199578a = j3;
        this.f199580c = j3;
    }

    public boolean a() {
        if (this.f199578a == -1) {
            return true;
        }
        if (this.f199579b > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            double d16 = this.f199580c;
            double d17 = currentTimeMillis - this.f199581d;
            long j3 = this.f199578a;
            double min = Math.min(d16 + ((d17 * j3) / this.f199579b), j3);
            this.f199580c = min;
            this.f199581d = currentTimeMillis;
            if (min >= 1.0d) {
                this.f199580c = min - 1.0d;
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f199578a == jVar.f199578a && this.f199579b == jVar.f199579b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f199578a;
        int i3 = ((int) (j3 ^ (j3 >>> 32))) * 31;
        long j16 = this.f199579b;
        return i3 + ((int) ((j16 >>> 32) ^ j16));
    }

    public String toString() {
        return String.format("TokenBucket:mTimes:%d,mPeriod:%d,mTokenCount:%f,mLastTimestamp:%d", Long.valueOf(this.f199578a), Long.valueOf(this.f199579b), Double.valueOf(this.f199580c), Long.valueOf(this.f199581d));
    }
}
