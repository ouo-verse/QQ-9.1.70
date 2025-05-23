package com.tencent.biz.richframework.collection;

import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWThreadLocal<T> {
    private T mMainValue;
    private final Map<Long, T> mSubThreadValue = new ConcurrentHashMap();

    public void clear() {
        this.mMainValue = null;
        this.mSubThreadValue.clear();
    }

    public T get() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.mMainValue == null) {
                this.mMainValue = initialValue(true);
            }
            return this.mMainValue;
        }
        T t16 = this.mSubThreadValue.get(Long.valueOf(Thread.currentThread().getId()));
        if (t16 == null && (t16 = initialValue(false)) != null) {
            this.mSubThreadValue.put(Long.valueOf(Thread.currentThread().getId()), t16);
        }
        return t16;
    }

    protected T initialValue(boolean z16) {
        return null;
    }

    public void remove() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.mMainValue = null;
        } else {
            this.mSubThreadValue.remove(Long.valueOf(Thread.currentThread().getId()));
        }
    }

    public void set(T t16) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.mMainValue = t16;
        } else {
            this.mSubThreadValue.put(Long.valueOf(Thread.currentThread().getId()), t16);
        }
    }
}
