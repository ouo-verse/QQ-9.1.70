package com.tencent.trackrecordlib;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f380914a = false;

    /* renamed from: b, reason: collision with root package name */
    public static final String f380915b = "com.tencent.trackrecordlib";

    /* renamed from: c, reason: collision with root package name */
    public static final String f380916c = "release";

    /* renamed from: d, reason: collision with root package name */
    public static final String f380917d = "";

    /* renamed from: e, reason: collision with root package name */
    public static final int f380918e = 4;

    /* renamed from: f, reason: collision with root package name */
    public static final String f380919f = "1.2.8";

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
