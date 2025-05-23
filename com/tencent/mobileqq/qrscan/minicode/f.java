package com.tencent.mobileqq.qrscan.minicode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    int f276764a;

    /* renamed from: b, reason: collision with root package name */
    int f276765b;

    /* renamed from: c, reason: collision with root package name */
    int f276766c;

    /* renamed from: d, reason: collision with root package name */
    String f276767d;

    /* renamed from: e, reason: collision with root package name */
    String f276768e;

    /* renamed from: f, reason: collision with root package name */
    String f276769f;

    /* renamed from: g, reason: collision with root package name */
    String f276770g;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
