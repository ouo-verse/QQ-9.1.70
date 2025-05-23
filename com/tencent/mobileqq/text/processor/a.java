package com.tencent.mobileqq.text.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public final /* synthetic */ class a {
    public static void a(ISpanProcessor iSpanProcessor, String str, Object[] objArr) {
        IPatchRedirector iPatchRedirector = ISpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) iSpanProcessor, (Object) str, (Object) objArr);
        }
    }
}
