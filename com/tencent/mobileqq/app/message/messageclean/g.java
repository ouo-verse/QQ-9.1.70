package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f196216a;

    /* renamed from: b, reason: collision with root package name */
    public int f196217b;

    /* renamed from: c, reason: collision with root package name */
    public String f196218c;

    /* renamed from: d, reason: collision with root package name */
    public String f196219d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f196220e;

    /* renamed from: f, reason: collision with root package name */
    public long f196221f;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
