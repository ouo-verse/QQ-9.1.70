package com.tencent.mobileqq.leba.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f240749a;

    /* renamed from: b, reason: collision with root package name */
    public String f240750b;

    /* renamed from: c, reason: collision with root package name */
    public String f240751c;

    /* renamed from: d, reason: collision with root package name */
    public String f240752d;

    /* renamed from: e, reason: collision with root package name */
    public int f240753e;

    /* renamed from: f, reason: collision with root package name */
    public int f240754f;

    /* renamed from: g, reason: collision with root package name */
    public int f240755g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f240749a = 0L;
        this.f240750b = "";
        this.f240751c = "";
        this.f240752d = "";
        this.f240753e = 0;
        this.f240754f = 0;
        this.f240755g = 1;
    }

    public abstract String a(int i3);

    public abstract String toString();
}
