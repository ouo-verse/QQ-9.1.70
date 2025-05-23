package com.tencent.mvi.runtime.strategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R(\u0010\u000f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mvi/runtime/strategy/a;", "Lcom/tencent/mvi/runtime/strategy/b;", "T", "Ljava/lang/Class;", "clazz", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "fetcher", "", "c", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "a", "", "Ljava/util/Map;", "servicePool", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Class<?>, IStrategyFetcher<?>> servicePool;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.servicePool = new LinkedHashMap();
        }
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> boolean a(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.servicePool.containsKey(clazz);
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    @Nullable
    public <T> T b(@NotNull Class<T> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        IStrategyFetcher<?> iStrategyFetcher = this.servicePool.get(clazz);
        if (!(iStrategyFetcher instanceof IStrategyFetcher)) {
            iStrategyFetcher = null;
        }
        IStrategyFetcher<?> iStrategyFetcher2 = iStrategyFetcher;
        if (iStrategyFetcher2 == null) {
            return null;
        }
        return (T) iStrategyFetcher2.b();
    }

    @Override // com.tencent.mvi.runtime.strategy.b
    public <T> void c(@NotNull Class<T> clazz, @NotNull IStrategyFetcher<T> fetcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clazz, (Object) fetcher);
            return;
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.servicePool.put(clazz, fetcher);
    }
}
