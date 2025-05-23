package com.tencent.mobileqq.qroute;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.module.b;
import com.tencent.mobileqq.qroute.route.g;
import com.tencent.mobileqq.qroute.utils.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRouteConfig {
    static IPatchRedirector $redirector_;
    private boolean mForceCheck;
    private boolean mInStartStep;
    private g mLogger;
    private List<String> mModules;
    private b mPluginFactory;
    private c mProcessCheck;
    private String mProcessName;
    private com.tencent.mobileqq.qroute.remote.a mRemoteProxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QRouteConfig(String str, boolean z16, c cVar, g gVar, com.tencent.mobileqq.qroute.remote.a aVar, b bVar, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), cVar, gVar, aVar, bVar, list);
            return;
        }
        this.mInStartStep = false;
        this.mProcessName = str;
        this.mForceCheck = z16;
        this.mProcessCheck = cVar;
        this.mLogger = gVar;
        this.mRemoteProxy = aVar;
        this.mPluginFactory = bVar;
        this.mModules = list;
    }

    public g getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (g) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mLogger;
    }

    public List<String> getModules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mModules;
    }

    public b getPluginFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mPluginFactory;
    }

    public c getProcessCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mProcessCheck;
    }

    public String getProcessName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mProcessName;
    }

    public com.tencent.mobileqq.qroute.remote.a getRemoteProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.qroute.remote.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mRemoteProxy;
    }

    public boolean isForceCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mForceCheck;
    }

    public boolean isInStartStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mInStartStep;
    }

    public void startStepBegin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mInStartStep = true;
        }
    }

    public void startStepEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mInStartStep = false;
        }
    }
}
