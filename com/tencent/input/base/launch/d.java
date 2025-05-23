package com.tencent.input.base.launch;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0004B\u0007\u00a2\u0006\u0004\b/\u00100R\"\u0010\n\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0004\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR8\u0010(\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020!\u0012\u0006\b\u0001\u0012\u00020\"\u0012\u0004\u0012\u00028\u00000 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u0019\u0010%\"\u0004\b&\u0010'R\"\u0010.\u001a\u00020)8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010*\u001a\u0004\b#\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/input/base/launch/d;", "Lcom/tencent/mvi/api/runtime/b;", "T", "", "a", "Lcom/tencent/mvi/api/runtime/b;", "b", "()Lcom/tencent/mvi/api/runtime/b;", h.F, "(Lcom/tencent/mvi/api/runtime/b;)V", "mParams", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "i", "(Landroid/view/ViewGroup;)V", "mParent", "Landroid/content/Context;", "Landroid/content/Context;", "()Landroid/content/Context;", "f", "(Landroid/content/Context;)V", "mContext", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getMLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "g", "(Landroidx/lifecycle/LifecycleOwner;)V", "mLifecycleOwner", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e", "Lcom/tencent/mvi/mvvm/BaseVB;", "()Lcom/tencent/mvi/mvvm/BaseVB;", "j", "(Lcom/tencent/mvi/mvvm/BaseVB;)V", "mRootVB", "Lcom/tencent/mvi/runtime/strategy/b;", "Lcom/tencent/mvi/runtime/strategy/b;", "()Lcom/tencent/mvi/runtime/strategy/b;", "k", "(Lcom/tencent/mvi/runtime/strategy/b;)V", "mStrategyService", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class d<T extends com.tencent.mvi.api.runtime.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public T mParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public ViewGroup mParent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Context mContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public LifecycleOwner mLifecycleOwner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public BaseVB<? extends ol3.b, ? extends MviUIState, T> mRootVB;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public com.tencent.mvi.runtime.strategy.b mStrategyService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000e\u001a\u00020\rJ*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u001c\u0010\u0013\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00010\u0010J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/input/base/launch/d$a;", "Lcom/tencent/mvi/api/runtime/b;", "T", "", "inputParams", "d", "(Lcom/tencent/mvi/api/runtime/b;)Lcom/tencent/input/base/launch/d$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "e", "Landroid/content/Context;", "context", "b", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "c", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "rootVB", "f", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "g", "Lcom/tencent/input/base/launch/d;", "a", "Lcom/tencent/input/base/launch/d;", "mLaunchParams", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class a<T extends com.tencent.mvi.api.runtime.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final d<T> mLaunchParams;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mLaunchParams = new d<>();
            }
        }

        @NotNull
        public final d<T> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (d) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.mLaunchParams;
        }

        @NotNull
        public final a<T> b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            this.mLaunchParams.f(context);
            return this;
        }

        @NotNull
        public final a<T> c(@NotNull LifecycleOwner lifecycleOwner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) lifecycleOwner);
            }
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.mLaunchParams.g(lifecycleOwner);
            return this;
        }

        @NotNull
        public final a<T> d(@NotNull T inputParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) inputParams);
            }
            Intrinsics.checkNotNullParameter(inputParams, "inputParams");
            this.mLaunchParams.h(inputParams);
            return this;
        }

        @NotNull
        public final a<T> e(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            this.mLaunchParams.i(parent);
            return this;
        }

        @NotNull
        public final a<T> f(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, T> rootVB) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) rootVB);
            }
            Intrinsics.checkNotNullParameter(rootVB, "rootVB");
            this.mLaunchParams.j(rootVB);
            return this;
        }

        @NotNull
        public final a<T> g(@NotNull com.tencent.mvi.runtime.strategy.b strategyService) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) strategyService);
            }
            Intrinsics.checkNotNullParameter(strategyService, "strategyService");
            this.mLaunchParams.k(strategyService);
            return this;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Context a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        throw null;
    }

    @NotNull
    public final T b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        T t16 = this.mParams;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParams");
        throw null;
    }

    @NotNull
    public final ViewGroup c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ViewGroup viewGroup = this.mParent;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParent");
        throw null;
    }

    @NotNull
    public final BaseVB<? extends ol3.b, ? extends MviUIState, T> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (BaseVB) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        BaseVB<? extends ol3.b, ? extends MviUIState, T> baseVB = this.mRootVB;
        if (baseVB != null) {
            return baseVB;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootVB");
        throw null;
    }

    @NotNull
    public final com.tencent.mvi.runtime.strategy.b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mvi.runtime.strategy.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
        throw null;
    }

    public final void f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public final void g(@NotNull LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) lifecycleOwner);
        } else {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<set-?>");
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    public final void h(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.mParams = t16;
        }
    }

    public final void i(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.mParent = viewGroup;
        }
    }

    public final void j(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, T> baseVB) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) baseVB);
        } else {
            Intrinsics.checkNotNullParameter(baseVB, "<set-?>");
            this.mRootVB = baseVB;
        }
    }

    public final void k(@NotNull com.tencent.mvi.runtime.strategy.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mStrategyService = bVar;
        }
    }
}
