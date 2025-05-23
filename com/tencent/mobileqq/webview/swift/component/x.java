package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class x {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        }
    }
}
