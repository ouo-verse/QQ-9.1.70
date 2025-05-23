package com.tencent.mobileqq.avifcodec.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f200174a;

    /* renamed from: b, reason: collision with root package name */
    public final int f200175b;

    public a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            this.f200174a = z16;
            this.f200175b = i3;
        }
    }
}
