package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Executor extends BaseThread {
    private Exception exception;
    private volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class ExecutorTermination implements JavaVoidCallback {
        public ExecutorTermination() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (!V8Executor.this.forceTerminating) {
            } else {
                throw new RuntimeException("V8Thread Termination");
            }
        }
    }

    public V8Executor(String str, boolean z16, String str2) {
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList<>();
        this.script = str;
        this.longRunning = z16;
        this.messageHandler = str2;
    }

    public void forceTermination() {
        synchronized (this) {
            this.forceTerminating = true;
            this.shuttingDown = true;
            V8 v85 = this.runtime;
            if (v85 != null) {
                v85.terminateExecution();
            }
            notify();
        }
    }

    public Exception getException() {
        return this.exception;
    }

    public String getResult() {
        return this.result;
    }

    public boolean hasException() {
        if (this.exception != null) {
            return true;
        }
        return false;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }

    public void postMessage(String... strArr) {
        synchronized (this) {
            this.messageQueue.add(strArr);
            notify();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
    
        if (r8.messageQueue.isEmpty() != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
    
        r3 = 0;
        r2 = r8.messageQueue.remove(0);
        r4 = new com.eclipsesource.mmv8.V8Array(r8.runtime);
        r5 = new com.eclipsesource.mmv8.V8Array(r8.runtime);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bc, code lost:
    
        r6 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bd, code lost:
    
        if (r3 >= r6) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bf, code lost:
    
        r5.push(r2[r3]);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
    
        r4.push((com.eclipsesource.mmv8.V8Value) r5);
        r8.runtime.executeVoidFunction(r8.messageHandler, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d1, code lost:
    
        r5.release();
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d9, code lost:
    
        r5.release();
        r4.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00df, code lost:
    
        throw r2;
     */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        synchronized (this) {
            V8 createV8Runtime = V8.createV8Runtime();
            this.runtime = createV8Runtime;
            createV8Runtime.registerJavaMethod(new ExecutorTermination(), "__j2v8__checkThreadTerminate");
            setup(this.runtime);
        }
        try {
            try {
                if (!this.forceTerminating) {
                    Object executeScript = this.runtime.executeScript("__j2v8__checkThreadTerminate();\n" + this.script, getName(), -1);
                    if (executeScript != null) {
                        this.result = executeScript.toString();
                    }
                    if (executeScript instanceof Releasable) {
                        ((Releasable) executeScript).release();
                    }
                    if (executeScript instanceof Releasable) {
                        ((Releasable) executeScript).release();
                    }
                }
                while (!this.forceTerminating && this.longRunning) {
                    synchronized (this) {
                        if (this.messageQueue.isEmpty() && !this.shuttingDown) {
                            LockMethodProxy.wait(this);
                        }
                        if ((!this.messageQueue.isEmpty() || !this.shuttingDown) && !this.forceTerminating) {
                        }
                    }
                    synchronized (this) {
                        if (this.runtime.getLocker().hasLock()) {
                            this.runtime.release();
                            this.runtime = null;
                        }
                        this.terminated = true;
                    }
                    return;
                }
                synchronized (this) {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.release();
                        this.runtime = null;
                    }
                    this.terminated = true;
                }
            } catch (Exception e16) {
                this.exception = e16;
                synchronized (this) {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.release();
                        this.runtime = null;
                    }
                    this.terminated = true;
                }
            }
        } catch (Throwable th5) {
            synchronized (this) {
                if (this.runtime.getLocker().hasLock()) {
                    this.runtime.release();
                    this.runtime = null;
                }
                this.terminated = true;
                throw th5;
            }
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.shuttingDown = true;
            notify();
        }
    }

    public V8Executor(String str) {
        this(str, false, null);
    }

    public void setup(V8 v85) {
    }
}
