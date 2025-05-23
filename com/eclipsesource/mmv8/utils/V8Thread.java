package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Thread extends BaseThread {
    private V8 runtime;
    private final V8Runnable target;

    public V8Thread(V8Runnable v8Runnable) {
        this.target = v8Runnable;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        V8 createV8Runtime = V8.createV8Runtime();
        this.runtime = createV8Runtime;
        try {
            this.target.run(createV8Runtime);
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.release();
                    this.runtime = null;
                }
            }
        } catch (Throwable th5) {
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.release();
                    this.runtime = null;
                }
                throw th5;
            }
        }
    }
}
