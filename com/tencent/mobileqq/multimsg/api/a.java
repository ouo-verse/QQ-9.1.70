package com.tencent.mobileqq.multimsg.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f251588a;

    /* renamed from: b, reason: collision with root package name */
    public int f251589b;

    /* renamed from: c, reason: collision with root package name */
    public String f251590c;

    /* renamed from: d, reason: collision with root package name */
    public Object f251591d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
