package com.tencent.mobileqq.data.entitymanager;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface Interceptor<T> {

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface Chain<T> {
        T proceed();
    }

    T intercept(Chain<T> chain);
}
