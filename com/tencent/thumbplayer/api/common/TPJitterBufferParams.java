package com.tencent.thumbplayer.api.common;

/* loaded from: classes26.dex */
public class TPJitterBufferParams {
    private long mAdjustIntervalThresholdMs;
    private long mFrozenThresholdMs;
    private long mMaxIncreaseDurationMs;
    private long mMinDecreaseDurationMs;
    private long mPerDecreaseDurationMs;
    private long mPerIncreaseDurationMs;

    /* loaded from: classes26.dex */
    public static final class Builder {
        public static final long DEFAULT_ADJUST_INTERVAL_THRESHOLD_MS = 60000;
        public static final long DEFAULT_FROZEN_THRESHOLD_MS = 800;
        public static final long DEFAULT_MAX_DECREASE_DURATION_MS = 8000;
        public static final long DEFAULT_MIN_DECREASE_DURATION_MS = 2000;
        public static final long DEFAULT_PER_DECREASE_DURATION_MS = 500;
        public static final long DEFAULT_PER_INCREASE_DURATION_MS = 1000;
        private long mMinDecreaseDurationMs = 2000;
        private long mMaxIncreaseDurationMs = 8000;
        private long mPerIncreaseDurationMs = 1000;
        private long mPerDecreaseDurationMs = 500;
        private long mAdjustIntervalThresholdMs = 60000;
        private long mFrozenThresholdMs = 800;

        public TPJitterBufferParams build() {
            return new TPJitterBufferParams(this.mMinDecreaseDurationMs, this.mMaxIncreaseDurationMs, this.mPerIncreaseDurationMs, this.mPerDecreaseDurationMs, this.mAdjustIntervalThresholdMs, this.mFrozenThresholdMs);
        }

        public Builder setAdjustIntervalThresholdMs(long j3) {
            this.mAdjustIntervalThresholdMs = j3;
            return this;
        }

        public Builder setFrozenThresholdMs(long j3) {
            this.mFrozenThresholdMs = j3;
            return this;
        }

        public Builder setMaxIncreaseDurationMs(long j3) {
            this.mMaxIncreaseDurationMs = j3;
            return this;
        }

        public Builder setMinDecreaseDurationMs(long j3) {
            this.mMinDecreaseDurationMs = j3;
            return this;
        }

        public Builder setPerDecreaseDurationMs(long j3) {
            this.mPerDecreaseDurationMs = j3;
            return this;
        }

        public Builder setPerIncreaseDurationMs(long j3) {
            this.mPerIncreaseDurationMs = j3;
            return this;
        }
    }

    protected TPJitterBufferParams(long j3, long j16, long j17, long j18, long j19, long j26) {
        this.mMinDecreaseDurationMs = j3;
        this.mMaxIncreaseDurationMs = j16;
        this.mPerIncreaseDurationMs = j17;
        this.mPerDecreaseDurationMs = j18;
        this.mAdjustIntervalThresholdMs = j19;
        this.mFrozenThresholdMs = j26;
    }

    public long getAdjustIntervalThresholdMs() {
        return this.mAdjustIntervalThresholdMs;
    }

    public long getFrozenThresholdMs() {
        return this.mFrozenThresholdMs;
    }

    public long getMaxIncreaseDurationMs() {
        return this.mMaxIncreaseDurationMs;
    }

    public long getMinDecreaseDurationMs() {
        return this.mMinDecreaseDurationMs;
    }

    public long getPerDecreaseDurationMs() {
        return this.mPerDecreaseDurationMs;
    }

    public long getPerIncreaseDurationMs() {
        return this.mPerIncreaseDurationMs;
    }
}
