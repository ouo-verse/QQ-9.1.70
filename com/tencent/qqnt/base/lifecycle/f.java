package com.tencent.qqnt.base.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/f;", "", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Lifecycle;", "realLifecycle", "Lcom/tencent/qqnt/base/lifecycle/c;", "provider", "Lcom/tencent/qqnt/base/lifecycle/a;", "configProvider", "a", "Lcom/tencent/qqnt/base/lifecycle/g;", "Lcom/tencent/qqnt/base/lifecycle/g;", "lifecycleRegisterProxy", "Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;", "b", "Lcom/tencent/qqnt/base/lifecycle/LifecycleDispatcher;", "dispatcher", "<init>", "()V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g lifecycleRegisterProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleDispatcher dispatcher;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Lifecycle a(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle realLifecycle, @NotNull c provider, @NotNull a configProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 2, this, lifecycleOwner, realLifecycle, provider, configProvider);
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(realLifecycle, "realLifecycle");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        if (realLifecycle instanceof LifecycleRegistry) {
            if (this.dispatcher == null) {
                LifecycleDispatcher lifecycleDispatcher = new LifecycleDispatcher(provider, configProvider, null, null, 12, null);
                this.dispatcher = lifecycleDispatcher;
                Intrinsics.checkNotNull(lifecycleDispatcher);
                realLifecycle.addObserver(lifecycleDispatcher);
            }
            if (this.lifecycleRegisterProxy == null) {
                LifecycleDispatcher lifecycleDispatcher2 = this.dispatcher;
                Intrinsics.checkNotNull(lifecycleDispatcher2);
                this.lifecycleRegisterProxy = new g(lifecycleOwner, (LifecycleRegistry) realLifecycle, lifecycleDispatcher2);
            }
            g gVar = this.lifecycleRegisterProxy;
            Intrinsics.checkNotNull(gVar);
            return gVar;
        }
        return realLifecycle;
    }
}
