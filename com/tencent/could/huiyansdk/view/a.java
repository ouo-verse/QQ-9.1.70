package com.tencent.could.huiyansdk.view;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends RelativeLayout {
    static IPatchRedirector $redirector_;

    public View getTuringPreviewView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return null;
    }
}
