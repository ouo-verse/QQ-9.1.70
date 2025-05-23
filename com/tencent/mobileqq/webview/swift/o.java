package com.tencent.mobileqq.webview.swift;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o extends w {
    static IPatchRedirector $redirector_;

    public o(@NonNull QQBrowserActivity qQBrowserActivity) {
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
            return;
        }
        super.i(bundle);
        IColorNoteController d16 = super.d();
        if (d16 != null) {
            d16.disableSwipe();
            d16.setShareEntr(false);
        }
    }
}
