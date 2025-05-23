package com.tencent.qqmini.sdk.launcher.utils;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class Singleton<T> {
    private T mInstance;

    protected abstract T create();

    public final T get() {
        T t16;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = create();
            }
            t16 = this.mInstance;
        }
        return t16;
    }
}
