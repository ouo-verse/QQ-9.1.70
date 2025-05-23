package com.tencent.tdf.module;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class TDFModuleContext {
    static IPatchRedirector $redirector_;

    public TDFModuleContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract TDFBaseModule getModule(String str);

    public abstract View getRootView();

    public abstract View getView(int i3);

    public abstract void sendEvent(String str, Map<String, Object> map);
}
