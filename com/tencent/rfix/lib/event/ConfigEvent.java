package com.tencent.rfix.lib.event;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.config.PatchConfig;
import com.tencent.rfix.lib.config.e;

/* compiled from: P */
@Keep
/* loaded from: classes25.dex */
public class ConfigEvent {
    static IPatchRedirector $redirector_;
    public PatchConfig config;
    public int resultCode;

    public ConfigEvent() {
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
        if (this.resultCode == e.f364942e) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ConfigEvent{resultCode=" + this.resultCode + "configId=" + this.config.configId + '}';
    }
}
