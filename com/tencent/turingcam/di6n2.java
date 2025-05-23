package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class di6n2 {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f382189i;

    /* renamed from: j, reason: collision with root package name */
    public static int f382190j;

    /* renamed from: k, reason: collision with root package name */
    public static di6n2 f382191k;

    /* renamed from: a, reason: collision with root package name */
    public di6n2 f382192a;

    /* renamed from: b, reason: collision with root package name */
    public String f382193b;

    /* renamed from: c, reason: collision with root package name */
    public int f382194c;

    /* renamed from: d, reason: collision with root package name */
    public int f382195d;

    /* renamed from: e, reason: collision with root package name */
    public int f382196e;

    /* renamed from: f, reason: collision with root package name */
    public float f382197f;

    /* renamed from: g, reason: collision with root package name */
    public float f382198g;

    /* renamed from: h, reason: collision with root package name */
    public long f382199h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21397);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f382189i = new Object();
        }
    }

    public di6n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
