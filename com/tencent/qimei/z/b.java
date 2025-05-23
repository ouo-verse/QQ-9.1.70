package com.tencent.qimei.z;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends a<Boolean> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f343435a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f343436b;

    public b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
        } else {
            this.f343435a = str;
            this.f343436b = z16;
        }
    }
}
