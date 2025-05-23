package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends b.C8976b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.e();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) bundle);
        } else if (5 == i3) {
            BrowserAutomator.p(this.f314441d.getWebViewProvider());
        }
    }

    public boolean g(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent)).booleanValue();
        }
        SwiftWebAccelerator.h().l();
        BrowserAutomator browserAutomator = BrowserAutomator.G;
        String str = com.tencent.mobileqq.webview.swift.startup.b.STEPS_STARTUP;
        if (!browserAutomator.n(str)) {
            try {
                browserAutomator.j(str);
            } catch (Throwable th5) {
                QLog.d("SwiftBrowserAutomator", 1, th5.getMessage(), th5);
            }
            com.tencent.mobileqq.webview.swift.startup.e.a();
        }
        BrowserAutomator.o(this.f314441d.getActivity());
        com.tencent.mobileqq.webview.swift.startup.e.c(com.tencent.mobileqq.webview.swift.startup.e.EVENT_ACTIVITY_CREATE, intent);
        return false;
    }
}
