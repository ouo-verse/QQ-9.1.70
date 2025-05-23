package com.tencent.raft.measure.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.log.DefaultLogDelegate;
import com.tencent.raft.measure.log.ILogDelegate;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MeasureAppConfigBuilder {
    static IPatchRedirector $redirector_;
    private ScheduledExecutorService executor;
    private boolean isDebug;
    private ILogDelegate logDelegate;

    public MeasureAppConfigBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.logDelegate = new DefaultLogDelegate();
        this.isDebug = false;
        this.executor = ProxyExecutors.newSingleThreadScheduledExecutor();
    }

    public MeasureAppConfig create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MeasureAppConfig) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new MeasureAppConfig(this.logDelegate, this.isDebug, this.executor);
    }

    public MeasureAppConfigBuilder setExecutor(ScheduledExecutorService scheduledExecutorService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MeasureAppConfigBuilder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) scheduledExecutorService);
        }
        this.executor = scheduledExecutorService;
        return this;
    }

    public MeasureAppConfigBuilder setIsDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MeasureAppConfigBuilder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        this.isDebug = z16;
        return this;
    }

    public MeasureAppConfigBuilder setLogDelegate(ILogDelegate iLogDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MeasureAppConfigBuilder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iLogDelegate);
        }
        this.logDelegate = iLogDelegate;
        return this;
    }
}
