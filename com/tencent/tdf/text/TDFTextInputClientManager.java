package com.tencent.tdf.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.view.TDFOutputView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TDFTextInputClientManager {
    static IPatchRedirector $redirector_;
    private TDFTextInputClient currentClient;
    private TDFOutputView outputView;

    public TDFTextInputClientManager(TDFOutputView tDFOutputView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tDFOutputView);
        } else {
            this.outputView = tDFOutputView;
        }
    }

    public void onSetCurrentActiveClient(TDFTextInputClient tDFTextInputClient) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tDFTextInputClient);
            return;
        }
        TDFTextInputClient tDFTextInputClient2 = this.currentClient;
        if (tDFTextInputClient2 != tDFTextInputClient) {
            if (tDFTextInputClient2 != null) {
                if (tDFTextInputClient == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                tDFTextInputClient2.deactivate(z16);
            }
            this.currentClient = tDFTextInputClient;
            if (tDFTextInputClient != null) {
                tDFTextInputClient.activate(this.outputView);
            }
        }
    }
}
