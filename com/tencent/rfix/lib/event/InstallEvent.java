package com.tencent.rfix.lib.event;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.entity.RFixPatchResult;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public class InstallEvent {
    static IPatchRedirector $redirector_;
    public RFixPatchResult patchResult;
    public int resultCode;

    public InstallEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.patchResult.isPatchSuccess();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "InstallEvent{resultCode=" + this.resultCode + "resultDesc=" + this.patchResult.result + '}';
    }
}
