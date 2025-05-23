package com.tencent.mobileqq.qcoroutine.framework.coroutine;

import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.QTaskPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/a;", "runnable", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b", "T", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/a;", "a", "Lcom/tencent/mobileqq/qcoroutine/framework/b;", "d", "c", "", "Ljava/util/Map;", "getQLaunchPools", "()Ljava/util/Map;", "qLaunchPools", "getQAsyncPools", "qAsyncPools", "Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "getStaticData", "()Lcom/tencent/mobileqq/qcoroutine/framework/report/a;", "staticData", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "getType", "()Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "<init>", "(Lcom/tencent/mobileqq/qcoroutine/api/i;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<a, com.tencent.mobileqq.qcoroutine.api.coroutine.b> qLaunchPools;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<a, com.tencent.mobileqq.qcoroutine.api.coroutine.a<?>> qAsyncPools;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qcoroutine.framework.report.a staticData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i type;

    public c(@NotNull i type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        this.qLaunchPools = new ConcurrentHashMap();
        this.qAsyncPools = new ConcurrentHashMap();
        this.staticData = new com.tencent.mobileqq.qcoroutine.framework.report.a(type, 0L, 0L, 0L, 0, 30, null);
    }

    @NotNull
    public final <T> com.tencent.mobileqq.qcoroutine.api.coroutine.a<T> a(@NotNull a runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.qcoroutine.api.coroutine.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        com.tencent.mobileqq.qcoroutine.api.coroutine.a<T> aVar = new com.tencent.mobileqq.qcoroutine.api.coroutine.a<>(System.currentTimeMillis());
        this.qAsyncPools.put(runnable, aVar);
        com.tencent.mobileqq.qcoroutine.api.a a16 = runnable.a();
        if (a16 != null) {
            a16.a();
        }
        return aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b b(@NotNull a runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qcoroutine.api.coroutine.b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = new com.tencent.mobileqq.qcoroutine.api.coroutine.b(System.currentTimeMillis());
        this.qLaunchPools.put(runnable, bVar);
        com.tencent.mobileqq.qcoroutine.api.a a16 = runnable.a();
        if (a16 != null) {
            a16.a();
        }
        return bVar;
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.framework.b c(@NotNull a runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.qcoroutine.framework.b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.staticData.a(d(runnable));
        QTaskPool.INSTANCE.a(runnable, d(runnable));
        int i3 = b.f261823b[runnable.j().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return this.qAsyncPools.remove(runnable);
            }
            throw new NoWhenBranchMatchedException();
        }
        return this.qLaunchPools.remove(runnable);
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.framework.b d(@NotNull a runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.qcoroutine.framework.b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        int i3 = b.f261822a[runnable.j().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return this.qAsyncPools.get(runnable);
            }
            throw new NoWhenBranchMatchedException();
        }
        return this.qLaunchPools.get(runnable);
    }
}
