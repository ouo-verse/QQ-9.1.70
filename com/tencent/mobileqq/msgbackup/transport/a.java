package com.tencent.mobileqq.msgbackup.transport;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f251353c;

    /* renamed from: a, reason: collision with root package name */
    private Executor f251354a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f251355b;

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251355b = new AtomicBoolean(false);
        if (this.f251354a == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolParams threadPoolParams = new ThreadPoolParams();
            threadPoolParams.corePoolsize = availableProcessors;
            threadPoolParams.maxPooolSize = availableProcessors;
            threadPoolParams.priority = 5;
            threadPoolParams.poolThreadName = "msgbackup_Tranport_Executor";
            this.f251354a = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f251353c == null) {
                f251353c = new a();
            }
            aVar = f251353c;
        }
        return aVar;
    }

    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        Executor executor = this.f251354a;
        if (executor == null) {
            f.D("MsgBackupMsgBackupTransportExecutor", "thread pool is destroyed!", new Object[0]);
        } else {
            executor.execute(runnable);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f.D("MsgBackupMsgBackupTransportExecutor", "msgbackup destroy-------------> destroyed = " + this.f251355b.get(), new Object[0]);
        if (this.f251355b.get()) {
            return;
        }
        this.f251355b.set(true);
    }
}
