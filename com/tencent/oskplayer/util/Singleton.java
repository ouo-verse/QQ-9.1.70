package com.tencent.oskplayer.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class Singleton<T> {
    private volatile T mInstance;

    protected abstract T createInstance();

    public final T getInstance() {
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = createInstance();
                }
            }
        }
        return this.mInstance;
    }
}
