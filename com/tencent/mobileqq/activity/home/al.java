package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f182853a;

    /* renamed from: b, reason: collision with root package name */
    public int f182854b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f182855c;

    /* renamed from: d, reason: collision with root package name */
    public int f182856d;

    /* renamed from: e, reason: collision with root package name */
    public int f182857e;

    /* renamed from: f, reason: collision with root package name */
    public String f182858f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f182859g;

    public al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TabData{mTabId=" + this.f182853a + ", mTabStatus=" + this.f182854b + ", mFirstShow=" + this.f182855c + ", mPushFrom=" + this.f182856d + ", mPushType=" + this.f182857e + ", mTabBusinessType='" + this.f182858f + "'}";
    }
}
