package com.tencent.cache.core.manager.store;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final WeakReference<com.tencent.cache.api.b> f98772a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f98773b;

    public a(@NotNull String subBusiness, @NotNull com.tencent.cache.api.b cache) {
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        Intrinsics.checkNotNullParameter(cache, "cache");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) subBusiness, (Object) cache);
        } else {
            this.f98773b = subBusiness;
            this.f98772a = new WeakReference<>(cache);
        }
    }
}
