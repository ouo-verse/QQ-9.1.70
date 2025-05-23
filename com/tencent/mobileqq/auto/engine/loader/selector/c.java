package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean c() {
        QLog.i("ASDynamicEngine", 1, "ASPluginSelectorSupportProcess#isUnSupport():false");
        return false;
    }

    @Override // com.tencent.mobileqq.auto.engine.loader.selector.g
    public ASPluginBean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (c()) {
            return new ASPluginBean();
        }
        return null;
    }
}
