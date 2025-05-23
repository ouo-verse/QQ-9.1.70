package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f280298a;

    /* renamed from: b, reason: collision with root package name */
    public String f280299b;

    /* renamed from: c, reason: collision with root package name */
    public String f280300c;

    /* renamed from: d, reason: collision with root package name */
    public String f280301d;

    /* renamed from: e, reason: collision with root package name */
    public String f280302e;

    /* renamed from: f, reason: collision with root package name */
    public String f280303f;

    /* renamed from: g, reason: collision with root package name */
    public String f280304g;

    /* renamed from: h, reason: collision with root package name */
    public String f280305h;

    /* renamed from: i, reason: collision with root package name */
    public String f280306i;

    /* renamed from: j, reason: collision with root package name */
    public String f280307j;

    /* renamed from: k, reason: collision with root package name */
    public String f280308k;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
