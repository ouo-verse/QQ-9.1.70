package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DispatchThread extends BaseThread {
    private final Queue<Runnable> C;
    private Boolean D;
    private Handler E;
    private HandlerThread F;

    private boolean o() {
        boolean booleanValue;
        synchronized (this.D) {
            booleanValue = this.D.booleanValue();
        }
        return booleanValue;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Runnable poll;
        while (true) {
            synchronized (this.C) {
                while (this.C.size() == 0 && !o()) {
                    try {
                        LockMethodProxy.wait(this.C);
                    } catch (InterruptedException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DispatchThread", 2, "Dispatcher thread wait() interrupted, exiting");
                        }
                    }
                }
                poll = this.C.poll();
            }
            if (poll == null) {
                if (o()) {
                    this.F.quit();
                    return;
                }
            } else {
                poll.run();
                synchronized (this) {
                    this.E.post(new Runnable() { // from class: com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (DispatchThread.this) {
                                DispatchThread.this.notifyAll();
                            }
                        }
                    });
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException unused2) {
                    }
                }
            }
        }
    }
}
