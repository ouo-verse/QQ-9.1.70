package com.tencent.mtt.hippy.common;

import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class HippyThreadRunnable<T> implements Runnable {
    private final T mParam;

    public HippyThreadRunnable(T t16) {
        this.mParam = t16;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            run(this.mParam);
        } catch (Throwable th5) {
            LogUtils.e("HippyThreadRunnable", "run: ", th5);
        }
    }

    public abstract void run(T t16);
}
