package com.tencent.msf.service.protocol.security;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int f336619a = 101;

    /* renamed from: b, reason: collision with root package name */
    public static final int f336620b = 203;

    /* renamed from: c, reason: collision with root package name */
    public static final int f336621c = 10;

    /* renamed from: d, reason: collision with root package name */
    public static final int f336622d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f336623e = 229;

    /* renamed from: f, reason: collision with root package name */
    public static final int f336624f = 235;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
