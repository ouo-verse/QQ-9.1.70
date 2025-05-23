package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi;
import com.tencent.mobileqq.leba.ILebaPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LebaDataServicesApiImpl implements ILebaDataServicesApi {
    static IPatchRedirector $redirector_;

    public LebaDataServicesApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi
    public void accountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ((ILebaPlugin) QRoute.api(ILebaPlugin.class)).accountChange();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi
    public BusinessInfoCheckUpdate.RedTypeInfo getRedTypeInfo(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BusinessInfoCheckUpdate.RedTypeInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return ((ILebaPlugin) QRoute.api(ILebaPlugin.class)).getNewTabRedTypeInfo();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi
    public void hiddeNewGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((ILebaPlugin) QRoute.api(ILebaPlugin.class)).hiddeNewGuide();
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi
    public Boolean redTouchContainerNewGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Boolean) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return Boolean.valueOf(((ILebaPlugin) QRoute.api(ILebaPlugin.class)).redTouchContainerNewGuide());
    }
}
