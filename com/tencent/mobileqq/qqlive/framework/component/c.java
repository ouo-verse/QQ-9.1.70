package com.tencent.mobileqq.qqlive.framework.component;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.k;
import com.tencent.mobileqq.qqlive.framework.exception.QQLiveException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u00a2\u0006\u0004\b \u0010!J!\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J!\u0010\u000e\u001a\u00020\u0005\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/component/c;", "Lfi2/a;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "E", "event", "", "b", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;)V", "Landroid/content/Context;", "getContext", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "C0", "", "getKey", "Lcom/tencent/mobileqq/qqlive/framework/component/e;", HippyQQConstants.URL_COMPONENT_NAME, "a", "d", "Lfi2/a;", "rootComponentContext", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "e", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "trigger", "f", "Ljava/lang/String;", "key", tl.h.F, "Lcom/tencent/mobileqq/qqlive/framework/component/e;", "<init>", "(Lfi2/a;Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;Ljava/lang/String;)V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class c implements fi2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fi2.a rootComponentContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h trigger;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e component;

    public c(@NotNull fi2.a rootComponentContext, @NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h trigger, @NotNull String key) {
        Intrinsics.checkNotNullParameter(rootComponentContext, "rootComponentContext");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(key, "key");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rootComponentContext, trigger, key);
            return;
        }
        this.rootComponentContext = rootComponentContext;
        this.trigger = trigger;
        this.key = key;
    }

    private final <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void b(E event) {
        fi2.a aVar = this.rootComponentContext;
        if (aVar instanceof com.tencent.mobileqq.qqlive.framework.eventbroadcaster.i) {
            ((com.tencent.mobileqq.qqlive.framework.eventbroadcaster.i) aVar).a(event);
        } else {
            com.tencent.mobileqq.qqlive.framework.c.e(new QQLiveException("RootComponentContext is not IRootEventTrigger!"));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h
    public <E extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b> void C0(@NotNull E event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof k) {
            b(event);
        } else {
            this.trigger.C0(event);
        }
    }

    public final void a(@NotNull e component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) component);
        } else {
            Intrinsics.checkNotNullParameter(component, "component");
            this.component = component;
        }
    }

    @Override // fi2.a
    @NotNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.rootComponentContext.getContext();
    }

    @Override // fi2.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.key;
    }

    @Override // fi2.a
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rootComponentContext.getLifecycleOwner();
    }

    @Override // fi2.a
    @NotNull
    public ViewModelStoreOwner y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewModelStoreOwner) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.rootComponentContext.y();
    }
}
