package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewTabBarData implements Serializable {
    static IPatchRedirector $redirector_;
    public String tabIcon;
    public String tabName;
    public String tag;
    public String url;

    public WebViewTabBarData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
