package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class a {
    public static Body a() {
        IPatchRedirector iPatchRedirector = Body.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Body) iPatchRedirector.redirect((short) 2);
        }
        return EmptyBody.INSTANCE;
    }

    public static Body b(String str) {
        IPatchRedirector iPatchRedirector = Body.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Body) iPatchRedirector.redirect((short) 1, (Object) str);
        }
        return StringBody.create(str);
    }
}
