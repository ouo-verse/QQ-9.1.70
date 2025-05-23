package com.tencent.mobileqq.magicface.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f243435a;

    /* renamed from: b, reason: collision with root package name */
    public String f243436b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f243437c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f243438d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
