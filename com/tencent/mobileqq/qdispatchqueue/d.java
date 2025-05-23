package com.tencent.mobileqq.qdispatchqueue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    static d f261876c;

    /* renamed from: a, reason: collision with root package name */
    Executor f261877a;

    /* renamed from: b, reason: collision with root package name */
    e f261878b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f261876c = new d();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static h a(@NonNull String str) {
        return b(str, null, null, false);
    }

    public static h b(@NonNull String str, @Nullable Executor executor, @Nullable e eVar, boolean z16) {
        if (executor == null) {
            executor = f().e();
        }
        if (eVar == null) {
            eVar = f().d();
        }
        return new h(str, executor, eVar, z16);
    }

    public static h c(@NonNull String str, boolean z16) {
        return b(str, null, null, z16);
    }

    static d f() {
        return f261876c;
    }

    public static synchronized void g(@Nullable e eVar, @Nullable Executor executor) {
        synchronized (d.class) {
            f().h(eVar);
            f().i(executor);
        }
    }

    private void h(e eVar) {
        if (eVar == null) {
            eVar = b.b();
        }
        this.f261878b = eVar;
    }

    private void i(Executor executor) {
        if (executor == null) {
            executor = c.a();
        }
        this.f261877a = executor;
    }

    e d() {
        return this.f261878b;
    }

    Executor e() {
        return this.f261877a;
    }
}
