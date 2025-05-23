package com.tencent.qimei.t;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f343375a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f343375a == null) {
                f343375a = new c(null);
            }
            aVar = f343375a;
        }
        return aVar;
    }

    public abstract void a(long j3, @NonNull Runnable runnable);

    public abstract void a(@NonNull Runnable runnable);
}
