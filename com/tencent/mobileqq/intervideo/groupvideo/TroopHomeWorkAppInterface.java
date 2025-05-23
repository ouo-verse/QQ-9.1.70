package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TroopHomeWorkAppInterface extends PluginRuntime {
    static IPatchRedirector $redirector_;

    public TroopHomeWorkAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            QLog.i("TroopHomeWorkAppInterface", 1, "init");
        }
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean decodeBool = g.a().decodeBool("isFloatWindowModel", false);
        QLog.i("TroopHomeWorkAppInterface", 1, "highPriorityWhenBackground isFloatWindowModel=" + decodeBool);
        return decodeBool;
    }
}
