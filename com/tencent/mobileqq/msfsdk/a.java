package com.tencent.mobileqq.msfsdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f251000a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final String f251001b = "com.tencent.mobileqq.msfsdk";

    /* renamed from: c, reason: collision with root package name */
    public static final String f251002c = "release";

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f251003d = false;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
