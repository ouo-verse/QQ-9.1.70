package com.tencent.aelight.camera.aioeditor.capture.control;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AbsAutomator;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.b;
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
/* loaded from: classes32.dex */
public class CaptureAsyncAutomator extends AbsAutomator {
    private AsyncStep G;
    private final LinkedList<AsyncStep> H;
    private ThreadPoolExecutor I;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f66665d = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(runnable, "CaptureAsyncAutomator_" + this.f66665d.getAndIncrement());
            baseThread.setPriority(4);
            return baseThread;
        }
    }

    private void k(AsyncStep asyncStep) {
        this.H.add(asyncStep);
        if (QLog.isColorLevel()) {
            QLog.d("CaptureAsyncAutomator", 2, "addWaitingMode_Locked " + asyncStep.mName);
        }
    }

    private void l() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new a());
        this.I = baseThreadPoolExecutor;
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean Q() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean S() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.mobileqq.app.automator.d
    public AsyncStep S1(b bVar, String str) {
        return CaptureAsyncStepFactory.a(this, str);
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, com.tencent.mobileqq.app.automator.b
    public void a2(AsyncStep asyncStep) {
        synchronized (this.f195304m) {
            QLog.d("CaptureAsyncAutomator", 1, "CameraEmo, mCountRunning " + this.f195303i);
            int i3 = this.f195303i;
            if (i3 < 3) {
                this.f195303i = i3 + 1;
                if (this.I == null) {
                    l();
                }
                this.I.execute(asyncStep);
            } else {
                this.f195304m.add(asyncStep);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, com.tencent.mobileqq.app.automator.b
    public String getTag() {
        return "CaptureAsyncAutomator";
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator
    public void i(AsyncStep asyncStep) {
        if (QLog.isColorLevel()) {
            QLog.d("CaptureAsyncAutomator", 2, "start " + asyncStep.mName);
        }
        synchronized (this.H) {
            if (this.G == null) {
                this.G = asyncStep;
                if (QLog.isColorLevel()) {
                    QLog.d("CaptureAsyncAutomator", 2, "run " + asyncStep.mName);
                }
                if (this.I == null) {
                    l();
                }
                this.I.execute(this);
            } else {
                k(asyncStep);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, java.lang.Runnable
    public void run() {
        while (true) {
            AsyncStep asyncStep = this.G;
            if (asyncStep != null) {
                asyncStep.run();
            }
            synchronized (this.H) {
                AsyncStep poll = this.H.poll();
                this.G = poll;
                if (poll == null) {
                    return;
                }
            }
        }
    }

    public CaptureAsyncAutomator(QQAppInterface qQAppInterface) {
        super(null, 3);
        this.G = null;
        this.H = new LinkedList<>();
    }
}
