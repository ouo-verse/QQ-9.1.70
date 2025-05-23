package com.tencent.mobileqq.qqlive.widget.chat.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f273763a;

    /* renamed from: b, reason: collision with root package name */
    public String f273764b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f273765c;

    /* renamed from: d, reason: collision with root package name */
    public String f273766d;

    /* renamed from: e, reason: collision with root package name */
    public String f273767e;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f273765c = false;
        }
    }
}
