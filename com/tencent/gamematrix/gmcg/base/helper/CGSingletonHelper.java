package com.tencent.gamematrix.gmcg.base.helper;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class CGSingletonHelper<T> {
    private volatile T mInstance;

    protected abstract T create();

    public final T get() {
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = create();
                }
            }
        }
        return this.mInstance;
    }
}
