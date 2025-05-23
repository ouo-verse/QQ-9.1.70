package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AutomatorImpl extends AbsAutomator {
    static IPatchRedirector $redirector_;
    protected final d G;
    protected final f H;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class a implements b.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.automator.b.a
        public AbstractExecutorService a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AbstractExecutorService) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new b());
            baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
            return baseThreadPoolExecutor;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b implements ThreadFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f195311d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f195311d = new AtomicInteger(1);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(runnable, "Automator_" + this.f195311d.getAndIncrement());
            if (baseThread.getPriority() != 10) {
                baseThread.setPriority(10);
            }
            return baseThread;
        }
    }

    public AutomatorImpl(d dVar, f fVar) {
        super(new a(), 3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) fVar);
        } else {
            this.G = dVar;
            this.H = fVar;
        }
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.H.Q();
    }

    @Override // com.tencent.mobileqq.app.automator.f
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.H.S();
    }

    @Override // com.tencent.mobileqq.app.automator.d
    public AsyncStep S1(com.tencent.mobileqq.app.automator.b bVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AsyncStep) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar, (Object) str);
        }
        return this.G.S1(this, str);
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator
    protected void a(LinearGroup linearGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) linearGroup);
            return;
        }
        if (h.f195319b.equals(linearGroup.mName)) {
            this.D.clear();
        }
        this.D.add(linearGroup);
        if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler.AutomatorImpl", 2, "addWaitingMode_Locked " + linearGroup.mName + " true");
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, com.tencent.mobileqq.app.automator.b
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQInitHandler.AutomatorImpl";
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.F && com.tencent.mobileqq.startup.a.f289669j) {
            i(this.G.S1(this, "{74}"));
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AbsAutomator, java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.F) {
            synchronized (this.D) {
                if (!this.F) {
                    z16 = true;
                    this.F = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                this.G.S1(this, "2").run();
            }
        }
        while (true) {
            LinearGroup linearGroup = this.C;
            if (linearGroup != null) {
                linearGroup.run();
            }
            synchronized (this.D) {
                LinearGroup poll = this.D.poll();
                this.C = poll;
                if (poll == null) {
                    return;
                }
            }
        }
    }
}
