package com.tencent.component.animation.rebound;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SpringSystem extends BaseSpringSystem {
    SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }

    public static SpringSystem create() {
        return new SpringSystem(AndroidSpringLooperFactory.createSpringLooper());
    }
}
