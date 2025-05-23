package com.tencent.mobileqq.auto.engine.lib.delegateimpl;

import com.tencent.mobileqq.auto.engine.enter.ASEngineEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.loader.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ASEngineImpl implements IASEngineDelegate {
    static IPatchRedirector $redirector_;

    public ASEngineImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate
    public boolean enter(String str, String str2, HashMap<String, String> hashMap, HashMap<String, byte[]> hashMap2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, str2, hashMap, hashMap2)).booleanValue();
        }
        ASEngineEnter.b(new ASEnterBean(str).setSchemeAction(str2).setAttrs(hashMap).setByteAttrs(hashMap2));
        return true;
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate
    public String getPluginVerSion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return String.valueOf(a.e(str).k().getVersionCode());
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate
    public boolean isOnThirdTab(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return a.e(str).w();
    }

    @Override // com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate
    public boolean setForceNative(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return a.e(str).y(z16);
    }
}
