package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n extends w {
    static IPatchRedirector $redirector_;

    public n(@NonNull QQBrowserActivity qQBrowserActivity) {
        super(qQBrowserActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQBrowserActivity);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.w
    public void i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.b();
            super.i(bundle);
        }
    }
}
