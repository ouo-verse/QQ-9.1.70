package com.tencent.raft.measure.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.log.ILogDelegate;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MeasureAppConfig {
    static IPatchRedirector $redirector_;
    private ScheduledExecutorService executor;
    private boolean isDebug;
    private ILogDelegate logDelegate;

    public MeasureAppConfig(ILogDelegate iLogDelegate, boolean z16, ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, iLogDelegate, Boolean.valueOf(z16), scheduledExecutorService);
            return;
        }
        this.logDelegate = iLogDelegate;
        this.isDebug = z16;
        this.executor = scheduledExecutorService;
    }

    public ScheduledExecutorService getExecutor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ScheduledExecutorService) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.executor;
    }

    public ILogDelegate getLogDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (ILogDelegate) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.logDelegate;
    }

    public boolean isDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isDebug;
    }

    public MeasureAppConfig setDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MeasureAppConfig) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        this.isDebug = z16;
        return this;
    }

    public MeasureAppConfig setExecutor(ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MeasureAppConfig) iPatchRedirector.redirect((short) 6, (Object) this, (Object) scheduledExecutorService);
        }
        this.executor = scheduledExecutorService;
        return this;
    }

    public MeasureAppConfig setLogDelegate(ILogDelegate iLogDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MeasureAppConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iLogDelegate);
        }
        this.logDelegate = iLogDelegate;
        return this;
    }
}
