package com.tencent.component.hdasync;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class BaseAction {
    protected long delay;
    protected Looper looper;
    protected ExecutorService pool;
    private WeakReference<HdAsync> weakHdAsync;
    private WeakReference<Object> weakHost;

    public BaseAction(Looper looper) {
        this.delay = 0L;
        this.looper = looper;
        this.pool = null;
    }

    public abstract BaseResult call(Object obj);

    public HdAsync getHdAsync() {
        WeakReference<HdAsync> weakReference = this.weakHdAsync;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Object getHost() {
        WeakReference<Object> weakReference = this.weakHost;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setHdAsync(HdAsync hdAsync) {
        this.weakHdAsync = new WeakReference<>(hdAsync);
    }

    public void setHost(Object obj) {
        this.weakHost = new WeakReference<>(obj);
    }

    public BaseAction(ExecutorService executorService) {
        this.delay = 0L;
        this.pool = executorService;
        this.looper = null;
    }
}
