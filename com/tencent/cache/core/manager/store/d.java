package com.tencent.cache.core.manager.store;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final CopyOnWriteArrayList<a> f98776a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final CopyOnWriteArrayList<a> f98777b;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f98776a = new CopyOnWriteArrayList<>();
            this.f98777b = new CopyOnWriteArrayList<>();
        }
    }
}
