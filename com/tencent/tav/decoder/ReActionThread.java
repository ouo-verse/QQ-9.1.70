package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class ReActionThread extends BaseThread {
    private static final String TAG = "ReActionThread";
    private boolean hasAction;
    private boolean release;

    public ReActionThread(String str) {
        super(str);
        this.release = false;
        this.hasAction = false;
    }

    public void action() {
        this.hasAction = true;
        synchronized (this) {
            notifyAll();
        }
        Logger.v(TAG, "action: " + this + " " + hashCode());
    }

    protected abstract void doAction();

    public synchronized void release() {
        if (!this.release) {
            this.release = true;
            synchronized (this) {
                notifyAll();
                try {
                    synchronized (this) {
                        wait(20L);
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Logger.d(TAG, "run start: " + this + " " + hashCode());
        while (!this.release) {
            while (!this.hasAction && !this.release) {
                synchronized (this) {
                    try {
                        wait(10L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            this.hasAction = false;
            if (!this.release) {
                doAction();
            }
            synchronized (this) {
                notifyAll();
            }
        }
        Logger.d(TAG, "run finish: " + this + " " + hashCode());
    }
}
