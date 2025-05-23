package com.tencent.mobileqq;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/w;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleRegistry;", "d", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "<init>", "()V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class w implements LifecycleOwner {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleRegistry lifecycleRegistry;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.lifecycleRegistry = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.lifecycleRegistry;
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
        }
    }

    public final void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
        }
    }
}
