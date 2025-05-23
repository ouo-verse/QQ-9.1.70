package com.tencent.mobileqq.troop.temporaryban;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f299204a;

    /* renamed from: b, reason: collision with root package name */
    public String f299205b;

    public a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f299204a = str;
            this.f299205b = str2;
        }
    }
}
