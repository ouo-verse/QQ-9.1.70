package com.tencent.mobileqq.emosm.control;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoCaptureAsyncAutomator extends EmoAutomator {
    protected EmoAsyncStep C = null;
    protected final LinkedList<EmoAsyncStep> D = new LinkedList<>();
    protected ThreadPoolExecutor E;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f204269d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable, "CaptureAsyncAutomator_" + this.f204269d.getAndIncrement());
            baseThread.setPriority(4);
            return baseThread;
        }
    }

    private void h(EmoAsyncStep emoAsyncStep) {
        this.D.add(emoAsyncStep);
        if (QLog.isColorLevel()) {
            QLog.d("EmoCaptureAsyncAutomator", 2, "addWaitingMode_Locked " + emoAsyncStep.f204262m);
        }
    }

    private void i() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new a());
        this.E = baseThreadPoolExecutor;
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.tencent.mobileqq.emosm.control.EmoAutomator
    public void g(EmoAsyncStep emoAsyncStep) {
        synchronized (this.f204266h) {
            QLog.d("EmoCaptureAsyncAutomator", 1, "CameraEmo, mCountRunning " + this.f204265f);
            int i3 = this.f204265f;
            if (i3 < 3) {
                this.f204265f = i3 + 1;
                if (this.E == null) {
                    i();
                }
                this.E.execute(emoAsyncStep);
            } else {
                this.f204266h.add(emoAsyncStep);
            }
        }
    }

    public void j(EmoAsyncStep emoAsyncStep) {
        if (QLog.isColorLevel()) {
            QLog.d("EmoCaptureAsyncAutomator", 2, "start " + emoAsyncStep.f204262m);
        }
        synchronized (this.D) {
            if (this.C == null) {
                this.C = emoAsyncStep;
                if (QLog.isColorLevel()) {
                    QLog.d("EmoCaptureAsyncAutomator", 2, "run " + emoAsyncStep.f204262m);
                }
                if (this.E == null) {
                    i();
                }
                this.E.execute(this);
            } else {
                h(emoAsyncStep);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            EmoAsyncStep emoAsyncStep = this.C;
            if (emoAsyncStep != null) {
                emoAsyncStep.run();
            }
            synchronized (this.D) {
                EmoAsyncStep poll = this.D.poll();
                this.C = poll;
                if (poll == null) {
                    return;
                }
            }
        }
    }
}
