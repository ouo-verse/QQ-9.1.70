package com.tencent.mobileqq.msf.core.net.t;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final int f249383a = 75;

    /* renamed from: b, reason: collision with root package name */
    public static final int f249384b = 200;

    /* renamed from: c, reason: collision with root package name */
    public static final int f249385c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249386d = 50;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249387e = 262144;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249388f = 262144;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249389g = 524288;

    /* renamed from: h, reason: collision with root package name */
    public static final int f249390h = 1048576;

    /* renamed from: i, reason: collision with root package name */
    public static final int f249391i = 10;

    /* renamed from: j, reason: collision with root package name */
    public static final int f249392j = 32768;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
