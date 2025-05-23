package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ASPluginBean f199883a;

    public f(ASPluginBean aSPluginBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aSPluginBean);
        } else {
            this.f199883a = aSPluginBean;
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.loader.selector.g
    public ASPluginBean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ASPluginBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ASPluginBean aSPluginBean = this.f199883a;
        if (aSPluginBean == null) {
            QLog.i("ASDynamicEngine", 1, "ASSelectorNativeProcess#checkAsset():No Asset Info");
            return null;
        }
        QLog.i(ASDynamicEngine.q(aSPluginBean.getBusinessKey()), 1, "ASSelectorNativeProcess#checkAsset():use asset plugin , assetVersion:" + this.f199883a.getVersionCode() + " ,MiniSupportVersion:" + this.f199883a.getSupportMinHostVersion());
        return this.f199883a;
    }
}
