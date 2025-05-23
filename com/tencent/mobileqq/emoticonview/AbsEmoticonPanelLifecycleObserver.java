package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public abstract class AbsEmoticonPanelLifecycleObserver extends AbstractEmoticonPanelHelper<IEmoticonPanelController> {
    static IPatchRedirector $redirector_;
    int providerID;

    public AbsEmoticonPanelLifecycleObserver(int i3) {
        super(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.providerID = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setPanelController(IEmoticonPanelController iEmoticonPanelController) {
        this.mPanelController = iEmoticonPanelController;
    }
}
