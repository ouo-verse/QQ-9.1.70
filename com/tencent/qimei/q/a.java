package com.tencent.qimei.q;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f343357b;

    /* renamed from: a, reason: collision with root package name */
    public String f343358a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f343357b == null) {
                synchronized (a.class) {
                    if (f343357b == null) {
                        f343357b = new a();
                    }
                }
            }
            aVar = f343357b;
        }
        return aVar;
    }
}
