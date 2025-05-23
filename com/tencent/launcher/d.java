package com.tencent.launcher;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b:\u0010;R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u0012\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0000\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\"\u001a\u0004\b\f\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010/\u001a\u0004\b\u0014\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u00105\u001a\u0004\b\u0003\u00106\"\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/launcher/d;", "", "Landroidx/fragment/app/Fragment;", "a", "Landroidx/fragment/app/Fragment;", "d", "()Landroidx/fragment/app/Fragment;", "l", "(Landroidx/fragment/app/Fragment;)V", "fragment", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mvi/api/runtime/b;", "b", "Lcom/tencent/mvi/mvvm/BaseVB;", "g", "()Lcom/tencent/mvi/mvvm/BaseVB;", "o", "(Lcom/tencent/mvi/mvvm/BaseVB;)V", "rootVB", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", DomainData.DOMAIN_NAME, "(Landroid/view/ViewGroup;)V", "parentView", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "e", "()Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Ljava/lang/Object;", "()Ljava/lang/Object;", "j", "(Ljava/lang/Object;)V", "baseParam", "Lcom/tencent/mvi/runtime/strategy/b;", "Lcom/tencent/mvi/runtime/strategy/b;", h.F, "()Lcom/tencent/mvi/runtime/strategy/b;", "p", "(Lcom/tencent/mvi/runtime/strategy/b;)V", "strategyService", "Lml3/b;", "Lml3/b;", "()Lml3/b;", "k", "(Lml3/b;)V", "emitterService", "", "Z", "()Z", "i", "(Z)V", "attachToParent", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Fragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public BaseVB<?, ?, ? super com.tencent.mvi.api.runtime.b> rootVB;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ViewGroup parentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner lifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Object baseParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mvi.runtime.strategy.b strategyService;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ml3.b emitterService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean attachToParent;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0005\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001J\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/launcher/d$a;", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lcom/tencent/mvi/api/runtime/b;", "rootVB", "f", "Landroidx/fragment/app/Fragment;", "fragment", "c", "Landroid/view/ViewGroup;", "parentView", "e", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "d", "baseParam", "a", "Lcom/tencent/launcher/d;", "b", "Lcom/tencent/launcher/d;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d launchParam;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.launchParam = new d();
            }
        }

        @NotNull
        public final a a(@NotNull Object baseParam) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, baseParam);
            }
            Intrinsics.checkNotNullParameter(baseParam, "baseParam");
            this.launchParam.j(baseParam);
            return this;
        }

        @NotNull
        public final d b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (d) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.launchParam;
        }

        @NotNull
        public final a c(@NotNull Fragment fragment) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
            }
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.launchParam.l(fragment);
            return this;
        }

        @NotNull
        public final a d(@NotNull LifecycleOwner lifecycleOwner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) lifecycleOwner);
            }
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.launchParam.m(lifecycleOwner);
            return this;
        }

        @NotNull
        public final a e(@NotNull ViewGroup parentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parentView);
            }
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            this.launchParam.n(parentView);
            return this;
        }

        @NotNull
        public final a f(@NotNull BaseVB<?, ?, ? extends com.tencent.mvi.api.runtime.b> rootVB) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootVB);
            }
            Intrinsics.checkNotNullParameter(rootVB, "rootVB");
            this.launchParam.o(rootVB);
            return this;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.attachToParent = true;
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.attachToParent;
    }

    @NotNull
    public final Object b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this);
        }
        Object obj = this.baseParam;
        if (obj != null) {
            return obj;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseParam");
        return Unit.INSTANCE;
    }

    @Nullable
    public final ml3.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ml3.b) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.emitterService;
    }

    @NotNull
    public final Fragment d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    @NotNull
    public final LifecycleOwner e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        return null;
    }

    @NotNull
    public final ViewGroup f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ViewGroup viewGroup = this.parentView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("parentView");
        return null;
    }

    @NotNull
    public final BaseVB<?, ?, ? super com.tencent.mvi.api.runtime.b> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVB) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        BaseVB<?, ?, ? super com.tencent.mvi.api.runtime.b> baseVB = this.rootVB;
        if (baseVB != null) {
            return baseVB;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootVB");
        return null;
    }

    @Nullable
    public final com.tencent.mvi.runtime.strategy.b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mvi.runtime.strategy.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.strategyService;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.attachToParent = z16;
        }
    }

    public final void j(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, obj);
        } else {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.baseParam = obj;
        }
    }

    public final void k(@Nullable ml3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bVar);
        } else {
            this.emitterService = bVar;
        }
    }

    public final void l(@NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "<set-?>");
            this.fragment = fragment;
        }
    }

    public final void m(@NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) lifecycleOwner);
        } else {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
            this.lifecycleOwner = lifecycleOwner;
        }
    }

    public final void n(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.parentView = viewGroup;
        }
    }

    public final void o(@NotNull BaseVB<?, ?, ? super com.tencent.mvi.api.runtime.b> baseVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseVB);
        } else {
            Intrinsics.checkNotNullParameter(baseVB, "<set-?>");
            this.rootVB = baseVB;
        }
    }

    public final void p(@Nullable com.tencent.mvi.runtime.strategy.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        } else {
            this.strategyService = bVar;
        }
    }
}
