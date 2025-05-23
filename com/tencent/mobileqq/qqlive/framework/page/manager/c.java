package com.tencent.mobileqq.qqlive.framework.page.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J+\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "", "Ljava/lang/Class;", "clazz", "", "b", "E", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "a", "(Ljava/lang/Class;Ljava/lang/Object;)V", "c", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "Ljava/util/Map;", "interfaceImplMap", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Class<?>, Object> interfaceImplMap;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.interfaceImplMap = new LinkedHashMap();
        }
    }

    private final void b(Class<?> clazz) {
        if (this.interfaceImplMap.containsKey(clazz)) {
            com.tencent.mobileqq.qqlive.framework.c.d(new RuntimeException("Ext Interface key has exist " + clazz.getSimpleName() + ",Please check code!"));
        }
    }

    public final <E> void a(@NotNull Class<E> clazz, E any) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz, (Object) any);
            return;
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        b(clazz);
        Map<Class<?>, Object> map = this.interfaceImplMap;
        Intrinsics.checkNotNull(any, "null cannot be cast to non-null type kotlin.Any");
        map.put(clazz, any);
    }

    @Nullable
    public final <E> E c(@NotNull Class<E> clazz) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (E) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (E) this.interfaceImplMap.get(clazz);
    }
}
