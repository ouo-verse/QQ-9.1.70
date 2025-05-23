package com.tencent.mobileqq.app.automator;

import java.util.concurrent.AbstractExecutorService;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface b extends d, f {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        AbstractExecutorService a();
    }

    void E();

    void a2(AsyncStep asyncStep);

    String getTag();

    void i2(AsyncStep[] asyncStepArr);
}
