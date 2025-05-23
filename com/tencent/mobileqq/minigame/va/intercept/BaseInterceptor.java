package com.tencent.mobileqq.minigame.va.intercept;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class BaseInterceptor {
    protected BaseInterceptor nextInterceptor;

    public abstract void handleIntercept(InterceptRequest interceptRequest);

    public void setNextInterceptor(BaseInterceptor baseInterceptor) {
        this.nextInterceptor = baseInterceptor;
    }
}
