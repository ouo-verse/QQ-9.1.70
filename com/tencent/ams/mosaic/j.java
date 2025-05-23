package com.tencent.ams.mosaic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Object f70653a;

    /* renamed from: b, reason: collision with root package name */
    public String f70654b;

    public j(Object obj, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) str);
        } else {
            this.f70654b = str;
            this.f70653a = obj;
        }
    }
}
