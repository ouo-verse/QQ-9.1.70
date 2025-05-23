package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public final /* synthetic */ class c {
    public static boolean a(d.a aVar) {
        IPatchRedirector iPatchRedirector = d.a.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) aVar)).booleanValue();
        }
        return false;
    }
}
