package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ASPluginBean f199881a;

    public d(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
        } else {
            this.f199881a = aSPluginBean;
        }
    }

    private ASPluginBean c(ASPluginBean aSPluginBean) {
        if (com.tencent.mobileqq.auto.engine.loader.a.e(aSPluginBean.getBusinessKey()).j().j()) {
            QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASPluginSelectorWnsProcess#checkWNS():WNS force use asset true");
            return aSPluginBean;
        }
        QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASPluginSelectorWnsProcess#checkWNS():WNS force use asset false");
        return null;
    }

    @Override // com.tencent.mobileqq.auto.engine.loader.selector.g
    public ASPluginBean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c(this.f199881a);
    }
}
