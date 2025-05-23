package com.tencent.mobileqq.qqlive.framework.page.manager;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017JN\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\u0018\u00010\nJ.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0010R@\u0010\u0015\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r0\u0012j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/a;", "", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Class;", "clazz", "", "key", "Lfi2/a;", "rootComponentContext", "", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "eventList", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/a;", "c", "b", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "componentRuntimeCache", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.qqlive.framework.pagefacotry.a<? extends com.tencent.mobileqq.qqlive.framework.component.e>> componentRuntimeCache;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.componentRuntimeCache = new HashMap<>();
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.componentRuntimeCache.clear();
        }
    }

    @Nullable
    public final <C extends com.tencent.mobileqq.qqlive.framework.component.e> com.tencent.mobileqq.qqlive.framework.pagefacotry.a<C> b(@NotNull Class<C> clazz, @NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqlive.framework.pagefacotry.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) clazz, (Object) key);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        return (com.tencent.mobileqq.qqlive.framework.pagefacotry.a) this.componentRuntimeCache.remove(ComponentManager.INSTANCE.a(clazz, key));
    }

    @NotNull
    public final <C extends com.tencent.mobileqq.qqlive.framework.component.e> com.tencent.mobileqq.qqlive.framework.pagefacotry.a<C> c(@NotNull Class<C> clazz, @NotNull String key, @NotNull fi2.a rootComponentContext, @Nullable List<? extends Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> eventList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqlive.framework.pagefacotry.a) iPatchRedirector.redirect((short) 2, this, clazz, key, rootComponentContext, eventList);
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        String a16 = ComponentManager.INSTANCE.a(clazz, key);
        com.tencent.mobileqq.qqlive.framework.pagefacotry.a<C> aVar = (com.tencent.mobileqq.qqlive.framework.pagefacotry.a) this.componentRuntimeCache.get(a16);
        if (aVar == null) {
            aVar = new com.tencent.mobileqq.qqlive.framework.pagefacotry.a<>(clazz, rootComponentContext, key, eventList, null, 16, null);
        }
        this.componentRuntimeCache.put(a16, aVar);
        return aVar;
    }
}
