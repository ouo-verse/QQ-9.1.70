package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f184978a;

    /* renamed from: b, reason: collision with root package name */
    public String f184979b;

    /* renamed from: c, reason: collision with root package name */
    public String f184980c;

    /* renamed from: d, reason: collision with root package name */
    public String f184981d;

    public bo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
