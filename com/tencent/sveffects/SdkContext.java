package com.tencent.sveffects;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.resource.Resources;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SdkContext {
    static IPatchRedirector $redirector_ = null;
    public static final String APP_DOV = "DOV";
    public static final String APP_QQ = "QQ";
    public static final String APP_UNKNOWN = "UNKNOWN";
    private static SdkContext instance;
    private String appName;
    private Application application;
    private DpcSwitcher dpcSwitcher;
    private Logger logger;
    private Reporter reporter;
    private Resources resources;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            instance = new SdkContext();
        }
    }

    SdkContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SdkContext getInstance() {
        return instance;
    }

    public String getAppName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.appName;
    }

    public Application getApplication() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Application) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.application;
    }

    public DpcSwitcher getDpcSwitcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DpcSwitcher) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.dpcSwitcher;
    }

    public Logger getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Logger) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.logger == null) {
            this.logger = new DefaultLogger();
        }
        return this.logger;
    }

    public Reporter getReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Reporter) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.reporter;
    }

    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Resources) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.resources;
    }

    public void init(Application application, DpcSwitcher dpcSwitcher, Resources resources, Logger logger, Reporter reporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init("UNKNOWN", application, dpcSwitcher, resources, logger, reporter);
        } else {
            iPatchRedirector.redirect((short) 2, this, application, dpcSwitcher, resources, logger, reporter);
        }
    }

    public void init(String str, Application application, DpcSwitcher dpcSwitcher, Resources resources, Logger logger, Reporter reporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, application, dpcSwitcher, resources, logger, reporter);
            return;
        }
        this.appName = str;
        this.application = application;
        this.dpcSwitcher = dpcSwitcher;
        this.resources = resources;
        this.logger = logger;
        this.reporter = reporter;
    }
}
