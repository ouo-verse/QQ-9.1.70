package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SynchronousLooper extends SpringLooper {
    public static double SIXTY_FPS = 16.6667d;
    private boolean mRunning;
    private double mTimeStep = SIXTY_FPS;

    public double getTimeStep() {
        return this.mTimeStep;
    }

    public void setTimeStep(double d16) {
        this.mTimeStep = d16;
    }

    @Override // com.tencent.component.animation.rebound.SpringLooper
    public void start() {
        this.mRunning = true;
        while (!this.mSpringSystem.getIsIdle() && this.mRunning) {
            this.mSpringSystem.loop(this.mTimeStep);
        }
    }

    @Override // com.tencent.component.animation.rebound.SpringLooper
    public void stop() {
        this.mRunning = false;
    }
}
