package com.tencent.cache.core.collection.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    @JvmDefault
    @Nullable
    public static com.tencent.cache.api.c a(b bVar) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.cache.api.c) iPatchRedirector.redirect((short) 4, (Object) bVar);
        }
        return bVar.getCollector().c().f98710i;
    }

    @JvmDefault
    @NotNull
    public static com.tencent.cache.core.manager.report.b b(b bVar) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.cache.core.manager.report.b) iPatchRedirector.redirect((short) 2, (Object) bVar);
        }
        int count = bVar.getCount();
        d cacheInfo = bVar.getCacheInfo();
        Intrinsics.checkNotNullParameter(cacheInfo, "cacheInfo");
        return new com.tencent.cache.core.manager.report.b(count, cacheInfo.c(), cacheInfo.a(), cacheInfo.a() + cacheInfo.d());
    }

    @JvmDefault
    public static void c(b bVar, @NotNull com.tencent.cache.api.c listener) {
        IPatchRedirector iPatchRedirector = b.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) bVar, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            bVar.getCollector().c().f98710i = listener;
        }
    }
}
