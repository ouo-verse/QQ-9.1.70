package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    @Override // com.tencent.component.animation.rebound.SpringLooper
    public void start() {
        this.mStarted = true;
        this.mLastTime = 0L;
    }

    public boolean step(long j3) {
        BaseSpringSystem baseSpringSystem = this.mSpringSystem;
        if (baseSpringSystem != null && this.mStarted) {
            long j16 = this.mLastTime + j3;
            baseSpringSystem.loop(j16);
            this.mLastTime = j16;
            return this.mSpringSystem.getIsIdle();
        }
        return false;
    }

    @Override // com.tencent.component.animation.rebound.SpringLooper
    public void stop() {
        this.mStarted = false;
    }
}
