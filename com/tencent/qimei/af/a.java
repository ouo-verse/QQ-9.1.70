package com.tencent.qimei.af;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static a f342967b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f342968a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342968a = false;
        }
    }

    public static a a() {
        if (f342967b == null) {
            synchronized (a.class) {
                if (f342967b == null) {
                    f342967b = new a();
                }
            }
        }
        return f342967b;
    }
}
