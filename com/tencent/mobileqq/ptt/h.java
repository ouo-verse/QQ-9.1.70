package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public float f261237a;

    /* renamed from: b, reason: collision with root package name */
    public int f261238b;

    /* renamed from: c, reason: collision with root package name */
    public float f261239c;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f261237a = -1.0f;
        this.f261238b = -1;
        this.f261239c = -1.0f;
    }
}
