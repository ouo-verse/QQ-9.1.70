package com.tencent.halley.downloader.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f113702b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113703a;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113703a = false;
        }
    }

    public static h a() {
        if (f113702b == null) {
            synchronized (h.class) {
                if (f113702b == null) {
                    f113702b = new h();
                }
            }
        }
        return f113702b;
    }
}
