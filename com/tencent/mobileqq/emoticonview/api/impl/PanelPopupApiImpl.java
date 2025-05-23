package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.emoticonview.api.IPanelPopupApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class PanelPopupApiImpl implements IPanelPopupApi {
    static IPatchRedirector $redirector_;

    public PanelPopupApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IPanelPopupApi
    public IPanelDependListener createPanelDependListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IPanelDependListener) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new EmotionPanelDependListener();
    }
}
