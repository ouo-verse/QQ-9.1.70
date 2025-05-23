package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class as {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f302081a;

    /* renamed from: b, reason: collision with root package name */
    public int f302082b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.f302081a = str;
            this.f302082b = i3;
        }
    }
}
