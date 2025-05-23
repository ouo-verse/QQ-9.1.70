package com.tencent.sonic.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SonicSessionClient {
    static IPatchRedirector $redirector_;
    private SonicSession session;

    public SonicSessionClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void bindSession(SonicSession sonicSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sonicSession);
        } else {
            this.session = sonicSession;
        }
    }

    public void clearHistory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public void clientReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        SonicSession sonicSession = this.session;
        if (sonicSession != null) {
            sonicSession.onClientReady();
        }
    }

    public void getDiffData(SonicDiffDataCallback sonicDiffDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sonicDiffDataCallback);
            return;
        }
        SonicSession sonicSession = this.session;
        if (sonicSession != null) {
            sonicSession.onWebReady(sonicDiffDataCallback);
        }
    }

    public abstract void loadDataWithBaseUrl(String str, String str2, String str3, String str4, String str5);

    public abstract void loadDataWithBaseUrlAndHeader(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap);

    public abstract void loadUrl(String str, Bundle bundle);

    public void pageFinish(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        SonicSession sonicSession = this.session;
        if (sonicSession != null) {
            sonicSession.onClientPageFinished(str);
        }
    }

    public Object requestResource(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        SonicSession sonicSession = this.session;
        if (sonicSession != null) {
            return sonicSession.onClientRequestResource(str);
        }
        return null;
    }
}
