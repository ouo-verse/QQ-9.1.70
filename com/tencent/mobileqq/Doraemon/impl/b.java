package com.tencent.mobileqq.Doraemon.impl;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    public b(Activity activity, int i3, String str) {
        super(activity, i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str);
        }
    }
}
