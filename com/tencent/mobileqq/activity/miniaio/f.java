package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f183480a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f183481b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f183482c;

    /* renamed from: d, reason: collision with root package name */
    public int f183483d;

    /* renamed from: e, reason: collision with root package name */
    public int f183484e;

    /* renamed from: f, reason: collision with root package name */
    public int f183485f;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
