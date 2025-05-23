package com.tencent.mobileqq.qqlive.framework.component;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.component.e;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0019\u0012\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\n\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0096\u0001J\u0017\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u000b\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/component/d;", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;", "Lcom/tencent/mobileqq/qqlive/framework/component/f;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "key", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/j;", "listener", "b", "c", "", "(Lcom/tencent/mobileqq/qqlive/framework/component/e;)V", "a", "()Lcom/tencent/mobileqq/qqlive/framework/component/e;", "d", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", HippyQQConstants.URL_COMPONENT_NAME, "registry", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/component/e;Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/g;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d<C extends e> implements com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g, f<C> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private C component;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g f271247e;

    public d(@Nullable C c16, @NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c16, (Object) registry);
        } else {
            this.component = c16;
            this.f271247e = registry;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.f
    @Nullable
    public C a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (C) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.component;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g
    @NotNull
    public com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g b(@NotNull Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> key, @NotNull j<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqlive.framework.eventbroadcaster.g) iPatchRedirector.redirect((short) 4, (Object) this, (Object) key, (Object) listener);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return this.f271247e.b(key, listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(@NotNull e c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) c16);
        } else {
            Intrinsics.checkNotNullParameter(c16, "c");
            this.component = c16;
        }
    }
}
