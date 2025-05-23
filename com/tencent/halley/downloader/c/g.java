package com.tencent.halley.downloader.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile g f113696f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113697a;

    /* renamed from: b, reason: collision with root package name */
    public long f113698b;

    /* renamed from: c, reason: collision with root package name */
    public int f113699c;

    /* renamed from: d, reason: collision with root package name */
    public int f113700d;

    /* renamed from: e, reason: collision with root package name */
    public int f113701e;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113697a = false;
        this.f113698b = 0L;
        this.f113699c = 3;
        this.f113700d = 5;
        this.f113701e = 0;
    }

    public static g a() {
        if (f113696f == null) {
            synchronized (g.class) {
                if (f113696f == null) {
                    f113696f = new g();
                }
            }
        }
        return f113696f;
    }
}
