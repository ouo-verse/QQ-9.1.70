package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Apple {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f382547i;

    /* renamed from: j, reason: collision with root package name */
    public static int f382548j;

    /* renamed from: k, reason: collision with root package name */
    public static Apple f382549k;

    /* renamed from: a, reason: collision with root package name */
    public Apple f382550a;

    /* renamed from: b, reason: collision with root package name */
    public String f382551b;

    /* renamed from: c, reason: collision with root package name */
    public int f382552c;

    /* renamed from: d, reason: collision with root package name */
    public int f382553d;

    /* renamed from: e, reason: collision with root package name */
    public int f382554e;

    /* renamed from: f, reason: collision with root package name */
    public float f382555f;

    /* renamed from: g, reason: collision with root package name */
    public float f382556g;

    /* renamed from: h, reason: collision with root package name */
    public long f382557h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9863);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382547i = new Object();
        }
    }

    public Apple() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
