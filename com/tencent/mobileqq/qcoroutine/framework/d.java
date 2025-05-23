package com.tencent.mobileqq.qcoroutine.framework;

import com.tencent.mobileqq.qcoroutine.api.f;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/d;", "", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "Lcom/tencent/mobileqq/qcoroutine/framework/QTaskPool;", "e", "", "b", "a", "Lcom/tencent/mobileqq/qcoroutine/framework/coroutine/c;", "c", "Lcom/tencent/mobileqq/qcoroutine/api/e;", "Lcom/tencent/mobileqq/qcoroutine/api/e;", "d", "()Lcom/tencent/mobileqq/qcoroutine/api/e;", "setInitApi", "(Lcom/tencent/mobileqq/qcoroutine/api/e;)V", "initApi", "", "Ljava/util/Map;", "getTaskPools", "()Ljava/util/Map;", "taskPools", "<init>", "()V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.qcoroutine.api.e initApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<i, QTaskPool> taskPools;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final d f261833c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10521);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f261833c = new d();
            taskPools = new ConcurrentHashMap();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public final void a(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Map<i, QTaskPool> map = taskPools;
        synchronized (map) {
            if (map.get(type) != null && !type.d()) {
                QTaskPool qTaskPool = map.get(type);
                if (qTaskPool != null) {
                    qTaskPool.b();
                }
                map.remove(type);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(@NotNull i type) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Map<i, QTaskPool> map = taskPools;
        synchronized (map) {
            if (map.get(type) == null) {
                z16 = true;
            } else {
                QTaskPool qTaskPool = map.get(type);
                if (qTaskPool != null) {
                    z16 = qTaskPool.m().get();
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                map.put(type, new QTaskPool(type));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.framework.coroutine.c c(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.qcoroutine.framework.coroutine.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, f.f261769e)) {
            return com.tencent.mobileqq.qcoroutine.framework.coroutine.jetpack.a.f261830c.a();
        }
        QTaskPool e16 = e(type);
        if (e16 != null) {
            return e16.f();
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (com.tencent.mobileqq.qcoroutine.api.e) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return initApi;
    }

    @Nullable
    public final QTaskPool e(@NotNull i type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QTaskPool) iPatchRedirector.redirect((short) 4, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Map<i, QTaskPool> map = taskPools;
        if (map.get(type) == null && type.d()) {
            b(type);
        }
        return map.get(type);
    }
}
