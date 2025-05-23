package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
/* loaded from: classes11.dex */
class SingleThreadExecutor extends ThreadManagerExecutor {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private final Queue<Runnable> f195085d;

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy(JoinPoint.SYNCHRONIZATION_LOCK)
    private boolean f195086e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f195087f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class Task implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final Runnable f195088d;

        Task(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SingleThreadExecutor.this, (Object) runnable);
            } else {
                this.f195088d = runnable;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f195088d.run();
            synchronized (SingleThreadExecutor.this.f195087f) {
                runnable = (Runnable) SingleThreadExecutor.this.f195085d.poll();
                if (runnable == null) {
                    SingleThreadExecutor.this.f195086e = false;
                }
            }
            if (runnable != null) {
                SingleThreadExecutor.super.execute(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleThreadExecutor(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f195085d = new LinkedList();
        this.f195086e = false;
        this.f195087f = new Object();
    }

    @Override // com.tencent.mobileqq.app.ThreadManagerExecutor, java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        Task task = new Task(runnable);
        synchronized (this.f195087f) {
            if (!this.f195086e) {
                this.f195086e = true;
                super.execute(task);
            } else {
                this.f195085d.offer(task);
            }
        }
    }
}
