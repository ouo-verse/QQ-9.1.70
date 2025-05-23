package com.tencent.mobileqq.pic.compress;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f258668a;

    /* renamed from: b, reason: collision with root package name */
    public static int f258669b;

    /* renamed from: c, reason: collision with root package name */
    public static int f258670c;

    /* renamed from: d, reason: collision with root package name */
    public static int f258671d;

    /* renamed from: e, reason: collision with root package name */
    public static int f258672e;

    /* renamed from: f, reason: collision with root package name */
    public static int f258673f;

    /* renamed from: g, reason: collision with root package name */
    public static int f258674g;

    /* renamed from: h, reason: collision with root package name */
    public static int f258675h;

    /* renamed from: i, reason: collision with root package name */
    public static int f258676i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34041);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258668a = 80;
        f258669b = 70;
        f258670c = 80;
        f258671d = 1920;
        f258672e = 960;
        f258673f = 960;
        f258674g = 960;
        f258675h = 960;
        f258676i = 960;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();
}
