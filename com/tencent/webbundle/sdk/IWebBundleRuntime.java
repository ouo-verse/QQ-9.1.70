package com.tencent.webbundle.sdk;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class IWebBundleRuntime {
    static IPatchRedirector $redirector_;
    private Context context;

    public IWebBundleRuntime(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    @NotNull
    public abstract IWebBundleWebView createWebView(@NotNull Context context);

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.context = null;
        }
    }

    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }
}
