package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Y6UCg {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382103a;

    /* renamed from: b, reason: collision with root package name */
    public String f382104b;

    /* renamed from: c, reason: collision with root package name */
    public String f382105c;

    /* renamed from: d, reason: collision with root package name */
    public String f382106d;

    public Y6UCg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
