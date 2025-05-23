package com.tencent.hlyyb.downloader.g.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f114663a;

    /* renamed from: b, reason: collision with root package name */
    public int f114664b;

    /* renamed from: c, reason: collision with root package name */
    public int f114665c;

    /* renamed from: d, reason: collision with root package name */
    public String f114666d;

    /* renamed from: e, reason: collision with root package name */
    public String f114667e;

    /* renamed from: f, reason: collision with root package name */
    public String f114668f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f114669g;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114666d = "";
        this.f114667e = "";
        this.f114668f = "";
        this.f114669g = true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "";
    }
}
