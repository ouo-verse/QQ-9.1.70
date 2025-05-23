package com.tencent.qqnt.avatar.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.avatar.f;
import com.tencent.qqnt.avatar.impl.core.ViewBindTarget;
import com.tencent.qqnt.avatar.impl.engine.FaceDrawableEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/a;", "Lcom/tencent/qqnt/avatar/f;", "Luv3/a;", "", "Landroid/graphics/drawable/Drawable;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/avatar/e;", "b", "Landroidx/lifecycle/Lifecycle;", "d", "Landroid/content/Context;", "c", "Lcom/tencent/qqnt/avatar/b;", "option", "Lcom/tencent/qqnt/avatar/impl/engine/a;", "a", "", "Ljava/lang/Object;", "host", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;)V", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements f, uv3.a<String, Drawable> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object host;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.host = context;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // uv3.a
    @NotNull
    public com.tencent.qqnt.avatar.impl.engine.a<String, Drawable> a(@NotNull b option) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.avatar.impl.engine.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) option);
        }
        Intrinsics.checkNotNullParameter(option, "option");
        return new FaceDrawableEngine(option);
    }

    @Override // com.tencent.qqnt.avatar.f
    @NotNull
    public e b(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
        Intrinsics.checkNotNullParameter(view, "view");
        return new ViewBindTarget(view, this, d());
    }

    @Override // uv3.a
    @NotNull
    public Context c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object obj = this.host;
        if (obj instanceof Fragment) {
            Context requireContext = ((Fragment) obj).requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "host.requireContext()");
            return requireContext;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.Context");
        return (Context) obj;
    }

    @Nullable
    public Lifecycle d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Lifecycle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Object obj = this.host;
        if (obj instanceof LifecycleOwner) {
            return ((LifecycleOwner) obj).getLifecycle();
        }
        return null;
    }

    public a(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.host = fragment;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fragment);
        }
    }
}
