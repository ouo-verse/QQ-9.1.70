package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class SpringLooper {
    protected BaseSpringSystem mSpringSystem;

    public void setSpringSystem(BaseSpringSystem baseSpringSystem) {
        this.mSpringSystem = baseSpringSystem;
    }

    public abstract void start();

    public abstract void stop();
}
