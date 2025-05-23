package com.tencent.qqnt.util.permission.impl;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a(Context context, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) strArr)).booleanValue();
        }
        if (context != null) {
            for (String str : strArr) {
                if (a.a(context, str) != 0) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Can't check permissions for null context");
    }
}
