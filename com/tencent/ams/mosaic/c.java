package com.tencent.ams.mosaic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final /* synthetic */ class c {
    public static boolean a(d dVar) {
        IPatchRedirector iPatchRedirector = d.$redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) dVar)).booleanValue();
    }
}
