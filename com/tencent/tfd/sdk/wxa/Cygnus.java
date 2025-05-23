package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Cygnus {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static Cygnus f375575k;

    /* renamed from: l, reason: collision with root package name */
    public static int f375576l;

    /* renamed from: m, reason: collision with root package name */
    public static Object f375577m;

    /* renamed from: a, reason: collision with root package name */
    public Cygnus f375578a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f375579b;

    /* renamed from: c, reason: collision with root package name */
    public int f375580c;

    /* renamed from: d, reason: collision with root package name */
    public int f375581d;

    /* renamed from: e, reason: collision with root package name */
    public int f375582e;

    /* renamed from: f, reason: collision with root package name */
    public float f375583f;

    /* renamed from: g, reason: collision with root package name */
    public float f375584g;

    /* renamed from: h, reason: collision with root package name */
    public float f375585h;

    /* renamed from: i, reason: collision with root package name */
    public float f375586i;

    /* renamed from: j, reason: collision with root package name */
    public String f375587j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62546);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375577m = new Object();
        }
    }

    public Cygnus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375587j = "";
        }
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "action : " + this.f375580c + ",deviceId : " + this.f375581d + ",toolType : " + this.f375582e + ",rawX : " + this.f375583f + ",rawY : " + this.f375584g + ",pressure : " + this.f375585h + ",size : " + this.f375586i;
    }
}
