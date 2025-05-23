package com.tencent.ams.xsad.rewarded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f71729a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f71730b;

    /* renamed from: c, reason: collision with root package name */
    public int f71731c;

    /* renamed from: d, reason: collision with root package name */
    public int f71732d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
