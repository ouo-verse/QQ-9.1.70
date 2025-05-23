package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.this, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cthis {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f375835a;

    /* renamed from: b, reason: collision with root package name */
    public String f375836b;

    /* renamed from: c, reason: collision with root package name */
    public String f375837c;

    /* renamed from: d, reason: collision with root package name */
    public String f375838d;

    public Cthis() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
