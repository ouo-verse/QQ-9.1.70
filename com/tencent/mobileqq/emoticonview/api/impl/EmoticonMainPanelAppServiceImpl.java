package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmoticonMainPanelAppServiceImpl implements IEmoticonMainPanelAppService {
    static IPatchRedirector $redirector_;

    public EmoticonMainPanelAppServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService
    public IEmoticonMainPanelApp createEmoticonMainPanelApp(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IEmoticonMainPanelApp) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return new QQEmoticonMainPanelApp(appRuntime);
    }
}
