package com.tencent.mobileqq.msf.core.x;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f250250a = true;

    /* renamed from: b, reason: collision with root package name */
    public static final long f250251b = 10000;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f250252c = true;

    /* renamed from: d, reason: collision with root package name */
    public static final int f250253d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f250254e = 60000;

    /* renamed from: f, reason: collision with root package name */
    public static final int f250255f = 180000;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f250256g = true;

    /* renamed from: h, reason: collision with root package name */
    public static final int f250257h = 10000;

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f250258i = true;

    /* renamed from: j, reason: collision with root package name */
    public static final int f250259j = 4;

    /* renamed from: k, reason: collision with root package name */
    public static final int f250260k = 15000;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
