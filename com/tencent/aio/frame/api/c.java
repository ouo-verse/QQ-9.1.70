package com.tencent.aio.frame.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J'\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u001e8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0017\u0010!R$\u0010&\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020#8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b\u001f\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/aio/frame/api/c;", "", "Landroid/view/View;", "j", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "d", "k", "Lcom/tencent/aio/api/frame/a;", "framesConfig", "Landroid/content/Context;", "context", "Lcom/tencent/aio/frame/api/e;", "controller", "c", "(Lcom/tencent/aio/api/frame/a;Landroid/content/Context;Lcom/tencent/aio/frame/api/e;)V", "Landroidx/lifecycle/LifecycleOwner;", "<set-?>", "Landroidx/lifecycle/LifecycleOwner;", "i", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "e", "Landroid/content/Context;", "f", "()Landroid/content/Context;", "Lcom/tencent/aio/frame/api/e;", "g", "()Lcom/tencent/aio/frame/api/e;", "Lts/a;", h.F, "Lts/a;", "()Lts/a;", "activityLauncher", "Lml3/b;", "Lml3/b;", "()Lml3/b;", "emitterService", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private e controller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ts.a activityLauncher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ml3.b emitterService;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public final void c(@NotNull com.tencent.aio.api.frame.a framesConfig, @NotNull Context context, @NotNull e controller) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, framesConfig, context, controller);
            return;
        }
        Intrinsics.checkNotNullParameter(framesConfig, "framesConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.context = context;
        this.controller = controller;
        this.lifecycleOwner = framesConfig.d();
        this.activityLauncher = framesConfig.a();
        this.emitterService = framesConfig.b();
    }

    public void d(@NotNull ViewGroup container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) container);
        } else {
            Intrinsics.checkNotNullParameter(container, "container");
        }
    }

    @NotNull
    public final ts.a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ts.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ts.a aVar = this.activityLauncher;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityLauncher");
        }
        return aVar;
    }

    @NotNull
    public final Context f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context;
    }

    @NotNull
    public final e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        e eVar = this.controller;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        return eVar;
    }

    @NotNull
    public final ml3.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ml3.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        ml3.b bVar = this.emitterService;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emitterService");
        }
        return bVar;
    }

    @NotNull
    public final LifecycleOwner i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        }
        return lifecycleOwner;
    }

    @Nullable
    public View j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
