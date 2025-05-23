package com.tencent.mobileqq.app.activitymodule;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class DefaultActivityModuleProvider implements IActivityModuleProvider {
    static IPatchRedirector $redirector_;
    protected GestureActivityModule gestureActivityModule;
    protected ScreenShotActivityModule screenShotActivityModule;
    protected SkinActivityModule skinActivityModule;
    protected SystemBarActivityModule systemBarActivityModule;

    public DefaultActivityModuleProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityModuleProvider
    public List<IActivityModule> generateModules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        IActivityModule systemBarModule = getSystemBarModule();
        if (systemBarModule != null) {
            arrayList.add(systemBarModule);
        }
        IActivityModule screenShotModule = getScreenShotModule();
        if (screenShotModule != null) {
            arrayList.add(screenShotModule);
        }
        IActivityModule skinModule = getSkinModule();
        if (skinModule != null) {
            arrayList.add(skinModule);
        }
        IActivityModule gestureModule = getGestureModule();
        if (gestureModule != null) {
            arrayList.add(gestureModule);
        }
        return arrayList;
    }

    protected IActivityModule getGestureModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (IActivityModule) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new GestureActivityModule();
    }

    protected IActivityModule getScreenShotModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IActivityModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ScreenShotActivityModule();
    }

    protected IActivityModule getSkinModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IActivityModule) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new SkinActivityModule();
    }

    protected IActivityModule getSystemBarModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IActivityModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new SystemBarActivityModule();
    }
}
